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
public class Productos {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">
    private String Codigo;    
    private String IdProveedor;
    private String IdCategoria;
    private String Nombre;
    private int PrecioCosto;
    private int Cantidad;
    private String IdUMedida;
    private int Stock;
    //</editor-fold>   
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Productos() {       
    }

    public Productos(String Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public Productos(String Codigo, String IdProveedor, String IdCategoria, String Nombre, int PrecioCosto, int Cantidad, String IdUMedida, int Stock) {
        this.Codigo = Codigo;
        this.IdProveedor = IdProveedor;
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
        this.PrecioCosto = PrecioCosto;
        this.Cantidad = Cantidad;
        this.IdUMedida = IdUMedida;
        this.Stock = Stock;
    }
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">    
    
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(String IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrecioCosto() {
        return PrecioCosto;
    }

    public void setPrecioCosto(int PrecioCosto) {
        this.PrecioCosto = PrecioCosto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getIdUMedida() {
        return IdUMedida;
    }

    public void setIdUMedida(String IdUMedida) {
        this.IdUMedida = IdUMedida;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    //</editor-fold> 

    
}
