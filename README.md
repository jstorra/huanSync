# Project's HuanSync

## Description

The project aims to manage, administer and store the information of the company called HuanSync. It is a comprehensive platform that makes it easy to organize cosplay events and other activities. In addition, the system allows efficient management of personnel assigned to various events, as well as detailed monitoring of the inventory of stores and restaurants participating in said events.

Among the key functionalities is ticket management, providing a complete solution for the planning and execution of events. This comprehensive platform not only simplifies event logistics, but also optimizes the experience for the participants and collaborators involved.

## Environment Configuration
### Database Configuration
**MySQL Database**
1. Prerequisites:
   - Make sure you have a MySQL server running.
   - Consult requirements [here](./sql/README%20Database.md)
2. BDConnection.java file configuration:

   - Open the file src/main/java/com/u2team/huansync/persistence/BDConection.java.

   - Modify the following properties to reflect your database configuration:

```java
public static Connection MySQLConnection() {
        url = "jdbc:mysql://localhost:3306/db_huansync";
        user = ""; // <--- Your User Here! 
        password = ""; // <--- Your Password Here!
        return getConnection(url, user, password);
    }
```

### Clone the Repository

To clone this repository, use the following command:

```bash
git clone https://github.com/Dabrox02/huanSync.git
```

## Project Structure
```
├───sql
│   └───img
├───src
│   └───main
│       └───java
│           └───com
│               └───u2team
│                   └───huansync
│                       ├───activity
│                       │   ├───controller
│                       │   ├───cosplay
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   ├───model
│                       │   └───trivia
│                       │       ├───controller
│                       │       └───model
│                       ├───establishment
│                       │   ├───controller
│                       │   ├───model
│                       │   ├───restaurant
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   └───store
│                       │       ├───controller
│                       │       └───model
│                       ├───event
│                       │   ├───controller
│                       │   └───model
│                       ├───persistence
│                       └───ticketOffice
│                           ├───controller
│                           └───model

```
## How I Contributed
### Cómo Contribuir
Si deseas contribuir a este proyecto, sigue estos pasos:

   1. Realiza un fork del repositorio.
   2. Crea una rama para tu contribución: `git checkout -b nombre-de-tu-rama`.
   3. Realiza los cambios y commitea: `git commit -m "Descripción de tus cambios"`.
   4. Haz push a tu rama: `git push origin nombre-de-tu-rama`.
   5. Abre un pull request explicando tus cambios.

## Contributors

1. Team 1
   - [Dabrox02](https://github.com/Dabrox02) (leader)
   - [johanp0308](https://github.com/johanp0308)
2. Team 2
   - [JCristinaJSalas](https://github.com/JCristinaJSalas) (leader)
   - [RCNicolas](https://github.com/RCNicolas)
   - [AitsuYuyu](https://github.com/AitsuYuyu)
3. Team 3
   - []()
   - [kazeventum](https://github.com/kazeventum)
   - [EMpinzon](https://github.com/EMpinzon)
4. Team 4
   - [AngieNC](https://github.com/AngieNC) (leader)
   - [Ancreem](https://github.com/Ancreem)
   - [DavidSantos004](https://github.com/DavidSantos004)
5. Team 5
   - []()
   - [robersks](https://github.com/robersks)
   - []()
6. Team 6
   - [jstorra](https://github.com/jstorra) (leader)
   - [leidert11](https://github.com/leidert11)
   - []()
7. Team 7
   - [Kevin-Jimenez-D](https://github.com/Kevin-Jimenez-D) (leader)
   - [BarbatosLopux](https://github.com/BarbatosLopux)
   - [DwightHernandez](https://github.com/DwightHernandez)
8. Team 8
   - [Trullez-44](https://github.com/Trullez-44)(leader)
   - [dfrincong](https://github.com/dfrincong)
   - [DeuryZ](https://github.com/DeuryZ)
