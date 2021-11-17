package com.tacoloco.orders.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @NotNull
    private Long clientId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

}
