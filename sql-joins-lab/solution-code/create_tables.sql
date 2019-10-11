-- Create database tables

CREATE TABLE employees (
    ssn VARCHAR(255) PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    year_of_birth INT NOT NULL,
    city VARCHAR(255) NOT NULL
);

CREATE TABLE jobs (
    id SERIAL PRIMARY KEY NOT NULL,
    ssn VARCHAR(255) NOT NULL UNIQUE,
    company VARCHAR(255) NOT NULL,
    salary INT NOT NULL,
    experience INT NOT NULL,
    FOREIGN KEY (ssn) REFERENCES employees(ssn)
);

