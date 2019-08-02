---
Title: Relational Database Modeling
Type: Lab
Duration: "1:00"
Author:
    Name: Alex De Marco
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Relational Database Modeling

## Overview

We'll use crow's foot notation to create entity relationship diagrams (ERDs) that represent relational database models.

## Whiteboard Demo: Relationships (15 min)

Relationships happen when we start seeing multiple occurrences of duplicative information, or when one object needs to "connect" to another object.

There are three different kinds of relationships:

### One to One
- Not frequently used, but important to know it's an option.
- Imagine that a `library` table ```has_one``` location and a location ```belongs_to``` a specific library. This allows us to perform a lookup based solely on location and see the connected library.
- Oftentimes in situations like this, you can make the location an attribute of the library. But, when a location has, for example, multiple fields (`address 1`, `address 2`, `state`, `zip`, etc.), it might make sense to create another table for addresses and set up a ```has_one``` relationship.

### One to Many
- This is the most common type of database relationship.
- An author ```has_many``` books, but a book ```belongs_to``` only one author.

### Many to Many
- This is also very frequent.
- A book probably ```has many``` categories and a category also probably ```has many``` books.

Keep in mind that the ```belongs_to``` part always goes on the opposite side of the ```has_many``` or ```has_one```. The `ID` of the model that "has" something is stored in a field on the child, such as `customer_id` or `author_id`. In our example with authors and books, the book model ```belongs_to``` the author model, while the author (as mentioned) ```has_many``` books.

## Lab: Practice Database Design (45 min)

You are tasked with drawing an ERD for a hypothetical application. Think about what models you would need and what tables you'd create, including the associated attributes and how they might relate to other tables.

Over the next 45 minutes, break into groups of three and work together to draw out diagrams for one of the apps below. You'll be drawing on the wall, so snap photos of the drawings when you're finished for safe keeping.

Remember to consider all different angles in each of these examples. What job relationships exist? What people are there? What objects and intangible ideas are necessary? How would you organize it?

### Exercise

___Requirements___

- In your group, pick one of the following, design the table relationships, and draw them:

  - An app to run a grocery store.
  - An app to run an airline.
  - An app to run a school.
  - An app to run a team of developers.

___Deliverable___

An ERD, using crow's foot notation, of whatever app you choose. For example:

![ERD Example](https://www.edrawsoft.com/images/examples/entity-relationship-diagram.png)

> **Note**: This example has "items" as placeholders for the attributes.

### Additional Resources

- [Crow's Foot Notation Cheat Sheet](http://www.vivekmchawla.com/content/images/2013/Dec/ERD_Relationship_Symbols_Quick_Reference-1.png)
- An Extra-Relevant [Resource for Students](https://developer.mozilla.org/en-US/docs/Web/Events)




