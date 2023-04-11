package com.book.store.controller;

import com.book.store.dto.BookDto;
import com.book.store.service.BookService;
import com.book.store.dto.request.CreateBookRequest;
import com.book.store.dto.request.UpdateBookRequest;
import com.book.store.service.RabbitMQSender;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    private final RabbitMQSender rabbitMQSender;

    public BookController(BookService bookService, RabbitMQSender rabbitMQSender) {
        this.bookService = bookService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        rabbitMQSender.sendBookToQueue(createBookRequest);
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> bookDtoList = bookService.getAllBookDtoList();
        return ResponseEntity.ok(bookDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) {
        BookDto bookDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable String id,@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, updateBookRequest));
    }

}
