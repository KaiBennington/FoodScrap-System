/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD; 

import Config.Bandera;
import Model.ConexionDB;
import Model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class UsuariosCAD extends ConexionDB{ 
    
    public static boolean guardar(Usuarios U){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL GuardarUsuarios(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, U.getTipoDocumento());
            pst.setString(2, U.getDocumento());
            pst.setString(3, U.getNombres());
            pst.setString(4, U.getApellidos());
            pst.setString(5, U.getTelefono());
            pst.setString(6, U.getDireccion());
            pst.setString(7, U.getFechaNacimiento());
            pst.setString(8, U.getEmail());
            pst.setString(9, U.getRoll());
            pst.setString(10, U.getUsuario());
            pst.setString(11, U.getContrasena());
            pst.setInt(12, U.getPregunta());
            pst.setString(13, U.getRespuesta());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Usuario Registrado".equalsIgnoreCase(resul)){
               Bandera.setRespuesta(resul);
               respuesta = true;
            }else{
               Bandera.setRespuesta(resul);
               respuesta = false;
            }
        } catch (SQLException e){ 
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }              
    }//FIN Metodo Guardar
    
    public static boolean modificar(Usuarios Um){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL ModificarUsuarios(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setInt(1, Um.getTipoDocumento());
            pst.setString(2, Um.getDocumento());
            pst.setString(3, Um.getNombres());
            pst.setString(4, Um.getApellidos());
            pst.setString(5, Um.getTelefono());
            pst.setString(6, Um.getDireccion());
            pst.setString(7, Um.getFechaNacimiento());
            pst.setString(8, Um.getEmail());
            pst.setString(9, Um.getRoll());
            pst.setString(10, Um.getUsuario());
            pst.setString(11, Um.getContrasena());
            pst.setInt(12, Um.getPregunta());
            pst.setString(13, Um.getRespuesta());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Información del Usuario Actualizada".equalsIgnoreCase(resul)){
               Bandera.setRespuesta(resul);
               respuesta = true;
            }else{
               Bandera.setRespuesta(resul);
               respuesta = false;
            }
        } catch (SQLException e){ 
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }      
    }//Fin Metodo Modificar
    
    public static boolean eliminar(Usuarios Ue){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL EliminarUsuarios(?,?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setInt(1, Ue.getTipoDocumento());
            pst.setString(2, Ue .getDocumento());            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Usuario Eliminado".equalsIgnoreCase(resul)){
               Bandera.setRespuesta(resul);
               respuesta = true;
            }else{
               Bandera.setRespuesta(resul);
               respuesta = false;
            }
        } catch (SQLException e){ 
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }      
    }//Fin Metodo Eliminar
    
    public static boolean acceder(Usuarios u){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;        
        
        try {
            String Sql = "CALL AccesoLogin(?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getContrasena());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");
            }
            
            if("existe".equalsIgnoreCase(resul)){
                respuesta = true;
                Bandera.setNombre(rs.getString("Nombre"));
                Bandera.setApellido(rs.getString("Apellido")); 
                Bandera.setUsuario(rs.getString("Usuario"));
                Bandera.setRol(rs.getString("Roll"));
                //CargarRoll(Bandera.getRol());
                //Bandera.setRespuesta(respuesta);
            }
        } catch (SQLException e) {
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }
    }// FIN metodo Acceder
    
    public static boolean CargarRoll(String N){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;        
        
        try {
            String Sql = "CALL CargarRoles("+ N +")";
            pst = getConexion().prepareStatement(Sql);
//            pst.setString(1, .getRoll());            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");
                Bandera.setNombreRol(rs.getString("Nombre"));
                Bandera.setSiglasRol(rs.getString("Siglas"));                 
            }
            
            if("existe".equalsIgnoreCase(resul)){
                respuesta = true;
                //Bandera.setRespuesta(respuesta);
            }else{ 
                respuesta = false;
                //Bandera.setRespuesta(respuesta);
            }
        } catch (SQLException e) {
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }
    }//FIN Cargar Roll
    
    public static boolean recuperar(Usuarios u){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;        
        
        try {
            String Sql = "CALL RecuperacionContra(?,?,?,?,?,?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, u.getTipoDocumento());
            pst.setString(2, u.getDocumento());
            pst.setString(3, u.getUsuario());
            pst.setInt(4, u.getPregunta());
            pst.setString(5, u.getRespuesta());
            pst.setString(6, u.getNuevaContra());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");
                Bandera.setRespuesta(resul);                
            }
            
            if(!"".equals(resul)){
               Bandera.setRespuesta(resul);
               respuesta = true;
            }
        } catch (SQLException e){ 
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }
    }// FIN Recuperar Contraseña
    
    public static boolean cambiarContrasena(Usuarios u){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;        
        
        try {
            String Sql = "CALL CambiarContra(?,?,?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getContrasena());
            pst.setString(3, u.getNuevaContra());            
            rs = pst.executeQuery();
            
            if (rs.next()) { 
                Bandera.setRespuesta(rs.getString("Mensaje"));                
            }
            
            if(!"El usuario no Existe".equals(Bandera.getRespuesta())){
               respuesta = true;
            }
        } catch (SQLException e){ 
            System.err.println("Error "+e);
        }
        finally{
            desconectar();
            return respuesta;
        }
    }// FIN Cambiar Contraseña
}
