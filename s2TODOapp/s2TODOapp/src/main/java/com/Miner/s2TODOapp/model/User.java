package com.Miner.s2TODOapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="user_id")
    private int id;


    private String firstname;
    private String lastname;
    private String password;
    @Column(unique=true)
    private String email;


    public User (User user){
        this.firstname=user.getFirstname();
        this.lastname=user.getLastname();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.id=user.getId();

    }
    public User(){

    }
}
