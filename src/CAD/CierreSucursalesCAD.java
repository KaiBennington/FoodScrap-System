/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.CierreSucursal;
import Model.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class CierreSucursalesCAD extends ConexionDB{
    
    public static boolean guardar(CierreSucursal Cs){
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false; 
        
        try {
            String Sql = "CALL GuardarCierreSucursal(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Cs.getNumFactura());
            pst.setString(2, Cs.getFechaFactura());
            pst.setString(3, Cs.getSucursal());
            pst.setDouble(4, Cs.getP_Sale());
            pst.setDouble(5, Cs.getP_Devuelve());            
            pst.setDouble(6, Cs.getBaseInicial());            
            pst.setDouble(7, Cs.getAlcancia());            
            pst.setDouble(8, Cs.getNetoExistente());            
            pst.setDouble(9, Cs.getTotalNeto());            
            pst.setDouble(10, Cs.getTotalBruto());            
            pst.setDouble(11, Cs.getResta());            
            rs = pst.executeQuery();
            
            String resul = "";
            if (rs.next()) {                
                resul = rs.getString("Mensaje");         
            }
            
            if("Cierre Sucursal Registrado".equalsIgnoreCase(resul)){
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
}
