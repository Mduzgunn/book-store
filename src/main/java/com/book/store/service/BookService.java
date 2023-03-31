package com.book.store.service;

import ch.qos.logback.classic.Logger;
import com.book.store.dto.BookDto;
import com.book.store.dto.converter.BookDtoConverter;
import com.book.store.dto.request.CreateBookRequest;
import com.book.store.dto.request.UpdateBookRequest;
import com.book.store.exception.BookNotFoundException;
import com.book.store.message.BookMessageListener;
import com.book.store.message.RabbitConfig;
import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;
    private final AuthorService authorService;
    private final RabbitTemplate rabbitTemplate;



    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter, AuthorService authorService, RabbitTemplate rabbitTemplate) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
        this.authorService = authorService;
        this.rabbitTemplate = rabbitTemplate;
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
                book.getId(),
                updateBookRequest.getTitle(),
                updateBookRequest.getCost(),
                updateBookRequest.getAuthorIdList()
        );

        return bookDtoConverter.convert(bookRepository.save(updateBook));
    }

    public void sendBookToQueue(CreateBookRequest createBookRequest) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, createBookRequest);
        LOGGER.info("Book sent to queue. Book Title: {} Book Cost: {}", createBookRequest.getTitle(), createBookRequest.getCost());
    }

}
