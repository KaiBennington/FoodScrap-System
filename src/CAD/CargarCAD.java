/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import static Model.ConexionDB.getConexion;
import Model.PreguntaSecreta;
import Model.Roles;
import Model.TipoDocumento;
import Model.Zonas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class CargarCAD extends ConexionDB {
    
    //<editor-fold desc="CARGAR TIPO DOCUMENTO" defaultstate="collapsed">
    public ArrayList CargarTipoDoc(){
        //Combo Tipo Documento
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            
            String Sql = "CALL CargarTipoDoc();";
            pst = getConexion().prepareStatement(Sql);            
            rs = pst.executeQuery();
            
            while (rs.next()) {   
                String Nombre,Siglas;
                int Codigo;
                Codigo = (rs.getInt(1));                
                Nombre = (rs.getString(2));                
                Siglas = (rs.getString(3));
                
            TipoDocumento Tp = new TipoDocumento(""+Codigo,Nombre,Siglas);            
            Lista.add(Tp);
               // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Tipo documento
    //</editor-fold>
    
    //<editor-fold desc="CARGAR ZONAS" defaultstate="collapsed">
    public ArrayList CargarZona(){
        //Combo Zonas
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            
            String Sql = "CALL CargarZonas();";
            pst = getConexion().prepareStatement(Sql);            
            rs = pst.executeQuery();
            
            while (rs.next()) {   
                String Nombre,Comuna;
                int Codigo;
                Codigo = (rs.getInt(1));                
                Nombre = (rs.getString(2));                
                Comuna = (rs.getString(3));
                
            Zonas Zn = new Zonas(""+Codigo,Nombre,Comuna);            
            Lista.add(Zn);
               // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Zonas
    //</editor-fold>
    
    //<editor-fold desc="CARGAR PREGUNTA SEGURIDAD" defaultstate="collapsed"> 
    public ArrayList CargarPregunta(){
        //Combo Pregunta Seguridad
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            
            String Sql = "CALL CargarPregunta();";
            pst = getConexion().prepareStatement(Sql);            
            rs = pst.executeQuery();
            
            while (rs.next()) {   
                String Nombre;
                int Codigo;
                Codigo = (rs.getInt(1));                
                Nombre = (rs.getString(2));
                
            PreguntaSecreta Ps = new PreguntaSecreta(""+Codigo,Nombre);            
            Lista.add(Ps);
             //   System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Pregunta Secreta
    //</editor-fold>
    
    //<editor-fold desc="CARGAR ROLES" defaultstate="collapsed"> 
    public ArrayList CargarRoles(){
        //Combo Clase Roll
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            
            String Sql = "CALL CargarRoles();";
            pst = getConexion().prepareStatement(Sql);            
            rs = pst.executeQuery();
            
            while (rs.next()) {   
                String Nombre,Siglas;
                int Codigo;
                Codigo = (rs.getInt(1));                
                Nombre = (rs.getString(2));                
                Siglas = (rs.getString(3));
                
            Roles Rl = new Roles(""+Codigo,Nombre,Siglas);            
            Lista.add(Rl);
              //  System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Roles
    //</editor-fold>   
    
    //<editor-fold desc="CARGAR ID SUCURSALES" defaultstate="collapsed">
    public String cargarId(){
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "" ;        
        try {
            String Sql = "select COALESCE(MAX(Id_Sucursal), 0)+1 FROM Sucursales;";
            pst = getConexion().prepareStatement(Sql);            
            rs = pst.executeQuery();
            
            while (rs.next()) {                 
                CI = rs.getString(1);
            }
            
        } catch (SQLException ex) {            
        }
        desconectar();
        return CI;
    }
    //</editor-fold>
}
