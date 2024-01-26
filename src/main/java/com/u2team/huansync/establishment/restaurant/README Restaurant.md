# Establishment : Restaurant

## Description

The Establishment module is in charge of managing the cash registers, the sales process and the orders. Specifically, the Restaurant sub-module is in charge of managing the menu of each restaurant with its respective items (dishes), controlling the inventory of ingredients and calculating the preparation time of the orders.

The management of each section was carried out by implementing CRUD (Create, Read, Update, Delete).

## OOP (Object Oriented Programming)

OOP is used in classes, methods, encapsulation, inheritance, polymorphism, collections and relationships between classes.

#### Classes

- Classes of establishment

   - Establishment: manages the establishments and indicates the events to which they relate.
      - long establishmentId;
      - String nameEstablishment;
      - long managerEstablishmentId;
      - CategoryEstablishment categoyEstablishment;
      - long establishmentEventId;

   - CashRegister: represents a cash register within an establishment.
      - long cashRegisterId ;
      - boolean statusCash ;
      - long cashierOperatorId;
      - double openingAmount;
      - double closingAmount ;
      - long establishmentsId;

- Classes of restaurant

   - Ingredient: manages the ingredients and indicates in which establishment they are located.
      - long ingredientId;
      - String nameIngredient;
      - int availableQuantity;
      - long establishmentId;

   - ItemMenu: manages the items (dishes) of the restaurant, the ingredients it contains and the establishment in which it is located.
      - long itemMenuId;
      - String nameItemMenu;
      - double priceItemMenu;
      - List<Long> listIngredientId;
      - ItemMenuType itemMenuType;
      - int preparationTime;
      - long establishmentId;

   - ItemMenuOrder: represents the association between an order and an item.
      - long orderId;      
      - long itemMenuId;
      - int quantity;

#### Enum

- Enum of restaurant

   - ItemMenuType: manages the types of dishes in the menu.
      - APPETIZER("appetizer"),
      - MAIN_COURSE("main course"),
      - DRINK("drink"),
      - DESSERT("dessert");

#### Interfaces

> The interfaces used were intended to implement the DAO, that is, to connect the project to the database. They were also used for the creation of the builder design patterns.

- Builders: these are used for the efficient creation of some classes. Example:

   ```java
   public interface CashRegisterBuilder {

    CashRegisterBuilder statusCash(boolean statusCash);
    CashRegisterBuilder openingAmount(double openingAmount);
    CashRegisterBuilder closingAmount(double closingAmount);
    CashRegisterBuilder cashRegisterId(long cashRegisterId);
    CashRegisterBuilder establishmentsId(long establishmentsId);
    CashRegisterBuilder cashierOperatorId(long cashierOperatorId);
    CashRegister build();
   }
   ```

- DAO: methods are implemented for connection to the database.

   ```java
   public interface ISaveDao<T> extends IDao{
   void save(T t);
   }
   ```

## Design pattern

**Builder**

- In the Establishment module, the builder creation pattern was implemented to efficiently create objects of the Establishment and CashRegister classes.

- In the Restaurant sub-module, the builder creative pattern was implemented to efficiently create objects of the ItemMenu class.

## SOLID application

The SOLID principles are used in the following way:

- Single Responsibility Principle (SRP): Each class should focus on a single functionality.

- Open/Closed Principle (OCP): Classes must be open to extensions, but closed to modifications. This means applies in inheritance when the superclass can be extended into child classes.

- Liskov Substitution Principle (LSP): Use of polymorphism, i.e. making different implementations of a method.

- Interface Segregation Principle (ISP): It is preferable to have several specific interfaces and not one too large because it is not optimal to implement methods that are not used.

- Dependency Inversion Principle (DIP): Modules must depend on abstractions and not on concrete classes as in the implementation of an interface.


## Package Structure

The path to the Establishment module is as follows:
> src\main\java\com\u2team\huansync\establishment

The path of the Restaurant sub-module is as follows:
> src\main\java\com\u2team\huansync\establishment\restaurant

The following package structure was used:

establishment
   - cash
      - controller
      - model
         - classes
            - builder
         - DAO
   - controller
   - DAO
   - model
      - classes
         - builder
      - DAO
   - order
      - controller
      - model
         - classes
         - DAO
   - restaurant
      - controller
      - ingredient
         - controller
         - model
            - classes
            - DAO
      - itemMenu
         - controller
         - model
            - classes
               - builder
            - DAO
      - itemMenuOrder
         - controller
         - model
            - classes
            - DAO
      - model
         - classes
         - DAO

## Authors

- Daniel Felipe Rincón Guerrero
- Kevin Andrés Corzo Garcia
- Misael Andrés Tirado Paternina