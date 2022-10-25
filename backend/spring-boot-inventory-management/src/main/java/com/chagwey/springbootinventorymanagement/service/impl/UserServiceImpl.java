package com.chagwey.springbootinventorymanagement.service.impl;

import com.chagwey.springbootinventorymanagement.exception.EntityNotFoundException;
import com.chagwey.springbootinventorymanagement.exception.ErrorCode;
import com.chagwey.springbootinventorymanagement.model.User;
import com.chagwey.springbootinventorymanagement.repository.UserRepository;
import com.chagwey.springbootinventorymanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.save(user);


    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElseThrow(() -> new EntityNotFoundException("No user with email " + email + " was found.",
                ErrorCode.USER_NOT_FOUND));

    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
