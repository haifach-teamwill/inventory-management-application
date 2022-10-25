package com.chagwey.springbootinventorymanagement.controller;

import com.chagwey.springbootinventorymanagement.controller.API.UserAPI;
import com.chagwey.springbootinventorymanagement.model.User;
import com.chagwey.springbootinventorymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController implements UserAPI {
    @Autowired
    private UserService userService;


//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer id) {

    }
}
