package com.chagwey.springbootinventorymanagement.controller.API;

import com.chagwey.springbootinventorymanagement.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/users")
public interface UserAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User save(@RequestBody User user);

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    User findById(@PathVariable("userId") Integer id);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> findAll();

    @DeleteMapping(value = "/userId", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("userId") Integer id);
}
