/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.ConexionDB;
import static Model.ConexionDB.getConexion;
import Model.Permisos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class PermisosCAD extends ConexionDB {

    //<editor-fold desc="CARGAR PERMISOS" defaultstate="collapsed">
    public Map CargarPermisos(int IdRoll, String Estado) {
        //Lista Permisos
        PreparedStatement pst;
        ResultSet rs = null;
//        ArrayList Lista = new ArrayList();
        Map Lista = new HashMap();
        try {

            String Sql = "CALL CargarPermisos(?,?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, IdRoll);
            pst.setString(2, Estado);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Codigo;

                Nombre = rs.getString(1);
                Codigo = rs.getString(2);

//                Permisos oPermiso = new Permisos(Codigo, Nombre);
                Lista.put(Nombre,Codigo);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Permisos
    //</editor-fold>

    //<editor-fold desc="CARGAR MODULOS" defaultstate="collapsed">
    public ArrayList CargarModulos() {
        //Combo Modulos
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarModulos();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String CodigoPermiso;
                CodigoPermiso = (rs.getString(1));

                Permisos oPermiso = new Permisos();
                oPermiso.setCodigoPermiso(CodigoPermiso);
                Lista.add(oPermiso);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Modulos
    //</editor-fold>

    //<editor-fold desc="GUARDAR PERMISOS" defaultstate="collapsed">
    public boolean GuardarPermiso(String Habilitado, int IdPermiso, String Usuario) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL GuardarPermisoUsuario(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Habilitado);
            pst.setInt(2, IdPermiso);
            pst.setString(3, Usuario);
            rs = pst.executeQuery();

            if (rs.next()) {
                Bandera.setRespuesta(rs.getString("Mensaje"));
            }

            if ("Permiso Actualizado Exitosamente".equalsIgnoreCase(Bandera.getRespuesta())) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }// FIN Metodo Guardar Permiso
    //</editor-fold>

    //<editor-fold desc="VALIDAR PERMISOS" defaultstate="collapsed">
    public boolean validarPermiso(String permiso, String modulo) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean existePermiso = false;
        try {

            String Sql = "SELECT COUNT(1) FROM PERMISOS_USUARIOS B WHERE B.Usuario = ? AND B.NOMBRE_PERMISO = ? AND B.CODIGO_PERMISO = ?";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Bandera.getUsuario());
            pst.setString(2, permiso);
            pst.setString(3, modulo);
            rs = pst.executeQuery();

            while (rs.next()) {
                existePermiso = rs.getInt(1) > 0;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return existePermiso;
    }// FIN Metodo Validar Permisos
    //</editor-fold>
}
