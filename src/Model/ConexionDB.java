
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class ConexionDB {

    private static Connection conn;
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String User ="root";
    private static final String Password ="jepetto987";
    private static final String DataBase ="foodscrap";
    private static final String Url ="jdbc:mysql://localhost:3306/"+DataBase+"";
     
    public ConexionDB(){
       
    }
    
    // Este metodo nos retorna la conexion
    public static Connection getConexion(){
         try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(Url, User, Password);
            if (conn != null) {
//                System.out.println("conexion Establecida...");
            }            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar : "+e);
        } 
        return conn;
    }
    
    //Con este metodo nos desconectamos de la base de datos
    public static void desconectar(){
        conn = null;
        if (conn == null) {
//            System.out.println("conexion Terminada...");
        }
    }
    
    public static void main(String[] args) {
        ConexionDB Cx = new ConexionDB();
        
    }
}