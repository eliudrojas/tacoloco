package com.tacoloco.orders.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull
    private Long orderId;

    @NotNull
    private Long clientId;

    @NotNull
    private List<OrderDetailsDTO> orderDetails;

}
