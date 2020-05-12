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

### drop database

```sh
psql -c 'DROP DATABASE company;'
```

### connect to the database
```sh
\c company
```

### insert data into the database
```sh
psql -d company -f insert_data.sql
```

### delete data from the database
```sh
psql -d company -c "truncate table employees cascade;"
```

### insert data into the datavase (alternative without hardcoded full path)
```sh
psql -d company -c "COPY employees(name,age,address,salary) FROM '`pwd`/employees.csv' DELIMITER ',' CSV HEADER";
psql -d company -c "COPY departments(dept_name,emp_id) FROM '`pwd`/departments.csv' DELIMITER ',' CSV HEADER";
```

### stop postgres
```sh 
pg_ctl -D /usr/local/var/postgres start
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



