/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import static Model.ConexionDB.desconectar;
import static Model.ConexionDB.getConexion;
import Model.Productos;
import Model.Proveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class ProductosCAD {
    
    public static boolean guardar(Productos P){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL GuardarProducto(?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, P.getCodigo());
            pst.setString(2, P.getIdProveedor());
            pst.setString(3, P.getIdCategoria());
            pst.setString(4, P.getNombre());
            pst.setInt(5, P.getPrecioCosto());
            pst.setInt(6, P.getCantidad());
            pst.setString(7, P.getIdUMedida());
            pst.setInt(8, P.getStock());    
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Producto Registrado".equalsIgnoreCase(resul)){
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
    
    public static boolean modificar(Productos Pm){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL ModificarProducto(?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Pm.getCodigo());
            pst.setString(2, Pm.getIdProveedor());
            pst.setString(3, Pm.getIdCategoria());
            pst.setString(4, Pm.getNombre());
            pst.setInt(5, Pm.getPrecioCosto());
            pst.setInt(6, Pm.getCantidad());
            pst.setString(7, Pm.getIdUMedida());
            pst.setInt(8, Pm.getStock());  
            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Información del Producto Actualizada".equalsIgnoreCase(resul)){
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
    
    public static boolean eliminar(Productos Pe){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL EliminarProducto(?)";
            pst = getConexion().prepareStatement(Sql);           
            pst.setString(1, Pe.getCodigo());          
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Producto Eliminado".equalsIgnoreCase(resul)){
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
