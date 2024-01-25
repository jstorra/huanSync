DROP DATABASE db_huansync;
CREATE DATABASE db_huansync;
use db_huansync;


CREATE TABLE `tbl_ingredients` (
  `ingredientId` int PRIMARY KEY AUTO_INCREMENT,
  `nameIngredient` varchar(50) NOT NULL,
  `availableQuantity` int NOT NULL,
  `establishmentId` int 
);

CREATE TABLE `tbl_itemMenu` (
  `itemMenuId` int PRIMARY KEY AUTO_INCREMENT,
  `nameItemMenu` varchar(50) NOT NULL,
  `priceItemMenu` decimal(10,2) NOT NULL,
  `itemMenuType` ENUM ('appetizer', 'main course', 'drink', 'dessert') NOT NULL,
  `preparationTime` int NOT NULL,
  `establishmentId` int NOT NULL,
UNIQUE( `nameItemMenu`, `establishmentId`)
);

CREATE TABLE `tbl_ingredients_itemMenu` (
  `itemMenuId` int NOT NULL,
  `ingredientId` int NOT NULL,
UNIQUE( `itemMenuId`, `ingredientId`)
);

CREATE TABLE tbl_establishments (
   establishmentId INT PRIMARY KEY AUTO_INCREMENT,
   categoryEstablishment ENUM('restaurant', 'store') NOT NULL,
   nameEstablishment VARCHAR(40) NOT NULL,
   eventId INT,
    managerEstablishmentId INT
);

ALTER TABLE `tbl_ingredients_itemMenu` ADD FOREIGN KEY (`ingredientId`) REFERENCES `tbl_ingredients` (`ingredientId`) ON DELETE CASCADE;

ALTER TABLE `tbl_ingredients_itemMenu` ADD FOREIGN KEY (`itemMenuId`) REFERENCES `tbl_itemMenu` (`itemMenuId`)  ON DELETE CASCADE;

ALTER TABLE `tbl_itemMenu` ADD FOREIGN KEY (`establishmentId`) REFERENCES `tbl_establishments` (`establishmentId`)  ON DELETE CASCADE;

ALTER TABLE `tbl_ingredients` ADD FOREIGN KEY (`establishmentId`) REFERENCES `tbl_establishments` (`establishmentId`) ON DELETE CASCADE;


-- SELECT * FROM tbl_ingredients;
-- SELECT * FROM tbl_establishments;
-- SELECT * FROM tbl_itemMenu;

-- INSERT INTO tbl_establishments VALUES(1),(2),(3);


INSERT INTO `tbl_ingredients` (`nameIngredient`, `availableQuantity`, establishmentId) VALUES('Harina', 500, 3),
('Azúcar', 1000, 3),
('Sal', 200, 2),
('Levadura', 50, 2),
('Huevos', 30, 1),
('Leche', 800, 2),
('Aceite', 300,1),
('Chocolate', 150, 2),
('Vainilla', 20, 1),
('Canela', 10, 2);