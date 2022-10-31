package com.library.demo.repositories;

import com.library.demo.entities.Comment;
import com.library.demo.entities.projections.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select comments.*",nativeQuery = true)
    CommentProjection getCommentById(Long commentId);
}
