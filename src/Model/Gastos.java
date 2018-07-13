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
public class Gastos {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed"> 
    private int IdFactura;
    private String Descripcion;
    private double Valor;
    //</editor-fold>
    
    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed"> 
    public Gastos() {
    }

    public Gastos(int IdFactura, String Descripcion, double Valor) {
        this.IdFactura = IdFactura;
        this.Descripcion = Descripcion;
        this.Valor = Valor;
    }
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed"> 
    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    //</editor-fold>
}
