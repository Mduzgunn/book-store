package com.book.store.repository;

import com.book.store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,String> {
}
