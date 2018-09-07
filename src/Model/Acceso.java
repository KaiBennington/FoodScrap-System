/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class Acceso {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed"> 
    private String Nombre;
    private String Apellido;
    private String Usuario;
    private String Contrasena;
    private String NomRoll;
    private String SiglasRoll;    
    //</editor-fold>

    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed"> 
    public Acceso(String Nombre, String Apellido, String Usuario, String Contrasena, String NomRoll, String SiglasRoll) {    
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.NomRoll = NomRoll;
        this.SiglasRoll = SiglasRoll;
    }

    public Acceso() {
    }

    public Acceso(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }   
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getNomRoll() {
        return NomRoll;
    }

    public void setNomRoll(String NomRoll) {
        this.NomRoll = NomRoll;
    }

    public String getSiglasRoll() {
        return SiglasRoll;
    }

    public void setSiglasRoll(String SiglasRoll) {
        this.SiglasRoll = SiglasRoll;
    }
    //</editor-fold>
}
