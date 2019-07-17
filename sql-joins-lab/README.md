---
title: SQL Joins
type: Lab
duration: "1:30"
creator:
    name: Yuliya Kaleda (and Alex De Marco)
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) SQL Joins Lab

## Introduction

> ***Note:*** _This should be done independently._

In this lab, you will create SQL scripts for Postgres that will create and initialize a database with two tables (Employee and Job) and then query the data in those tables. 

The Employee table has the following data:  

<p align="center">
  <img src="./screenshots/employee.png">  
</p>

The Job table looks like this:  

<p align="center">
  <img src="./screenshots/job.png">   
</p>

The main purpose of our scripts is to query information from both tables:  

1.  Show the full names of employees working at Macy's.
2.  Show the companies located in Boston.  
3.  Show the full name of the employee with the highest salary.  


## Exercise

### Requirements

An ``init_db.sh`` script should:  
  1. Create the database. 
  1. Create the tables.
  1. Populate the tables.

A ``run_queries.sh`` script should run three queries, one for each of the following:
  1. **Employees working at macys** - The full names of employees working at Macy's.
  1. **Companies in Boston** - The companies located in Boston.
  1. **Employee with the highest salary** - The full name of the employee with the highest salary.

*Note: Those two files can call other files if you wish.*

### Starter Code

Refer to [this lab's starter code](./starter-code) and as well as the [sql-join-lesson starter code](../sql-joins-lesson/starter-code) to build your solution.

### Deliverable

A pull request with all your code for a working app that meets the requirements above.
