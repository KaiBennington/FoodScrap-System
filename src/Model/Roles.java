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
public class Roles {
    
    private int IdRol;
    private String Nombre;
    private String Siglas;

    public Roles(int IdRol, String Nombre, String Siglas) {
        this.IdRol = IdRol;
        this.Nombre = Nombre;
        this.Siglas = Siglas;
    }

    public Roles() {
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSiglas() {
        return Siglas;
    }

    public void setSiglas(String Siglas) {
        this.Siglas = Siglas;
    }
    
    
}
