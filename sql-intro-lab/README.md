---
title: SQL Basics
type: lab
duration: "2:00"
creator: Melissa Arliss, pulled from ed-prob-lib
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) SQL Basics

## Introduction

> **Note:** This can be a pair programming activity or done independently.

#### Where In The World Is Carmen Sandiego?

We're going to use what we've already learned about searching with SQL commands and apply it to chase down and capture an elusive and world-renowned thief: Carmen Sandiego. Follow the clues, use the interweb, write down both the SQL commands/queries you used and your answers to the clues, and figure out where Carmen is headed so we can catch her.

## Exercise

#### Requirements

- Fork and clone the [starter code](./starter-code).
- Use the `clues.sql` file as your "answer sheet."
- From the command line, let's create a new database called `carmen` and populate it with the SQL found in `world.sql`.

```
# Enter psql
psql

# Create database
CREATE DATABASE carmen;

# Connect to carmen
\c carmen
\i world.SQL
```

**Pro tip:** You can do this in one step with the command:

```bash
psql -U <postgres-username> -d carmen -f /your/path/to/this/file/starter-code/world.sql
```

After that, use the clues below to create the appropriate SQL queries to help you find Carmen. Tell us where she's heading!

### The Clues

  - **Clue No. 1:** We recently got word that someone fitting Carmen Sandiego's description has been traveling through Southern Europe. She's most likely traveling someplace where she won't be noticed, so find the least populated country in Southern Europe, and we'll start looking for her there.

  - **Clue No. 2:** Now that we're here, we have insight that Carmen was seen attending language classes in this country's officially recognized language. Check our databases and find out what language is spoken in this country so we can call in a translator to work with you.

  - **Clue No. 3:** We have new news on the classes Carmen attended: Our gumshoes tell us she's moved on to a different country; a country where people speak *only* the language she was learning. Find out which nearby country speaks nothing but that language.

  - **Clue No. 4:** We're booking the first flight out: Maybe we've actually got a chance to catch her this time! There are only two cities she could be flying to in the country. One is named the *same* as the country... that would be too obvious. We're following our gut on this one; find out what other city in that country she might be flying to.

  - **Clue No. 5:** Oh no, she pulled a switch. There are two cities with very similar names, but in totally different parts of the globe! She's headed to South America as we speak; go find a city whose name is *like* the one we were headed to but doesn't end in the same way. Find out the city, and perform another search for what country it's in. Hurry!

  - **Clue No. 6:** We're close! Our South American agent says she just got a taxi at the airport and is headed toward the capital! Look up the country's capital, and get there pronto. Send us the name of where you're headed and we'll follow right behind you.

  - **Clue #7:** She knows we're on to her. Her taxi dropped her off at the international airport, and she beat us to the boarding gates. We have one chance to catch her: We just have to know where she's heading and beat her to the gate. Lucky for us, she's getting cocky. She left us a note, and I'm sure she thinks she's very clever, but if we can crack it, we can finally put her where she belongs: behind bars.

```
  Our play date of late has been unusually fun ???
  As an agent, I'll say, you've been a joy to outrun.
  And while the food here is great, and the people ??? so nice!
  I need a little more sunshine with my slice of life.
  So I'm off to add one to the population I find
  In a city of ninety-one thousand and, now, eighty five.
```

#### Starter Code

Again, be sure to grab the `.sql` file from the [starter code](starter-code/world.sql) and run it in your PostgreSQL terminal using the commands above.

#### Deliverable

Use the `clues.sql` file to write in the SQL queries that correspond with each clue and tell us where Carmen's heading at the bottom.

## Additional Resources

- [PostgreSQL Tutorial](http://www.tutorialspoint.com/postgresql/)
- [PostgreSQL Official Documentation](http://www.postgresql.org/docs/)


