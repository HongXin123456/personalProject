package org.ascending.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customers {
//    id              BIGSERIAL NOT NULL PRIMARY KEY,
//    first_name      VARCHAR(30) not null unique,
//    last_name       VARCHAR(30) not null unique,
//    email           VARCHAR(50),
//    address         VARCHAR(150),
//    num_Issue_opened    INTEGER,
//    customers_issues_fk INTEGER REFERENCES issues (id)

    public Customers(){}

    public Customers(String firstName, String lastName, String email, String address, int numIssueOpened){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
        this.address = address;
        this.numIssueOpened = numIssueOpened;
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
    @Column(name = "numIssueOpened")
    private int numIssueOpened;

    //    One           Many
    //    Issues        employees
    //    Customers     issues

    @OneToMany(mappedBy = "customers", cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "issues_id")
    private Set<Issue> issues;

    public void setId(long id) {
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setEmail(String email){this.email=email;}
    public void setAddress(String address){
        this.address=address;
    }
    public void setNumIssueOpened(int numIssueOpened){
        this.numIssueOpened=numIssueOpened;
    }
}
