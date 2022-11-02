package com.library.demo.controllers;


import com.library.demo.controllers.dtos.requests.OrderRequest;
import com.library.demo.controllers.dtos.responses.BaseResponse;
import com.library.demo.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getOrderById(@PathVariable Long id){
        BaseResponse baseResponse = service.getOrder(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping
    public  ResponseEntity<BaseResponse> getTotal(@RequestBody BigDecimal total){
        BaseResponse baseResponse = service.getTotal(total);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> addOrder(@RequestBody OrderRequest request){
        BaseResponse baseResponse = service.addOrder(request);
        return  new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("updateOrder/{id}")
    public ResponseEntity<BaseResponse> updateBookById(@PathVariable Long id, @RequestBody OrderRequest request){
        BaseResponse baseResponse = service.updateOrderById(id, request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("deleteOrder/{id}")
    public ResponseEntity<BaseResponse> deleteBookById(@PathVariable Long id){
        BaseResponse baseResponse = service.deleteOrderById(id);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
