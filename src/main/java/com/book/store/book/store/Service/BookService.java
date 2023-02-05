package com.book.store.book.store.Service;

import com.book.store.book.store.Dto.BookDto;
import com.book.store.book.store.Dto.BookDtoConverter;
import com.book.store.book.store.Dto.request.CreateBookRequest;
import com.book.store.book.store.Dto.request.UpdateBookRequest;
import com.book.store.book.store.Exception.BookNotFoundException;
import com.book.store.book.store.Model.Book;
import com.book.store.book.store.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    private final AuthorService authorService;


    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
        this.authorService = authorService;
    }

    protected Book findBookById(String id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("book not found " + id));
    }

    public BookDto getBookById(String id) {
        return bookDtoConverter.convert(findBookById(id));
    }

    protected List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookDto> getAllBookDtoList() {
        return bookDtoConverter.convertToBookDtoList(getAllBooks());
    }

    public String deleteBookById(String id) {
        getBookById(id);
        bookRepository.deleteById(id);
        return "book deleted successfully " + id;
    }

    public BookDto createBook (CreateBookRequest createBookRequest) {
        Book book = new Book(
        createBookRequest.getTitle(),
        createBookRequest.getCost()
);
        return bookDtoConverter.convert(bookRepository.save(book));
    }

    public BookDto updateBook (String id, UpdateBookRequest updateBookRequest) {
        Book book = findBookById(String.valueOf(id));
        Book updateBook = new Book(
                book.getTitle(),
                book.getCost()
        );

        return bookDtoConverter.convert(bookRepository.save(updateBook));
    }

}
