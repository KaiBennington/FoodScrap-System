/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.Categorias;
import Model.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class CategoriasCAD extends ConexionDB{
    
    //<editor-fold desc="GUARDAR CATEGORIAS" defaultstate="collapsed">
    public static boolean guardar(Categorias CTg){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL InsertarCategoria(?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, CTg.getCodigo());
            pst.setString(2, CTg.getNombre());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Categoria registrada con exito".equalsIgnoreCase(resul)){
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
    //</editor-fold>
    
    //<editor-fold desc="MODIFICAR CATEGORIAS" defaultstate="collapsed">
    public static boolean modificar(Categorias CTm){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL ModificarCategoria(?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, CTm.getCodigo());
            pst.setString(2, CTm.getNombre());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Categoria Actualizada con exito".equalsIgnoreCase(resul)){
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
    //</editor-fold>
    
    //<editor-fold desc="ELIMINAR CATEGORIAS" defaultstate="collapsed">
    public static boolean eliminar(Categorias CTe){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL EliminarCategoria(?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, CTe.getCodigo());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Categoria Eliminada con exito".equalsIgnoreCase(resul)){
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
    }// Fin Metodo Eliminar
    //</editor-fold>
}
