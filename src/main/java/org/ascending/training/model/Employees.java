package org.ascending.training.model;
import javax.persistence.*;
import java.math.BigDecimal;

public class Employees {
//    id              BIGSERIAL NOT NULL PRIMARY KEY,
//    first_name      VARCHAR(30) not null unique,
//    last_name       VARCHAR(30) not null unique,
//    email           VARCHAR(50),
//    address         VARCHAR(150),
//    hired_date      date,
//    num_Issue_closed   INTEGER

    public Employees(){}
    public Employees(String firstName, String lastName, String email, String address, long hiredDate, int numIssueClosed){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this. address = address;
        this.hiredDate = hiredDate;
        this.numIssueClosed = numIssueClosed;
    }
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "hire_date")
    private long hiredDate;
    @Column(name = "num_issue_closed")
    private int numIssueClosed;

    //    One          Many
    //    Issue        employees
    //    Customer     issue

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    public void setId(long id) {
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setHiredDate(long hiredDate){
        this.hiredDate=hiredDate;
    }
    public void setNumIssueClosed(int numIssueClosed){
        this.numIssueClosed=numIssueClosed;
    }
}
