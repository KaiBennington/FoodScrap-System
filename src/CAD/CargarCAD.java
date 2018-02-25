/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Model.ConexionDB;
import static Model.ConexionDB.getConexion;
import Model.PreguntaSecreta;
import Model.TipoDocumento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class CargarCAD extends ConexionDB {
    
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
                System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Tipo documento
    
    public ArrayList CargarPregunta(){
        //Combo Tipo Documento
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
                System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {            
        } 
        return Lista;
    }// FIN Metodo Cargar Tipo documento
    
    
}
