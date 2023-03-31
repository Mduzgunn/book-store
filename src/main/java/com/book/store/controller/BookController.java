package com.book.store.controller;

import com.book.store.dto.BookDto;
import com.book.store.message.RabbitConfig;
import com.book.store.service.BookService;
import com.book.store.dto.request.CreateBookRequest;
import com.book.store.dto.request.UpdateBookRequest;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private final RabbitTemplate rabbitTemplate;

    public BookController(BookService bookService, RabbitTemplate rabbitTemplate) {
        this.bookService = bookService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        bookService.sendBookToQueue(createBookRequest);
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }


//    @PostMapping
//    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
//        bookService.sendBookToQueue(bookDto);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

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
