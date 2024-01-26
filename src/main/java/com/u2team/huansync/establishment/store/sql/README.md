create database db_huansync;
use db_huansync;

create table tbl_order(
orderId int not null auto_increment,
orderStatusEnum enum("REGISTERED", "PAID", "DELIVERED")not null,
customerId int not null ,
establishmentId int not null ,
cashRegisterId int not null ,
cashierOperatorId int not null ,
primary key (orderId)
);


INSERT INTO tbl_order(orderId,customerId,establishmentId,cashRegisterId,cashierOperatorId,orderStatusEnum) VALUES(1,1,1,1,1,"REGISTERED");
