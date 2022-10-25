package com.chagwey.springbootinventorymanagement.service.auth;

import com.chagwey.springbootinventorymanagement.model.auth.ExtendedUser;
import com.chagwey.springbootinventorymanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.chagwey.springbootinventorymanagement.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        log.info(email);
        User user = userService.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new ExtendedUser(user.getEmail(), user.getPassword(), authorities, user.getCompany().getId());


//        org.springframework.security.core.userdetails.User is a class that implenents UserDetails class

    }


}
