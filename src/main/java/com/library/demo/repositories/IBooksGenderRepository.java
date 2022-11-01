package com.library.demo.repositories;

import com.library.demo.entities.Gender;
import com.library.demo.entities.pivots.BookGender;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.entities.projections.GenderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBooksGenderRepository extends JpaRepository<BookGender, Long> {

    @Query(value = "select genders.* from books_genders " +
            "inner join genders on books_genders.gender_id = genders.id " +
            "where books_genders.book_id = :bookId", nativeQuery = true)
    List<GenderProjection> listAllGendersByBookId(Long bookId);

    @Query(value = "select books.* from books_genders " +
            "inner join books on books_genders.book_id = books.id " +
            "where books_genders.gender_id = :genderId", nativeQuery = true)
    List<BookProjection> listAllBooksByGenderId(Long genderId);

}
