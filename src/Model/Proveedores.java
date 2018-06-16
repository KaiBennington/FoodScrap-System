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
public class Proveedores {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">
    private String Codigo;    
    private String Nit;
    private String RazonSocial;
    private String Nombre;
    private String Correo;
    private String Direccion;
    private String Telefono;
    private String Fax;
    //</editor-fold>   
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Proveedores() {    
    }

    public Proveedores(String Codigo, String Nit, String RazonSocial,String Nombre, String Correo, String Direccion, String Telefono, String Fax) {
        this.Codigo = Codigo;
        this.Nit = Nit;
        this.RazonSocial = RazonSocial;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Fax = Fax;
    }    
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">    
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }    
    //</editor-fold> 

}
