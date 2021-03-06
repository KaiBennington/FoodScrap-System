/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Sucursales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class SucursalesCAD extends ConexionDB{
    
    public static boolean guardar(Sucursales S){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL GuardarSucursal(?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, S.getCodigo());
            pst.setString(2, S.getNombre());
            pst.setString(3, S.getDireccion());
            pst.setInt(4, S.getZona());
            pst.setString(5, S.getTelefono());            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Sucursal Registrada".equalsIgnoreCase(resul)){
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
    
    public static boolean modificar(Sucursales Sm){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL ModificarSucursales(?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Sm.getCodigo());
            pst.setString(2, Sm.getNombre());
            pst.setString(3, Sm.getTelefono());
            pst.setString(4, Sm.getDireccion());
            pst.setInt(5, Sm.getZona());
            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Información de la Sucursal Actualizada".equalsIgnoreCase(resul)){
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
    
    public static boolean eliminar(Sucursales Se){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL EliminarSucursales(?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Se.getCodigo());          
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Sucursal Eliminada".equalsIgnoreCase(resul)){
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
    
}
