package com.tacoloco.orders.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @NotNull
    private Long quantity;
}
