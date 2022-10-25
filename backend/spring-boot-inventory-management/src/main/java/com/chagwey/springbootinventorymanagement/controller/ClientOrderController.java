package com.chagwey.springbootinventorymanagement.controller;


import com.chagwey.springbootinventorymanagement.controller.API.ClientOrderAPI;
import com.chagwey.springbootinventorymanagement.model.ClientOrder;
import com.chagwey.springbootinventorymanagement.model.ClientOrderItem;
import com.chagwey.springbootinventorymanagement.service.ClientOrderService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin("*")
@RestController
@Slf4j
public class ClientOrderController implements ClientOrderAPI {

    private ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @Override
    public ClientOrder save(@RequestBody ClientOrder clientOrder) {
        ClientOrder newClientOrder = clientOrderService.save(clientOrder);
        return newClientOrder;

    }


    @Override
    public ResponseEntity<List<ClientOrder>> findAll() {
        List<ClientOrder> clientsOrders = clientOrderService.findAll();
        return new ResponseEntity<>(clientsOrders, OK);
    }


}
