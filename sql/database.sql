CREATE DATABASE db_huansync;
USE db_huansync;

CREATE TABLE `tbl_events` (
  `eventId` integer PRIMARY KEY AUTO_INCREMENT,
  `nameEvent` varchar(50) UNIQUE,
  `countryEvent` varchar(30),
  `cityEvent` varchar(30),
  `addressEvent` varchar(40),
  `peopleCapacity` integer,
  `storeCapacity` integer,
  `restaurantCapacity` integer,
  `dateEvent` date,
  `timeEvent` time,
  `organizerId` integer NOT NULL,
  `ageClassification` ENUM ('family', 'adult', 'younger'),
  `statusEvent` ENUM ('active', 'finished', 'pending')
);

CREATE TABLE `tbl_workerRoles` (
  `workerRoleId` integer PRIMARY KEY AUTO_INCREMENT,
  `nameWorkerRole` varchar(50) UNIQUE,
  `activitiesWorkerRole` text
);

CREATE TABLE `tbl_staff` (
  `staffId` integer PRIMARY KEY AUTO_INCREMENT,
  `staffNumberId` varchar(15) UNIQUE,
  `nameStaff` varchar(50) NOT NULL,
  `birthdayStaff` date,
  `statusStaff` ENUM ('TASK_ASSIGNED', 'NO_TASK_ASSIGNED', 'DISMISSED', 'INCAPACITED'),
  `roleWorkId` integer
);

CREATE TABLE `tbl_staff_event` (
  `eventId` integer,
  `staffId` integer
);

CREATE TABLE `db_huansync`.`tbl_ticketoffice` (
  `ticketOfficeId` INT PRIMARY KEY AUTO_INCREMENT,
  `eventId` INT NOT NULL,
  `address` VARCHAR(50) DEFAULT NULL,
  `location` BOOLEAN NOT NULL,
  `contactNumber` VARCHAR(40) NOT NULL,
  `staffId` INT NOT NULL
);

CREATE TABLE `db_huansync`.`tbl_ticketType` (
  `ticketTypeId` INT PRIMARY KEY AUTO_INCREMENT,
  `nameTicketType` VARCHAR(40),
  `description` VARCHAR(255),
  `price` DECIMAL(10, 2)
);

CREATE TABLE `db_huansync`.`tbl_customers` (
  `customerId` INT PRIMARY KEY AUTO_INCREMENT,
  `nameCustomer` VARCHAR(50) NOT NULL,
  `document` INT NOT NULL,
  `gender` VARCHAR(20) DEFAULT NULL,
  `birthDate` DATE DEFAULT NULL,
  `emailCustomer` VARCHAR(50) DEFAULT NULL,
  `phoneNumber` VARCHAR(50) DEFAULT NULL,
  `typeCustomer` VARCHAR(50) DEFAULT NULL
);

CREATE TABLE `db_huansync`.`tbl_tickets` (
  `ticketId` INT PRIMARY KEY NOT NULL,
  `nameTicket` VARCHAR(50) DEFAULT NULL,
  `status` ENUM ('paid', 'reserved') DEFAULT NULL,
  `additionalCost` DECIMAL(10,2) DEFAULT NULL,
  `customerId` INT NOT NULL,
  `ticketOfficeId` INT NOT NULL,
  `ticketTypeId` INT NOT NULL
);

ALTER TABLE `db_huansync`.`tbl_ticketoffice` ADD FOREIGN KEY (`eventId`) REFERENCES `tbl_events` (`eventId`);

ALTER TABLE `db_huansync`.`tbl_ticketoffice` ADD FOREIGN KEY (`staffId`) REFERENCES `tbl_staff` (`staffId`);

ALTER TABLE `tbl_staff` ADD FOREIGN KEY (`roleWorkId`) REFERENCES `tbl_workerRoles` (`workerRoleId`);

ALTER TABLE `tbl_staff_event` ADD FOREIGN KEY (`staffId`) REFERENCES `tbl_staff` (`staffId`);

ALTER TABLE `tbl_staff_event` ADD FOREIGN KEY (`eventId`) REFERENCES `tbl_events` (`eventId`);

ALTER TABLE `db_huansync`.`tbl_tickets` ADD CONSTRAINT `fk_tickets_ticketOffice` FOREIGN KEY (`ticketOfficeId`) REFERENCES `db_huansync`.`tbl_ticketoffice` (`ticketOfficeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `db_huansync`.`tbl_tickets` ADD CONSTRAINT `fk_tickets_customer` FOREIGN KEY (`customerId`) REFERENCES `db_huansync`.`tbl_customers` (`customerId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `db_huansync`.`tbl_tickets` ADD CONSTRAINT `fk_ticket_tickettype` FOREIGN KEY (`ticketTypeId`) REFERENCES `db_huansync`.`tbl_ticketType` (`ticketTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

