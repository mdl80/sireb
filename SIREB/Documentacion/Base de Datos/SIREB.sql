-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema SIREB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SIREB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SIREB` DEFAULT CHARACTER SET utf8 ;
USE `SIREB` ;

-- -----------------------------------------------------
-- Table `SIREB`.`BarriosZonas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`BarriosZonas` (
  `idBarrioZona` INT(11) NOT NULL AUTO_INCREMENT,
  `barrioZona` VARCHAR(45) NOT NULL,
  `jurisdiccion` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idBarrioZona`))
ENGINE = InnoDB
AUTO_INCREMENT = 45
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Grados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Grados` (
  `idGrado` INT(11) NOT NULL AUTO_INCREMENT,
  `grado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGrado`))
ENGINE = InnoDB
AUTO_INCREMENT = 50
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`MotivosBajas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`MotivosBajas` (
  `idMotivoBaja` INT(11) NOT NULL AUTO_INCREMENT,
  `motivo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMotivoBaja`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Bomberos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Bomberos` (
  `idBombero` INT(11) NOT NULL AUTO_INCREMENT,
  `DNI` VARCHAR(8) NOT NULL,
  `nombre1` VARCHAR(45) NOT NULL,
  `nombre2` VARCHAR(40) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefonoCasa` BIGINT(20) NULL DEFAULT NULL,
  `telefonoCelular` BIGINT(20) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `edad` SMALLINT(6) NOT NULL,
  `factorSanguineo` ENUM('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', '0+', '0-') NOT NULL,
  `genero` ENUM('M', 'F', 'X') NOT NULL,
  `fechaAlta` DATE NOT NULL,
  `fechaBaja` DATE NULL DEFAULT NULL,
  `idMotivoBaja` INT(11) NULL DEFAULT NULL,
  `idGrado` INT(11) NOT NULL,
  `idCuartel` INT(11) NOT NULL,
  PRIMARY KEY (`idBombero`),
  INDEX `fk_Bomberos_MotivosBajas_idx` (`idMotivoBaja` ASC) VISIBLE,
  INDEX `fk_Bomberos_Grados1_idx` (`idGrado` ASC) VISIBLE,
  CONSTRAINT `fk_Bomberos_Grados1`
    FOREIGN KEY (`idGrado`)
    REFERENCES `SIREB`.`Grados` (`idGrado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idMotivosBajas`
    FOREIGN KEY (`idMotivoBaja`)
    REFERENCES `SIREB`.`MotivosBajas` (`idMotivoBaja`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 51
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Cuarteles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Cuarteles` (
  `idCuartel` INT(11) NOT NULL AUTO_INCREMENT,
  `regionalNumero` INT(11) NOT NULL,
  `cuartelNumero` INT(11) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `jefeCuartel` INT(11) NOT NULL,
  `logo` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idCuartel`, `jefeCuartel`),
  UNIQUE INDEX `jefeCuartel_UNIQUE` (`jefeCuartel` ASC) VISIBLE,
  INDEX `fk_Cuarteles_Bomberos1_idx` (`jefeCuartel` ASC) VISIBLE,
  CONSTRAINT `fk_Cuarteles_Bomberos1`
    FOREIGN KEY (`jefeCuartel`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`EstadoMoviles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`EstadoMoviles` (
  `idEstadoMovil` INT(11) NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstadoMovil`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Estados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Estados` (
  `idEstado` INT(11) NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstado`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Eventos` (
  `idEventos` INT(11) NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(100) NOT NULL,
  `Mensaje` VARCHAR(300) NOT NULL,
  `Fecha` DATETIME NOT NULL,
  `idBombero` INT(11) NOT NULL,
  PRIMARY KEY (`idEventos`),
  INDEX `fk_idBombero` (`idBombero` ASC) VISIBLE,
  CONSTRAINT `fk_idBombero`
    FOREIGN KEY (`idBombero`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1200
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Modificados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Modificados` (
  `idModificado` INT(11) NOT NULL AUTO_INCREMENT,
  `modificado` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`idModificado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`TiposBombas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`TiposBombas` (
  `idTipoBomba` INT(11) NOT NULL AUTO_INCREMENT,
  `bombaTipo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipoBomba`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`TiposMoviles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`TiposMoviles` (
  `idTipoMovil` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipoMovil`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Moviles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Moviles` (
  `idmovil` INT(11) NOT NULL AUTO_INCREMENT,
  `numeroMovil` SMALLINT(6) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `plaza` INT(11) NOT NULL,
  `idTipoBomba` INT(11) NULL DEFAULT NULL,
  `idEstadoMovil` INT(11) NOT NULL,
  `idTipoMovil` INT(11) NOT NULL,
  PRIMARY KEY (`idmovil`),
  INDEX `fk_moviles_TiposBombas_idx` (`idTipoBomba` ASC) VISIBLE,
  INDEX `fk_moviles_EstadoMoviles_idx` (`idEstadoMovil` ASC) VISIBLE,
  INDEX `fk_moviles_TiposMoviles_idx` (`idTipoMovil` ASC) VISIBLE,
  CONSTRAINT `fk_moviles_EstadoMoviles`
    FOREIGN KEY (`idEstadoMovil`)
    REFERENCES `SIREB`.`EstadoMoviles` (`idEstadoMovil`),
  CONSTRAINT `fk_moviles_TiposBombas`
    FOREIGN KEY (`idTipoBomba`)
    REFERENCES `SIREB`.`TiposBombas` (`idTipoBomba`),
  CONSTRAINT `fk_moviles_TiposMoviles`
    FOREIGN KEY (`idTipoMovil`)
    REFERENCES `SIREB`.`TiposMoviles` (`idTipoMovil`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`TipoAvisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`TipoAvisos` (
  `idTipoAviso` INT(11) NOT NULL AUTO_INCREMENT,
  `avisoTipo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoAviso`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`SubTipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`SubTipos` (
  `idSubTipo` INT(11) NOT NULL AUTO_INCREMENT,
  `subTipo` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSubTipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Tipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Tipos` (
  `idTipo` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`TiposIntervenciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`TiposIntervenciones` (
  `idTipoIntervencion` INT(11) NOT NULL AUTO_INCREMENT,
  `idTipo` INT(11) NOT NULL,
  `idSubTipo` INT(11) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoIntervencion`),
  INDEX `fk_TiposIntervenciones_Tipos1_idx` (`idTipo` ASC) VISIBLE,
  INDEX `fk_TiposIntervenciones_SubTipos1_idx` (`idSubTipo` ASC) VISIBLE,
  CONSTRAINT `fk_TiposIntervenciones_SubTipos1`
    FOREIGN KEY (`idSubTipo`)
    REFERENCES `SIREB`.`SubTipos` (`idSubTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TiposIntervenciones_Tipos1`
    FOREIGN KEY (`idTipo`)
    REFERENCES `SIREB`.`Tipos` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Intervenciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Intervenciones` (
  `idIntervencion` INT(11) NOT NULL AUTO_INCREMENT,
  `ticket` VARCHAR(12) NOT NULL,
  `fecha` DATE NOT NULL,
  `horaInicio` DATE NOT NULL,
  `horaFin` DATE NULL DEFAULT NULL,
  `horaLlamado` DATE NULL DEFAULT NULL,
  `nombreAlertante` VARCHAR(45) NOT NULL,
  `apellidoAlertante` VARCHAR(45) NOT NULL,
  `contactoAlertante` VARCHAR(45) NOT NULL,
  `direccion1` VARCHAR(45) NOT NULL,
  `direccion2` VARCHAR(45) NULL DEFAULT NULL,
  `informeIntervencion` BLOB NULL DEFAULT NULL,
  `idTipoAviso` INT(11) NOT NULL,
  `idEstado` INT(11) NOT NULL,
  `idBarrioZona` INT(11) NOT NULL,
  `idModificado` INT(11) NOT NULL,
  `idJefeBrigada` INT(11) NOT NULL,
  `idTipoIntervencion` INT(11) NOT NULL,
  `idMovilRespuesta` INT(11) NOT NULL,
  PRIMARY KEY (`idIntervencion`),
  INDEX `FK_tipoAviso` (`idTipoAviso` ASC) VISIBLE,
  INDEX `FK_estado` (`idEstado` ASC) VISIBLE,
  INDEX `FK_BarrioZona` (`idBarrioZona` ASC) VISIBLE,
  INDEX `FK_modificado` (`idModificado` ASC) VISIBLE,
  INDEX `FK_jefeBrigrada` (`idJefeBrigada` ASC) VISIBLE,
  INDEX `FK_tipoIntervencion` (`idTipoIntervencion` ASC) VISIBLE,
  INDEX `FK_movilRespuesta` (`idMovilRespuesta` ASC) VISIBLE,
  CONSTRAINT `FK_BarrioZona`
    FOREIGN KEY (`idBarrioZona`)
    REFERENCES `SIREB`.`BarriosZonas` (`idBarrioZona`),
  CONSTRAINT `FK_estado`
    FOREIGN KEY (`idEstado`)
    REFERENCES `SIREB`.`Estados` (`idEstado`),
  CONSTRAINT `FK_jefeBrigrada`
    FOREIGN KEY (`idJefeBrigada`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`),
  CONSTRAINT `FK_modificado`
    FOREIGN KEY (`idModificado`)
    REFERENCES `SIREB`.`Modificados` (`idModificado`),
  CONSTRAINT `FK_movilRespuesta`
    FOREIGN KEY (`idMovilRespuesta`)
    REFERENCES `SIREB`.`Moviles` (`idmovil`),
  CONSTRAINT `FK_tipoAviso`
    FOREIGN KEY (`idTipoAviso`)
    REFERENCES `SIREB`.`TipoAvisos` (`idTipoAviso`),
  CONSTRAINT `FK_tipoIntervencion`
    FOREIGN KEY (`idTipoIntervencion`)
    REFERENCES `SIREB`.`TiposIntervenciones` (`idTipoIntervencion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`OtrosServicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`OtrosServicios` (
  `idOtroServicio` INT(11) NOT NULL AUTO_INCREMENT,
  `servicio` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idOtroServicio`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`OtrosServiciosEnIntervenciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`OtrosServiciosEnIntervenciones` (
  `Ticket` INT(11) NOT NULL,
  `idOtroServicio` INT(11) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Privilegios` (
  `idPrivilegio` INT(11) NOT NULL AUTO_INCREMENT,
  `tipoPrivilegio` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idPrivilegio`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`PrivilegiosBomberos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`PrivilegiosBomberos` (
  `idBombero` INT(11) NOT NULL,
  `idPrivilegio` INT(11) NOT NULL,
  `fechaAlta` DATE NOT NULL,
  `fechaBaja` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idBombero`, `idPrivilegio`),
  INDEX `fk_Bomberos_has_Privilegios_Privilegios1_idx` (`idPrivilegio` ASC) VISIBLE,
  INDEX `fk_Bomberos_has_Privilegios_Bomberos1_idx` (`idBombero` ASC) VISIBLE,
  CONSTRAINT `fk_Bomberos_has_Privilegios_Bomberos1`
    FOREIGN KEY (`idBombero`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bomberos_has_Privilegios_Privilegios1`
    FOREIGN KEY (`idPrivilegio`)
    REFERENCES `SIREB`.`Privilegios` (`idPrivilegio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`Registros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`Registros` (
  `idRegistros` INT(11) NOT NULL AUTO_INCREMENT,
  `idBombero` INT(11) NOT NULL,
  `Login` DATETIME NOT NULL,
  `logout` DATETIME NULL DEFAULT NULL,
  `ingreso` BIT(1) NOT NULL,
  PRIMARY KEY (`idRegistros`, `idBombero`),
  INDEX `fk_Registros_Bomberos1_idx` (`idBombero` ASC) VISIBLE,
  CONSTRAINT `fk_Registros_Bomberos1`
    FOREIGN KEY (`idBombero`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `SIREB`.`UsuarioContraseña`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SIREB`.`UsuarioContraseña` (
  `idUsuarioContraseña` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `idBomber` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuarioContraseña`),
  INDEX `fk_UsuarioContraseña_Bomberos1_idx` (`idBomber` ASC) VISIBLE,
  CONSTRAINT `fk_UsuarioContraseña_Bomberos1`
    FOREIGN KEY (`idBomber`)
    REFERENCES `SIREB`.`Bomberos` (`idBombero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
