# Useful commands

## Postgres (command line)

### start postgres
```sh
psql -U <postgres-username>
```

### create database

```sh
CREATE DATABASE company;
```

### connect to the database
```sh
\c company
```

### create table in the database

```
CREATE TABLE employees (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    age INT,
    address VARCHAR(255),
    salary INT,
    UNIQUE(name,age,address)
);

CREATE TABLE departments (
    id SERIAL PRIMARY KEY NOT NULL,
    dept VARCHAR(255),
    emp_id SERIAL NOT NULL,
    FOREIGN KEY (emp_id) REFERENCES employees(id)
);
```

### insert data into the database 

```sh
\copy employees(name,age,address,salary) FROM '<path-to-dir>/databases/sql-joins-lesson/starter-code/employees.csv' DELIMITER ',' CSV HEADER;

\copy departments(dept,emp_id) FROM '<path-to-dir>/databases/sql-joins-lesson/starter-code/departments.csv' DELIMITER ',' CSV HEADER;
```

## Postgres (psql client)

### show all tables
```sh
\dt
```

### describe a table
```sh 
\d <table_name>
```

### quit session
```sh 
\q
```



