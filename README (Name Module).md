
[Repite esta estructura para cada uno de los 8 grupos en tu proyecto, llenando los detalles específicos de cada uno. Asegúrate de proporcionar información detallada y relevante para cada grupo en su respectiva sección del README.]


[Se recuerda a los grupos que tiene cosas en comun hacer un seccion y en ella colocar cada sub seccion :
   Ejemplo: 
   - [Actividades]: [Estructura del modulo]
        - Cosplay
            - [Estructura del modulo]
        - Trivia
            - [Estructura del modulo]
              
]

---


# [Nombre del Grupo] (Esto es estructura del modulo)          ----------> todo hecho en Ingles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

## Description
[Describe brevemente lo que hace este módulo o grupo en tu proyecto]

## OOP (Object Oriented Programming)        ----------> todo hecho en Ingles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
[Explica cómo aplicaste la Programación Orientada a Objetos en este grupo. Enumera las clases creadas y proporciona una breve descripción de sus métodos y funcionalidades]

## Design pattern       ----------> todo hecho en Ingles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
[Explica qué patrón de diseño se implementó en este grupo y por qué se eligió. Detalla cómo se aplicó en el código]

## SOLID application        ---------->todo hecho en Ingles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
[Habla sobre cómo se aplicaron los principios SOLID en este módulo, especialmente enfocándote en la creación de DAO (Data Access Object). Explica cómo se logró la separación de responsabilidades y la modularidad]

## Package Structure        ---------->todo hecho en Ingles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
[Indica dónde se encuentra el código fuente o los archivos relacionados con este grupo en el repositorio del proyecto, ademas de enlazar a sus respectivas carpetas]


[Nombre del Grupo]
   - Controller
   - DAO
      - model
   - staff
      - controller
      - model
         - classes
         - DAO

















# View File

All folders have a "Controller" and a "Model"


### *Activity Module*

##### The Activity folder retains 9 types of files:
	- ActivitiesTable
	- ActivityView
	- AddActivity
	- AlertDelete
	- ResponsibleTrivia
	- Rounds
	- Successful
	- Trivia
	- WinnerTrivia


1. **ActivitiesTable**
   The code defines a graphical user interface (GUI) for managing activities. The main window, represented by the "ActivitiesTable" class, includes a table for displaying activity data and text fields for entering information about new activities. Buttons allow CRUD actions. The interface is initialized in the constructor and shown when the program is run through the "main()" method. In summary, this code provides a complete interface for managing activities, including basic CRUD operations (Create, Read, Update, Delete).

2. **ActivityView**
   The "ActivityView" class represents the main window of the interface, which contains a table ("tblActivities") to display activity data and various text fields for entering information about new activities.

   The "validateFields()" method is used to ensure all required fields are completed before certain actions, such as creating a new activity.

3. **AddActivity**
   The AddActivity class provides a simple interface for adding activity details to the application, allowing users to input information and save it for later use.

4. **AlertDelete**

5. **Cosplay**

6. **FinishQualification**

7. **JuryQualify**

8. **ModifyCosplay**

9. **Qualify**

10. **ResponsibleTrivia**

11. **Rounds**

12. **Successful**

13. **TieCosplay**

14. **TrivialList**

15. **WinnersCosplay**

16. **WinnerTrivia**


### *Establishment Module*

##### The Establishment folder retains a single folder:
	- EstablishmentView
	- Ingredients
	- OrderMenu
	- Restaurant

1. **EstablishmentView**
   - The "EstablishmentView" class represents the main window of the user interface, which allows users to perform operations related to establishments, such as adding, updating, and deleting.

**Key Methods:**
   - **"validateFields()":** Checks if mandatory fields are completed before performing certain actions, such as adding a new establishment.
   - **"btnCreatEstabActionPerformed()":** Handles the click event on the "Add" button, validating the fields and showing a successful message if validation is successful.
   - **"btnBackEstabActionPerformed()":** Handles the click event on the "Back" button, navigating back to the main menu view.
   - **"btnDeletEstabActionPerformed()":** Handles the click event on the "Delete" button, showing a confirmation alert before deleting an establishment.

2. **Ingredients**
   The main functionality of the "Ingredients" class is inventory management of ingredients.

   The provided code implements a Java Swing graphical user interface (GUI) to manage ingredient inventory in an application. Here's the detailed analysis:

**Key Methods:**
   - **"validateFields()":** Checks if mandatory fields are completed before performing certain actions, such as adding a new ingredient.
   - **"btnAddIngredienteActionPerformed()":** Handles the click event on the "Add" button, validating the fields and showing a successful message if validation is successful.
   - **"btnDeleteIgredientActionPerformed()":** Handles the click event on the "Delete" button, showing a confirmation alert before deleting an ingredient.
   - **"btnBackActionPerformed()":** Handles the click event on the "Back" button, navigating back to the main view related to ingredients.

**Related Views:**
   - **"AlertDelete":** A view to display a confirmation alert before deleting an ingredient.
   - **"Successful":** A view to display a successful message after adding a new ingredient.
   - **"Restaurant":** Another view related to restaurant management.

3. **OrderMenu**
   The "OrderMenu" class has a user interface for managing menus of an establishment.

4. **Restaurant**


##### The Event folder retains 4 types of folders:


### *Persistence Module*

##### The Persistence folder contains two files:


### *TicketOffice Module*

##### The TicketOffice folder contains 2 folders and 2 internal modules with reference to TicketOffice.

