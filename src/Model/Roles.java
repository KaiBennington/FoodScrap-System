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
    
    private String Codigo;
    private String Nombre;
    private String Siglas;

    public Roles(String Codigo, String Nombre, String Siglas) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Siglas = Siglas;
    }

    public Roles() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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
