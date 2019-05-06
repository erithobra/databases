---
Title: Relational Database Modeling
Type: Lesson
Duration: "2:00"
Author:
    Name: Alex De Marco
    City: NYC
---

# Relational Database Modeling

Students need to understand tables and relationships between them so that they can write SQL in the next lesson to store and operate on data in relational databases. We'll use Crow's Foot notation to create Entity-Relationship (ER) diagrams that represent relational database models.

## Objectives

- Describe the relationship between tables, rows, and columns.
- Draw entity relationship diagrams with crow's foot notation.
- Describe how tables relate to each other using foreign keys.
- Explain the different relationship types – has_many_through, has_and_belongs_to_many, belongs_to.
- Get hands-on practice building ERDs.

## References

- [GA WDI - Intro to Relational Data Modeling](https://git.generalassemb.ly/ed-product-library/wdi-curriculum/blob/master/resources/05-databases/data-modeling-intro-lesson/)
- [GA WDI - Practice Database Design](https://git.generalassemb.ly/ed-product-library/wdi-curriculum/tree/master/resources/05-databases/data-modeling-erd-design-lab)

## Relationships - Whiteboard Demo (30 mins)

> Note: Use the [author/book/category example](../relational-databases-intro-lesson#lets-draw-on-the-board---we-do-30-mins) tables from the prior lesson to demonstrate creating relationships by making an ERD on the whiteboard; you should use crow's foot notation, making a point to demonstrate it on the board with our existing table drawings.

> ![crows foot notation cheat sheet](http://www.vivekmchawla.com/content/images/2013/Dec/ERD_Relationship_Symbols_Quick_Reference-1.png)

Relationships happen when we start seeing multiple duplicative information or when one object needs to "connect" to another object.

There are 3 different kinds:

### One to One
- not frequently used, but important to know it's an option
- imagine a Library table ```has_one``` location, and a location ```belongs_to``` a specific library - that lets us look up solely by location, and see the connected library
- often, in situations like that, you can make the location an attribute of the library, but when a location has, for example, multiple fields (address 1, address 2, state, zip, etc.), it might make sense to create another table for addresses and set up a ```has_one``` relationship

### One to Many
- the most common type of database relationship
- an author ```has_many``` books, but a book ```belongs_to``` only one author

### Many to Many
- also very frequent
- a book probably ```has many``` categories, and a category also probably ```has many``` books

Keep in mind, the ```belongs_to``` part always goes on the opposite side of the ```has_many``` or ```has_one```. And the way it's stored is that the ID of the model that "has" something is stored in a field on the child, like "customer_id" or "author_id".  In our example with authors and books, the Book model ```belongs_to``` the Author model, while the Author, as mentioned, ```has_many``` books.

## Practice Database Design Lab (90 minutes)

You are tasked with drawing ERDs for a handful of hypothetical applications. Think about what models you would need and what tables you'd create, including the associated attributes and how they would related to other tables.

Over the next 60 minutes, break into groups of three and work together to draw out diagrams for one of the apps below. You'll be drawing on the wall, so snap photos of the drawings when you've finished for safe keeping.

In the last 30 minutes of class, we'll ask for volunteers (or pick some participants) to walk us through your thinking & explain your decisions.

Remember to consider all different angles in each of these examples. What jobs relationships exist? What people are there? What objects and intangible ideas are necessary? How would you organize it?

### Exercise

___Requirements___

- Pick one of the following in your group, design the table relationships, and draw them:

  - an app to run a grocery store
  - an app to run an airline
  - an app to run a school
  - an app to run a team of developers

___Deliverable___

An ERD diagram, using crow's foot notation, of whatever app you choose.  For example:


![ER Diagram Example](https://www.edrawsoft.com/images/examples/entity-relationship-diagram.png)

> Note: this example has "Items" as placeholders for the attributes.


### Additional Resources

- [crows foot notation cheat sheet](http://www.vivekmchawla.com/content/images/2013/Dec/ERD_Relationship_Symbols_Quick_Reference-1.png)
- Extra relevant [resource for students](https://developer.mozilla.org/en-US/docs/Web/Events)





