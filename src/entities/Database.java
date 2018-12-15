package src.entities;

public class Database {
	private String db_name;
	
	public Database() {
		 this.db_name = null;	
	}
	
	public Database(String db_name) {
	 this.db_name = db_name;	
	}
	
	public String enableUniqueCheck() {
		return ("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
	}
	public String enableForeignCheck() {
		return ("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
	}
	
	public String enableSqlMode() {
		return ("SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';");
	}
				
	public String createSchema() {
		return ("CREATE SCHEMA IF NOT EXISTS `"+db_name+"` DEFAULT CHARACTER SET latin1;");
	}
	
	public String createUser() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`user` ("
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
				+ "`password` VARCHAR(45) NULL DEFAULT NULL,"
				+ "`securityQuestion` MEDIUMTEXT NULL DEFAULT NULL,"
				+ "`securityQuestionAnswer` MEDIUMTEXT NULL DEFAULT NULL,"
				+ "`username` VARCHAR(45) NULL DEFAULT NULL,"
				+ "PRIMARY KEY (`id`),"
				+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC))"
				+ "DEFAULT CHARACTER SET = latin1;");
	}
	
	public String createCourse() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`course` ( "
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
		 		+ "`name` VARCHAR(45) NOT NULL,"
		 		+ "`description` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`start_time` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`days` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
		 		+ "`college` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`courseid` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`type` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "`userid` INT(11) NOT NULL,"
		 		+ "`year` VARCHAR(45) NULL DEFAULT NULL,"
		 		+ "PRIMARY KEY (`id`),"
		 		+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC),"
		 		+ "INDEX `userid_idx` (`userid` ASC),"
		 		+ "CONSTRAINT `user-id`"
		 		+ "FOREIGN KEY (`userid`)"
		 		+ "REFERENCES `grading_system`.`user` (`id`)"
		 		+ "ON DELETE NO ACTION "
		 		+ "ON UPDATE NO ACTION);");
		}

	public String createAssignment() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`assignment` ("
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
				+ "`courseid` INT(11) NOT NULL,"
				+ "`name` VARCHAR(45) NOT NULL,"
				+ "`weight` INT(11) NOT NULL,"
				+ "`createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
				+ "`description` MEDIUMTEXT NULL DEFAULT NULL,"
				+ "`type` VARCHAR(45) NOT NULL,"
				+ "`total` INT(11) NOT NULL,"
				+ "`isOptional` TINYINT NULL,"
				+ "PRIMARY KEY (`id`),"
				+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC),"
				+ "INDEX `courseid_idx` (`courseid` ASC),"
				+ "CONSTRAINT `course-id`"
				+ "FOREIGN KEY (`courseid`)"
				+ "REFERENCES `grading_system`.`course` (`id`)"
				+ "ON DELETE NO ACTION "
				+ "ON UPDATE NO ACTION);");
	}
	
	public String createStudent() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`student` ("
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
				+ "`studentid` VARCHAR(45) NOT NULL,"
				+ "`first_name` VARCHAR(45) NOT NULL,"
				+ "`last_name` VARCHAR(45) NOT NULL,"
				+ "`year` VARCHAR(45) NOT NULL,"
				+ "`type` VARCHAR(45) NOT NULL,"
				+ "`createdAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
				+ "PRIMARY KEY (`id`),"
				+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC),"
				+ "UNIQUE INDEX `studentid_UNIQUE` (`studentid` ASC));");
	}
	
	public String createClass() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`class` ("
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
				+ "`courseid` INT(11) NOT NULL,"
				+ "`studentid` INT(11) NOT NULL,"
				+ "`created-at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
				+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC),"
				+ "INDEX `studentid_idx` (`studentid` ASC),"
				+ "CONSTRAINT `studentid`"
				+ "FOREIGN KEY (`studentid`)"
				+ "REFERENCES `grading_system`.`student` (`id`)"
				+ "ON DELETE NO ACTION "
				+ "ON UPDATE NO ACTION);");
	}
	

	public String createGrade() {
		return ("CREATE TABLE IF NOT EXISTS `"+db_name+"`.`grade` ("
				+ "`id` INT(11) NOT NULL AUTO_INCREMENT,"
				+ "`assignmentid` INT(11) NOT NULL,"
				+ "`studentid` INT(11) NOT NULL,"
				+ "`note` MEDIUMTEXT NULL DEFAULT NULL,"
				+ "`grade` DOUBLE NOT NULL,"
				+ "`created-at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
				+ "PRIMARY KEY (`id`),"
				+ "UNIQUE INDEX `id_UNIQUE` (`id` ASC),"
				+ "INDEX `assignmentid_idx` (`assignmentid` ASC),"
				+ "INDEX `student-id_idx` (`studentid` ASC),"
				+ "CONSTRAINT `assignmentid`"
				+ "FOREIGN KEY (`assignmentid`)"
				+ "REFERENCES `grading_system`.`assignment` (`id`)"
				+ "ON DELETE NO ACTION "
				+ "ON UPDATE NO ACTION,"
				+ "CONSTRAINT `student-id`"
				+ "FOREIGN KEY (`studentid`)"
				+ "REFERENCES `grading_system`.`student` (`id`)"
				+ "ON DELETE NO ACTION "
				+ "ON UPDATE NO ACTION);");
	}
	
	public String unableUniqueCheck() {
		return ("SET SQL_MODE=@OLD_SQL_MODE;");
	}
	
	public String unableForeignCheck() {
		return ("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
	}
	
	public String unableSqlMode() {
		return ("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");
	}
	
}
