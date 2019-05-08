# Installing Postgres for Mac via Brew

## References

- [Install Postgres via Brew](https://gist.github.com/ibraheem4/ce5ccd3e4d7a65589ce84f2a3b7c23a3)
- [Getting Started with PostgreSQL on Mac OSX
](https://www.codementor.io/engineerapart/getting-started-with-postgresql-on-mac-osx-are8jcopb)

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

1. Create a ``postgres`` superuser. It will prompt you to enter a password for the new user twice. (See [here](https://www.postgresql.org/docs/devel/app-createuser.html)) for more information.

   ```
   createuser -P -s postgres
   ```   
   
1. Create your database

   ```
    createdb `whoami`
   ```

1. Test you connection to the server
    ```
    $ psql
    psql (11.2)
    Type "help" for help.
    
    alex=# 
    ```
    Note: In addition to the ``postgres`` superuser created above, the installation process has created a superuser using your Mac username. When any user attempts to log in, it will not ask for a password. If you want to change that (and you probably should), see more about the [pg_hba.conf](https://www.postgresql.org/docs/9.1/auth-pg-hba-conf.html)) file. You can copy [this config file](pg_hba.conf) to ``/usr/local/var/postgres/pg_hba.conf ``
    
1. Terminate your session
    ```
    alex=# \q 
    ```

1. (optional) Stop the Database Server

    If you ever want to stop your database server, run this command.

   ```
   pg_ctl -D /usr/local/var/postgres stop
   ```
