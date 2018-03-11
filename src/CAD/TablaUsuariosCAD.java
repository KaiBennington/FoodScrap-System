/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import Model.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class TablaUsuariosCAD extends ConexionDB{

    public TablaUsuariosCAD() {
    }
    
    public DefaultTableModel getTablaUsuarios(String Valor){
        
      DefaultTableModel modelo = new DefaultTableModel();          
      int registros = 0;
      String[] NombreClmns = {"Tipo Documento","Documento","Nombres","Apellidos","Telefono","Dirección","Fecha Nacimiento",
      "Correo Electronico","Roll","Usuario","Contraseña","Pregunta S","Respuesta S","IdTipoDoc","IdRoll","IdPreguntaS"};
      
      PreparedStatement pst;
      ResultSet rs = null;
      try{
         String Sql = "SELECT count(*) as total FROM Usuario";
         pst = getConexion().prepareStatement(Sql);
         rs = pst.executeQuery();
         
         rs.next();
         registros = rs.getInt("total");
         rs.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }      
    
    Object[][] data = new String[registros][16];
      try{
         String Sql;
         if(Valor.equals(""))
    {
        Sql=" SELECT A.*,B.*,C.NOMBRE AS TipoDocumento,D.NOMBRE AS Roll,E.PREGUNTA FROM Usuario A INNER JOIN Persona B ON A.Id_Persona = B.Id_Persona"
                + " INNER JOIN TIPODOCUMENTO C ON C.IdTipoDoc = B.IdTipoDoc"
                + " INNER JOIN ROLES D ON D.Id_Roll = A.Id_Roll"
                + " INNER JOIN PREGUNTASECRETA E ON E.Id_Pregunta = A.Id_Pregunta";
    }
    else{
        Sql=" SELECT A.*,B.*,C.NOMBRE AS TipoDocumento,D.NOMBRE AS Roll,E.PREGUNTA FROM Usuario A INNER JOIN Persona B ON A.Id_Persona = B.Id_Persona"
                + " INNER JOIN TIPODOCUMENTO C ON C.IdTipoDoc = B.IdTipoDoc"
                + " INNER JOIN ROLES D ON D.Id_Roll = A.Id_Roll"
                + " INNER JOIN PREGUNTASECRETA E ON E.Id_Pregunta = A.Id_Pregunta"
                + " WHERE upper (B.Nombre) LIKE upper ('"+Valor+"%')";        
    }
         pst = getConexion().prepareStatement(Sql);
         rs = pst.executeQuery();         
         int i=0;
         while(rs.next()){
                data[i][0] = rs.getString( "TipoDocumento" );
                data[i][1] = rs.getString( "Documento" );
                data[i][2] = rs.getString( "Nombre" );
                data[i][3] = rs.getString( "Apellidos" );
                data[i][4] = rs.getString( "Telefono" );
                data[i][5] = rs.getString( "Direccion" );
                data[i][6] = rs.getString("FechaNacimiento" );
                data[i][7] = rs.getString( "Correo" );
                data[i][8] = rs.getString( "Roll" );
                data[i][9] = rs.getString( "Usuario" );
                data[i][10] = rs.getString( "Contraseña" );
                data[i][11] = rs.getString( "Pregunta" );
                data[i][12] = rs.getString( "Respuesta" );
                data[i][13] = rs.getString( "IdTipoDoc" );
                data[i][14] = rs.getString( "Id_Roll" );
                data[i][15] = rs.getString( "Id_Pregunta" );
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
