/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Ingredientes;
import Model.Lista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.vPlatos;

/**
 *
 * @author USUARIO
 */
public class IngredientesCAD extends ConexionDB {

    public static boolean guardar(Lista L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL GuardarIngredientes(?,?,?)";
            pst = getConexion().prepareStatement(Sql);

            for (int i = 0; i < L.getListaIngredientes().size(); i++) {
                pst.setString(1, L.getListaIngredientes().get(i).getIdPlato());
                pst.setString(2, L.getListaIngredientes().get(i).getIngrediente());
                pst.setString(3, L.getListaIngredientes().get(i).getCantidad());
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

//    public static boolean modificar(Platos Pm) {
//        PreparedStatement pst;
//        ResultSet rs = null;
//        boolean respuesta = false;
//
//        try {
//            String Sql = "CALL ModificarPlato(?,?,?,?)";
//            pst = getConexion().prepareStatement(Sql);
//            pst.setString(1, Pm.getIdPlato());
//            pst.setString(2, Pm.getCodigoPlato());
//            pst.setString(3, Pm.getNombre());
//            pst.setDouble(4, Pm.getValor());
//
//            rs = pst.executeQuery();
//
//            String resul = "";
//            if (rs.next()) {
//                resul = rs.getString("Mensaje");
//            }
//
//            if ("Información del Plato Actualizada".equalsIgnoreCase(resul)) {
//                Bandera.setRespuesta(resul);
//                respuesta = true;
//            } else {
//                Bandera.setRespuesta(resul);
//                respuesta = false;
//            }
//        } catch (SQLException e) {
//            System.err.println("Error " + e);
//        } finally {
//            desconectar();
//            return respuesta;
//        }
//    }//Fin Metodo Modificar
//
//    public static boolean eliminar(Platos Pe) {
//        PreparedStatement pst;
//        ResultSet rs = null;
//        boolean respuesta = false;
//
//        try {
//            String Sql = "CALL EliminarPlato(?)";
//            pst = getConexion().prepareStatement(Sql);
//            pst.setString(1, Pe.getIdPlato());
//            rs = pst.executeQuery();
//
//            String resul = "";
//            if (rs.next()) {
//                resul = rs.getString("Mensaje");
//            }
//
//            if ("Plato Eliminado".equalsIgnoreCase(resul)) {
//                Bandera.setRespuesta(resul);
//                respuesta = true;
//            } else {
//                Bandera.setRespuesta(resul);
//                respuesta = false;
//            }
//        } catch (SQLException e) {
//            System.err.println("Error " + e);
//        } finally {
//            desconectar();
//            return respuesta;
//        }
//    }//Fin Metodo Eliminar

}
