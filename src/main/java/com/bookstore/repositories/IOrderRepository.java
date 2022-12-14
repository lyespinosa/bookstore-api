package com.bookstore.repositories;

import com.bookstore.entities.Order;
import com.bookstore.entities.projections.OrderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

    @Query(value ="select orders.*, users.id as userId, books.id as bookId, status.name as statusName from orders " +
            "inner join users on orders.user_id = users.id " +
            "inner join books on orders.book_id = books.id " +
            "inner join status on orders.status_id = status.id " +
            "where orders.user_id = :userId and orders.status_id != 1 ",nativeQuery = true)
    List<OrderProjection> listAllOrdersByUserIdExceptShopping(Long userId);

    @Query(value = "select orders.*, users.id as userId, books.id as bookId, status.name as statusName from orders " +
            "inner join users on orders.user_id = users.id " +
            "inner join books on orders.book_id = books.id " +
            "inner join status on orders.status_id = status.id " +
            "where orders.id = :id",nativeQuery = true)
    OrderProjection getOrderById(Long id);

    @Query(value = "select orders.*, users.id as userId, books.id as bookId, status.name as statusName from orders " +
            "inner join users on orders.user_id = users.id " +
            "inner join books on orders.book_id = books.id " +
            "inner join status on orders.status_id = status.id " +
            "where orders.user_id = :idUser and orders.status_id = 1 and orders.book_id = :idBook",nativeQuery = true)
    OrderProjection existOneBookInShoppingToThisUser(Long idUser, Long idBook);





}
