# Installing Postgres for Mac via Brew

## References

- [Install Postgres via Brew](https://gist.github.com/ibraheem4/ce5ccd3e4d7a65589ce84f2a3b7c23a3)

## Pre-Requisites

1. Install [Brew Package Manager](http://brew.sh)
1. Then check and update your brew installation:
   ```
    brew doctor
    brew update
   ```

## Install Postgres With Brew

1. Install postgres
   ```
   brew install postgresql
   ``` 

1. Start the Database Server
   ```
   pg_ctl -D /usr/local/var/postgres start
   ```

1. Create your database

   ```
    createdb `whoami`
   ```

1. Test you connection to the server
    ```
    $ psql
    psql (10.0)
    Type "help" for help.
    
    alex=# 
    ```

1. List databases
    ```
    psql -U alex -l
    ```

1. Show tables in database
    ```
    psql -U alex -d alex
    ```
    
1. (optional) Stop the Database Server

    If you ever want to stop your database server, run this command.

   ```
   pg_ctl -D /usr/local/var/postgres stop
   ```

