package org.ascending.training.model;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "issues")
public class Issue {
//    id              BIGSERIAL NOT NULL PRIMARY KEY,
//    problem_description            VARCHAR(500) not null unique,
//    open_date      date,
//    close_date       date,
//    closed          VARCHAR(1),
//    priority          VARCHAR(10),
//    issues_employees_fk INTEGER REFERENCES employees (id)


    public Issue(){}
    public Issue(String problemDescription, String openDate, String closeDate, String closed, String priority){
        this.problemDescription = problemDescription;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.closed = closed;
        this.priority = priority;
    }
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "problemDescription")
    private String problemDescription;
    @Column(name = "open_date")
    private String openDate;
    @Column(name = "close_date")
    private String closeDate;
    @Column(name = "closed")
    private String closed;
    @Column(name = "priority")
    private String priority;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customers customers;
    @OneToMany(mappedBy = "issues", cascade = CascadeType.REMOVE)
    private Set<Employees> employees;

    public void setId(long id) {
        this.id = id;
    }
    public void setProblemDescription(String problemDescription){
        this.problemDescription = problemDescription;}
    public void setOpenDate(String openDate){
        this.openDate=openDate;
    }
    public void setCloseDate(String closeDate){
        this.closeDate=closeDate;
    }
    public void setClosed(String closed){
        this.closed=closed;
    }
    public void setPriority(String priority){
        this.priority=priority;
    }
}

