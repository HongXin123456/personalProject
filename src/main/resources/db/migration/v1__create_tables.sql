CREATE TABLE employees (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    first_name      VARCHAR(30) not null unique,
    last_name       VARCHAR(30) not null unique,
    email           VARCHAR(50),
    address         VARCHAR(150),
    hired_date      date,
    num_Issue_closed   INTEGER
);


CREATE TABLE issues (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    problem_description            VARCHAR(500) not null unique,
    open_date      date,
    close_date       date,
    closed          VARCHAR(1),
    priority          VARCHAR(10),
   issues_employees_fk INTEGER REFERENCES employees (id)
);

CREATE TABLE customers (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    first_name      VARCHAR(30) not null unique,
    last_name       VARCHAR(30) not null unique,
    email           VARCHAR(50),
    address         VARCHAR(150),
    num_ssue_opened    INTEGER,
    customers_issues_fk INTEGER
 REFERENCES issues (id)
);
