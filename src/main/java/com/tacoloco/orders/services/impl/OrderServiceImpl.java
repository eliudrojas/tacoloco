package com.tacoloco.orders.services.impl;

import com.tacoloco.orders.dto.OrderDTO;
import com.tacoloco.orders.entity.Orders;
import com.tacoloco.orders.entity.OrderDetails;
import com.tacoloco.orders.repository.OrderRepository;
import com.tacoloco.orders.services.OrderService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<OrderDTO> findAllOrder() {
        return modelMapper.map(orderRepository.findAll(), new TypeToken<List<OrderDTO>>() {}.getType());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        Orders orders = modelMapper.map(orderDTO, new TypeToken<Orders>() {}.getType());


        // lambda for demo purposes
        Orders orders1 = new Orders();
        orders1.setOrderId(orderDTO.getOrderId());
        orders1.setClientId(orderDTO.getClientId());
        orders1.setOrderDetails(orderDTO.getOrderDetails().stream().map(p -> new OrderDetails(p.getOrderId(),p.getProductId(), p.getQuantity()))
                .collect(Collectors.toList()));
        // lambda only for demo purposes.
        return modelMapper.map(orderRepository.save(orders), OrderDTO.class);
    }

    @Override
    public OrderDTO update(OrderDTO order) {
        return create(order);
    }
}
