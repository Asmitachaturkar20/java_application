package com.Miner.s2TODOapp.repository;

import com.Miner.s2TODOapp.model.ToDo;
import com.Miner.s2TODOapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ToDoReposirtory extends JpaRepository<Integer,ToDo> {
    public List<ToDo> findByUserOrderSchedule(User user);
}
