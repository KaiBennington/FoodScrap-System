/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.PlatosVendidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PlatosVendidosCAD extends ConexionDB{
    
    public static boolean guardar(ArrayList L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL GuardarPlatosVendidos(?,?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.size(); i++) {
                PlatosVendidos oPlatosVend = (PlatosVendidos) L.get(i);
                pst.setString(1, oPlatosVend.getCodigoPlato());
                pst.setInt(2, oPlatosVend.getNum_Factura());
                pst.setString(3, oPlatosVend.getCantidad());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("P. Vendidos Registrados".equalsIgnoreCase(resul)) {
                Bandera.setSubRespuesta(resul);
                respuesta = true;
            } else {
                Bandera.setSubRespuesta(resul);
                respuesta = false;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//FIN Metodo Guardar

    public static boolean modificar(ArrayList L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL ModificarPlatosVendidos(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            
            for (int i = 0; i < L.size(); i++) {
                PlatosVendidos oPlatosVend = (PlatosVendidos) L.get(i);
                pst.setString(1, oPlatosVend.getCodigoPlato());
                pst.setInt(2, oPlatosVend.getNum_Factura());
                pst.setString(3, oPlatosVend.getCantidad());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Información de P. Vendidos Actualizada".equalsIgnoreCase(resul)) {
                Bandera.setSubRespuesta(resul);
                respuesta = true;
            } else {
                Bandera.setSubRespuesta(resul);
                respuesta = false;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//Fin Metodo Modificar

    public static boolean eliminar(List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL EliminarPlatosVendidos(?,?)";
            pst = getConexion().prepareStatement(Sql);
            
            for (int i = 0; i < L.size(); i++) {
                PlatosVendidos oPlatosVend = (PlatosVendidos) L.get(i);
                pst.setString(1, oPlatosVend.getCodigoPlato());
                pst.setInt(2, oPlatosVend.getNum_Factura());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("P. Vendidos Eliminados".equalsIgnoreCase(resul)) {
                Bandera.setSubRespuesta(resul);
                respuesta = true;
            } else {
                Bandera.setSubRespuesta(resul);
                respuesta = false;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//Fin Metodo Eliminar
}
