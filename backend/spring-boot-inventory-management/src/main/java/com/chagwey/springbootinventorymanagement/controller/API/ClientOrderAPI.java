package com.chagwey.springbootinventorymanagement.controller.API;

import com.chagwey.springbootinventorymanagement.model.Article;
import com.chagwey.springbootinventorymanagement.model.ClientOrder;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/clientsOrders")
public interface ClientOrderAPI {

    //    @ApiOperation(value = "Find all clients orders", notes = "This method allows you to retrieve all clients orders from DB", responseContainer = "List<ClientOrder>")
//    @ApiResponses(value = {
//    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ClientOrder>> findAll();

    //    @ApiOperation(value = "Save client order", notes = "This method allows you to add or modify a client order", response = ClientOrder.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Client order added/modified successfully"),
//            @ApiResponse(code = 400, message = "Client order not valid")
//    })
    @PostMapping
    ClientOrder save(@RequestBody ClientOrder clientOrder);
}
