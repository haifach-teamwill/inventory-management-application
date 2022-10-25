package com.chagwey.springbootinventorymanagement.service;

import com.chagwey.springbootinventorymanagement.model.ClientOrder;

import java.util.List;

public interface ClientOrderService {

    List<ClientOrder> findAll();

    ClientOrder findById(Integer id);

    ClientOrder save(ClientOrder ClientOrderDTO);

    void delete(Integer id);
}
