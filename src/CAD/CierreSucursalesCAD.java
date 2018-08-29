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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class CierreSucursalesCAD extends ConexionDB {

    public static boolean guardar(CierreSucursal Cs, ArrayList PlatosVendidos, List Gastos) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_PlatosVendidos;

        try {
            String Sql = "CALL GuardarCierreSucursal(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Cs.getNumFactura());
            pst.setDate(2, Cs.getFechaFactura());
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

            if ("Cierre Sucursal Registrado".equalsIgnoreCase(resul)) {

                boolean guardarPlatosVendidos = PlatosVendidosCAD.guardar(PlatosVendidos);

                if (!guardarPlatosVendidos) {
                    return false;
                } else {
                    Msj_PlatosVendidos = Bandera.getSubRespuesta();
                }
                if (Gastos.size() > 0) {
                    boolean guardarGastos = GastosCAD.guardar(Gastos);

                    if (!guardarGastos) {
                        return false;
                    }
                }

                String R_Cierre = resul;

                String[] Rsp_Pl = R_Cierre.split(" ", 3);
                String parte = Rsp_Pl[0] + " " + Rsp_Pl[1];
                Bandera.setRespuesta(parte + " y " + Msj_PlatosVendidos);

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

    public static boolean modificar(CierreSucursal Cs, ArrayList PlatosVendidos, List Gastos) {
        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;
        String Msj_PlatosVendidos;

        try {
            String Sql = "CALL ModificarCierreSucursal(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Cs.getNumFactura());
            pst.setDate(2, Cs.getFechaFactura());
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

            if ("Información del Cierre Sucursal Actualizada".equalsIgnoreCase(resul)) {

                boolean modificarPlatosVendidos = PlatosVendidosCAD.guardar(PlatosVendidos);

                if (!modificarPlatosVendidos) {
                    return false;
                } else {
                    Msj_PlatosVendidos = Bandera.getSubRespuesta();
                }
                if (Gastos.size() > 0) {
                    boolean modificarGastos = GastosCAD.modificar(Gastos);

                    if (!modificarGastos) {
                        return false;
                    }
                }

//                String R_Cierre = resul;
//
//                String[] Rsp_Pl = R_Cierre.split(" ", 3);
//                String parte = Rsp_Pl[0] + " " + Rsp_Pl[1];
//                Bandera.setRespuesta(parte + " y " + Msj_PlatosVendidos);
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
    }//FIN Metodo Modificar

    public static boolean eliminar(CierreSucursal Cs, ArrayList PlatosVendidos, List Gastos) {

        boolean respuesta = false;
        String RspEliminarCierre;

        try {
            boolean eliminarPlatosVendidos = PlatosVendidosCAD.eliminar(PlatosVendidos);
            if (!eliminarPlatosVendidos) {
                return false;
            } else {
                if (Gastos.size() > 0) {
                    boolean eliminarGastos = GastosCAD.eliminar(Gastos);

                    if (!eliminarGastos) {
                        return false;
                    }
                }// End IF list Gastos.

                boolean eliminarCierreSucursal = CierreSucursalesCAD.eliminarCierre(Cs);

                if (!eliminarCierreSucursal) {
                    return false;
                }// End IF Bean Cierre
                RspEliminarCierre = Bandera.getRespuesta();
            }
            respuesta = "Registro Cierre Sucursal Eliminado".equalsIgnoreCase(RspEliminarCierre);
        } catch (Exception e) {
            System.err.println("Error " + e);
        } finally {
            desconectar();
            return respuesta;
        }
    }//Fin Metodo Eliminar

    private static boolean eliminarCierre(CierreSucursal Cs) {

        PreparedStatement pst;
        ResultSet rs = null;
        boolean respuesta = false;

        try {
            String Sql = "CALL EliminarCierreSucursal(?,?,?)";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, Cs.getNumFactura());
            pst.setDate(2, Cs.getFechaFactura());
            pst.setString(3, Cs.getSucursal());
            rs = pst.executeQuery();

            String resul = "";
            if (rs.next()) {
                resul = rs.getString("Mensaje");
            }

            if ("Registro Cierre Sucursal Eliminado".equalsIgnoreCase(resul)) {

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
    }
}
