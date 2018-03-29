/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Roles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class RolesCAD extends ConexionDB {
    
    //<editor-fold desc="GUARDAR TIPO DOCUMENTO" defaultstate="collapsed">
    public static boolean guardar(Roles Rg){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL InsertarRoll(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Rg.getCodigo());
            pst.setString(2, Rg.getNombre());
            pst.setString(3, Rg.getSiglas());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Roll registrado con exito".equalsIgnoreCase(resul)){
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
    
    //<editor-fold desc="MODIFICAR TIPO DOCUMENTO" defaultstate="collapsed">
    public static boolean modificar(TipoDocumento TDm){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL ModificarTDocumento(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, TDm.getCodigo());
            pst.setString(2, TDm.getNombre());
            pst.setString(3, TDm.getSiglas());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Tipo Documento Actualizado con exito".equalsIgnoreCase(resul)){
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
    
    //<editor-fold desc="ELIMINAR TIPO DOCUMENTO" defaultstate="collapsed">
    public static boolean eliminar(TipoDocumento TDe){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL EliminarTDocumento(?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, TDe.getCodigo());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Tipo Documento Eliminado con exito".equalsIgnoreCase(resul)){
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
