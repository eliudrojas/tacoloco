package com.tacoloco.orders.services;


import com.tacoloco.orders.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAllOrder();
    OrderDTO create(OrderDTO order);
    OrderDTO update(OrderDTO order);


}
