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
public class PlatosVendidos {

    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">     
    private String CodigoPlato;
    private int Num_Factura;
    private String Cantidad;
    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public String getCodigoPlato() {
        return CodigoPlato;
    }

    public void setCodigoPlato(String CodigoPlato) {
        this.CodigoPlato = CodigoPlato;
    }

    public int getNum_Factura() {
        return Num_Factura;
    }

    public void setNum_Factura(int Num_Factura) {
        this.Num_Factura = Num_Factura;
    }

    public String getCantidad() {
        return Cantidad;
    }
    
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
    //</editor-fold>
    
    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed">
    public PlatosVendidos(String CodigoPlato, int Num_Factura, String Cantidad) {
        this.CodigoPlato = CodigoPlato;
        this.Num_Factura = Num_Factura;
        this.Cantidad = Cantidad;
    }

    public PlatosVendidos() {
    }
    //</editor-fold>

}
