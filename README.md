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
│                       │   │   ├───categorycosplay
│                       │   │   │   ├───controller
│                       │   │   │   └───model
│                       │   │   ├───Controller
│                       │   │   ├───managementQualification
│                       │   │   │   ├───controller
│                       │   │   │   └───model
│                       │   │   └───model
│                       │   ├───model
│                       │   │   └───prize
│                       │   │       ├───controller
│                       │   │       └───model
│                       │   ├───sql
│                       │   └───trivia
│                       │       ├───controller
│                       │       ├───img
│                       │       ├───informs
│                       │       ├───model
│                       │       └───question
│                       │           ├───controller
│                       │           └───model
│                       ├───establishment
│                       │   ├───cash
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       │   └───builder
│                       │   │       └───DAO
│                       │   ├───controller
│                       │   ├───DAO
│                       │   ├───model
│                       │   │   ├───classes
│                       │   │   │   └───builder
│                       │   │   └───DAO
│                       │   ├───order
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       └───DAO
│                       │   ├───restaurant
│                       │   │   ├───controller
│                       │   │   ├───ingredient
│                       │   │   │   ├───controller
│                       │   │   │   └───model
│                       │   │   │       ├───classes
│                       │   │   │       └───DAO
│                       │   │   ├───itemMenu
│                       │   │   │   ├───controller
│                       │   │   │   └───model
│                       │   │   │       ├───classes
│                       │   │   │       │   └───builder
│                       │   │   │       └───DAO
│                       │   │   ├───itemMenuOrder
│                       │   │   │   ├───controller
│                       │   │   │   └───model
│                       │   │   │       ├───classes
│                       │   │   │       └───DAO
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       └───DAO
│                       │   └───store
│                       │       ├───controller
│                       │       ├───product
│                       │       │   ├───controller
│                       │       │   └───model
│                       │       │       ├───classes
│                       │       │       │   └───builder
│                       │       │       └───DAO
│                       │       ├───productOrder
│                       │       │   ├───controller
│                       │       │   └───model
│                       │       │       ├───classes
│                       │       │       └───DAO
│                       │       ├───promotion
│                       │       │   ├───controller
│                       │       │   └───model
│                       │       │       ├───classes
│                       │       │       │   └───builder
│                       │       │       └───DAO
│                       │       └───sql
│                       ├───event
│                       │   ├───controller
│                       │   ├───DAO
│                       │   ├───equipment
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       └───DAO
│                       │   ├───model
│                       │   │   ├───classes
│                       │   │   │   └───builders
│                       │   │   ├───DAO
│                       │   │   └───util
│                       │   ├───staff
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       └───DAO
│                       │   └───workerRoles
│                       │       ├───controller
│                       │       └───model
│                       │           ├───classes
│                       │           └───DAO
│                       ├───persistence
│                       ├───ticketOffice
│                       │   ├───accounting
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       └───DAO
│                       │   ├───client
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       │   └───builders
│                       │   │       └───DAO
│                       │   ├───controller
│                       │   ├───img
│                       │   ├───model
│                       │   │   ├───builders
│                       │   │   ├───classes
│                       │   │   ├───DAO
│                       │   │   └───util
│                       │   ├───participation
│                       │   │   ├───controller
│                       │   │   └───model
│                       │   │       ├───classes
│                       │   │       │   └───buildes
│                       │   │       └───DAO
│                       │   └───tickets
│                       │       ├───controller
│                       │       ├───model
│                       │       │   ├───classes
│                       │       │   │   └───builders
│                       │       │   ├───DAO
│                       │       │   └───util
│                       │       └───ticketType
│                       │           ├───controller
│                       │           └───model
│                       │               ├───classes
│                       │               └───DAO
│                       └───view
│                           ├───activityView
│                           ├───establishmentView
│                           ├───eventView
│                           ├───icons
│                           ├───staffView
│                           ├───ticketView
│                           └───workerRoleView
```
## Modules

### Database
- [See Database](sql/README%20Database.md)

### Event
- [See Event](src/main/java/com/u2team/huansync/event/)

### TicketOffice
- [See TicketOffice](src/main/java/com/u2team/huansync/ticketOffice/README%20TicketOffice.md)

### Activity
- [See Activity](src/main/java/com/u2team/huansync/activity/README_Activity.md)

### Trivia
- [See Trivia](src/main/java/com/u2team/huansync/activity/trivia/)

### Cosplay
- [See Cosplay](src/main/java/com/u2team/huansync/activity/cosplay/)

### Store
- [See Store](src/main/java/com/u2team/huansync/establishment/store/README.md)

### Restaurant
- [See Restaurant](src/main/java/com/u2team/huansync/establishment/restaurant/README%20Restaurant.md)


## How to Contribute
If you want to contribute to this project, follow these steps:

   1. Fork the repository.
   2. Create a branch for your contribution: `git checkout -b your-branch-name`.
   3. Make the changes and commit: `git commit -m "Description of your changes"`.
   4. Push your branch: `git push origin your-branch-name`.
   5. Open a pull request explaining your changes.
## Contributors

1. Team 1 
   - [Dabrox02](https://github.com/Dabrox02) (leader)
   - [johanp0308](https://github.com/johanp0308)
2. Team 2
   - [duranangie](https://github.com/duranangie) (leader)
   - [RCNicolas](https://github.com/RCNicolas)
   - [AitsuYuyu](https://github.com/AitsuYuyu)
3. Team 3
   - [JCristinaJSalas](https://github.com/JCristinaJSalas) (leader)
   - [kazeventum](https://github.com/kazeventum)
   - [EMpinzon](https://github.com/EMpinzon)
4. Team 4
   - [AngieNC](https://github.com/AngieNC) (leader)
   - [Ancreem](https://github.com/Ancreem)
   - [DavidSantos004](https://github.com/DavidSantos004)
5. Team 5
   - [Santiago24x](https://github.com/Santiago24x) (leader)
   - [robersks](https://github.com/robersks)
   - [JUANDGG](https://github.com/JUANDGG)
6. Team 6
   - [jstorra](https://github.com/jstorra) (leader)
   - [leidert11](https://github.com/leidert11)
   - [violetavillamizara](https://github.com/violetavillamizara)
7. Team 7
   - [Kevin-Jimenez-D](https://github.com/Kevin-Jimenez-D) (leader)
   - [BarbatosLopux](https://github.com/BarbatosLopux)
   - [DwightHernandez](https://github.com/DwightHernandez)
8. Team 8
   - [Trullez-44](https://github.com/Trullez-44)(leader)
   - [dfrincong](https://github.com/dfrincong)
   - [DeuryZ](https://github.com/DeuryZ)
