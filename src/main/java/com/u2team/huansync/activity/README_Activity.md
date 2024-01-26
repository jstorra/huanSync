# Our software for managing Anime events

> equipo6

## Activities

### What does it do?

#### Description

Manage event participants based on ticket information, indicating whether there is a maximum capacity. Additionally, oversee activities by handling details such as name, type, participants, time, and assigned personnel. Ensure the system allows the registration of multiple activities of the same type at different times for a single event.

Efficiently handle an inventory of available prizes and assign them to specific activities and participants, if applicable.

Generate comprehensive reports with relevant information.

It is essential to model and define rules for two types of activities, enabling effective tracking for both.

> That's why we came up with TRIVIA:

-   activity
    -   Cosplay
    -   Trivia
        -   controller
            -   TriviaController
        -   informs
            -   Informs
            -   InformsDAO
        -   model
            -   Trivia
            -   TriviaBuilder
            -   TriviaBuilderImpl
            -   TriviaDAO
        -   question
            -   controller
                -   QuestionController
            -   model
                -   CategoryQuestion
                -   DifficultyQuestion
                -   Question
                -   QuestionBuilder
                -   QuestionBuilderImpl
                -   QuestionDAO
        -   PruebaTrivia(main Class)

---

## OOP (Object Oriented Programming)

This project leverages Object-Oriented Programming (OOP) principles to create a well-organized and modular codebase. Key aspects of the implementation include:

    Classes and Objects: Entities within the system are modeled as classes, encapsulating related data and behaviors.
        - Activity
        - Prize
        - Trivia
        - Question
        - Informs

    Encapsulation: The use of encapsulation ensures that the internal implementation of classes is hidden, exposing only relevant interfaces. This promotes modularity and ease of future modifications.

        private attributes

    Inheritance: Inheritance establishes relationships between classes, facilitating code reuse and maintaining consistency in programming logic.
    Polymorphism: Polymorphism allows objects of different classes to be treated uniformly, enhancing code flexibility and extensibility.

        Activity --> Cosplay and Trivia

    Abstraction: Abstraction is employed to identify and model essential system entities, simplifying complexity and providing a clear representation of reality.

This OOP implementation results in a maintainable, scalable, and comprehensible codebase, fostering collaboration and facilitating future project expansions.

## Design pattern

### Builder

The Builder pattern was applied for mostly of the classes that needed a lot of attributes, like Prize, its a creational design pattern that lets you construct complex objects step by step. It allows you to produce different types and representations of a product using the same construction code.
It will provide a method that constructs the object at the end "build()".

-   Class Prize
-   Interface PrizeBuilder
-   Class PrizeBuilderImpl (implements the interface)

## SOLID application

The SOLID principles are followed in the development of the trivia module because:

Single Responsibility Principle (SRP)

    Each class was created to do only one thing.

Interface Segregation Principle (ISP) and Open/Closed Principle (OCP)

    No class depends on interfaces that are not used.
    Interfaces to avoid manipulating the base code.

Dependency Inversion Principle (DIP)

    High-level modules do not depend on low-level ones; both depend on abstractions.
    Abstractions do not depend on details.

---

### DAO

One of those important patterns was DAO or Data Access Object that separates a data resource's client interface from its data access mechanisms.
We used it mostly to separate the access or persistence methods, in which a class is responsible for operations against a database table.

-   controller
    -   ClassController
-   model
    -   Class
    -   DAO
