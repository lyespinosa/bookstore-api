package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.OrderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.controllers.dtos.responses.BookResponse;
import com.library.demo.controllers.dtos.responses.OrderResponse;
import com.library.demo.entities.projections.BookProjection;
import com.library.demo.entities.projections.OrderProjection;
import com.library.demo.repositories.IOrderRepository;
import com.library.demo.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Override
    public BaseResponse getOrder(Long id) {
        OrderResponse response = from(repository.getOrderById(id));
        return  buildBaseResponse(response, "Searching order by id");
    }

    @Override
    public BaseResponse updateOrderById(Long id, OrderRequest request) {
        return null;
    }

    @Override
    public BaseResponse deleteOrderById(Long id) {
        return null;
    }

    @Override
    public BaseResponse getTotal(BigDecimal price) {
        OrderResponse response = from(repository.getTotal(price));
        return  buildBaseResponse(response, "Getting total");
    }

    @Override
    public BaseResponse addOrder(OrderRequest request) {
        return null;
    }

    private BaseResponse buildBaseResponse(OrderResponse response, String message){
        return BaseResponse.builder()
                .data(response)
                .message(message)
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private BaseResponse buildBaseResponse(List<BookResponse> response, String message){
        return BaseResponse.builder()
                .data(response)
                .message(message)
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private OrderResponse from(OrderProjection order){
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setTotal(order.getTotal());
        response.setQuantity(order.getQuantity());
        response.setBookId(order.getBookId());
        response.setUserId(order.getUserId());
        response.setStatus(order.getStatus());
        return response;
    }
}
