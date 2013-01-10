SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `dream` ;
CREATE SCHEMA IF NOT EXISTS `dream` DEFAULT CHARACTER SET latin1 ;
USE `dream` ;

-- -----------------------------------------------------
-- Table `dream`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dream`.`User` ;

CREATE  TABLE IF NOT EXISTS `dream`.`User` (
  `id` BIGINT(20) NOT NULL ,
  `created_date` DATETIME NULL DEFAULT NULL ,
  `last_updated_date` DATETIME NULL DEFAULT NULL ,
  `created_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `last_updated_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  `password` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKFE64F9ED1FC7FF40285feb` (`created_by_user` ASC) ,
  INDEX `FKFE64F9EDF46EDA6A285feb` (`last_updated_by_user` ASC) ,
  CONSTRAINT `FKFE64F9EDF46EDA6A285feb`
    FOREIGN KEY (`last_updated_by_user` )
    REFERENCES `dream`.`User` (`id` ),
  CONSTRAINT `FKFE64F9ED1FC7FF40285feb`
    FOREIGN KEY (`created_by_user` )
    REFERENCES `dream`.`User` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dream`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dream`.`Category` ;

CREATE  TABLE IF NOT EXISTS `dream`.`Category` (
  `id` BIGINT(20) NOT NULL ,
  `created_date` DATETIME NULL DEFAULT NULL ,
  `last_updated_date` DATETIME NULL DEFAULT NULL ,
  `created_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `last_updated_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `description` VARCHAR(255) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKFE64F9ED1FC7FF406dd211e` (`created_by_user` ASC) ,
  INDEX `FKFE64F9EDF46EDA6A6dd211e` (`last_updated_by_user` ASC) ,
  CONSTRAINT `FKFE64F9EDF46EDA6A6dd211e`
    FOREIGN KEY (`last_updated_by_user` )
    REFERENCES `dream`.`User` (`id` ),
  CONSTRAINT `FKFE64F9ED1FC7FF406dd211e`
    FOREIGN KEY (`created_by_user` )
    REFERENCES `dream`.`User` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dream`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dream`.`Item` ;

CREATE  TABLE IF NOT EXISTS `dream`.`Item` (
  `id` BIGINT(20) NOT NULL ,
  `created_date` DATETIME NULL DEFAULT NULL ,
  `last_updated_date` DATETIME NULL DEFAULT NULL ,
  `created_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `last_updated_by_user` BIGINT(20) NULL DEFAULT NULL ,
  `description` VARCHAR(255) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL ,
  `category_id` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `FKFE64F9ED1FC7FF4022ef33` (`created_by_user` ASC) ,
  INDEX `FK22EF33BD21D393` (`category_id` ASC) ,
  INDEX `FKFE64F9EDF46EDA6A22ef33` (`last_updated_by_user` ASC) ,
  CONSTRAINT `FKFE64F9EDF46EDA6A22ef33`
    FOREIGN KEY (`last_updated_by_user` )
    REFERENCES `dream`.`User` (`id` ),
  CONSTRAINT `FK22EF33BD21D393`
    FOREIGN KEY (`category_id` )
    REFERENCES `dream`.`Category` (`id` ),
  CONSTRAINT `FKFE64F9ED1FC7FF4022ef33`
    FOREIGN KEY (`created_by_user` )
    REFERENCES `dream`.`User` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dream`.`hibernate_sequences`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dream`.`hibernate_sequences` ;

CREATE  TABLE IF NOT EXISTS `dream`.`hibernate_sequences` (
  `sequence_name` VARCHAR(255) NULL DEFAULT NULL ,
  `sequence_next_hi_value` INT(11) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
