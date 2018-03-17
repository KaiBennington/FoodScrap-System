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
public class Sucursales {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">
    private String Codigo;    
    private String Nombre;
    private String Direccion;
    private int Zona;
    private String Telefono; 
    //</editor-fold>   
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Sucursales() {    
    }

    public Sucursales(String Codigo, String Nombre, String Direccion, int Zona, String Telefono) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Zona = Zona;
        this.Telefono = Telefono;
    }

    public Sucursales(String Codigo, String Nombre, int Zona) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Zona = Zona;
    }
    
    
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getZona() {
        return Zona;
    }

    public void setZona(int Zona) {
        this.Zona = Zona;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    //</editor-fold> 
    
}
