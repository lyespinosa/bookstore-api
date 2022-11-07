package com.library.demo.controllers;


import com.library.demo.controllers.dtos.requests.CreateOrderRequest;
import com.library.demo.controllers.dtos.requests.UpdateOrderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping("user/{id}")
    public ResponseEntity<BaseResponse> lisAllOrdersByUserId(@PathVariable Long id){
        BaseResponse baseResponse = service.listAllOrdersByUserId(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("user/{id}/status/{statusName}")
    public ResponseEntity<BaseResponse> lisAllOrdersByUserIdFilterStatus(@PathVariable Long id, @PathVariable String statusName){
        BaseResponse baseResponse = service.listAllOrdersByUserIdFilterStatus(id, statusName);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
    @GetMapping("user/{id}/AllOrders")
    public ResponseEntity<BaseResponse> listAllOrdersByUserIdExceptShopping(@PathVariable Long id){
        BaseResponse baseResponse = service.listAllOrdersByUserIdExceptShopping(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getOrderById(@PathVariable Long id){
        BaseResponse baseResponse = service.getOrderById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }


    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateOrderRequest request){
        BaseResponse baseResponse = service.create(request);
        return  new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateOrderRequest request){
        BaseResponse baseResponse = service.update(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
