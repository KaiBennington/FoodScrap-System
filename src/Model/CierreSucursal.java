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
public class CierreSucursal {

    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed"> 
    private int NumFactura;
    private String FechaFactura;
    private String Sucursal;
    private double P_Sale;
    private double P_Devuelve;
    private double BaseInicial;
    private double Alcancia;
    private double NetoExistente;
    private double TotalNeto;
    private double TotalBruto;
    private double Resta;
    //</editor-fold>

    //<editor-fold desc="CONSTRUCTOR" defaultstate="collapsed"> 
    public CierreSucursal(int NumFactura, String FechaFactura, String Sucursal, double P_Sale, double P_Devuelve, double BaseInicial, double Alcancia, double NetoExistente, double TotalNeto, double TotalBruto, double Resta) {
        this.NumFactura = NumFactura;
        this.FechaFactura = FechaFactura;
        this.Sucursal = Sucursal;
        this.P_Sale = P_Sale;
        this.P_Devuelve = P_Devuelve;
        this.BaseInicial = BaseInicial;
        this.Alcancia = Alcancia;
        this.NetoExistente = NetoExistente;
        this.TotalNeto = TotalNeto;
        this.TotalBruto = TotalBruto;
        this.Resta = Resta;
    }

    public CierreSucursal() {
    }

    //</editor-fold>
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed"> 
    public int getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(int NumFactura) {
        this.NumFactura = NumFactura;
    }

    public String getFechaFactura() {
        return FechaFactura;
    }

    public void setFechaFactura(String FechaFactura) {
        this.FechaFactura = FechaFactura;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }

    public double getP_Sale() {
        return P_Sale;
    }

    public void setP_Sale(double P_Sale) {
        this.P_Sale = P_Sale;
    }

    public double getP_Devuelve() {
        return P_Devuelve;
    }

    public void setP_Devuelve(double P_Devuelve) {
        this.P_Devuelve = P_Devuelve;
    }

    public double getBaseInicial() {
        return BaseInicial;
    }

    public void setBaseInicial(double BaseInicial) {
        this.BaseInicial = BaseInicial;
    }

    public double getAlcancia() {
        return Alcancia;
    }

    public void setAlcancia(double Alcancia) {
        this.Alcancia = Alcancia;
    }

    public double getNetoExistente() {
        return NetoExistente;
    }

    public void setNetoExistente(double NetoExistente) {
        this.NetoExistente = NetoExistente;
    }

    public double getTotalNeto() {
        return TotalNeto;
    }

    public void setTotalNeto(double TotalNeto) {
        this.TotalNeto = TotalNeto;
    }

    public double getTotalBruto() {
        return TotalBruto;
    }

    public void setTotalBruto(double TotalBruto) {
        this.TotalBruto = TotalBruto;
    }

    public double getResta() {
        return Resta;
    }

    public void setResta(double Resta) {
        this.Resta = Resta;
    }
    //</editor-fold>
    
}
