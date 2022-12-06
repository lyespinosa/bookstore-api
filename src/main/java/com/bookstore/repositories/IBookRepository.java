package com.bookstore.repositories;

import com.bookstore.entities.Book;
import com.bookstore.entities.projections.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select books.*, authors.name as authorName, editorials.name as editorialName from books " +
            "inner join authors on books.author_id = authors.id " +
            "inner join editorials on books.editorial_id = editorials.id order by books.id", nativeQuery = true)
    List<BookProjection> listBooks();

    @Query(value = "select books.*, authors.name as authorName, editorials.name as editorialName from books " +
            "inner join authors on books.author_id = authors.id " +
            "inner join editorials on books.editorial_id = editorials.id order by books.id DESC ", nativeQuery = true)
    List<BookProjection> listNewBooks();

    @Query(value = "select books.*, authors.name as authorName, editorials.name as editorialName from books " +
            "inner join authors on books.author_id = authors.id " +
            "inner join editorials on books.editorial_id = editorials.id order by RAND()", nativeQuery = true)
    List<BookProjection> listRandBooks();

    @Query(value = "select books.*, authors.name as authorName, editorials.name as editorialName from books " +
            "inner join authors on books.author_id = authors.id " +
            "inner join editorials on books.editorial_id = editorials.id " +
            "where books.name like %:bookName%", nativeQuery = true)
    List<BookProjection> getBookByName(String bookName);


}

