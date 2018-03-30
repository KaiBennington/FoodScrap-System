/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Permisos;
import Model.Roles;
import Model.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class RolesCAD extends ConexionDB {
    
    //<editor-fold desc="GUARDAR ROLES" defaultstate="collapsed">
    public static boolean guardar(Roles Rl,Map permisos){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL InsertarRoll(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Rl.getIdRol());
            pst.setString(2, Rl.getNombre());
            pst.setString(3, Rl.getSiglas());
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Rol registrado con exito".equalsIgnoreCase(resul)){
                Bandera.setRespuesta(resul);
                
                // Recuperamos las opciones relacionadas a los modulos seleccionados 
                Iterator entries = permisos.entrySet().iterator();
                String SqlPermisos = "SELECT Codigo_Permiso,Nombre_Permiso FROM PERMISOS WHERE CODIGO_PERMISO = ?";
                
                while (entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) entries.next();
                    pst = getConexion().prepareStatement(SqlPermisos);
                    pst.setString(1, entry.getKey().toString());
                    rs = pst.executeQuery();         
                    while(rs.next()){
                        // Insertamos dichas opciones recuperadas relacionadas al rol
                        String sqlInserPermiso = "INSERT IGNORE INTO PERMISOS (CODIGO_PERMISO,NOMBRE_PERMISO,ID_ROLL) VALUES (?,?,?)";
                        pst = getConexion().prepareStatement(sqlInserPermiso);
                        
                        pst.setString(1, rs.getString("Codigo_Permiso"));
                        pst.setString(2, rs.getString("Nombre_Permiso"));
                        pst.setInt(3, Rl.getIdRol());
                        
                        pst.executeUpdate();    
                    }
                    rs.close(); 
                }
               
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
    
    //<editor-fold desc="MODIFICAR ROLES" defaultstate="collapsed">
    public static boolean modificar(Roles Rl){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL ModificarRoles(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Rl.getIdRol());
            pst.setString(2, Rl.getNombre());
            pst.setString(3, Rl.getSiglas());
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
    public static boolean eliminar(Roles Rl){
        
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        
        try {
            String Sql = "CALL EliminarRoles(?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Rl.getIdRol());
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
