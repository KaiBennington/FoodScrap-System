/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Lista;
import Model.Platos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class PlatosCAD extends ConexionDB {

    public static boolean guardar(Platos P, Lista L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_Ingredientes;

        try {
            String Sql = "CALL GuardarPlato(?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, P.getIdPlato());
            pst.setString(2, P.getCodigoPlato());
            pst.setString(3, P.getNombre());
            pst.setDouble(4, P.getValor());

            rs = pst.executeQuery();

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Plato Registrado".equalsIgnoreCase(resul)) {

                boolean guardarIngredientes = IngredientesCAD.guardar(L);

                if (!guardarIngredientes) {
                    return false;
                } else {
                    Msj_Ingredientes = Bandera.getRespuestaIngredientes();
                }
                String R_Plato = resul ;
                
                String[] Rsp_Pl = R_Plato.split(" ");
                String parte = Rsp_Pl[0]; //Plato
                Bandera.setRespuesta(parte + " e " + Msj_Ingredientes);
                respuesta = true;
            } else {
                Bandera.setRespuesta(resul);
                respuesta = false;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//FIN Metodo Guardar

    public static boolean modificar(Platos Pm) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL ModificarPlato(?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Pm.getIdPlato());
            pst.setString(2, Pm.getCodigoPlato());
            pst.setString(3, Pm.getNombre());
            pst.setDouble(4, Pm.getValor());

            rs = pst.executeQuery();

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Información del Plato Actualizada".equalsIgnoreCase(resul)) {
                Bandera.setRespuesta(resul);
                respuesta = true;
            } else {
                Bandera.setRespuesta(resul);
                respuesta = false;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//Fin Metodo Modificar

    public static boolean eliminar(Platos Pe) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL EliminarPlato(?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Pe.getIdPlato());
            rs = pst.executeQuery();

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Plato Eliminado".equalsIgnoreCase(resul)) {
                Bandera.setRespuesta(resul);
                respuesta = true;
            } else {
                Bandera.setRespuesta(resul);
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
