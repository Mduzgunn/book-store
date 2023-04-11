package com.book.store.dto.converter;

import com.book.store.dto.AuthorDto;
import com.book.store.dto.BookDto;
import com.book.store.model.Author;
import com.book.store.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorDtoConverter {
    public AuthorDto convert(Author from) {
        return new AuthorDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail(),
                from.getPhone(),
                getBookList(from.getBooks())
        );
    }

    public List<BookDto> getBookList(List<Book> books){
        return books.stream().map(
                p -> new BookDto(
                        p.getId(),
                        p.getTitle(),
                        p.getCost()
                )
        ).collect(Collectors.toList());
    }

    public List<AuthorDto> convertToAuthorDtoList(List<Author> authorList) {
        return authorList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
