---
Title: Relational Database Modeling
Type: Lesson
Duration: "2:00"
Author:
    Name: Alex De Marco
    City: NYC
---

# Relational Database Modeling

## Objectives

- Describe the relationship between tables, rows, and columns.
- Draw entity relationship diagrams with crow's foot notation.
- Describe how tables relate to each other using foreign keys.
- Explain the different relationship types – has_many_through, has_and_belongs_to_many, belongs_to.

## Relationships - Whiteboard Demo (15 mins)

> Note: Use the author/book/category example tables you've drawn to demonstrate creating relationships by making an ERD on the whiteboard; you should use crow's foot notation, making a point to demonstrate it on the board with our existing table drawings

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
- a book probably "has many" categories, and a category also probably "has many" books

Keep in mind, the ```belongs_to``` part always goes on the opposite side of the ```has_many``` or ```has_one```. And the way it's stored is that the ID of the model that "has" something is stored in a field on the child, like "customer_id" or "author_id".  In our example with authors and books, the Book model ```belongs_to``` the Author model, while the Author, as mentioned, ```has_many``` books.

## Independent Practice (20 minutes)

 Working with a partner, draw out some Entity Relation Diagrams like we have on the board, with crow's foot notation like we have.

 Try drawing one (or more, if you're fast) of the following:

 - A social media site, with users and posts/tweets/pins
 - An online ordering system, with customers and orders
 - A bar drink system, with orders, customers, drinks, and/or liquors

## Conclusion (5 mins)
- How do you represent a relational database in drawings? How would you describe the metaphor of storing data like a spreadsheet?
- What are the three types of relationships, and what are some examples of how you would you use them?



