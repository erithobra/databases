---
title: Intro to SQL
type: lesson
duration: "1:25"
creator:
    name: Jay Nappy
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Intro to SQL

### Objectives

*After this lesson, students will be able to:*

- Create a database table.
- Insert, retrieve, update, and delete a row (or rows) of a database table.

## Intro: We Know About Databases, But What Is SQL? (10 min)

Let's review: At its simplest, a **relational database** is a mechanism for storing and retrieving data in a tabular form. Spreadsheets are a good analogy! But, how do we interact with our database (inserting, updating, retrieving, and deleting data)? That's where SQL comes in!

#### What Is SQL?

SQL stands for **Structured Query Language**, and it's a language that's universally used and adapted to interact with relational databases. When you use a SQL client and connect to a relational database that contains tables with data, the scope of what you can do with SQL commands includes:

- Inserting data.
- Querying or retrieving data.
- Updating or deleting data.
- Creating new tables and entire databases.
- Controlling permissions of who can access to our data.

Note that all of these actions depend on what the database administrator sets for user permissions. If you're an analyst, for example, you'll only have access to retrieving company data. But, as a developer, you could access all of these commands and be in charge of setting the database permissions for your web or mobile application.

#### Why Is SQL Important?

A database is just a repository for storing data, and you need to use systems to dictate how that data will be stored and how clients will interact with it. We call these systems **database management systems**, and they come in _many_ forms:

- MySQL
- SQLite
- PostgreSQL (what we'll be using!)

All of these management systems use SQL (or some adaptation of it) as a language for managing data in the system.

## Code-Along: Connect and Create a Database (10 min)

Let's create a database! First, make sure you have PostgreSQL running. Once you do, open your terminal and type:

```bash
$ psql
```

You should see something like:

```bash
your_user_name=#
```

Great! You've entered the PostgreSQL equivalent of IRB: Now, you can execute PSQL commands (or PostgreSQL's version of SQL).

Let's use these commands; but before we can, we must create a database. Let's call it `sei`:

```psql
your_user_name=# CREATE DATABASE sei;
CREATE DATABASE
```

The semicolon is important! Be sure to always end your SQL queries and commands with semicolons.

Now let's _use_ that database we just created:

```psql
your_user_name=# \c sei
You are now connected to database "sei" as user "your_user_name".
sei=#
```

## Demo: Create a Table (10 min)

Now that we have a database, let's create a table. (Think of this like: "Hey, now that we have a workbook/worksheet, let's block off these cells with a border and labels to show it's a unique set of values.")

#### SQL Style Guide (See http://www.sqlstyle.guide)

1. Fields should *always* be lower case.
2. SQL _keywords_ should always be upper case. 
2. Never name a field `id`; always correlate it to the table name (e.g., `student_id`).
3. Always check your company's style guide or follow the convention; never create your own style.

```sql
CREATE TABLE instructors (
  instructor_id SERIAL PRIMARY KEY NOT NULL,
  name TEXT NOT NULL,
  experience INT NOT NULL,
  website VARCHAR(50)
);
```

When we paste this into PSQL:

```psql
sei=# CREATE TABLE instructors (
sei(#  instructor_id  SERIAL PRIMARY KEY   NOT NULL,
sei(#  name           TEXT          NOT NULL,
sei(#  experience     INT           NOT NULL,
sei(#  website        CHAR(50)
sei(#  );
CREATE TABLE
```

Notice the different parts of these commands:

```psql
sei=# CREATE TABLE instructors (
```
This starts our table creation; it tells PostgreSQL to create a table named `instructors`...

```psql
sei(#  instructor_id        SERIAL   PRIMARY KEY   NOT NULL,
sei(#  name      TEXT                NOT NULL,
```

...then, each successive line denotes a new column we're going to create for this table, what the column will be called, the data type, whether or not it's a primary key, and if the database (when data is added) can allow data without missing values. In this case, we're not allowing `name` or `instructor_id` to remain blank; but we're OK with `website` being blank.

## Code-Along: Create a Student Table and Insert Data (10 min)

Now that we're keeping track of our instructors, let's create a table for students that collects information about:

- An `id` (cannot be left blank).
- The student's name (cannot be left blank).
- Their age.
- Their address (cannot be left blank).

> **Instructor Note**: Remembering the commands we just went over, students should try to guide the instructors through this!  

Here's what that query should have looked like:

```sql
CREATE TABLE students (
  student_id SERIAL PRIMARY KEY NOT NULL,
        name TEXT NOT NULL,
         age INT NOT NULL,
     address VARCHAR(50)
);
```

In PSQL, that will look like:

```psql
sei=# CREATE TABLE students (
sei(#  student_id  SERIAL   PRIMARY KEY   NOT NULL,
sei(#  name        TEXT                NOT NULL,
sei(#  age         INT                 NOT NULL,
sei(#  address     VARCHAR(50)
sei(#  );
CREATE TABLE
```
Great job! Now let's finally _insert_ some data into that table. Remember what cannot be left blank!

We'll insert five students: Jack, Jill, John, Jackie, and Slagathorn. The syntax is as follows:

```psql
INSERT INTO table_name VALUES (value1, value2, value3,...);
```

Let's do it for Jack:

```sql
INSERT INTO students VALUES (DEFAULT, 'Jack Sparrow', 28, '50 Main St, New York, NY');
```
In PSQL, that will look like:

```psql
sei=# INSERT INTO students VALUES (DEFAULT, 'Jack Sparrow', 28, '50 Main St, New York, NY');
INSERT 0 1
```

## Independent Practice: Insert Data (10 min)

Now, try it for the other students and pay attention to the order of Jack's parameters and the single quotes; they both matter.

- Jill's full name is Jilly Cakes; she's 30 years old and lives at 123 Webdev Dr. Boston, MA.
- John's full name is Johnny Bananas; he's 25 years old and lives at 555 Five St, Fivetowns, NY.
- Jackie's full name is Jackie Lackie; she's 101 years old and lives at 2 OldForThis Ct, Fivetowns, NY.
- Slagathorn's full name is Slaggy McRaggy; he's 28 years old and prefers not to list his address.

You should come up with:

```sql
INSERT INTO students VALUES (DEFAULT, 'Jilly Cakes', 30, '123 Webdev Dr. Boston, MA');
INSERT INTO students VALUES (DEFAULT, 'Johnny Bananas', 25, '555 Five St, Fivetowns, NY');
INSERT INTO students VALUES (DEFAULT, 'Jackie Lackie', 101, '2 OldForThis Ct, Fivetowns, NY');
INSERT INTO students VALUES (DEFAULT, 'Slaggy McRaggy', 28);
```

In PSQL, this should look like:

```psql
sei=# INSERT INTO students VALUES (DEFAULT, 'Jilly Cakes', 30, '123 Webdev Dr. Boston, MA');
INSERT 0 1
sei=# INSERT INTO students VALUES (DEFAULT, 'Johnny Bananas', 25, '555 Five St, Fivetowns, NY');
INSERT 0 1
sei=# INSERT INTO students VALUES (DEFAULT, 'Jackie Lackie', 101, '2 OldForThis Ct, Fivetowns, NY');
INSERT 0 1
sei=# INSERT INTO students VALUES (DEFAULT, 'Slaggy McRaggy', 28);
INSERT 0 1
```


## Code-Along: What's in Our Database? (15 min)

Now that we have this data saved, we're going to need to access it at some point, right? We're going to want to _select_ particular data points in our data set, provided certain conditions. The PostgreSQL `SELECT` statement is used to fetch data from a database table that returns data in the form of a result table. These result tables are called **result sets**, and their syntax is just what you would have guessed:

```psql
SELECT column1, column2, column3 FROM table_name;
```
We can pass in the columns we want to look at (such as above), or even get all of our table records:

```psql
SELECT * FROM table_name;
```

For example, we can get all of the records back:

```psql
sei=# SELECT * FROM students;
 id |      name      | age |                      address
----+----------------+-----+----------------------------------------------------
  1 | Jack Sparrow   |  28 | 50 Main St, New York, NY
  2 | Jilly Cakes    |  30 | 123 Webdev Dr. Boston, MA
  3 | Johnny Bananas |  25 | 555 Five St, Fivetowns, NY
  4 | Jackie Lackie  | 101 | 2 OldForThis Ct, Fivetowns, NY
  5 | Slaggy McRaggy |  28 |
(5 rows)
```

We can get just the names and ages of our students:

```psql
sei=# SELECT name, age FROM students;
      name      | age
----------------+-----
 Jack Sparrow   |  28
 Jilly Cakes    |  30
 Johnny Bananas |  25
 Jackie Lackie  | 101
 Slaggy McRaggy |  28
(5 rows)
```

#### Getting More Specific

As with Ruby or JavaScript, all of our comparison and Boolean operators can help us select more specific data.

- Say I want the names of all of the students who aren't dinosaurs:

```psql
sei=# SELECT name FROM students WHERE age < 100;
      name
----------------
 Jack Sparrow
 Jilly Cakes
 Johnny Bananas
 Slaggy McRaggy
(4 rows)
```

Done! 

- How about the names of students ordered by age?

```psql
sei=# SELECT name, age FROM students ORDER BY age;
      name      | age
----------------+-----
 Johnny Bananas |  25
 Jack Sparrow   |  28
 Slaggy McRaggy |  28
 Jilly Cakes    |  30
 Jackie Lackie  | 101
(5 rows)
```

Done!

- How about reversed?

```psql
sei=# SELECT name, age FROM students ORDER BY age DESC;
      name      | age
----------------+-----
 Jackie Lackie  | 101
 Jilly Cakes    |  30
 Jack Sparrow   |  28
 Slaggy McRaggy |  28
 Johnny Bananas |  25
(5 rows)
```

Done!

- How about those students who live in Fivetowns?

```psql
sei=# SELECT * FROM students WHERE address LIKE '%Fivetowns%';
 id |      name      | age |                      address
----+----------------+-----+----------------------------------------------------
  3 | Johnny Bananas |  25 | 555 Five St, Fivetowns, NY
  4 | Jackie Lackie  | 101 | 2 OldForThis Ct, Fivetowns, NY
(2 rows)
```

We can find strings within strings, too!

## Code-Along: Updates to Our Database (5 min)

OK, there are some mistakes we've made to our database, but that's cool, because we can update it or delete information we don't like. Let's start by adding one more student:

```psql
sei=# INSERT INTO students VALUES (6, 'Miss Take', 500, 'asdfasdfasdf');
INSERT 0 1
```

But, oh no, we messed them up! Miss Take doesn't live at asdfasdfasdf; she lives at 100 Main St., New York, NY. Let's fix it:  

```psql
sei=# UPDATE students SET address = '100 Main St., New York, NY' where address = 'asdfasdfasdf';
UPDATE 1

sei=# SELECT * FROM students;
 id |      name      | age |                      address
----+----------------+-----+----------------------------------------------------
  1 | Jack Sparrow   |  28 | 50 Main St, New York, NY
  2 | Jilly Cakes    |  30 | 123 Webdev Dr. Boston, MA
  3 | Johnny Bananas |  25 | 555 Five St, Fivetowns, NY
  4 | Jackie Lackie  | 101 | 2 OldForThis Ct, Fivetowns, NY
  5 | Slaggy McRaggy |  28 |
  6 | Miss Take      | 500 | 100 Main St., New York, NY
(6 rows)
```

But wait, she just canceled. No big deal!

```psql
sei=# DELETE FROM students where name = 'Miss Take';
DELETE 1

sei=# SELECT * FROM students;
 id |      name      | age |                      address
----+----------------+-----+----------------------------------------------------
  1 | Jack Sparrow   |  28 | 50 Main St, New York, NY
  2 | Jilly Cakes    |  30 | 123 Webdev Dr. Boston, MA
  3 | Johnny Bananas |  25 | 555 Five St, Fivetowns, NY
  4 | Jackie Lackie  | 101 | 2 OldForThis Ct, Fivetowns, NY
  5 | Slaggy McRaggy |  28 |
(5 rows)

```

## Independent Practice: SQL Challenges (10 min)

There's _no way_ you're going to remember the exact syntax of everything we just did, but let's practice something you should have been doing since Week 1: finding and reading documentation. Check out [this PostgreSQL tutorial](http://www.tutorialspoint.com/postgresql/) and, using the same database and data table of users, complete as many of these SQL challenges as possible in the next 10 minutes:

- Insert five more students:
  - Nancy Gong is 40 years old and lives at 200 Horton Ave., Lynbrook, NY.
  - Laura Rossi is 70 years old and listed her address as "Unlisted."
  - David Daniele is 28 years old and lives at 300 Dannington Ln., Washington, D.C.
  - Greg Fitzgerald is 25 years old and did not list an address.
  - Randi Fitz is 28 years old and lives in Oceanside, NY.

- Randi wants her address to be corrected to 25 Broadway, New York, NY.
- Get a list of names and addresses for students who are older than 30, then order them by their address alphabetically.
- Get a list of students whose first name begins with the letter "J."
- Get a list of student names who live in NY or MA.

## Conclusion (5 min)

When we finally hook our apps up to databases (especially with Rails), we'll have a whole slew of shortcuts we can use to get the data we need. So, wait, why the heck are we practicing SQL? Well, let's look at what happens when you call for a particular user from a `users` table (with some nifty methods) in a Rails environment when you're connected to a database:

```ruby  
User.last
  User Load (1.5ms)  SELECT  "users".* FROM "users"   ORDER BY "users"."id" DESC LIMIT 1
=> #<User id: 1, first_name: "jay", last_name: "nappy"...rest of object >
```

There's SQL!!!

```SQL
SELECT  "users".* FROM "users"   ORDER BY "users"."id" DESC LIMIT 1
```

The Ruby on Rails scripts get converted to raw SQL before they query the database. Going forward, you'll know the underlying concepts and query language for how the requested data is returned to you.

#### Common PostgreSQL Commands

Here is a list of some common PostgreSQL commands you may need:

- `\c` - Connect to database
- `\l`
- `\d`
- `\d+`
- `\q`
- `\h` - Help


Answer these questions:

- How does SQL relate to relational databases?
- What kinds of Boolean and conditional operators can we use in SQL?
