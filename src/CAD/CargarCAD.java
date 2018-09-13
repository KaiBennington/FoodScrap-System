/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Config.Bandera;
import Model.Acceso;
import Model.Categorias;
import Model.ConexionDB;
import Model.Permisos;
//import static Model.ConexionDB.getConexion;
import Model.Platos;
import Model.PlatosVendidos;
import Model.PreguntaSecreta;
import Model.Productos;
import Model.Proveedores;
import Model.Roles;
import Model.Secciones;
import Model.Sucursales;
import Model.TipoDocumento;
import Model.UnidadMedidas;
import Model.Zonas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class CargarCAD extends ConexionDB {

    //<editor-fold desc="CARGAR TIPO DOCUMENTO" defaultstate="collapsed">
    public ArrayList CargarTipoDoc() {
        //Combo Tipo Documento
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarTipoDoc();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Siglas;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));
                Siglas = (rs.getString(3));

                TipoDocumento Tp = new TipoDocumento("" + Codigo, Nombre, Siglas);
                Lista.add(Tp);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Tipo documento
    //</editor-fold>

    //<editor-fold desc="CARGAR UNIDAD DE MEDIDA" defaultstate="collapsed">
    public ArrayList CargarUndMedida() {
        //Combo Unidad de Medida
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarUndMedida();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Siglas;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));
                Siglas = (rs.getString(3));

                UnidadMedidas Um = new UnidadMedidas("" + Codigo, Nombre, Siglas);
                Lista.add(Um);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Unidad de Medida
    //</editor-fold>

    //<editor-fold desc="CARGAR CATEGORIAS" defaultstate="collapsed">
    public ArrayList CargarCategoria() {
        //Combo Categorias
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarCategoria();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));

                Categorias Ct = new Categorias("" + Codigo, Nombre);
                Lista.add(Ct);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Categorias
    //</editor-fold>

    //<editor-fold desc="CARGAR PROVEEDORES" defaultstate="collapsed">
    public ArrayList CargarProveedor() {
        //Combo Proveedores
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarProveedor();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, RazonSocial;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));
                RazonSocial = (rs.getString(3));

                Proveedores Pr = new Proveedores("" + Codigo, Nombre, RazonSocial);
                Lista.add(Pr);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Proveedores
    //</editor-fold>

    //<editor-fold desc="CARGAR INGREDIENTES" defaultstate="collapsed">
    public ArrayList CargarIngrediente() {
        //Combo Ingredientes
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarIngrediente();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));

                Productos Pr = new Productos("" + Codigo, Nombre);
                Lista.add(Pr);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Ingredientes
    //</editor-fold>

    //<editor-fold desc="CARGAR PLATOS" defaultstate="collapsed">
    public ArrayList CargarPlatos() {
        //Jtab Platos
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarPlatos();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Codigo, Nombre, Seccion;
                double Valor;
                Codigo = (rs.getString("Codigo"));
                Nombre = (rs.getString("Nombre"));
                Valor = (rs.getDouble("Valor"));
                Seccion = (rs.getString("IdSeccion"));

                Platos Pl = new Platos();
                Pl.setCodigoPlato(Codigo);
                Pl.setNombre(Nombre);
                Pl.setValor(Valor);
                Pl.setSeccion(Seccion);

                Lista.add(Pl);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Platos
    //</editor-fold>

    //<editor-fold desc="CARGAR SECCIONES" defaultstate="collapsed">
    public ArrayList CargarSeccion() {
        //Combo Secciones
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarSeccion();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));

                Secciones Sc = new Secciones("" + Codigo, Nombre);
                Lista.add(Sc);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Secciones
    //</editor-fold>

    //<editor-fold desc="CARGAR SUCURSALES" defaultstate="collapsed">
    public ArrayList CargarSucursal() {
        //Combo Sucursales
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarSucursal();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Codigo;
                int Zona;
                Codigo = (rs.getString("Id_Sucursal"));
                Nombre = (rs.getString("Nombre"));
                Zona = (rs.getInt("IdZona"));

                Sucursales Sc = new Sucursales(Codigo, Nombre, Zona);
                Lista.add(Sc);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Sucursales
    //</editor-fold>

    //<editor-fold desc="CARGAR DETALLES PLATOS V" defaultstate="collapsed">
    public ArrayList CargarPlatosVendidos(String Valor) {
        //Lista Detalles Platos
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarPlatosVendidos(?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Valor);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Codigo, Cantidad;
                int NFactura;
                Codigo = (rs.getString("Codigo"));
                NFactura = (rs.getInt("Num_Factura"));
                Cantidad = (rs.getString("Cantidad"));

                PlatosVendidos Pv = new PlatosVendidos(Codigo, NFactura, Cantidad);
                Lista.add(Pv);
//               System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Detalles Platos Vendidos
    //</editor-fold>

    //<editor-fold desc="CARGAR ZONAS" defaultstate="collapsed">
    public ArrayList CargarZona() {
        //Combo Zonas
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarZonas();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Comuna;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));
                Comuna = (rs.getString(3));

                Zonas Zn = new Zonas("" + Codigo, Nombre, Comuna);
                Lista.add(Zn);
                // System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Zonas
    //</editor-fold>

    //<editor-fold desc="CARGAR PREGUNTA SEGURIDAD" defaultstate="collapsed"> 
    public ArrayList CargarPregunta() {
        //Combo Pregunta Seguridad
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

                PreguntaSecreta Ps = new PreguntaSecreta("" + Codigo, Nombre);
                Lista.add(Ps);
                //   System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Pregunta Secreta
    //</editor-fold>

    //<editor-fold desc="CARGAR ROLES" defaultstate="collapsed"> 
    public ArrayList CargarRoles() {
        //Combo Clase Roll
        PreparedStatement pst;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {

            String Sql = "CALL CargarRoles();";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String Nombre, Siglas;
                int Codigo;
                Codigo = (rs.getInt(1));
                Nombre = (rs.getString(2));
                Siglas = (rs.getString(3));

                Roles Rl = new Roles(Codigo, Nombre, Siglas);
                Lista.add(Rl);
                //  System.out.println(""+Lista);
            }
            return Lista;
        } catch (SQLException ex) {
        }
        return Lista;
    }// FIN Metodo Cargar Roles
    //</editor-fold>      

    //<editor-fold desc="CARGAR IDs" defaultstate="collapsed">
    public String cargarIds(Bandera B) {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "CALL CargarIds(?,?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, B.getTabla());
            pst.setString(2, B.getCampo());
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString(1);
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>
    
    //<editor-fold desc="CARGAR NOMBRE SUCURSAL" defaultstate="collapsed">
    public String cargarNombreSucursal(int IdSucursal) {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "SELECT Nombre FROM Sucursales WHERE Id_Sucursal = ?";
            pst = getConexion().prepareStatement(Sql);
            pst.setInt(1, IdSucursal);            
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString("Nombre");
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR ID TIPO DOCUMENTO" defaultstate="collapsed">
    public String cargarIdTipoDocumento() {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "select COALESCE(MAX(IdTipoDoc), 0)+1 FROM TipoDocumento;";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString(1);
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR ID UNIDAD DE MEDIDAS" defaultstate="collapsed">
    public String cargarIdUnidadMedidas() {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "select COALESCE(MAX(IdUndMedida), 0)+1 FROM UnidadMedidas;";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString(1);
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR ID CATEGORIAS" defaultstate="collapsed">
    public String cargarIdCategorias() {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "select COALESCE(MAX(IdCategoria), 0)+1 FROM Categorias;";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString(1);
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR ID ROLES" defaultstate="collapsed">
    public String cargarIdRoles() {
        PreparedStatement pst;
        ResultSet rs = null;
        String CI = "";
        try {
            String Sql = "select COALESCE(MAX(Id_Roll), 0)+1 FROM Roles;";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CI = rs.getString(1);
            }

        } catch (SQLException ex) {
        }
        desconectar();
        return CI;
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR PERMISOS" defaultstate="collapsed">
    public List cargarPermisos(Acceso Ac) {
        PreparedStatement pst;
        ResultSet rs = null;
        List ListaPermisos = new ArrayList();

        try {
            String Sql = "select Nombre_Permiso, Codigo_Permiso from permisos where Id_Roll = (Select Id_Roll from Roles where Nombre = ?);";
            pst = getConexion().prepareStatement(Sql);
            pst.setString(1, Ac.getNomRoll());
            rs = pst.executeQuery();

            while (rs.next()) {
                String Permiso, Codigo;

                Permiso = (rs.getString(1));
                Codigo = (rs.getString(2));

                Permisos Pm = new Permisos(Codigo, Permiso);
                ListaPermisos.add(Pm);

            }

        } catch (SQLException ex) {
        }
        desconectar();
        return ListaPermisos;
    }
    //</editor-fold>
    
    
}
