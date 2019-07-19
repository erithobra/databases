---
title: ACID Transactions
type: Morning Exercise
duration: "1:00"
creator:
    name: Melissa Arliss
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) ACID Transactions

## Introduction 

Get ready, cuz we've got another acronym for you: ACID.

ACID is a series of principles that should be used whenever you modify a database. The goal in using these principles is to maintain a stable, consistent database, before and after whatever operation you're performing.

---

## First Things First: Definitions

There's a lot to break down in the term "ACID transaction."

First: What exactly do we mean by transaction?

> A **transaction** is a single unit of work that modifies a database. It might be several individual actions, but think of them as a unit, all working on the same task.

Great. Now let's break down that acrony: ACID.

**Atomicity:** Transactions are all or nothing; they go all in; there's no cutting corners with transactions. However you want to put it, *atomicity* just means that all parts of a transaction take place at once and run to completion, or it doesn't happen at all. You can't have Step 3 unless Steps 1 and 2 (and all the steps after 3) happen as well.

**Consistency:** The database should be consistent before and after the transaction happens. Kinda like how energy can neither be created nor destroyed, it just changes forms; if you're moving or removing something in a database, it has to go *somewhere*. And this one is pretty stringent; if the transaction can't be fully completed at that time, everything will be rolled back to the original version.

**Isolation:** Transactions must be able to happen independently, without interference, while still maintaining the ultimate goal of *consistency* in the database. And, transactions must be able to happen concurrently, while still keeping things consistent.

**Durability:** Once a transaction is complete, it doesn't just say "See ya!" and ride off into the sunset. Any changes that are made must be permanently stored in the database's memory. And if something goes wrong, the record of the transaction still exists and is always accessible in the database.

The goal of any good database is to be "ACID compliant," meaning that all transactions that happen abide by these rules.

--- 

## Make It Real

We know what ACID is all about now. It's time to bring things down to real life!

We've listed a few scenarios that are actual, real life examples of database transactions that happen all the time. With a partner, review the scenarios. Think through:
- Which part(s) of ACID is this dealing with?
- Assuming the DB is ACID compliant, what should happen?
- What would happen if the DB is **not** ACID compliant? What are the risks?

**Meet the scenarios:**

- You’re shopping on an e-commerce site, you must have an item in your cart in order to pay for it. What you can’t do is pay for something that’s not in your cart. 
- imagine you and your neighbor are both trying to buy something from the same e-commerce platform at the same time. There are 10 items for sale: your neighbor wants five and you want six. Isolation means that one of those transactions would be completed ahead of the other one. In other words, if your neighbor clicked first, they will get five items, and only five items will be remaining in stock. So you will only get to buy five items. If you clicked first, you will get the six items you want, and they will only get four. Thus, isolation ensures that eleven items aren’t sold when only ten exist.
- Imagine you’re buying in-demand concert tickets on a site similar to Ticketmaster.com. Right when tickets go on sale, you’re ready to make a purchase. After being stuck in the digital waiting room for some time, you’re finally able to add those tickets to your cart. You then make the purchase and get your confirmation. However if that database lacks durability, even after your ticket purchase was confirmed, if the database suffers a failure incident your transaction would still be lost!
- Bank transaction

----

## How Does ACID Fit In?

By now you probably get it: ACID is really important to the way we set up our databases, transactions, and interactions. But how does it affect the apps we're working on? 




