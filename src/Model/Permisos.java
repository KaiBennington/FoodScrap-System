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
public class Permisos {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">    
    private int IdPermiso;    
    private String CodigoPermiso;
    private String NombrePermiso;
    private int IdRoll; 
    private String Habilitado;
    //</editor-fold>    
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public int getIdPermiso() {
        return IdPermiso;
    }

    public void setIdPermiso(int IdPermiso) {
        this.IdPermiso = IdPermiso;
    }

    public String getCodigoPermiso() {
        return CodigoPermiso;
    }

    public void setCodigoPermiso(String CodigoPermiso) {
        this.CodigoPermiso = CodigoPermiso;
    }

    public String getNombrePermiso() {
        return NombrePermiso;
    }

    public void setNombrePermiso(String NombrePermiso) {
        this.NombrePermiso = NombrePermiso;
    }

    public int getIdRoll() {
        return IdRoll;
    }
    
    public void setIdRoll(int IdRoll) {
        this.IdRoll = IdRoll;
    }
    
    public String getHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(String Habilitado) {
        this.Habilitado = Habilitado;
    }
    //</editor-fold> 
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Permisos(int IdPermiso,String CodigoPermiso,String NombrePermiso,int IdRoll,String Habilitado) {
        this.IdPermiso = IdPermiso;
        this.CodigoPermiso = CodigoPermiso;
        this.NombrePermiso = NombrePermiso;
        this.IdRoll = IdRoll;
        this.Habilitado = Habilitado;
    }
    
    public Permisos() {
    }
    
    public Permisos(String CodigoPermiso, String NombrePermiso) {
        this.CodigoPermiso = CodigoPermiso;
        this.NombrePermiso = NombrePermiso;
    }
    //</editor-fold>
}
