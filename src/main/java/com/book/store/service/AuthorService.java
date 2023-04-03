package com.book.store.service;

import com.book.store.dto.converter.AuthorDtoConverter;
import com.book.store.repository.AuthorRepository;
import com.book.store.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoConverter authorDtoConverter;


    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    protected List<Author> getAuthorListByIdList(List<String> idList) {
        return Optional.of(authorRepository.findAllByIdIn(idList))
                .filter(a -> !a.isEmpty())
                .orElse(List.of(
                        new Author("id",
                                "firstname",
                                "lastname",
                                "email",
                                "phone")
                ));
    }


}