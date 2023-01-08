package com.book.store.book.store.Repository;

import com.book.store.book.store.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
