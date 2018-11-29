-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema grading_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema grading_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grading_system` DEFAULT CHARACTER SET latin1 ;
USE `grading_system` ;

-- -----------------------------------------------------
-- Table `grading_system`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `start_time` VARCHAR(45) NULL DEFAULT NULL,
  `days` VARCHAR(45) NULL DEFAULT NULL,
  `createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grading_system`.`assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`assignment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `courseid` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `weight` INT(11) NOT NULL,
  `createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `courseid_idx` (`courseid` ASC),
  CONSTRAINT `course-id`
    FOREIGN KEY (`courseid`)
    REFERENCES `grading_system`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grading_system`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `studentid` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `year` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `studentid_UNIQUE` (`studentid` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grading_system`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`class` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `courseid` INT(11) NOT NULL,
  `studentid` INT(11) NOT NULL,
  `created-at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `studentid_idx` (`studentid` ASC),
  CONSTRAINT `studentid`
    FOREIGN KEY (`studentid`)
    REFERENCES `grading_system`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grading_system`.`grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`grade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `assignmentid` INT(11) NOT NULL,
  `studentid` INT(11) NOT NULL,
  `note` MEDIUMTEXT NULL DEFAULT NULL,
  `grade` DOUBLE NOT NULL,
  `created-at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `assignmentid_idx` (`assignmentid` ASC),
  INDEX `student-id_idx` (`studentid` ASC),
  CONSTRAINT `assignmentid`
    FOREIGN KEY (`assignmentid`)
    REFERENCES `grading_system`.`assignment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student-id`
    FOREIGN KEY (`studentid`)
    REFERENCES `grading_system`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grading_system`.`security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grading_system`.`security` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `security-question` MEDIUMTEXT NULL DEFAULT NULL,
  `security-question-answer` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
