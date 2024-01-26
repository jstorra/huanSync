
# COSPLAY 🎭         
## DESCRIPTION
El módulo de Sistema de Gestión de Cosplays y Calificación se enfoca en proporcionar a los usuarios un sistema integral para administrar categorías de cosplays, realizar el registro de participantes y gestionar el proceso de calificación mediante la asignación de jurados. Este módulo se diseñó con el objetivo de facilitar la organización y evaluación eficiente de eventos de cosplay.

**Gestión de Categorías:**
El sistema permite a los usuarios definir y personalizar categorías de cosplays según sus necesidades específicas. La flexibilidad del sistema se refleja en la capacidad de crear y eliminar categorías de manera intuitiva. Además, se proporcionan métodos de listado que permiten a los usuarios visualizar todas las categorías creadas, brindando una visión general de las actividades relacionadas con los cosplays. El método de actualización incluye una característica adicional que brinda a los usuarios la opción de marcar una categoría como no eliminable, garantizando así la integridad de los datos y considerando futuras integraciones del sistema.

**Registro de Participantes:**
El sistema mantiene un registro detallado por cada participante, que incluye información clave como el cosplay con el que van a concursar, la categoría a la que pertenecen y el puntaje obtenido. Para facilitar el proceso de inscripción, al llegar un participante a la mesa, se le solicita su número de participante y el nombre de su cosplay. Esta funcionalidad asegura un seguimiento preciso de la participación y los resultados de cada concursante.

**Sistema de Calificación y Jurados:**
El módulo gestiona un sistema de calificación que involucra la asignación de jurados a cada participante. Los calificadores tienen la capacidad de evaluar a cada participante de manera individual. Después de la calificación de los jurados, el sistema realiza automáticamente el cálculo del promedio y asigna este puntaje total al participante correspondiente. Se destaca la precisión de la presentación de la calificación, que se muestra con dos decimales, asegurando una representación exacta y detallada de los resultados de la evaluación.

## OOP (Object Oriented Programming)

## Cosplay
### ControllerMagnamentCosplay

- La clase ControllerMagnamentCosplay es un controlador que esta diseñado para gestionar operaciones relacionadas con cosplays en el contexto de alguna actividad. Utiliza una instancia de CosplayDaoOperationsCrudImpl para realizar operaciones de Crear, Leer, Actualizar y Eliminar (CRUD)

### Cosplay

- la clase Cosplay encapsula la información relacionada con un cosplay, proporcionando métodos para acceder y modificar sus propiedades, así como un método toString para obtener una representación de cadena del objeto

### CosplayBuilder

- la interfaz CosplayBuilder proporciona un conjunto de métodos para configurar gradualmente las propiedades de un cosplay y facilita la construcción de instancias de la clase Cosplay utilizando el patrón Builder.

### CosplayBuilderImpl
- la clase CosplayBuilderImpl proporciona una implementación del patrón Builder para facilitar la construcción gradual de instancias de la clase Cosplay, permitiendo una forma más legible y mantenible de crear objetos Cosplay con propiedades específicas.

### CosplayDaoOperationsCrud
- Esta interfaz proporciona un contrato para interactuar con la capa de persistencia y realizar las operaciones CRUD necesarias para gestionar entidades de cosplay en una base de datos.


### CosplayDaoOperationsCrudImpl
- Esta clase proporciona una implementación concreta de las operaciones CRUD para las entidades de cosplay, utilizando consultas SQL predefinidas y validaciones específicas antes de realizar operaciones en la base de datos

### CosplayValidatorDao
- La interfaz CosplayValidatorDao establece un contrato para implementar operaciones de validación específicas para las entidades de cosplay en un entorno de acceso a datos

### CosplayValidatorDaoImpl
- Esta clase proporciona lógica de validación específica para garantizar que las entidades de cosplay cumplan con ciertas condiciones antes de realizar operaciones en la base de datos.

### CosplayView
- CosplayView actúa como una interfaz de usuario simple para gestionar cosplays, interactuando con la lógica de negocio a través del controlador y permitiendo al usuario realizar operaciones básicas en la base de dato

## Category cosplay 

### CategoryCosplayController

- CategoryCosplayController proporciona una interfaz para que otras partes del programa realicen operaciones relacionadas con las categorías de cosplays, interactuando con la capa de acceso a datos para realizar operaciones en la base de datos.

### CategoryCosplay 
- CategoryCosplay proporciona una representación de las categorías de cosplay con métodos para acceder y modificar sus atributos. La propiedad deletable puede utilizarse para determinar si una categoría puede ser eliminada, según la lógica de negocio de la aplicación

### CategoryCosplayDAO
 - CategoryCosplayDAO proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos para las categorías de cosplay.

### cosplayCategoryView
- CosplayCategoryView proporciona una interfaz de consola para que el usuario interactúe con las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de las categorías de cosplay, utilizando el controlador CategoryCosplayController

##  Management Qualification


### controllerQualification
- ControllerQualification se encarga de gestionar las operaciones relacionadas con las calificaciones de cosplays. Proporciona métodos para obtener el número de calificaciones y enviar nuevas calificaciones para un cosplay específico utilizando la instancia de QualificationDaoImp.

### Qualification
- la clase Qualification modela una calificación específica para un cosplay, con detalles sobre el cosplay al que se refiere, el miembro del jurado que proporciona la calificación y la puntuación misma. La implementación incluye métodos getters y setters para acceder y modificar estos atributos.

### QualificationDao
- QualificationDao define las operaciones que pueden realizarse en relación con las calificaciones de cosplay. Aquí hay un resumen de los métodos definidos en la interfaz

### QualificationDaoImp

- La clase QualificationDaoImp implementa la interfaz QualificationDao y se encarga de gestionar las calificaciones para los cosplays en un sistema

### QualificationDaoView

- La clase QualificationCosplayView maneja la interacción con el usuario para la gestión de calificaciones de cosplays.

## DESING PATTERN
**Patrón DAO (Data Access Object):**

Clases Relevantes:
CosplayValidatorDao, CosplayValidatorDaoImpl
CategoryCosplayDAO
QualificationDao, QualificationDaoImp
Explicación:
Se utiliza para separar la lógica de acceso a datos de la lógica empresarial. Las interfaces (CosplayValidatorDao, QualificationDao) definen operaciones relacionadas con la validación y acceso a datos, mientras que las clases concretas (CosplayValidatorDaoImpl, CategoryCosplayDAO, QualificationDaoImp) implementan estas operaciones.

**Patrón MVC (Modelo-Vista-Controlador):**

Clases Relevantes:
CosplayView, CosplayCategoryView, QualificationCosplayView
ControllerMagnamentCosplay, CategoryCosplayController, ControllerQualification
Explicación:
El patrón MVC se utiliza para separar la lógica de presentación de la lógica de negocio y el manejo de datos. Las vistas (CosplayView, CosplayCategoryView, QualificationCosplayView) manejan la interacción con el usuario, los controladores (ControllerMagnamentCosplay, CategoryCosplayController, ControllerQualification) gestionan la lógica de negocio y los modelos (como Cosplay y CategoryCosplay) representan los datos.

**Patrón Singleton:**

Clases Relevantes:
BDConnection
Explicación:
La clase BDConnection actúa como un Singleton para garantizar que solo haya una instancia de la conexión a la base de datos. Este enfoque es común para manejar conexiones a la base de datos de manera eficiente.

**patron builder:**

En las clases CosplayBuilder e CosplayBuilderImpl, se implementa el patrón de diseño Builder. Este patrón es útil cuando la construcción de un objeto es compleja y tiene múltiples parámetros. El patrón Builder separa la construcción de un objeto de su representación, permitiendo crear diferentes representaciones del objeto utilizando el mismo proceso de construcción.
A continuación, analicemos cómo se implementa el patrón Builder en estas clases:
CosplayBuilder (Interfaz Builder):
Interfaz para construir instancias de la clase Cosplay: Define los métodos para configurar las propiedades de un objeto Cosplay.


## SOLID 
**Principio de Responsabilidad Única (SRP):**

El principio SRP establece que una clase debe tener solo una razón para cambiar. En los scripts proporcionados:

CosplayValidatorDaoImpl: Esta clase tiene la responsabilidad de validar cosplays y tiene métodos específicos para validar participación, participante y el estado del cosplay. Su única razón de cambio sería si las reglas de validación cambian.

CategoryCosplayController: Se encarga de gestionar las categorías de cosplays. Su única razón de cambio sería si las reglas de gestión de categorías cambian.

CosplayCategoryView: Maneja la interacción con el usuario para las categorías de cosplays. Su única razón de cambio sería si los requisitos de la interfaz de usuario para las categorías cambian.

ControllerQualification: Se encarga de la lógica relacionada con la gestión de calificaciones. Su única razón de cambio sería si las reglas para el manejo de calificaciones cambian.

QualificationDaoImp: Implementa la interfaz para acceder y gestionar las calificaciones en la base de datos. Su única razón de cambio sería si las operaciones relacionadas con las calificaciones cambian.

QualificationCosplayView: Maneja la interacción con el usuario para las calificaciones de cosplays. Su única razón de cambio sería si los requisitos de la interfaz de usuario para las calificaciones cambian.

Cada clase tiene una responsabilidad única y está centrada en un aspecto específico de la aplicación.

**Principio de Abierto/Cerrado (OCP):**

El principio OCP establece que las clases deben estar abiertas para la extensión pero cerradas para la modificación. En los scripts proporcionados:

CategoryCosplayController: La capacidad de gestionar categorías está abierta para extenderse mediante la adición de nuevos métodos o funcionalidades, pero está cerrada para modificar la forma en que se gestionan las categorías.

CosplayValidatorDaoImpl: Puede extenderse para agregar nuevas validaciones sin cambiar su estructura existente.

ControllerQualification: La lógica para el manejo de calificaciones puede extenderse mediante la adición de nuevos métodos o funcionalidades sin cambiar la estructura existente.

**Principio de Sustitución de Liskov (LSP):**

El principio LSP establece que las instancias de una clase derivada deben poder reemplazar instancias de la clase base sin afectar la funcionalidad del programa. En los scripts proporcionados:

CategoryCosplayController: La clase base CategoryCosplay y sus derivadas deberían poder ser utilizadas de manera intercambiable sin afectar la funcionalidad del controlador.

CosplayValidatorDaoImpl: Las implementaciones de las validaciones deben poder reemplazar la interfaz CosplayValidatorDao sin cambiar la funcionalidad del código que las utiliza.

**Principio de Segregación de Interfaz (ISP):**

El principio ISP establece que una clase no debe verse obligada a implementar interfaces que no utiliza. En los scripts proporcionados:

CosplayValidatorDao: Define una interfaz con métodos relacionados con la validación de cosplays.

CategoryCosplayController: Implementa métodos específicos de gestión de categorías.

QualificationDao: Define una interfaz con métodos relacionados con el manejo de calificaciones.

**Principio de Inversión de Dependencia (DIP):**

El principio DIP establece que las clases de alto nivel no deben depender de clases de bajo nivel, ambas deben depender de abstracciones. En los scripts proporcionados:

CosplayCategoryView, QualificationCosplayView: Dependencia de abstracciones (controladores) en lugar de clases concretas.

CategoryCosplayController, ControllerQualification: Son clases de alto nivel que dependen de abstracciones (interfaces).

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
