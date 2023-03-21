package com.book.store.book.store.Controller;

import com.book.store.book.store.Dto.BookDto;
import com.book.store.book.store.Dto.request.CreateBookRequest;
import com.book.store.book.store.Dto.request.UpdateBookRequest;
import com.book.store.book.store.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> bookDtoList = bookService.getAllBookDtoList();
        return ResponseEntity.ok(bookDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) {
        BookDto movieDto = bookService.getBookById(id);
        return ResponseEntity.ok(movieDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable String id,@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, updateBookRequest));
    }

}
