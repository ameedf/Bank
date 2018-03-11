CREATE SCHEMA `bank` ;
use bank;
CREATE TABLE `bank`.`transactions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(10) NULL,
  `amount` DECIMAL(10,2) NULL,
  `account_id` INT(11) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `bank`.`accounts` (
  `acc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `owner` VARCHAR(45) NULL,
  `total` DECIMAL(10,2) NULL,
  PRIMARY KEY (`acc_id`));
