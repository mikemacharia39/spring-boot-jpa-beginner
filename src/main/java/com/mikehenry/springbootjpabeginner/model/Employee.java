package com.mikehenry.springbootjpabeginner.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID")
    private long employeeID;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private String emailAddress;

    private int active;

    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date dateModified;

    @OneToOne(fetch = FetchType.LAZY) //to support lazy loading
    @JoinColumn(name = "addressID")
    Address address;
}
