package com.library.demo.repositories;

import com.library.demo.entities.Comment;
import com.library.demo.entities.projections.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    @Query(value ="select comments.*, users.name as userName, books.name as bookName from comments " +
            "inner join users on comments.user_id = users.id " +
            "inner join books on comments.book_id = books.id " +
            "where comments.book_id = :bookId",nativeQuery = true)
    List<CommentProjection> listAllCommentsByBookId(Long bookId);


}
