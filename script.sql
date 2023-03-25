-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Patient` (
  `idPatient` INT NOT NULL AUTO_INCREMENT,
  `Firstname` VARCHAR(45) NOT NULL,
  `Lastname` VARCHAR(45) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`idPatient`),
  UNIQUE INDEX `idPatient_UNIQUE` (`idPatient` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research` (
  `idResearch` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(500) NULL,
  PRIMARY KEY (`idResearch`),
  UNIQUE INDEX `idResearch_UNIQUE` (`idResearch` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Test` (
  `idTest` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTest`),
  UNIQUE INDEX `idTest_UNIQUE` (`idTest` ASC) VISIBLE,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  UNIQUE INDEX `Description_UNIQUE` (`Description` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Access_level` TINYINT NOT NULL,
  `Patient_idPatient` INT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_User_Patient1_idx` (`Patient_idPatient` ASC) VISIBLE,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_User_Patient1`
    FOREIGN KEY (`Patient_idPatient`)
    REFERENCES `mydb`.`Patient` (`idPatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Result` (
  `idResult` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idResult`),
  UNIQUE INDEX `idResult_UNIQUE` (`idResult` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agreement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agreement` (
  `idAgreement` INT NOT NULL AUTO_INCREMENT,
  `Patient_idPatient` INT NOT NULL,
  `Agreement` VARCHAR(45) NULL,
  `Research_idResearch` INT NOT NULL,
  PRIMARY KEY (`idAgreement`),
  INDEX `fk_Agreement_Patient1_idx` (`Patient_idPatient` ASC) VISIBLE,
  UNIQUE INDEX `idAgreement_UNIQUE` (`idAgreement` ASC) VISIBLE,
  CONSTRAINT `fk_Agreement_Patient1`
    FOREIGN KEY (`Patient_idPatient`)
    REFERENCES `mydb`.`Patient` (`idPatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Referral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Referral` (
  `idReferral` INT NOT NULL AUTO_INCREMENT,
  `Term` DATE NULL,
  `Patient_idPatient` INT NOT NULL,
  `Research_idResearch` INT NOT NULL,
  `Test_idTest` INT NOT NULL,
  `Result_idResult` INT NULL,
  PRIMARY KEY (`idReferral`),
  UNIQUE INDEX `idReferral_UNIQUE` (`idReferral` ASC) VISIBLE,
  INDEX `fk_Referral_Patient1_idx` (`Patient_idPatient` ASC) VISIBLE,
  INDEX `fk_Referral_Result1_idx` (`Result_idResult` ASC) VISIBLE,
  INDEX `fk_Referral_Research1_idx` (`Research_idResearch` ASC) VISIBLE,
  INDEX `fk_Referral_Test1_idx` (`Test_idTest` ASC) VISIBLE,
  CONSTRAINT `fk_Referral_Patient1`
    FOREIGN KEY (`Patient_idPatient`)
    REFERENCES `mydb`.`Patient` (`idPatient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Referral_Result1`
    FOREIGN KEY (`Result_idResult`)
    REFERENCES `mydb`.`Result` (`idResult`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Referral_Research1`
    FOREIGN KEY (`Research_idResearch`)
    REFERENCES `mydb`.`Research` (`idResearch`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Referral_Test1`
    FOREIGN KEY (`Test_idTest`)
    REFERENCES `mydb`.`Test` (`idTest`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
