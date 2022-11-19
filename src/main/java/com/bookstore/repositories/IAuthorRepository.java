package com.bookstore.repositories;

import com.bookstore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select authors.* from authors " +
            "where authors.name like %:authorName%", nativeQuery = true)
    List<Author> getAuthorByName(String authorName);

}
