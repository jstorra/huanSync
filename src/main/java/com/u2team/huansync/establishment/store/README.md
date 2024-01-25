# TRADE - STORE, GROUP 7

Based on the specific requirements of the system, we have the management of cash registers along with stores, aiming to facilitate sales of various items in the requested convention. Each store will feature unique products in its inventory, and it will also handle those items that fulfill specific requests from buyers. The cash registers will have three states: active, inactive, and in the case of order transactions, there will be three states: registered, paid, and delivered.
Additionally, we will oversee a product inventory, managing its specifications and categorizing them by product types. All of these components are designed to optimize the sales process and ensure a seamless experience for buyers.

Hemos realizado varios apartados creando el modelo de clases, el apartado de base de datos y los CRUD's pertinentes para la conexion con Mysql, ademas en los apartados de ``Product`` y ``Promotion`` aplicamos la logica pertinente para aplicar lo soliciado en el trabajo.


## OOP (Object Oriented Programming)

Aplicamos el apartado de programacion orientada a objetos en la creacion entre herencias, encapsulamiento e interfaces en las tablas.

## Design pattern

Para una solucion reutilizable en el codigo creamos patrones de diseños como ```Builder``` para la creacion de estructuras que contaban con muchos objetos y hacer el codigo lo mas rentable posible, tambien contamos con patrones de diseño de creacion para la creacion de nuevos productos e implementarlos a la base de datos, tambien contamos con patrones de comportamiento que se centran en la comunicacion generalizada de objetos y aplicar una asignacion a dichos objetos llamados n la funcion del metodo. 

## Solid application 
En el contexto de la creación de DAO, estos principios SOLID pueden aplicarse de la siguiente manera para lograr la separación de responsabilidades y la modularidad:

* Responsabilidad única: Cada clase o componente de DAO se enfoca en una sola tarea específica, como la creación, lectura, actualización o eliminación de datos en la base de datos. Esto promueve la cohesión y facilita el mantenimiento y la comprensión del código.

* Abierto/cerrado: La estructura de las clases DAO se diseña de manera que pueda extenderse para agregar nuevas funcionalidades de acceso a datos sin necesidad de modificar el código existente. Por ejemplo, al agregar soporte para una nueva base de datos, se pueden crear nuevas implementaciones de DAO sin alterar el funcionamiento de las existentes.

* Sustitución de Liskov: Las implementaciones concretas de acceso a datos pueden ser utilizadas de manera intercambiable, lo que permite adaptar la aplicación a diferentes entornos de almacenamiento de datos sin afectar su funcionalidad general.

* Segregación de la interfaz: Las interfaces de acceso a datos se dividen en componentes más pequeños y específicos, lo que promueve una mayor modularidad y facilita la implementación de diferentes estrategias de acceso a datos.

* Inversión de dependencias: Las capas superiores de la aplicación dependen de abstracciones que representan las operaciones de acceso a datos, lo que permite desacoplar estas capas de las implementaciones concretas y facilita la prueba y la sustitución de componentes.

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
Esta estructura se generealiza para productOrder y promotion


##

#### Authors 
* Kevin Johan Jimenez 
* Kevin Sneider Esteban Merchan 
* Kevinn Dwight 
