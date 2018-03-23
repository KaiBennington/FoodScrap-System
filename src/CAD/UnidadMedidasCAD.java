/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.UnidadMedidas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class UnidadMedidasCAD extends ConexionDB {
    
    //<editor-fold desc="GUARDAR UNIDAD MEDIDA" defaultstate="collapsed">
    public static boolean guardar(UnidadMedidas UMg){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL InsertarUndMedida(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, UMg.getCodigo());
            pst.setString(2, UMg.getNombre());
            pst.setString(3, UMg.getSiglas());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Unidad de Medida registrada con exito".equalsIgnoreCase(resul)){
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
    
    //<editor-fold desc="MODIFICAR UNIDAD MEDIDA" defaultstate="collapsed">
    public static boolean modificar(UnidadMedidas UMm){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL ModificarUndMedida(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, UMm.getCodigo());
            pst.setString(2, UMm.getNombre());
            pst.setString(3, UMm.getSiglas());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Unidad de Medida Actualizada con exito".equalsIgnoreCase(resul)){
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
    
    //<editor-fold desc="ELIMINAR UNIDAD MEDIDAS" defaultstate="collapsed">
    public static boolean eliminar(UnidadMedidas UMe){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL EliminarUndMedida(?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, UMe.getCodigo());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Unidad de Medida Eliminada con exito".equalsIgnoreCase(resul)){
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
