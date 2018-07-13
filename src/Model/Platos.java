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
public class Platos {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed"> 
    private String idPlato;
    private String CodigoPlato;
    private String Seccion;
    private String Nombre;
    private double Valor; 
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public String getIdPlato() {
        return idPlato;
    }
    
    public void setIdPlato(String idPlato) {    
        this.idPlato = idPlato;
    }

    public String getCodigoPlato() {
        return CodigoPlato;
    }

    public void setCodigoPlato(String CodigoPlato) {
        this.CodigoPlato = CodigoPlato;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getValor() {
        return Valor;
    }
    
    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    //</editor-fold> 
    
    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed">

    public Platos(String idPlato, String CodigoPlato, String Seccion, String Nombre, int Valor) {
        this.idPlato = idPlato;
        this.CodigoPlato = CodigoPlato;
        this.Seccion = Seccion;
        this.Nombre = Nombre;
        this.Valor = Valor;
    }
    
    public Platos() {
    }
    
    public Platos(String idPlato, String CodigoPlato) {
        this.idPlato = idPlato;
        this.CodigoPlato = CodigoPlato;
    }
    
    
    //</editor-fold>

}
