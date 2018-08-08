/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import Model.Platos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PlatosCAD extends ConexionDB {

    public static boolean guardar(Platos P, List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_Ingredientes;

        try {
            String Sql = "CALL GuardarPlato(?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, P.getIdPlato());
            pst.setString(2, P.getCodigoPlato());
            pst.setString(3, P.getNombre());
            pst.setDouble(4, P.getValor());
            pst.setString(5, P.getSeccion());

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
                    Msj_Ingredientes = Bandera.getSubRespuesta();
                }
                String R_Plato = resul;

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

    public static boolean modificar(Platos Pm, List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_Ingredientes;

        try {
            String Sql = "CALL ModificarPlato(?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Pm.getIdPlato());
            pst.setString(2, Pm.getCodigoPlato());
            pst.setString(3, Pm.getNombre());
            pst.setDouble(4, Pm.getValor());
            pst.setString(5, Pm.getSeccion());

            rs = pst.executeQuery();

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Información del Plato Actualizada".equalsIgnoreCase(resul)) {

                boolean modificarIngredientes = IngredientesCAD.modificar(L);

                if (!modificarIngredientes) {
                    return false;
                } else {
                    Msj_Ingredientes = Bandera.getSubRespuesta();
                }
                String R_Plato = resul;
//                Información de Ingredientes Actualizada
                String[] Rsp_Pl = R_Plato.split("(?<= )");
                String parte = Rsp_Pl[0]; //Informacion
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
    }//Fin Metodo Modificar

    public static boolean eliminar(Platos Pe, List L) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_Ingredientes;

        try {
            boolean eliminarIngredientes = IngredientesCAD.eliminar(L);

            if (!eliminarIngredientes) {
                return false;
            } else {
                Msj_Ingredientes = Bandera.getSubRespuesta();

                String Sql = "CALL EliminarPlato(?,?)";
                pst = getConexion().prepareStatement(Sql);
                pst.setString(1, Pe.getIdPlato());
                pst.setString(2, Pe.getCodigoPlato());
                rs = pst.executeQuery();

                String resul = "";
                if (rs.next()) {
                    resul = rs.getString("Mensaje");
                }

                if ("Plato Eliminado".equalsIgnoreCase(resul)) {
                    String R_Plato = resul;

                    String[] Rsp_Pl = R_Plato.split(" ");
                    String parte = Rsp_Pl[0]; //Plato
                    Bandera.setRespuesta(parte + " e " + Msj_Ingredientes);
                    respuesta = true;
                } else {
                    Bandera.setRespuesta(resul + " " + Msj_Ingredientes);
                    respuesta = false;
                }
            }// Fin if Eliminar Ingredientes

        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//Fin Metodo Eliminar

}
