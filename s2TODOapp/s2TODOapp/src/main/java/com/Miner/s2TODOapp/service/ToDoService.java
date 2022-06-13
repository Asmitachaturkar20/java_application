package com.Miner.s2TODOapp.service;

import com.Miner.s2TODOapp.model.ToDo;
import com.Miner.s2TODOapp.model.User;
import com.Miner.s2TODOapp.repository.ToDoReposirtory;
import com.Miner.s2TODOapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ToDoReposirtory toDoReposirtory;
    public List<ToDo> getAllTodo(){
        List<ToDo> toDos = null;
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser= userRepository.findUserByEmail(email);
        if((optionalUser).isPresent()){
           toDos = toDoReposirtory.findByUserOrderSchedule(optionalUser.get());
           return toDos;
        }
        return toDos;
    }
}
