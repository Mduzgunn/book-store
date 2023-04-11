package com.book.store.service;

import com.book.store.dto.AuthorDto;
import com.book.store.dto.converter.AuthorDtoConverter;
import com.book.store.dto.request.CreateAuthorRequest;
import com.book.store.dto.request.UpdateAuthorRequest;
import com.book.store.exception.AuthorNotFoundException;
import com.book.store.repository.AuthorRepository;
import com.book.store.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoConverter authorDtoConverter;


    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    protected Author findAuthorById(String id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found " + id));
    }
    public AuthorDto getAuthorById(String id) {
        return authorDtoConverter.convert(findAuthorById(id));
    }

    protected List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorDto> getAllAuthorDtoList() {
        return authorDtoConverter.convertToAuthorDtoList(getAllAuthors());
    }

    public String deleteAuthorById(String id) {
        getAuthorById(id);
        authorRepository.deleteById(id);
        return "Author deleted successfully " + id;
    }

    public AuthorDto createAuthor (CreateAuthorRequest createAuthorRequest) {
        Author author = new Author(
                createAuthorRequest.getFirstName(),
                createAuthorRequest.getLastName(),
                createAuthorRequest.getEmail(),
                createAuthorRequest.getPhone()
        );
        return authorDtoConverter.convert(authorRepository.save(author));
    }

    public AuthorDto updateAuthor (String id, UpdateAuthorRequest updateAuthorRequest) {
        Author author = findAuthorById(String.valueOf(id));
        Author updateAuthor = new Author(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                updateAuthorRequest.getEmail(),
                updateAuthorRequest.getPhone(),
                updateAuthorRequest.getBooks()
        );

        return authorDtoConverter.convert(authorRepository.save(updateAuthor));
    }

}
