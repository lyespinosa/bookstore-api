package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.CreateOrderRequest;
import com.library.demo.controllers.dtos.requests.UpdateOrderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.entities.Order;

import java.math.BigDecimal;

public interface IOrderService {

    Order findOrderById(Long id);

    BaseResponse listAllOrdersByUserId(Long id);


    BaseResponse getOrderById(Long id);

    BaseResponse create(CreateOrderRequest request);

    BaseResponse update(Long id, UpdateOrderRequest request);

    void delete(Long id);



}
