package com.library.demo.repositories;

import com.library.demo.entities.Order;
import com.library.demo.entities.projections.CommentProjection;
import com.library.demo.entities.projections.OrderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query(value ="select orders.*, users.id as userId, books.id as bookId, status.name as statusName from orders " +
            "inner join users on orders.user_id = users.id " +
            "inner join books on orders.book_id = books.id " +
            "inner join status on orders.status_id = status.id " +
            "where orders.user_id = :userId",nativeQuery = true)
    List<OrderProjection> listAllOrdersByUserId(Long userId);

    @Query(value ="select orders.*, users.id as userId, books.id as bookId, status.name as statusName from orders " +
            "inner join users on orders.user_id = users.id " +
            "inner join books on orders.book_id = books.id " +
            "inner join status on orders.status_id = status.id " +
            "where orders.user_id = :userId and orders.status_id = :statusId ",nativeQuery = true)
    List<OrderProjection> listAllOrdersByUserIdFilterStatus(Long userId, Long statusId);

    @Query(value = "select id.*, users.id as userId, books.id as bookId books.price as total from orders" +
            "inner join users on orders.user_id = user.id" +
            "inner join books on orders.book_id = books.id" +
            "inner join books on orders.total = books.price" +
            "where orders.id = :id",nativeQuery = true)
    OrderProjection getOrderById(Long id);


}
