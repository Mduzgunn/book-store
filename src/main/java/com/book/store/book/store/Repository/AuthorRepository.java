package com.book.store.book.store.Repository;

import com.book.store.book.store.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAllByIdIn(List<String> idList);
}
