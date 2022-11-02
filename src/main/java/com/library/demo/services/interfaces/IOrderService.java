package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.OrderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;

import java.math.BigDecimal;

public interface IOrderService {

    BaseResponse getOrder(Long id);

    BaseResponse updateOrderById(Long id, OrderRequest request);

    BaseResponse deleteOrderById(Long id);

    BaseResponse getTotal(BigDecimal price);

    BaseResponse addOrder(OrderRequest request);

}
