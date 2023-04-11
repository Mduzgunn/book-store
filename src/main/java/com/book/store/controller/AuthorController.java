package com.book.store.controller;

import com.book.store.dto.AuthorDto;
import com.book.store.dto.request.CreateAuthorRequest;
import com.book.store.dto.request.UpdateAuthorRequest;
import com.book.store.service.AuthorService;
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
@RequestMapping("/v1/author")
public class AuthorController {
    private final AuthorService authorService;
    private final RabbitMQSender rabbitMQSender;

    public AuthorController(AuthorService authorService, RabbitMQSender rabbitMQSender) {
        this.authorService = authorService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest) {
        rabbitMQSender.sendAuthorToQueue(createAuthorRequest);
        return ResponseEntity.ok(authorService.createAuthor(createAuthorRequest));
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        List<AuthorDto> authorDtoList = authorService.getAllAuthorDtoList();
        return ResponseEntity.ok(authorDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> geAuthorById(@PathVariable String id) {
        AuthorDto authorDto = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable String id,@Valid @RequestBody UpdateAuthorRequest updateAuthorRequest) {
        return ResponseEntity.ok(authorService.updateAuthor(id, updateAuthorRequest));
    }

}
