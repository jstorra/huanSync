# Trivia Module

## Description

Our team, Team 6, is responsible for developing the trivia module within our project. The trivia module hosts a competition with questions related to various animes, movies, and comics. Each competition involves two participants, one from each group. Participants are randomly organized based on the total number of participants. The competition consists of a total of 5 randomly selected questions, and the first participant to answer correctly to 3 questions advances to the next round. The trivia is categorized into three difficulty levels: easy, intermediate, and difficult. As the trivia tournament progresses, the difficulty level increases. The winner receives a prize from the merchandise store.

## Object-Oriented Programming (OOP)

### Class Hierarchy

- **Activity (Main Class)**
- **Cosplay (Secondary Class)**
- **Trivia (Secondary Class)**

### Trivia Class

The `Trivia` class extends the `Activity` class and contains attributes specific to organizing trivia competitions. CRUD operations for trivia are handled by the `TriviaDAO` class, which uses the Builder pattern for efficient creation.

### Controller

The `TriviaController` class contains methods to handle CRUD operations for trivia instances.

## Design Pattern: Builder

The Builder design pattern is implemented in the `TriviaBuilder` interface and its corresponding implementation, `TriviaBuilderImpl`.

## SOLID Principles Applied

SOLID principles are followed in the development of the trivia module.

- Each class was created to do only one thing.
- No class depends on interfaces that are not used.
- High-level modules do not depend on low-level modules; both depend on abstractions.
- Abstractions do not depend on details.

## Package Structure

The trivia module is organized within the project repository as follows:

- Team 6
  - Activity
    - Controller
      - TriviaController
    - Model
      - Trivia
      - TriviaBuilder
      - TriviaBuilderImpl
      - TriviaDAO

# Cosplay Module (Shared Features)

## CategoryCosplayController

The `CategoryCosplayController` class manages CRUD operations for cosplay categories.

## CategoryCosplay

The `CategoryCosplay` class represents a cosplay category with a unique identifier, name, and deletion status.

## CategoryCosplayDAO

The `CategoryCosplayDAO` class is a Data Access Object (DAO) responsible for managing operations related to cosplay categories in the database.
