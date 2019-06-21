# Installing Postgres

1.  Mac users, run the command `brew install postgres`
2.  Lets install using-

	3.  [Post gres app](https://postgresapp.com/)
	3.  Move the app to your `/Applications/` directory.
	4.  Now, double-click it to run it.
	5.  Select **Open Postgres** in the bottom-right corner.
			
			OR
			
	1. Run `brew tap homebrew/services` to install brew services.
	2. Then run `brew services start postgresql` to start postgres as a background service
	3. To stop postgres manually, run `brew services stop postgresql`. You can also use brew services to restart Postgres `brew services restart postgresql`


####  LIST ALL THE DATABASES!

* We've provided a cheatsheet of Postgres commands to help you out.
* First thing's first - run `psql postgres` on the terminal 
* Now, let'ssee if we have any databases!
* `\l` to list **all** databses using the following command:

#### Creating a database

* This is pretty straigtforward!
* Let's tell Postgres to create a database with a name!
* Syntax **matters**. Close each statement with a `;`
* `CREATE DATABASE mytest;`
* Run the list command to see our new database!
* To remove a database use `DROP DATABASE databasename;`

#### Connecting to your database
	
* Time to connect to our database.
* We can do that with the following syntax:
* `\c databasename`
* In our case, `\c mytest`
* We can't do anything inside of our DB until we connect to it.

####  Creating tables in a Database

* We specify to `CREATE TABLE name_of_table();`
* We pass in attribute names inside of the parenthases.

```sql
CREATE TABLE users 
(id SERIAL PRIMARY KEY, user_name varchar(255));
```

* Let's break this down...
* SERIAL PRIMARY KEY sets our Primary Key.
* We can now define the rest of our values using `attribute_name` with an associated `value_type`
* We organize them using commas to split them up.
* You can also use `\d+ tablename` to describe the table.

#### Listing tables in a database

* To see a list of all tables in a database...
* Run the following command:
* `\dt`


#### Adding rows to a database

Check this syntax out:

```sql
INSERT INTO users (user_name)
VALUES
('test_name');
```

* We don't need to include a Primary Key.
* Why? Remember auto-incremement?
* When we add a new row we get an automatic ID!
* We just specify the attributes to add into.
* And then we specify the **Values**!


#### Selecting rows from a database

* We can select all the rows!
* We use the **SELECT** statement!

```sql
SELECT * FROM courses;
```

* We can look for specific rows!

```sql
SELECT * FROM courses WHERE id = 1;
```

