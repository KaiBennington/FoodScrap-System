/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Model.ConexionDB;
import com.mm.swing.table.config.CeldasTabla;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TablasCAD extends ConexionDB {

    private final CeldasTabla modelo = new CeldasTabla();

    public TablasCAD() {
    }

    //<editor-fold desc="TABLA USUARIOS" defaultstate="collapsed">
    public DefaultTableModel getTablaUsuarios(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Tipo Documento", "Documento", "Nombres", "Apellidos", "Telefono", "Dirección", "Fecha Nacimiento",
            "Correo Electronico", "Roll", "Usuario", "Contraseña", "Pregunta S", "Respuesta S", "IdTipoDoc", "IdRoll", "IdPreguntaS"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Usuario";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][16];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT A.*,B.*,C.NOMBRE AS TipoDocumento,D.NOMBRE AS Roll,E.PREGUNTA FROM Usuario A INNER JOIN Persona B ON A.Id_Persona = B.Id_Persona"
                        + " INNER JOIN TIPODOCUMENTO C ON C.IdTipoDoc = B.IdTipoDoc"
                        + " INNER JOIN ROLES D ON D.Id_Roll = A.Id_Roll"
                        + " INNER JOIN PREGUNTASECRETA E ON E.Id_Pregunta = A.Id_Pregunta";
            } else {
                Sql = " SELECT A.*,B.*,C.NOMBRE AS TipoDocumento,D.NOMBRE AS Roll,E.PREGUNTA FROM Usuario A INNER JOIN Persona B ON A.Id_Persona = B.Id_Persona"
                        + " INNER JOIN TIPODOCUMENTO C ON C.IdTipoDoc = B.IdTipoDoc"
                        + " INNER JOIN ROLES D ON D.Id_Roll = A.Id_Roll"
                        + " INNER JOIN PREGUNTASECRETA E ON E.Id_Pregunta = A.Id_Pregunta"
                        + " WHERE upper (B.Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("TipoDocumento");
                data[i][1] = rs.getString("Documento");
                data[i][2] = rs.getString("Nombre");
                data[i][3] = rs.getString("Apellidos");
                data[i][4] = rs.getString("Telefono");
                data[i][5] = rs.getString("Direccion");
                data[i][6] = rs.getString("FechaNacimiento");
                data[i][7] = rs.getString("Correo");
                data[i][8] = rs.getString("Roll");
                data[i][9] = rs.getString("Usuario");
                data[i][10] = rs.getString("Contraseña");
                data[i][11] = rs.getString("Pregunta");
                data[i][12] = rs.getString("Respuesta");
                data[i][13] = rs.getString("IdTipoDoc");
                data[i][14] = rs.getString("Id_Roll");
                data[i][15] = rs.getString("Id_Pregunta");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Usuarios
    //</editor-fold>

    //<editor-fold desc="TABLA TIPO DOCUMENTO" defaultstate="collapsed">
    public DefaultTableModel getTablaTDocumento(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Id Tipo", "Nombre", "Siglas"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM TipoDocumento";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][3];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM TipoDocumento ";
            } else {
                Sql = " SELECT * FROM TipoDocumento WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdTipoDoc");
                data[i][1] = rs.getString("Nombre");
                data[i][2] = rs.getString("Siglas");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Tipo Documento
    //</editor-fold>    

    //<editor-fold desc="TABLA UNIDAD MEDIDAS" defaultstate="collapsed">
    public DefaultTableModel getTablaUndMedida(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Id Und", "Nombre", "Siglas"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM UnidadMedidas";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][3];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM UnidadMedidas ";
            } else {
                Sql = " SELECT * FROM UnidadMedidas WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdUndMedida");
                data[i][1] = rs.getString("Nombre");
                data[i][2] = rs.getString("Siglas");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Unidad Medidas
    //</editor-fold>   

    //<editor-fold desc="TABLA CATEGORIAS" defaultstate="collapsed">
    public DefaultTableModel getTablaCategorias(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Id Cat", "Nombre"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Categorias";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][2];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Categorias ";
            } else {
                Sql = " SELECT * FROM Categorias WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdCategoria");
                data[i][1] = rs.getString("Nombre");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Categorias
    //</editor-fold>    

    //<editor-fold desc="TABLA ROLES" defaultstate="collapsed">
    public DefaultTableModel getTablaRoles(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Id Roll", "Nombre", "Siglas"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Roles";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][3];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Roles ";
            } else {
                Sql = " SELECT * FROM Roles WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("Id_Roll");
                data[i][1] = rs.getString("Nombre");
                data[i][2] = rs.getString("Siglas");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Roles
    //</editor-fold>   

    //<editor-fold desc="TABLA SUCURSALES" defaultstate="collapsed">
    public DefaultTableModel getTablaSucursales(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Codigo", "Nombre", "Dirección", "Zona", "Telefono"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Sucursales";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][5];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Sucursales ";
            } else {
                Sql = " SELECT * FROM Sucursales WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("Id_Sucursal");
                data[i][1] = rs.getString("Nombre");
                data[i][2] = rs.getString("Direccion");
                data[i][3] = rs.getString("IdZona");
                data[i][4] = rs.getString("Telefono");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Sucursales
    //</editor-fold>  

    //<editor-fold desc="TABLA PROVEEDORES" defaultstate="collapsed">
    public DefaultTableModel getTablaProveedores(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Codigo", "Nit", "Nombre", "Razon Social", "Direccion", "Telefono", "Correo", "Fax"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Proveedores";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][8];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Proveedores ";
            } else {
                Sql = " SELECT * FROM Proveedores WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdProveedor");
                data[i][1] = rs.getString("Nit");
                data[i][2] = rs.getString("Nombre");
                data[i][3] = rs.getString("RazonSocial");
                data[i][4] = rs.getString("Direccion");
                data[i][5] = rs.getString("Telefono");
                data[i][6] = rs.getString("Correo");
                data[i][7] = rs.getString("Fax");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Proveedores
    //</editor-fold>    

    //<editor-fold desc="TABLA PRODUCTOS" defaultstate="collapsed">
    public DefaultTableModel getTablaProductos(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Codigo", "Cantidad", "Und Medida", "Nombre", "Precio Costo", "Categoria", "Proveedor", "Stock"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Productos";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][8];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Productos ";
            } else {
                Sql = " SELECT * FROM Productos WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdProducto");
                data[i][1] = rs.getString("Cantidad");
                data[i][2] = rs.getString("IdUndMedida");
                data[i][3] = rs.getString("Nombre");
                data[i][4] = rs.getString("PrecioC");
                data[i][5] = rs.getString("IdCategoria");
                data[i][6] = rs.getString("IdProveedor");
                data[i][7] = rs.getString("Stock");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Productos
    //</editor-fold>    

    //<editor-fold desc="TABLA PLATOS" defaultstate="collapsed">
    public DefaultTableModel getTablaPlatos(String Valor) {

//      DefaultTableModel modelo = new DefaultTableModel();          
        int registros = 0;
        String[] NombreClmns = {"Id", "Codigo", "Nombre", "Valor", "Sección"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Platos";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][5];
        try {
            String Sql;
            if (Valor.equals("")) {
                Sql = " SELECT * FROM Platos ";
            } else {
                Sql = " SELECT * FROM Platos WHERE upper (Nombre) LIKE upper ('" + Valor + "%')";
            }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("IdPlato");
                data[i][1] = rs.getString("Codigo");
                data[i][2] = rs.getString("Nombre");
                data[i][3] = rs.getString("Valor");
                data[i][4] = rs.getString("IdSeccion");
                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Productos
    //</editor-fold>  

    //<editor-fold desc="TABLA INGREDIENTES" defaultstate="collapsed">
    public DefaultTableModel getTablaIngredientes(String Valor) {

        int registros = 0;
        String[] NombreClmns = {"Ingrediente", "Cantidad"};

        PreparedStatement pst;
        ResultSet rs = null;
        try {
            String Sql = "SELECT count(*) as total FROM Ingredientes WHERE IdPlato = " + Valor + " ;";
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();

            rs.next();
            registros = rs.getInt("total");
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registros][2];
        try {
            String Sql = null;
            if (Valor.equals("")) {
                JOptionPane.showMessageDialog(null, "No se encuentran los ingredientes del Plato\n Verifique que tenga conexión a la Base de Datos.");
            } else {
                Sql = "SELECT I.*,P.Nombre As Nombre FROM Ingredientes I INNER JOIN Productos P ON I.IdProducto = P.IdProducto WHERE I.IdPlato = "+Valor+" ;";
                }
            pst = getConexion().prepareStatement(Sql);
            rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("Nombre");
                data[i][1] = rs.getString("Cantidad");

                i++;
            }
            rs.close();
            modelo.setDataVector(data, NombreClmns);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return modelo;
    } //FIN Tabla Ingredientes
    //</editor-fold>    
}
