---
Title: Intro to Relational Databases
Type: Lesson
Duration: "2:00"
Author:
    Name: Alex De Marco
    City: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Intro to Relational Databases

## Lesson Objectives

By the end of this lesson, students should be able to: 

- Explain what relational databases are used for.
- Explain how data is organized in relational databases.   
- Describe the relationship between tables, rows, and columns.
- Understand the basics of database normalization.

## Overview

Relational databases are a way to store and retrieve data on disk (or many disks). They provide more powerful storage and retrieval capabilities than simple files. They are used in banking, e-commerce, healthcare, and all kinds of web and enterprise applications. 

Knowing the basics of how they work, and how to use them (with SQL) will allow students to build “full stack” applications that include business logic (Java back-end), a UI (HTML/CSS/JS front-end), plus permanent storage in a database.

## What are Databases? - Intro (15 mins)

A database is a place where information is stored in a hard drive (or distributed across multiple hard drives) on a computer somewhere. Much as we've been creating and storing data here and there, a database represents a collection of individual pieces of data stored in a highly structured and searchable way; they represent a model of reality, which why we call them models in MVC.

Inside a database, we carry out basic actions such as Create, Read, Update, and Delete data (or CRUD)!

In modern web development, there are different categories of databases: Relational (a.k.a. SQL), NoSQL, Key/Value, and others. We're focusing on relational databases here.

SQL stands for Structured Query Language, and it's a language used to manage and get information from what are considered "relational" databases (we'll talk more about SQL next lesson).

We call these "relational" because different models (or pieces of data) can be linked to other models, a.k.a. "related." Relational databases store data in a "table"; think of it like a spreadsheet. The table holds all the data for one model, while the columns define the model's attributes; we often call columns "attributes" or "fields." A row is an instance (remember instantiation!); think of it as a unique copy of the blueprint that is our model (often called a record).

![relational db](https://cloud.githubusercontent.com/assets/25366/8589355/2646c588-25ca-11e5-9f2d-3d3afe8b7817.png)

## Let's Draw on The Board - We Do (30 mins)

> This lesson explains the basic idea around taking a real-world data problem and organizing a solution in tables and relationships between tables.

Let's say we're building an app for a library. Consider what some tables would look like (e.g., what information or attributes would be associated with each table?).

> Maybe call on random students to come up to the board to draw different tables with rows and columns. If we secretly guide them towards building individual models that should be related, we can naturally draw connections between them to show relationships.

- What would the table for a book look like?
- What would the table for an author look like?
- What would the table for a category look like?

This is when we start seeing relationships form. This is great. You can imagine duplicate pieces of data being stored naturally, especially when an author has multiple books (for instance). That's a waste of space! Let's talk about how we can connect these tables so we don't have tons of duplicate data all over the place.

## Explaining Relational Databases by Comparing Them to Spreadsheets (10 minutes) 

> This lesson explains the process of [database normalization](https://en.wikipedia.org/wiki/Database_normalization) by starting with a spreadsheet with lots of duplicated data, and then reorganizing the data into a relational database with less data duplication.

In spreadsheets, you'll often see a lot of duplicated data. Consider this example for a [Tire Store Inventory](Tire-Store.xlsx). 

Notice how the word "Pirelli" is listed 35 times? If you spelled it wrong and you wanted to correct the spelling, you'd need to do a search and replace for each of the 35 rows. 

Also notice that model names seem to be unique for each vendor. If you were adding new rows to your spreadsheet, it might get tricky to avoid entering models for the wrong vendor.

Finally, notice how you'd want to sum up the "Quantity in Stock" to find out how many tires you have in your inventory. You would never want to sum up aspect ratios; that just doesn't make sense.  

The process of de-duplicating data when you design a relational database is called "normalization." Going the other way is called "denormalization" or "flattening" your data.

### Let's Work on an Example Together (50 minutes):

> Instructor: State the problem below. Let students work on it on their own for a while (maybe 10-15 minutes). Then work through the solution in the rest of the time available (35 minutes). 

You run a tire store. You have a spreadsheet of your tire inventory. You sell 16 different models of tires in different sizes from three vendors: Michelin, Bridgestone, and Pirelli. You have over a thousand tires in your inventory. You can get started with [this spreadsheet](Tire-Store.xlsx). Note that tire sizes are always listed as a combination of width, aspect ratio, and diameter.
 
Describe how you would convert your spreadsheet into a relational database model so that: 
1. Vendor names "Michelin," "Bridgestone," and "Pirelli" are listed once, not repeated many times in many rows and tables.
1. Tire models are listed once, not repeated many times in many tables.
1. Tire size combinations (width, aspect ratio, diameter) should also only be in one table (not repeated many times). Hint: There are actually 7 sizes in the spreadsheet.

> Solution: 
> - One table called Vendor with three rows... one for each vendor.
> - One table called Model with 16 rows... one for each model.
> - One table called Size with 7 rows... one for a tuple of (width, aspect ratio, diameter).
> - One table called Inventory with a maximum of 3x16x7 rows. Each row has a relationship to Vendor, Model, Size (i.e., foreign keys) and an integer for "Quantity in Stock." 

__Bonus__: Design your model so that it would be impossible for a user to enter invalid vendor-model pairs into your inventory. For example, invalid pairs would be (Pirelli, Ecopia) or (Michelin, Nero).  

> There are at least a couple of ways to complete this bonus question. One way is to combine Vendor and Model into one table. If you do this, your data would not be normalized because you'd be repeating the Vendor name many times, but maybe that's OK. Another way is to create a new table, called VendorModel, which relates only valid Vendor and Model rows to each other; then each row of Inventory would relate to VendorModel instead of Vendor and Model separately.    

## Conclusion (15 mins)

- Why would you use a relational database? 
- Why use a relational database instead of a NoSQL database (assuming NoSQL has been taught in a prior lesson)?
- How would you describe "normalization" to your grandma? Think about the metaphor of storing data like a spreadsheet.



