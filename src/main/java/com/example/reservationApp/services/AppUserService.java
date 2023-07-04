package com.example.reservationApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.reservationApp.entities.AppUsers;
import com.example.reservationApp.repo.AppUserRepository;
@Service
public class AppUserService implements UserDetailsService {

    @Autowired
        private AppUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final AppUsers user = userRepository.findByUserName(username).orElseThrow(()->
     new UsernameNotFoundException("User not found"));
    return User.builder().username(user.getUserName()).password(user.getPassword()).
    roles(user.getRole()).build();
    }
    
}
