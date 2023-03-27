package com.book.store.dto.converter;

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
                from.getCost()
        );
    }
    public List<BookDto> convertToBookDtoList(List<Book> bookList) {
        return bookList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
