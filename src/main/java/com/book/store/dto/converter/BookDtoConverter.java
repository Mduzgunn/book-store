package com.book.store.dto.converter;

import com.book.store.dto.AuthorDto;
import com.book.store.dto.BookDto;
import com.book.store.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDtoConverter {
    public BookDto convert(Book from) {
        return new BookDto(
                from.getId(),
                from.getTitle(),
                from.getCost(),
                new AuthorDto(from.getAuthor().getId(),
                        from.getAuthor().getFirstName(),
                        from.getAuthor().getLastName(),
                        from.getAuthor().getEmail(),
                        from.getAuthor().getPhone()
                )
        );
    }

    public List<BookDto> convertToBookDtoList(List<Book> bookList) {
        return bookList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
