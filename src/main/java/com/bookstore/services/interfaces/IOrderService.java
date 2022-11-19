package com.bookstore.services.interfaces;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.entities.Order;
import com.bookstore.controllers.dtos.requests.CreateOrderRequest;
import com.bookstore.controllers.dtos.requests.UpdateOrderRequest;

public interface IOrderService {

    Order findOrderById(Long id);

    BaseResponse listAllOrdersByUserId(Long id);

    BaseResponse listAllOrdersByUserIdFilterStatus(Long id, String statusName);

    BaseResponse listAllOrdersByUserIdExceptShopping(Long id);


    BaseResponse getOrderById(Long id);

    BaseResponse create(CreateOrderRequest request);

    BaseResponse update(Long id, UpdateOrderRequest request);

    void delete(Long id);



}
