package com.chagwey.springbootinventorymanagement.service;

import com.chagwey.springbootinventorymanagement.model.Article;
import com.chagwey.springbootinventorymanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
}
