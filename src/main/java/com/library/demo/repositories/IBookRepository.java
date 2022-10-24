package com.library.demo.repositories;

import com.library.demo.entities.Author;
import com.library.demo.entities.projections.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Author, Long> {

    @Query(value = "select books.*, authors.name as authorName, editorials.name as editorialName from books " +
            "inner join authors on books.author_id = authors.id " +
            "inner join editorials on books.editorial_id = editorials.id ", nativeQuery = true)
    List<BookProjection> listBooks();
}

