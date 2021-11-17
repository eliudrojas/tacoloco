package com.tacoloco.orders.controller;

import com.tacoloco.orders.dto.ClientDTO;
import com.tacoloco.orders.services.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PostMapping
    @ApiOperation(value = "Add new Client", response = ClientDTO.class)
    public ResponseEntity<ClientDTO> newClient (@RequestBody @Validated ClientDTO client) {
        return new ResponseEntity<ClientDTO> (clientService.create(client), HttpStatus.OK);
    }
}
