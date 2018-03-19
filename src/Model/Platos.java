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
    
    private int CodigoPlato;    
    private String Categoria;
    private String Nombre;
    private int Valor; 
    //</editor-fold>    
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public int getCodigoPlato() {
        return CodigoPlato;
    }

    public void setCodigoPlato(int CodigoPlato) {
        this.CodigoPlato = CodigoPlato;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getValor() {
        return Valor;
    }
    
    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    //</editor-fold> 
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Platos(int CodigoPlato,String Categoria,String Nombre,int Valor) {
        this.CodigoPlato = CodigoPlato;
        this.Categoria = Categoria;
        this.Nombre = Nombre;
        this.Valor = Valor;
    }
    
    public Platos() {
    }
    //</editor-fold>

}
