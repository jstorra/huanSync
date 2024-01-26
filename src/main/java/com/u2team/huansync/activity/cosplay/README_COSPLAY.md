
# COSPLAY 🎭         
## DESCRIPTION
The Cosplay Management and Qualification System module focuses on providing users with a comprehensive system to manage cosplay categories, register participants, and manage the qualification process by assigning juries. This module was designed with the objective of facilitating the efficient organization and evaluation of cosplay events.

**Category Management:**
The system allows users to define and customize categories of cosplays according to their specific needs. The flexibility of the system is reflected in the ability to create and delete categories intuitively. Additionally, listing methods are provided that allow users to view all created categories, providing an overview of cosplay-related activities. The update method includes an additional feature that gives users the option to mark a category as non-deletable, thus ensuring data integrity and considering future system integrations.

**Registration of participants:**
The system maintains a detailed record for each participant, which includes key information such as the cosplay they are going to compete with, the category to which they belong, and the score obtained. To facilitate the registration process, when a participant arrives at the table, they are asked for their participant number and the name of their cosplay. This functionality ensures accurate tracking of the participation and results of each contestant.

**Qualification System and Juries:**
The module manages a qualification system that involves assigning jurors to each participant. Raters have the ability to evaluate each participant individually. After the judges' qualification, the system automatically calculates the average and assigns this total score to the corresponding participant. The precision of the presentation of the score is highlighted, which is shown with two decimal places, ensuring an accurate and detailed representation of the evaluation results.

## OOP (Object Oriented Programming)

## Cosplay
### ControllerMagnamentCosplay

- The ControllerMagnamentCosplay class is a controller that is designed to manage operations related to cosplays in the context of some activity. Uses a CosplayDaoOperationsCrudImpl instance to perform Create, Read, Update, and Delete (CRUD) operations

### Cosplay

- The Cosplay class encapsulates information related to a cosplay, providing methods to access and modify its properties, as well as a toString method to obtain a string representation of the object

### CosplayBuilder

- The CosplayBuilder interface provides a set of methods to gradually configure the properties of a cosplay and makes it easy to build instances of the Cosplay class using the Builder pattern.

### CosplayBuilderImpl
- la clase CosplayBuilderImpl proporciona una implementación del patrón Builder para facilitar la construcción gradual de instancias de la clase Cosplay, permitiendo una forma más legible y mantenible de crear objetos Cosplay con propiedades específicas.

### CosplayDaoOperationsCrud
- This interface provides a contract to interact with the persistence layer and perform the CRUD operations necessary to manage cosplay entities in a database.

### CosplayDaoOperationsCrudImpl
- This class provides a concrete implementation of CRUD operations for cosplay entities, using predefined SQL queries and specific validations before performing operations on the database

### CosplayValidatorDao
- The CosplayValidatorDao interface establishes a contract to implement specific validation operations for cosplay entities in a data access environment

### CosplayValidatorDaoImpl
- This class provides specific validation logic to ensure that cosplay entities meet certain conditions before performing operations on the database.

### CosplayView
- CosplayView acts as a simple user interface to manage cosplays, interacting with the business logic through the controller and allowing the user to perform basic operations on the database

## Category cosplay 
### CategoryCosplayController

- CategoryCosplayController provides an interface for other parts of the program to perform operations related to cosplay categories, interacting with the data access layer to perform operations on the database.

### CategoryCosplay
- CategoryCosplay provides a representation of cosplay categories with methods to access and modify their attributes. The deletable property can be used to determine whether a category can be deleted, depending on the business logic of the application

### CategoryCosplayDAO
  - CategoryCosplayDAO provides methods to perform CRUD (Create, Read, Update, Delete) operations on the database for cosplay categories.

### cosplayCategoryView
- CosplayCategoryView provides a console interface for the user to interact with CRUD (Create, Read, Update, Delete) operations of cosplay categories, using the CategoryCosplayController controller

##  Management Qualification
### ControllerQualification
- ControllerQualification is responsible for managing operations related to cosplay qualifications. Provides methods to get the number of ratings and submit new ratings for a specific cosplay using the QualificationDaoImp instance.

### Qualification
- the Qualification class models a specific rating for a cosplay, with details about the cosplay it refers to, the jury member providing the rating, and the score itself. The implementation includes getters and setters methods to access and modify these attributes.

###QualificationDao
- QualificationDao defines the operations that can be performed regarding cosplay qualifications. Here is a summary of the methods defined in the interface

### QualificationDaoImp

- The QualificationDaoImp class implements the QualificationDao interface and is responsible for managing qualifications for cosplays in a system

### QualificationDaoView

- The QualificationCosplayView class handles user interaction for managing cosplay ratings.
  
## DESING PATTERN
**DAO (Data Access Object) Pattern:**

Relevant Classes:
CosplayValidatorDao, CosplayValidatorDaoImpl
CategoryCosplayDAO
QualificationDao, QualificationDaoImp
Explanation:
It is used to separate data access logic from business logic. The interfaces (CosplayValidatorDao, QualificationDao) define operations related to data validation and access, while the concrete classes (CosplayValidatorDaoImpl, CategoryCosplayDAO, QualificationDaoImp) implement these operations.

**MVC (Model-View-Controller) Pattern:**

Relevant Classes:
CosplayView, CosplayCategoryView, QualificationCosplayView
ControllerMagnamentCosplay, CategoryCosplayController, ControllerQualification
Explanation:
The MVC pattern is used to separate presentation logic from business logic and data handling. Views (CosplayView, CosplayCategoryView, QualificationCosplayView) handle user interaction, controllers (ControllerMagnamentCosplay, CategoryCosplayController, ControllerQualification) handle business logic, and models (such as Cosplay and CategoryCosplay) represent data.

**Singleton Pattern:**

Relevant Classes:
BDConnection
Explanation:
The BDConnection class acts as a Singleton to ensure that there is only one instance of the database connection. This approach is common to handle database connections efficiently.

**Builder pattern:**

In the CosplayBuilder and CosplayBuilderImpl classes, the Builder design pattern is implemented. This pattern is useful when the construction of an object is complex and has multiple parameters. The Builder pattern separates the construction of an object from its representation, allowing different representations of the object to be created using the same construction process.
Next, let's analyze how the Builder pattern is implemented in these classes:
CosplayBuilder (Builder Interface):
Interface to build instances of the Cosplay class: Defines the methods to configure the properties of a Cosplay object.

## SOLID 
**Single Responsibility Principle (SRP):**

The SRP principle states that a class should have only one reason to change. In the provided scripts:

CosplayValidatorDaoImpl: This class has the responsibility of validating cosplays and has specific methods to validate participation, participant and the state of the cosplay. Your only reason for change would be if the validation rules change.

CategoryCosplayController: Responsible for managing cosplay categories. Your only reason for change would be if the category management rules change.

CosplayCategoryView: Handles user interaction for cosplay categories. Your only reason for changing would be if the UI requirements for the categories change.

ControllerQualification: Handles the logic related to qualification management. Your only reason for change would be if the rules for handling grades change.

QualificationDaoImp: Implements the interface to access and manage qualifications in the database. Your only reason for change would be if operations related to the ratings change.

QualificationCosplayView: Handles user interaction for cosplay ratings. Your only reason for change would be if the UI requirements for ratings change.

Each class has a unique responsibility and is focused on a specific aspect of the application.

**Open/Closed Principle (OCP):**

The OCP principle states that classes should be open for extension but closed for modification. In the provided scripts:

CategoryCosplayController: The ability to manage categories is open to extending by adding new methods or functionality, but is closed to modifying the way categories are managed.

CosplayValidatorDaoImpl: Can be extended to add new validations without changing its existing structure.

ControllerQualification: The logic for handling qualifications can be extended by adding new methods or functionality without changing the existing structure.

**Liskov Substitution Principle (LSP):**

The LSP principle states that instances of a derived class must be able to replace instances of the base class without affecting the functionality of the program. In the provided scripts:

CategoryCosplayController: The CategoryCosplay base class and its derivatives should be able to be used interchangeably without affecting the functionality of the controller.

CosplayValidatorDaoImpl: Validation implementations must be able to override the CosplayValidatorDao interface without changing the functionality of the code that uses them.

**Interface Segregation Principle (ISP):**

The ISP principle states that a class should not be forced to implement interfaces that it does not use. In the provided scripts:

CosplayValidatorDao: Defines an interface with methods related to cosplay validation.

CategoryCosplayController: Implements specific category management methods.

QualificationDao: Defines an interface with methods related to handling qualifications.

**Dependency Inversion Principle (DIP):**

The DIP principle states that high-level classes should not depend on low-level classes, both should depend on abstractions. In the provided scripts:

CosplayCategoryView, QualificationCosplayView: Dependency on abstractions (controllers) instead of concrete classes.

CategoryCosplayController, ControllerQualification: These are high-level classes that depend on abstractions (interfaces).

## PACKAGE STRUCTURE        
Package Structure      


* cosplay
    * categorycosplay
        * controller
            * CategoryCosplayController.java
        * model
            * CategoryCosplay.java
            * CategoryCosplayDAO.java
        * CosplayCategoryView.java
    * Controller
        * ControllerMagnamentCosplay.java
    * managementQualification
        * controller
            * ControllerQualification.java
        * model
            * Main.java
            * Qualification.java
            * QualificationDao.java
            * QualificationDaoImp.java
        * QualificationCosplayView.java
    * model
        * Cosplay.java
        * CosplayBuilder.java
        * CosplayBuilderImpl.java
        * CosplayDaoOperationsCrud.java
        * CosplayDaoOperationsCrudImpl.java
        * CosplayValidatorDao.java
        * CosplayValidatorDaoImpl.java
    * CosplayCategoryView.java
