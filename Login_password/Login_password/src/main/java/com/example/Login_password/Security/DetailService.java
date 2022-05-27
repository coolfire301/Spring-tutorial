package com.example.Login_password.Security;

import com.example.Login_password.Construct.Users;
import com.example.Login_password.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AppRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException(username + " is not yet registered");
        }
        return user;

    }

}