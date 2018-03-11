-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.20-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para foodscrap
CREATE DATABASE IF NOT EXISTS `foodscrap` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `foodscrap`;

-- Volcando estructura para procedimiento foodscrap.AccesoLogin
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `AccesoLogin`(
	IN `u` varchar (20),
	IN `c` varchar(20)

)
begin
	if not exists (select * from usuario where Usuario = u and Contraseña = c) then   

           select 'Usuario No Existe' as Mensaje;
        else 
	       select 'Existe' as Mensaje,A.Usuario,C.Nombre as Nombre_Rol,C.Siglas as Siglas_Rol,B.Nombre,B.Apellidos from usuario A 
				 inner join persona B ON A.Id_Persona = B.Id_Persona 
				 inner join roles C on C.Id_Roll = A.Id_Roll
			 where Usuario=u and Contraseña=c;
   end if;
 end//
DELIMITER ;

-- Volcando estructura para tabla foodscrap.bebidas
CREATE TABLE IF NOT EXISTS `bebidas` (
  `Id_bebida` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `valor_Und` double NOT NULL,
  PRIMARY KEY (`Id_bebida`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.bebidas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;

-- Volcando estructura para procedimiento foodscrap.CambiarContra
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CambiarContra`(
P_Usuario varchar(20),
P_Contrasena varchar (20),
P_Nueva varchar (20)

)
begin
	if not exists (select * from Usuarios where Usuario = P_Usuario and Contrasena = P_Contrasena) then   

           select 'El usuario no Existe' as Mensaje;
        else 		
	       Update Usuarios SET Contrasena = P_Nueva Where Usuario = P_Usuario;
           select 'Contraseña Actualizada' as Mensaje,usuarios. * from usuarios where Usuario = P_Usuario;
   end if;
 end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.CargarModulos
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargarModulos`()
begin  
	SELECT DISTINCT A.Codigo_Permiso FROM PERMISOS A;
end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.CargarPermisos
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargarPermisos`(IN P_Usuario varchar(30),IN P_Codigo_Permiso varchar(50))
begin  
	SELECT A.*,IF((SELECT COUNT(1) FROM PERMISOS_USUARIOS B WHERE B.Id_Permiso = A.Id_Permiso and B.Usuario = P_Usuario) > 0, 'S','N') HABILITADO FROM PERMISOS A where A.Codigo_Permiso = P_Codigo_Permiso;
end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.CargarPregunta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargarPregunta`()
begin
Select 0 AS Id_Pregunta, 'Seleccione...' AS Pregunta
UNION
SELECT Id_Pregunta, Pregunta FROM PreguntaSecreta 
ORDER BY Id_Pregunta ;
end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.CargarRoles
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargarRoles`()
begin
Select 0 AS Id_Roll, 'Seleccione...' AS Nombre, 'SL' AS Siglas
UNION
SELECT Id_Roll, Nombre, Siglas FROM Roles 
ORDER BY Id_Roll;
 end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.CargarTipoDoc
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargarTipoDoc`()
begin
Select 0 AS IdTipoDoc, 'Seleccione...' AS Nombre, 'SL' AS Siglas
UNION
SELECT IdTipoDoc, Nombre, Siglas FROM TipoDocumento 
ORDER BY IdTipoDoc;
end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.EliminarUsuarios
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarUsuarios`(
	IN `P_TipoDoc` int,
	IN `P_Documento` varchar (15)     
    


)
begin  
	if not exists (select * from Persona where IdTipoDoc = P_TipoDoc and Documento = P_Documento) then             
	
		select 'El Usuario no se encuentra' as Mensaje,Persona.* from Persona where IdTipoDoc = P_TipoDoc and Documento = P_Documento;

	else
		delete from Permisos_Usuarios where Usuario = (select Usuario from Usuario where Id_Persona = (SELECT Id_Persona FROM Persona WHERE P_TipoDoc and Documento= P_Documento));
		delete from Usuario where Id_Persona = (SELECT Id_Persona FROM Persona WHERE P_TipoDoc and Documento= P_Documento);
		delete from Persona where IdTipoDoc = P_TipoDoc and Documento= P_Documento;
	    select 'Usuario Eliminado' as Mensaje ;
   end if;
end//
DELIMITER ;

-- Volcando estructura para tabla foodscrap.gastos
CREATE TABLE IF NOT EXISTS `gastos` (
  `Id_Gasto` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Sucursal` int(11) DEFAULT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`Id_Gasto`),
  KEY `Id_Sucursal` (`Id_Sucursal`),
  CONSTRAINT `gastos_ibfk_1` FOREIGN KEY (`Id_Sucursal`) REFERENCES `sucursales` (`Id_Sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.gastos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;

-- Volcando estructura para procedimiento foodscrap.GuardarPermisoUsuario
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `GuardarPermisoUsuario`(P_Habilitado varchar(1),P_IdPermiso int,P_Usuario varchar(50))
begin  
	if (P_Habilitado = "S") then
		DELETE FROM Permisos_Usuarios WHERE Id_Permiso = P_IdPermiso AND Usuario = P_Usuario;
		INSERT IGNORE INTO Permisos_Usuarios values(P_IdPermiso,P_Usuario);
	else 
		DELETE FROM Permisos_Usuarios WHERE Id_Permiso = P_IdPermiso AND Usuario = P_Usuario;
	end if;
	SELECT 'Permiso Actualizado Exitosamente' as Mensaje;
end//
DELIMITER ;

-- Volcando estructura para procedimiento foodscrap.GuardarUsuarios
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `GuardarUsuarios`(

	 P_TipoDoc int,
	 P_Documento varchar (15),    
    P_Nombre varchar (30),
    P_Apellido varchar (30),
    P_Telefono varchar (20),
    P_Direccion varchar (30),
    P_FechaNacimiento date,
    P_Correo varchar (40),
    P_Roll varchar (30),
	 P_Usuario varchar (20),
	 P_Contraseña varchar (20),
    P_Pregunta int,
    P_Respuesta varchar (50)
    )
begin  
	DECLARE IdPersonaInsert INT UNSIGNED DEFAULT 0;
	if not exists (select Id_Persona from PERSONA where Documento = P_Documento) then 
		
		 INSERT IGNORE INTO PERSONA (IdTipoDoc,Documento,Nombre,Apellidos,FechaNacimiento,Telefono,Direccion,Correo) 		 VALUES
		 (P_TipoDoc,P_Documento,P_Nombre,P_Apellido,P_FechaNacimiento,P_Telefono,P_Direccion,P_Correo);
		
		 SELECT Id_Persona INTO IdPersonaInsert FROM PERSONA WHERE DOCUMENTO = P_Documento;
		
		 INSERT IGNORE INTO USUARIO (Id_Persona,Usuario,Contraseña,Id_Pregunta,Respuesta,Id_Roll) VALUES
		 (IdPersonaInsert,P_Usuario,P_Contraseña,P_Pregunta,P_Respuesta,P_Roll);
		
		 SELECT 'Usuario ingresado correctamente';

	ELSE 
	    select 'El Usuario ya existe' as Mensaje,A.* from USUARIO A INNER JOIN PERSONA B ON A.Id_Persona = B.Id_Persona where B.IdTipoDoc = P_TipoDoc and B.Documento = P_Documento;
   end if;
end//
DELIMITER ;

-- Volcando estructura para tabla foodscrap.liquidacion
CREATE TABLE IF NOT EXISTS `liquidacion` (
  `Id_Liquidacion` int(11) NOT NULL AUTO_INCREMENT,
  `NFactura` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Cant_Gastos` int(11) NOT NULL,
  `valor_Gastos` int(11) NOT NULL,
  `Cant_Bebidas` int(11) NOT NULL,
  `valor_Bebidas` int(11) NOT NULL,
  `Cant_Fritos` int(11) NOT NULL,
  `valor_Fritos` int(11) NOT NULL,
  `Cant_Plancha` int(11) NOT NULL,
  `valor_Plancha` int(11) NOT NULL,
  `Base` double NOT NULL,
  PRIMARY KEY (`Id_Liquidacion`),
  UNIQUE KEY `NFactura` (`NFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.liquidacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `liquidacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `liquidacion` ENABLE KEYS */;

-- Volcando estructura para procedimiento foodscrap.ModificarUsuarios
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarUsuarios`(
	IN `P_TipoDoc` int,
	IN `P_Documento` varchar (15),
	IN `P_Nombre` varchar (30),
	IN `P_Apellido` varchar (30),
	IN `P_Telefono` varchar (20),
	IN `P_Direccion` varchar (30),
	IN `P_Fecha` date,
	IN `P_Correo` varchar (40),
	IN `P_Roll` varchar (30),
	IN `P_Usuario` varchar (20),
	IN `P_Contraseña` varchar (20),
	IN `P_Pregunta` INT,
	IN `P_Respuesta` varchar (50)
    


)
begin  
	if not exists (select * from Persona where IdTipoDoc = P_TipoDoc and Documento = P_Documento) then             
	
		select 'El usuario no Existe' as Mensaje,A.* from Persona A where A.IdTipoDoc = P_TipoDoc and Documento = P_Documento;

	else 
		Update Persona SET Nombre = P_Nombre,Apellidos = P_Apellido,Telefono = P_Telefono,
		Direccion = P_Direccion,FechaNacimiento = P_Fecha,Correo = P_Correo where IdTipoDoc = P_TipoDoc && Documento = P_Documento;
		Update Usuario SET Id_Roll = (select Id_Roll from Roles where Nombre=P_Roll), Usuario = P_Usuario,Contraseña = P_Contraseña,Id_Pregunta = P_Pregunta,Respuesta = P_Respuesta where Id_Persona = (Select Id_Persona from Persona where IdTipoDoc = P_TipoDoc and Documento = P_Documento);
    
	    select 'Información del Usuario Actualizada' as Mensaje,A.*,B.* from usuario A inner join Persona B on A.Id_Persona = B.Id_Persona where B.IdTipoDoc = P_TipoDoc and B.Documento = P_Documento;
   end if;
end//
DELIMITER ;

-- Volcando estructura para tabla foodscrap.permisos
CREATE TABLE IF NOT EXISTS `permisos` (
  `Id_Permiso` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo_Permiso` varchar(50) DEFAULT NULL,
  `Nombre_Permiso` varchar(50) DEFAULT NULL,
  `Id_Roll` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Permiso`),
  KEY `Id_Roll` (`Id_Roll`),
  CONSTRAINT `permisos_ibfk_1` FOREIGN KEY (`Id_Roll`) REFERENCES `roles` (`Id_Roll`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.permisos: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` (`Id_Permiso`, `Codigo_Permiso`, `Nombre_Permiso`, `Id_Roll`) VALUES
	(1, 'Usuarios', 'Guardar', 1),
	(2, 'Usuarios', 'Eliminar', 1),
	(3, 'Productos', 'Guardar', 1);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.permisos_usuarios
CREATE TABLE IF NOT EXISTS `permisos_usuarios` (
  `Id_Permiso` int(11) DEFAULT NULL,
  `Usuario` varchar(30) DEFAULT NULL,
  KEY `Usuario` (`Usuario`),
  KEY `Id_Permiso` (`Id_Permiso`),
  CONSTRAINT `permisos_usuarios_ibfk_1` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`Usuario`),
  CONSTRAINT `permisos_usuarios_ibfk_2` FOREIGN KEY (`Id_Permiso`) REFERENCES `permisos` (`Id_Permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.permisos_usuarios: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `permisos_usuarios` DISABLE KEYS */;
INSERT INTO `permisos_usuarios` (`Id_Permiso`, `Usuario`) VALUES
	(1, 'Jepetto308');
/*!40000 ALTER TABLE `permisos_usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `Id_Persona` int(11) NOT NULL AUTO_INCREMENT,
  `IdTipoDoc` int(11) DEFAULT NULL,
  `Documento` varchar(20) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Direccion` varchar(30) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Id_Persona`),
  UNIQUE KEY `Documento` (`Documento`),
  KEY `IdTipoDoc` (`IdTipoDoc`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`IdTipoDoc`) REFERENCES `tipodocumento` (`IdTipoDoc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.persona: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`Id_Persona`, `IdTipoDoc`, `Documento`, `Nombre`, `Apellidos`, `FechaNacimiento`, `Telefono`, `Direccion`, `Correo`) VALUES
	(2, 1, '1152706883', 'Jefferson', 'Palacios Torres', '1997-01-01', '5054912', 'Calle 112 # 77 D - 01', 'jefferson308@hotmail.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.preguntasecreta
CREATE TABLE IF NOT EXISTS `preguntasecreta` (
  `Id_Pregunta` int(11) NOT NULL AUTO_INCREMENT,
  `Pregunta` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Pregunta`),
  UNIQUE KEY `Pregunta` (`Pregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.preguntasecreta: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `preguntasecreta` DISABLE KEYS */;
INSERT INTO `preguntasecreta` (`Id_Pregunta`, `Pregunta`) VALUES
	(1, '¿ Como te llamas ?');
/*!40000 ALTER TABLE `preguntasecreta` ENABLE KEYS */;

-- Volcando estructura para procedimiento foodscrap.RecuperacionContra
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `RecuperacionContra`(
P_TipoDoc int,
P_Documento varchar (15),
P_Usuario varchar (20),
P_Pregunta int,
P_Respuesta varchar (50),
P_Nueva varchar (10)
)
begin
	if not exists (select * from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento and Usuario = P_Usuario and Pregunta = P_Pregunta and Respuesta = P_Respuesta) then   

           select 'Datos Incorrectos' as Mensaje;
        else 			
	       Update Usuarios SET Contrasena = P_Nueva Where Documento = P_Documento;
           select Contrasena as Mensaje,usuarios. * from usuarios where Documento = P_Documento;
   end if;
 end//
DELIMITER ;

-- Volcando estructura para tabla foodscrap.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `Id_Roll` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Siglas` varchar(5) NOT NULL,
  PRIMARY KEY (`Id_Roll`),
  UNIQUE KEY `Nombre` (`Nombre`),
  UNIQUE KEY `Siglas` (`Siglas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.roles: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`Id_Roll`, `Nombre`, `Siglas`) VALUES
	(1, 'Root', 'ROOT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.sucursales
CREATE TABLE IF NOT EXISTS `sucursales` (
  `Id_Sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Direccion` varchar(30) NOT NULL,
  `Zona` varchar(30) NOT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_Sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.sucursales: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.tipodocumento
CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `IdTipoDoc` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Siglas` varchar(5) NOT NULL,
  PRIMARY KEY (`IdTipoDoc`),
  UNIQUE KEY `Nombre` (`Nombre`),
  UNIQUE KEY `Siglas` (`Siglas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.tipodocumento: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` (`IdTipoDoc`, `Nombre`, `Siglas`) VALUES
	(1, 'Cedula', 'CC');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;

-- Volcando estructura para tabla foodscrap.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Persona` int(11) DEFAULT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Contraseña` varchar(30) NOT NULL,
  `Id_Pregunta` int(11) DEFAULT NULL,
  `Respuesta` varchar(40) NOT NULL,
  `Id_Roll` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Usuario`),
  UNIQUE KEY `Usuario` (`Usuario`),
  KEY `Id_Persona` (`Id_Persona`),
  KEY `Id_Pregunta` (`Id_Pregunta`),
  KEY `Id_Roll` (`Id_Roll`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Id_Persona`) REFERENCES `persona` (`Id_Persona`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`Id_Pregunta`) REFERENCES `preguntasecreta` (`Id_Pregunta`),
  CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`Id_Roll`) REFERENCES `roles` (`Id_Roll`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla foodscrap.usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`Id_Usuario`, `Id_Persona`, `Usuario`, `Contraseña`, `Id_Pregunta`, `Respuesta`, `Id_Roll`) VALUES
	(2, 2, 'Jepetto308', '123456789', 1, 'Jeffersons', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
