package com.mikehenry.springbootjpabeginner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskID;

    private String taskName;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;
}
