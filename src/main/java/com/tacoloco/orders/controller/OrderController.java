package com.tacoloco.orders.controller;

import com.tacoloco.orders.dto.OrderDTO;
import com.tacoloco.orders.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create (@RequestBody @Validated OrderDTO order) {
        return new ResponseEntity<OrderDTO> (orderService.create(order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll () {
        return new ResponseEntity<List<OrderDTO>> (orderService.findAllOrder(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update (@RequestBody @Validated OrderDTO order) {
        return new ResponseEntity<OrderDTO> (orderService.update(order), HttpStatus.OK);
    }
}
