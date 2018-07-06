/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Ingredientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class IngredientesCAD extends ConexionDB {

    public static boolean guardar(List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL GuardarIngredientes(?,?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.size(); i++) {
                Ingredientes oIngrediente = (Ingredientes) L.get(i);
                pst.setString(1, oIngrediente.getIdPlato());
                pst.setString(2, oIngrediente.getIngrediente());
                pst.setString(3, oIngrediente.getCantidad());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Ingredientes Registrados".equalsIgnoreCase(resul)) {
                Bandera.setRespuestaIngredientes(resul);
                respuesta = true;
            } else {
                Bandera.setRespuestaIngredientes(resul);
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
            String Sql = "CALL ModificarIngredientes(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            
            for (int i = 0; i < L.size(); i++) {
                Ingredientes oIngrediente = (Ingredientes) L.get(i);
                pst.setString(1, oIngrediente.getIdPlato());
                pst.setString(2, oIngrediente.getIngrediente());
                pst.setString(3, oIngrediente.getCantidad());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Información de Ingredientes Actualizada".equalsIgnoreCase(resul)) {
                Bandera.setRespuestaIngredientes(resul);
                respuesta = true;
            } else {
                Bandera.setRespuestaIngredientes(resul);
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
            String Sql = "CALL EliminarIngredientes(?,?)";
            pst = getConexion().prepareStatement(Sql);
            
            for (int i = 0; i < L.size(); i++) {
                Ingredientes oIngrediente = (Ingredientes) L.get(i);
                pst.setString(1, oIngrediente.getIdPlato());
                pst.setString(2, oIngrediente.getIngrediente());
                rs = pst.executeQuery();
            }

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Ingrediente Eliminado".equalsIgnoreCase(resul)) {
                Bandera.setRespuestaIngredientes(resul);
                respuesta = true;
            } else {
                Bandera.setRespuestaIngredientes(resul);
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
