> # Anime Event Management Software (TEAM 6)

## Activities

### WHAT DOES IT DO?

Our software efficiently manages Anime events by handling various aspects such as event participant management, activity oversight, inventory of prizes, and comprehensive reporting. The system ensures seamless handling of ticket information, checks for maximum capacity, and facilitates the registration of multiple activities of the same type at different times for a single event.

**Key Features:**

-   **Activity Management:**

    -   Cosplay
    -   Trivia

-   **Components:**

    -   Controllers:

        -   TriviaController
        -   QuestionController

    -   Informers:

        -   Informs
        -   InformsDAO

    -   Models:
        -   Trivia
        -   Question
        -   CategoryQuestion
        -   DifficultyQuestion

-   **Main Class:** ActivityMain

## Object-Oriented Programming (OOP)

This project employs Object-Oriented Programming (OOP) principles for a well-organized and modular codebase. The implementation includes:

-   **Classes and Objects:**

    -   Activity
    -   Prize
    -   Trivia
    -   Question
    -   Informs

-   **Encapsulation:**

    -   Private attributes ensure the internal implementation is hidden, promoting modularity and ease of future modifications.

-   Inheritance and Polymorphism:

    -   Inheritance establishes relationships between classes for code reuse.
    -   Polymorphism allows treating objects uniformly.

    **Example:** Activity --> Cosplay and Trivia

-   **Abstraction:**

    -   Identifies and models essential system entities, simplifying complexity.

This OOP approach results in a maintainable, scalable, and comprehensible codebase, fostering collaboration and facilitating future expansions.

## Design pattern

### Builder

The Builder pattern is applied to classes with numerous attributes (e.g., Prize). It's a creational design pattern that constructs complex objects step by step, providing a method, "build()," for object construction.

-   **Classes:**
    -   Prize
    -   Interface: PrizeBuilder
    -   Implementation: PrizeBuilderImpl

## SOLID application

The SOLID principles guide the development of the trivia module:

1. **Single Responsibility Principle (SRP):**

    - Each class is designed to perform a single task.

2. **Interface Segregation Principle (ISP) and Open/Closed Principle (OCP):**

    - Classes depend only on interfaces they use.
    - Interfaces prevent manipulation of the base code.

3. **Dependency Inversion Principle (DIP):**

    - High-level modules do not depend on low-level ones; both depend on abstractions.
    - Abstractions do not depend on details.

## DAO

One of those important patterns was DAO or Data Access Object that separates a data resource's client interface from its data access mechanisms.
We used it mostly to separate the access or persistence methods, in which a class is responsible for operations against a database table.

-   **controller**
    -   ClassController
-   **model**
    -   Class
    -   DAO

## Class Diagram

![](.\trivia\img\ClassDiagram.jpg)
