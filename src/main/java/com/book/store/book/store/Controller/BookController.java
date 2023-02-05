package com.book.store.book.store.Controller;

import com.book.store.book.store.Dto.BookDto;
import com.book.store.book.store.Dto.request.CreateBookRequest;
import com.book.store.book.store.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping
//    public ResponseEntity<List<MovieDto>> getMovies() {
//        List<MovieDto> movieDtoList = movieService.getAllMovieDtoList();
//        return ResponseEntity.ok(movieDtoList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<MovieDto> getMovieById(@PathVariable String id) {
//        MovieDto movieDto = movieService.getMovieById(id);
//        return ResponseEntity.ok(movieDto);
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<MovieDto> updateMovie(@PathVariable String id,@Valid @RequestBody UpdateMovieRequest updateMovieRequest) {
//        return ResponseEntity.ok(movieService.updateMovie(id, updateMovieRequest));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteMovieById(@PathVariable String id) {
//        return ResponseEntity.ok(movieService.deleteMovieById(id));
//    }
}
