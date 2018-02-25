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
public class Usuarios {
    
    //<editor-fold desc="ATRIBUTOS" defaultstate="collapsed">
    private int TipoDocumento;    
    private String Documento;
    private String Nombres;
    private String Apellidos;
    private String Telefono;
    private String Direccion;
    private String FechaNacimiento;    
    private String Email;
    private String Roll;    
    private String Usuario;
    private String Contrasena;    
    private int Pregunta;    
    private String Respuesta;

// -----------------
    private String NuevaContra;    
    //</editor-fold>    
    
    //<editor-fold desc="PROPIEDADES" defaultstate="collapsed">
    public int getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(int TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String Roll) {
        this.Roll = Roll;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    public int getPregunta() {
        return Pregunta;
    }

    public void setPregunta(int Pregunta) {
        this.Pregunta = Pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    public String getNuevaContra() {
        return NuevaContra;
    }

    public void setNuevaContra(String NuevaContra) {
        this.NuevaContra = NuevaContra;
    }
    //</editor-fold> 
    
    //<editor-fold desc="CONTRUCTOR" defaultstate="collapsed">
    public Usuarios(int TipoDocumento, String Documento, String Nombres, String Apellidos, String Telefono, String Direccion, String FechaNacimiento, String Email, String Roll, String Usuario, String Contrasena, int Pregunta, String Respuesta) {
        this.TipoDocumento = TipoDocumento;
        this.Documento = Documento;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.FechaNacimiento = FechaNacimiento;
        this.Email = Email;
        this.Roll = Roll;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
    }
    
    public Usuarios() {
    }
    //</editor-fold>

    

}
