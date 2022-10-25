package com.chagwey.springbootinventorymanagement.service;

import com.chagwey.springbootinventorymanagement.model.Client;

import java.util.List;


public interface ClientService {

    List<Client> findAll();

    Client findById(Integer id);

    Client save(Client clientDTO);

    void delete(Integer id);

}
