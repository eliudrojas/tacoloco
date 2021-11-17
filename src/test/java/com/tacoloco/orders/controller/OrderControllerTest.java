package com.tacoloco.orders.controller;

import com.tacoloco.orders.dto.OrderDTO;
import com.tacoloco.orders.dto.OrderDetailsDTO;
import com.tacoloco.orders.services.OrderService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(value = OrderController.class)
class OrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    List<OrderDetailsDTO> orderDetailsDTO;



    @MockBean
    private OrderService service;



    @Test
    public void statusCode200() throws Exception {

        Mockito.when(service.findAllOrder()).thenReturn(createData());
        mockMvc.perform(get("/api/v1/orders")).andExpect(status().isOk());
    }

    @Test
    public void finddAll() throws Exception {

        Mockito.when(service.findAllOrder()).thenReturn(createData());
        mockMvc.perform(get("/api/v1/orders")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].orderId", Matchers.equalTo(1)));
    }


    List<OrderDTO> createData() {
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        List <OrderDTO> orders = new ArrayList<>();

        List orderDetailsList = new ArrayList<>();

        orderDetailsDTO.setOrderId(1L);
        orderDetailsDTO.setProductId(1L);
        orderDetailsDTO.setQuantity(1L);
        orderDetailsList.add(orderDetailsDTO);

        OrderDTO order = new OrderDTO();
        order.setOrderId(1L);
        order.setClientId(1L);
        order.setOrderDetails(orderDetailsList);
        orders.add(order);
        return orders;
    }
}