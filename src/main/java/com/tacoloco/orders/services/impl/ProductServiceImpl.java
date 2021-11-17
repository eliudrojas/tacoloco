package com.tacoloco.orders.services.impl;


import com.tacoloco.orders.dto.ProductDTO;
import com.tacoloco.orders.entity.Product;
import com.tacoloco.orders.repository.ProductRepository;
import com.tacoloco.orders.services.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findAllProduct() {
        return modelMapper.map(productRepository.findAll(),new TypeToken<List<ProductDTO>>() {}.getType());
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO product) {
        return create(product);
    }
}
