/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Proveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class ProveedoresCAD extends ConexionDB{
    
    public static boolean guardar(Proveedores P){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL GuardarProveedor(?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, P.getCodigo());
            pst.setString(2, P.getNit());
            pst.setString(3, P.getRazonSocial());
            pst.setString(4, P.getNombre());
            pst.setString(5, P.getCorreo());
            pst.setString(6, P.getDireccion());
            pst.setString(7, P.getTelefono());
            pst.setString(8, P.getFax());    
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Proveedor Registrado".equalsIgnoreCase(resul)){
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
    
    public static boolean modificar(Proveedores Pm){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL ModificarProveedor(?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Pm.getCodigo());
            pst.setString(2, Pm.getNit());
            pst.setString(3, Pm.getRazonSocial());
            pst.setString(4, Pm.getNombre());
            pst.setString(5, Pm.getCorreo());
            pst.setString(6, Pm.getDireccion());
            pst.setString(7, Pm.getTelefono());
            pst.setString(8, Pm.getFax());
            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Información del Proveedor Actualizada".equalsIgnoreCase(resul)){
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
    
    public static boolean eliminar(Proveedores Pe){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL EliminarProveedor(?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Pe.getCodigo());          
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Proveedor Eliminado".equalsIgnoreCase(resul)){
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
