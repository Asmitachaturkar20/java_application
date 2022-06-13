package com.Miner.s2TODOapp.service;

import com.Miner.s2TODOapp.model.CustomUserDetail;
import com.Miner.s2TODOapp.model.User;
import com.Miner.s2TODOapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailesService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByEmail(name);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return optionalUser.map(CustomUserDetail::new).get();
    }
}