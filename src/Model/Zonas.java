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
public class Zonas {
    
    private String Codigo;
    private String Nombre;
    private String Comuna;

    public Zonas(String Codigo, String Nombre, String Comuna) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Comuna = Comuna;
    }

    public Zonas() {
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

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }
    
    
    
}
