package org.ascending.training.repository;

import org.ascending.training.model.Employees;

import java.util.List;

public interface IEmployeesDao {
    //DAO has 4 utilities, CRUD
    //Create, mapping java to records in the db
    void save(Employees employees); //or return a boolean to indicate status of save or Exception handling
    //the return value is not important. input is the same as output

    //Retrieve
    List<Employees> getDepartments(); //retrieve all or several objects
    //the return value is important, because I want to retrieve something

    //Update, (1)this object has to be in db first, use HQL to find, (2) want to change this record
    //Update = get + change + save
    //HQL: SELECT Department from as d where d.id=1 (id is Primary key)
    Employees getById(Long id); //use id to find record in db or return void, must have a reason for a return type
    // the return value is a new department object


    //Delete, delete record in db, what to do in java? (java object is a record in db)
    boolean delete(Employees employees); //nothing to return after deleting

}
