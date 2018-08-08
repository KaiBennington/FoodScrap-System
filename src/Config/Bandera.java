/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author USUARIO
 */
public class Bandera {
   
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">
    public static String Nombre = "";
    public static String Apellido = "";
    public static String Usuario = "";
//    --------------------
    public static String Rol = "";
    public static String NombreRol = "";
    public static String SiglasRol = "";
    
//    --------------------
    public static String Respuesta; 
    public static String SubRespuesta; 
    private String Codigo;
//    --------------------
    private String Tabla;
    private String Campo;
    //</editor-fold> 
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        Bandera.Nombre = Nombre;
    }

    public static String getApellido() {
        return Apellido;
    }

    public static void setApellido(String Apellido) {
        Bandera.Apellido = Apellido;
    }

    public static String getRol() {
        return Rol;
    }

    public static void setRol(String Rol) {
        Bandera.Rol = Rol;
    }
    
    public static String getRespuesta() {
        return Respuesta;
    }

    public static void setRespuesta(String Respuesta) {
        Bandera.Respuesta = Respuesta;
    }

    public static String getSubRespuesta() {
        return SubRespuesta;
    }

    public static void setSubRespuesta(String SubRespuesta) {
        Bandera.SubRespuesta = SubRespuesta;
    }
    
    public static String getUsuario() {
        return Usuario;
    }

    public static void setUsuario(String Usuario) {
        Bandera.Usuario = Usuario;
    }

    public static String getNombreRol() {
        return NombreRol;
    }

    public static void setNombreRol(String NombreRol) {
        Bandera.NombreRol = NombreRol;
    }
    
    public static String getSiglasRol() {
        return SiglasRol;
    }

    public static void setSiglasRol(String SiglasRol) {
        Bandera.SiglasRol = SiglasRol;
    }
    
    public String getTabla() {
        return Tabla;
    }

    public void setTabla(String Tabla) {
        this.Tabla = Tabla;
    }

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
    }
    //</editor-fold> 

    public Bandera(String Tabla, String Campo) {
        this.Tabla = Tabla;
        this.Campo = Campo;
    }
    
    

    

    

    

    

    

    
    

    

    
}
