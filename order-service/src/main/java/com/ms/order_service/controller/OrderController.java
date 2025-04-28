package com.ms.order_service.controller;

import com.ms.order_service.entity.Order;
import com.ms.order_service.entity.dto.ResponseData;
import com.ms.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<ResponseData>> placeOrder(@RequestBody Order order)
    {
        return orderService.placeOrder(order).map(orderResponseDTO ->
                ResponseEntity.status(HttpStatus.CREATED).body(new ResponseData(orderResponseDTO,null)))
                .onErrorResume(e -> {
                    ResponseData<String> errorResponse = new ResponseData<>();
                    errorResponse.setError(Map.of("message", e.getMessage()));
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
                });
    }

    @GetMapping
    public List<Order> getAllOrder()
    {
        return orderService.getAllOrder();
    }


}
