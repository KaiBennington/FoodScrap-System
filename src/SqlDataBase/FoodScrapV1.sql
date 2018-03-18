-- Procedimiento Almacenado "Eliminar Tipo Documento" --
drop procedure if exists EliminarTDocumento;
DELIMITER $$
CREATE PROCEDURE EliminarTDocumento(

	P_TipoDoc int    
    )
begin  
	if not exists (select * from TipoDocumento where IdTipoDoc = P_IdTipoDoc) then             
	
		select 'El Tipo Documento no se encuentra' as Mensaje,TipoDocumento.* from TipoDocumento where IdTipoDoc = P_IdTipoDoc;

	else 
		delete from TipoDocumento where IdTipoDoc= P_IdTipoDoc ;
	    select 'Tipo Documento Eliminado con exito' as Mensaje ;
   end if;
end$$

-- Procedimiento Almacenado "Modificar Tipo Documento" --
drop procedure if exists ModificarTDocumento;
DELIMITER $$
CREATE PROCEDURE ModificarTDocumento(

	P_IdTipoDoc int ,
    P_Nombre varchar (30),
    P_Siglas varchar (5)      
    )
begin  
	if not exists (select * from TipoDocumento where IdTipoDoc = P_IdTipoDoc) then    
    
		select 'El Tipo Documento no existe' as Mensaje,TipoDocumento.* from TipoDocumento where IdTipoDoc = P_IdTipoDoc;
	else 
		update TipoDocumento set Nombre=(P_Nombre), Siglas=(P_Siglas)  where IdTipoDoc=(P_IdTipoDoc) ;
	    select 'Tipo Documento Actualizado con exito' as Mensaje,TipoDocumento.* from TipoDocumento where IdTipoDoc = P_IdTipoDoc;        
   end if;
end$$

-- Procedimiento Almacenado "Guardar Tipo Documento" --
drop procedure if exists InsertarTDocumento;
DELIMITER $$
CREATE PROCEDURE InsertarTDocumento(

	P_IdTipoDoc int ,
    P_Nombre varchar (30),
    P_Siglas varchar (5)      
    )
begin  
	if not exists (select * from TipoDocumento where IdTipoDoc = P_IdTipoDoc or Nombre = P_Nombre) then    
    
		insert into TipoDocumento (IdTipoDoc, Nombre, Siglas) values (P_IdTipoDoc, P_Nombre, P_Siglas);
		select 'Tipo Documento registrado con exito' as Mensaje,TipoDocumento.* from TipoDocumento where IdTipoDoc = P_IdTipoDoc;

	else 
	    select 'El Tipo Documento ya existe' as Mensaje,TipoDocumento.* from TipoDocumento where IdTipoDoc = P_IdTipoDoc or Nombre = P_Nombre;
   end if;
end$$

-- Procedimiento almacenado de lista Zonas --
DELIMITER $$
Create Procedure listaZonas(
)
begin
Select 0 AS IdZona, 'Seleccione...' AS Nombre, 0 AS Comuna
UNION
SELECT IdZona, Nombre, Comuna FROM Zonas 
ORDER BY IdZona ;
end$$

-- Procedimiento Almacenado "Eliminar Usuarios" --
drop procedure if exists EliminarUsuarios;
DELIMITER $$
CREATE PROCEDURE EliminarUsuarios(

	P_TipoDoc int,
	P_Documento varchar (15)     
    )
begin  
	if not exists (select * from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento) then             
	
		select 'El Usuario no se encuentra' as Mensaje,usuarios.* from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento;

	else 
		delete from Usuarios where TipoDoc = P_TipoDoc and Documento= P_Documento ;
	    select 'Usuario Eliminado' as Mensaje ;
   end if;
end$$

-- Procedimiento Almacenado "Modificar Usuarios" --
drop procedure if exists ModificarUsuarios;
DELIMITER $$
CREATE PROCEDURE ModificarUsuarios(

	P_TipoDoc int,
	P_Documento varchar (15),    
    P_Nombre varchar (30),
    P_Apellido varchar (30),
    P_Telefono varchar (20),
    P_Direccion varchar (30),
    P_Fecha date,
    P_Correo varchar (40),
    P_Roll varchar (30),
	P_Usuario varchar (20),
	P_Contraseña varchar (20),
    P_Pregunta int,
    P_Respuesta varchar (50)
    )
begin  
	if not exists (select * from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento) then             
	
		select 'El usuario no Existe' as Mensaje,usuarios.* from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento;

	else 
		Update Usuarios SET Nombre = P_Nombre,Apellido = P_Apellido,Telefono = P_Telefono,
		Direccion = P_Direccion,FechaNacimiento = P_Fecha,Email = P_Correo,Roll = (select IdRol from Roles where Nombre=P_Roll),
		Usuario = P_Usuario,Contrasena = P_Contraseña,Pregunta = P_Pregunta,Respuesta = P_Respuesta where TipoDoc = P_TipoDoc && Documento = P_Documento;
    
	    select 'Información del Usuario Actualizada' as Mensaje,usuarios.* from usuarios where TipoDoc = P_TipoDoc and Documento = P_Documento;
   end if;
end$$

-- Procedimiento Almacenado "Guardar Usuarios" --
drop procedure if exists GuardarUsuarios;
DELIMITER $$
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
end$$
DELIMITER ;

-- Procedimiento Almacenado "Verificacion Login" --
DELIMITER $$
CREATE PROCEDURE AccesoLogin(
u varchar (20),
c varchar(20))
begin
	if not exists (select * from usuarios where Usuario = u and Contrasena = c) then   

           select 'Usuario No Existe' as Mensaje;
        else 
	       select 'Existe' as Mensaje,usuarios.* from usuarios where Usuario=u and Contrasena=c;
   end if;
 end$$
 
 -- Procedimiento Almacenado " Recuperacion de Contraseña"
 DELIMITER $$
CREATE PROCEDURE RecuperacionContra(
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
 end$$
	

call RecuperacionContra(1,'1040182002','kai',1,'uno');

-- Procedimiento almacenado de TipoDocumento --
drop procedure if exists CargarTipoDoc;
DELIMITER $$
Create Procedure CargarTipoDoc(
)
begin
Select 0 AS IdTipo, 'Seleccione...' AS Nombre, 'SL' AS Siglas
UNION
SELECT IdTipo, Nombre, Siglas FROM TipoDocumento 
ORDER BY IdTipo;
end$$

-- Procedimiento almacenado de PreguntaSecreta --
DELIMITER $$
Create Procedure CargarPregunta(
)
begin
Select 0 AS IdPregunta, 'Seleccione...' AS Pregunta
UNION
SELECT IdPregunta, Pregunta FROM PreguntaSecreta 
ORDER BY IdPregunta ;
end$$

-- Procedimiento almacenado de CargarRoles --
DELIMITER $$
Create Procedure CargarRoles(
)
begin
Select 0 AS IdRol, 'Seleccione...' AS Nombre, 'SL' AS Siglas
UNION
SELECT IdRol, Nombre, Siglas FROM Roles 
ORDER BY IdRol;
 end$$
 
 
 -- Procedimiento almacenado de CargarRoles --
DELIMITER $$
Create Procedure CambiarContra(
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
 end$$
 
 -- Procedimiento almacenado de Cargar Sucursal --
drop procedure if exists CargarSucursal;
DELIMITER $$
Create Procedure CargarSucursal(
)
begin
Select 0 AS Id_Sucursal, 'Seleccione...' AS Nombre, 0 AS IdZona
UNION
SELECT Id_Sucursal, Nombre, IdZona FROM Sucursales 
ORDER BY Id_Sucursal;
end$$