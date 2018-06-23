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
public class Ingredientes {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed"> 
    private String idPlato;
    private String Ingrediente;
    private String Cantidad;
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public String getIdPlato() {
        return idPlato;
    }
    
    public void setIdPlato(String idPlato) {    
        this.idPlato = idPlato;
    }

    public String getIngrediente() {
        return Ingrediente;
    }

    public void setIngrediente(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }    
    //</editor-fold> 
    
    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed">

    public Ingredientes(String idPlato, String Ingrediente, String Cantidad) {
        this.idPlato = idPlato;
        this.Ingrediente = Ingrediente;
        this.Cantidad = Cantidad;
    }    
    
    public Ingredientes() {
    }
    //</editor-fold>
}
