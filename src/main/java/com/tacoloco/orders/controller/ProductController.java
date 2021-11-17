package com.tacoloco.orders.controller;

import com.tacoloco.orders.dto.OrderDTO;
import com.tacoloco.orders.dto.ProductDTO;
import com.tacoloco.orders.services.OrderService;
import com.tacoloco.orders.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create (@RequestBody @Validated ProductDTO productDTO) {
        return new ResponseEntity<ProductDTO> (productService.create(productDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll () {
        return new ResponseEntity<List<ProductDTO>> (productService.findAllProduct(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update (@RequestBody @Validated ProductDTO  productDTO) {
        return new ResponseEntity<ProductDTO> (productService.update(productDTO), HttpStatus.OK);
    }
}
