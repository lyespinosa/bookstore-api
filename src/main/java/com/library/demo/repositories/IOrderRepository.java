package com.library.demo.repositories;

import com.library.demo.entities.Author;
import com.library.demo.entities.Book;
import com.library.demo.entities.Order;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.entities.projections.OrderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Author, Long> {

    @Query(value = "select id.*, users.id as userId, books.id as bookId books.price as total from orders" +
                "inner join users on orders.user_id = user.id" +
                "inner join books on orders.book_id = books.id" +
                "inner join books on orders.total = books.price" +
                "where orders.id = :id",nativeQuery = true)
    OrderProjection getOrderById(Long id);

    @Query(value = "select id.*, user.id as userId, books.id as bookId, books.price as total from orders" +
            "inner join user on orders.user_id = user.id" +
            "inner join books on orders.books_id = books.id" +
            "inner join books on orders.total = books.price" +
            "where books.price = :total", nativeQuery = true)
    OrderProjection getTotal(BigDecimal price);

}
