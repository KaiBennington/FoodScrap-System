/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Gastos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class GastosCAD extends ConexionDB {

    public static boolean guardar(List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL GuardarGastos(?,?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.size(); i++) {
                Gastos oGastos = (Gastos) L.get(i);
                pst.setInt(1, oGastos.getIdFactura());
                pst.setString(2, oGastos.getDescripcion());
                pst.setDouble(3, oGastos.getValor());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Gastos Registrados".equalsIgnoreCase(resul)) {
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

    public static boolean modificar(List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL ModificarGastos(?,?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.size(); i++) {
                Gastos oGastos = (Gastos) L.get(i);
                pst.setInt(1, oGastos.getIdFactura());
                pst.setString(2, oGastos.getDescripcion());
                pst.setDouble(3, oGastos.getValor());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Información de Gastos Actualizada".equalsIgnoreCase(resul)) {
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
            String Sql = "CALL EliminarGastos(?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.size(); i++) {
                Gastos oGastos = (Gastos) L.get(i);
                pst.setInt(1, oGastos.getIdFactura());
                pst.setString(2, oGastos.getDescripcion());
                rs = pst.executeQuery();
            }
            
            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Gasto Eliminado".equalsIgnoreCase(resul)) {
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
