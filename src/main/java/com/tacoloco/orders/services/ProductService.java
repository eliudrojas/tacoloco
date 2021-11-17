package com.tacoloco.orders.services;

import com.tacoloco.orders.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProduct();
    ProductDTO create(ProductDTO order);
    ProductDTO update(ProductDTO order);
}
