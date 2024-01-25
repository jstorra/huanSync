# TRADE - STORE, GROUP 7

Based on the specific requirements of the system, we have the management of cash registers along with stores, aiming to facilitate sales of various items in the requested convention. Each store will feature unique products in its inventory, and it will also handle those items that fulfill specific requests from buyers. The cash registers will have three states: active, inactive, and in the case of order transactions, there will be three states: registered, paid, and delivered.
Additionally, we will oversee a product inventory, managing its specifications and categorizing them by product types. All of these components are designed to optimize the sales process and ensure a seamless experience for buyers.

We have addressed various sections, including class modeling, database design, and the relevant CRUD operations for MySQL connectivity. Additionally, in the "Product" and "Promotion" sections, we have implemented the necessary logic to meet the requirements specified in the project.


## OOP (Object Oriented Programming)

We applied Object Oriented Programming principles, including inheritance, encapsulation, and interfaces in the class models.

## Design pattern

We implemented design patterns such as the Builder pattern for creating structures with many objects efficiently. Additionally, creation patterns were used for adding new products to the database. Behavior patterns were employed for generalized communication between objects and applying method assignments.

## Solid application 
In the context of DAO (Data Access Object) creation, we applied SOLID principles:


* Single Responsibility: Each DAO class focuses on a specific data access task, promoting cohesion and code maintainability.

* Open/Closed: The DAO structure allows for easy extension to add new data access functionalities without modifying existing code.

* Liskov Substitution: Concrete data access implementations can be used interchangeably, adapting the application to different data storage environments.

* Interface Segregation: Data access interfaces are divided into smaller, specific components, enhancing modularity and facilitating different data access strategy implementations.

* Dependency Inversion: Higher layers of the application depend on abstractions representing data access operations, allowing decoupling from concrete implementations for easier testing and component substitution.

## Package Structure 

[Group7- Trade, Store]
* establishment 
    * store
        * Controller 
            * StoreController 
        * Product 
            * controller
                * ProductController.java
            * model
                * classes
                    * builder
                        * ProductBuilder.java
                        * ProductConcreteBuilder.java
                    * Product.java
                    * TypeProductEnum.java
                * DAO
                    * ProductDAO
This structure is generalized and applied to other components such as productOrder and promotion.

##

#### Authors 
* Kevin Johan Jimenez 
* Kevin Sneider Esteban Merchan 
* Kevinn Dwight 
