-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pwi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pwi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pwi` DEFAULT CHARACTER SET utf8 ;
USE `pwi` ;


-- -----------------------------------------------------
-- Table `pwi`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`company` (
  `company_id` INT(11) NOT NULL,
  `company_name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pwi`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`location` (
  `location_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `company_id` INT(11) NOT NULL,
  PRIMARY KEY (`location_id`, `company_id`),
  CONSTRAINT `fk_location_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `pwi`.`company` (`company_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_location_company_idx` ON `pwi`.`location` (`company_id` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`warehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`warehouse` (
  `warehouse_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`warehouse_id`, `location_id`),
  CONSTRAINT `fk_warehouse_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `pwi`.`location` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_warehouse_location1_idx` ON `pwi`.`warehouse` (`location_id` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`product_type` (
  `product_type_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `is_sellable` TINYINT NULL,
  PRIMARY KEY (`product_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwi`.`brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`brands` (
  `brand_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `company_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`brand_id`),
  CONSTRAINT `company_id`
    FOREIGN KEY (`company_id`)
    REFERENCES `pwi`.`company` (`company_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `company_id_idx` ON `pwi`.`brands` (`company_id` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`product` (
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(45) NULL,
  `in_stock` INT NULL,
  `avl_qty` INT NULL,
  `in_transit` INT NULL,
  `moq` INT NULL,
  `qpb` INT NULL,
  `reorder_point` INT NULL,
  `product_type_id` INT NOT NULL,
  `brand_id` INT(11) NOT NULL,
  PRIMARY KEY (`product_id`, `brand_id`),
  CONSTRAINT `fk_product_product_type1`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `pwi`.`product_type` (`product_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_brands1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `pwi`.`brands` (`brand_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_product_product_type1_idx` ON `pwi`.`product` (`product_type_id` ASC);

CREATE INDEX `fk_product_brands1_idx` ON `pwi`.`product` (`brand_id` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`product_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`product_detail` (
  `product_size_id` INT NOT NULL,
  `product_size_value` VARCHAR(45) NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`product_size_id`, `product_id`),
  CONSTRAINT `fk_product_size_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `pwi`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_product_size_product1_idx` ON `pwi`.`product_detail` (`product_id` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`product_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`product_mapping` (
  `product_mapping_id` INT NOT NULL,
  `warehouse_id` INT NOT NULL,
  `brand_id` INT(11) NOT NULL,
  PRIMARY KEY (`product_mapping_id`, `warehouse_id`, `brand_id`),
  CONSTRAINT `fk_product_mapping_warehouse1`
    FOREIGN KEY (`warehouse_id`)
    REFERENCES `pwi`.`warehouse` (`warehouse_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_mapping_brands1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `pwi`.`brands` (`brand_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_product_mapping_warehouse1_idx` ON `pwi`.`product_mapping` (`warehouse_id` ASC);

CREATE INDEX `fk_product_mapping_brands1_idx` ON `pwi`.`product_mapping` (`brand_id` ASC);

USE `pwi` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
