/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TablaUsuarios extends ConexionDB{

    public TablaUsuarios() {
    }
    
    public DefaultTableModel getTablaUsuarios(String Valor){
        
      DefaultTableModel modelo = new DefaultTableModel();          
      int registros = 0;
      String[] NombreClmns = {"Tipo Documento","Documento","Nombres","Apellidos","Telefono","Dirección","Fecha Nacimiento",
      "Correo Electronico","Roll","Usuario","Contraseña","Pregunta S","Respuesta S"};
      
      PreparedStatement pst;
      ResultSet rs = null;
      try{
         String Sql = "SELECT count(*) as total FROM Usuarios";
         pst = getConexion().prepareStatement(Sql);
         rs = pst.executeQuery();
         
         rs.next();
         registros = rs.getInt("total");
         rs.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }      
    
    Object[][] data = new String[registros][13];
      try{
         String Sql;
         if(Valor.equals(""))
    {
        Sql="SELECT * FROM Usuarios";
    }
    else{
        Sql=" SELECT * FROM Usuarios WHERE upper (Nombre) LIKE upper ('"+Valor+"%')";        
    }
         pst = getConexion().prepareStatement(Sql);
         rs = pst.executeQuery();         
         int i=0;
         while(rs.next()){
                data[i][0] = rs.getString( "TipoDoc" );
                data[i][1] = rs.getString( "Documento" );
                data[i][2] = rs.getString( "Nombre" );
                data[i][3] = rs.getString( "Apellido" );
                data[i][4] = rs.getString( "Telefono" );
                data[i][5] = rs.getString( "Direccion" );
                data[i][6] = rs.getString("FechaNacimiento" );
                data[i][7] = rs.getString( "Email" );
                data[i][8] = rs.getString( "Roll" );
                data[i][9] = rs.getString( "Usuario" );
                data[i][10] = rs.getString( "Contrasena" );
                data[i][11] = rs.getString( "Pregunta" );
                data[i][12] = rs.getString( "Respuesta" );
            i++;
         }
         rs.close();         
         modelo.setDataVector(data, NombreClmns );
         
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return modelo;
    }    
}
