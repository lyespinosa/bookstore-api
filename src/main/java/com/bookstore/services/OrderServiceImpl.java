package com.bookstore.services;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.OrderResponse;
import com.bookstore.controllers.exceptions.BookException;
import com.bookstore.entities.Book;
import com.bookstore.entities.Order;
import com.bookstore.entities.Status;
import com.bookstore.entities.projections.OrderProjection;
import com.bookstore.repositories.IOrderRepository;
import com.bookstore.controllers.dtos.requests.CreateOrderRequest;
import com.bookstore.controllers.dtos.requests.UpdateOrderRequest;
import com.bookstore.segurity.entity.User;
import com.bookstore.segurity.service.UserService;
import com.bookstore.services.interfaces.IBookService;
import com.bookstore.services.interfaces.IOrderService;
import com.bookstore.services.interfaces.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository repository;

    @Autowired
    private IBookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private IStatusService statusService;


    @Override
    public Order findOrderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookException("Order not found "));
    }
    @Override
    public BaseResponse listAllOrdersByUserId(Long id) {
        List<OrderResponse> response = repository.listAllOrdersByUserId(id).stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("All orders by userId")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse listAllOrdersByUserIdFilterStatus(Long id, String statusName) {
        Status status = statusService.findStatusByName(statusName);
        List<OrderResponse> response = repository.listAllOrdersByUserIdFilterStatus(id, status.getId())
                .stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("All orders on " + status.getName() + "status")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse listAllOrdersByUserIdExceptShopping(Long id) {
        List<OrderResponse> responses = repository.listAllOrdersByUserIdExceptShopping(id).
                stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(responses)
                .message("All orders")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getOrderById(Long id) {
        OrderResponse response = from(repository.getOrderById(id));
        return  BaseResponse.builder()
                .data(response)
                .message("Order by id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateOrderRequest request) {

        OrderResponse response = new OrderResponse();

        OrderProjection projection = existOneBookInShoppingToThisUser( request.getUserId(), request.getBookId() );

        if(projection != null){
             response = addOneBookToExistingOrder(projection.getId(), request.getQuantity());
        }
        else {
            Order order = new Order();
            order = create(request, order);
             response = from(repository.save(order));
        }
        return BaseResponse.builder()
                .data(response)
                .message("Order created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateOrderRequest request) { //Update the status only
        Order order = findOrderById(id);
        order = update(request, order);
        OrderResponse response = from(repository.save(order));
        return BaseResponse.builder()
                .data(response)
                .message("Order status update")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public void delete(Long id) {
        findOrderById(id);
        repository.deleteById(id);
    }


    private OrderProjection existOneBookInShoppingToThisUser(Long idUser, Long idBook){
        return repository.existOneBookInShoppingToThisUser(idUser, idBook);
    }

    private OrderResponse addOneBookToExistingOrder(Long id, int quantity){
        Order order = findOrderById(id);
        order.setQuantity(order.getQuantity() + quantity);
        OrderResponse response = from(repository.save(order));
        return response;

    }

    private OrderResponse from(OrderProjection order){
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setBookId(order.getBookId());
        response.setUserId(order.getUserId());

        response.setPrice(order.getPrice());
        response.setQuantity(order.getQuantity());

        response.setTotal(order.getTotal());

        response.setOrderDate(order.getOrder_date());
        response.setDeliveryDate(order.getDelivery_date());

        response.setStatus(order.getStatusName());
        return response;
    }

    private OrderResponse from(Order order){
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setBookId(order.getBook().getId());
        response.setUserId(order.getUser().getId());

        response.setPrice(order.getPrice());
        response.setQuantity(order.getQuantity());
        response.setTotal(order.getTotal());

        response.setOrderDate(order.getOrderDate());
        response.setDeliveryDate(order.getDeliveryDate());

        response.setStatus(order.getStatus().getName());

        return response;
    }

    private Order create(CreateOrderRequest request, Order order){

        User user = userService.findUserById(request.getUserId());
        order.setUser(user);

        Book book = bookService.findBookById(request.getBookId());
        order.setBook(book);

        Status status = statusService.findStatusByName(request.getStatus());
        order.setStatus(status);

        order.setPrice(book.getPrice());
        order.setQuantity(request.getQuantity());


        BigDecimal quantityDecimal = new BigDecimal(request.getQuantity());
        order.setTotal( book.getPrice().multiply(quantityDecimal) );

        order.setOrderDate(request.getOrderDate());
        order.setDeliveryDate(request.getDeliveryDate());

        return order;
    }

    private Order update(UpdateOrderRequest request, Order order){

        Status status = statusService.findStatusByName(request.getStatus());
        order.setStatus(status);

        order.setOrderDate(request.getOrderDate());
        order.setDeliveryDate(request.getDeliveryDate());

        return order;
    }
}
