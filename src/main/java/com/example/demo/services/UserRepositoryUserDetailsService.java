package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserDetailsService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Spring will know that this is a bean
public class UserRepositoryUserDetailsService
    implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired //dependency injection
    public UserRepositoryUserDetailsService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null){
            return user;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
