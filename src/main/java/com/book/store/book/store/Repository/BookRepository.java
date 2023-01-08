package com.book.store.book.store.Repository;

import com.book.store.book.store.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    List<Book> findAllByIdIn(List<String> idList);
}
