package com.Miner.s2TODOapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String title;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "user_id")
    private User user;

    public ToDo() {
    }
}
