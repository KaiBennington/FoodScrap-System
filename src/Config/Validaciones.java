/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Model.Sucursales;
import Model.Usuarios;
import java.util.Map;

/**
 *
 * @author USUARIO
 */
public class Validaciones {
    
    //<editor-fold desc="VALIDAR USUARIO" defaultstate="collapsed">
    public Map validarCampos(Map respuesta){
        
        Usuarios U = (Usuarios)respuesta.get("User");
        
        if (U.getTipoDocumento() <= 0) {
            respuesta.put("Mensaje","Debe Seleccionar Tipo Documento");
            respuesta.put("campo","CbxTipoDoc.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getDocumento().equals("")) {
            respuesta.put("Mensaje","El campo de Documento se encuentra Vacio");
            respuesta.put("campo","TxtDocumento.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getNombres().equals("")) {
            respuesta.put("Mensaje","El campo de Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getApellidos().equals("")) {
            respuesta.put("Mensaje","El campo de Apellido se encuentra Vacio");
            respuesta.put("campo","CbxTipoDoc.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getTelefono().equals("")) {
            respuesta.put("Mensaje","El campo de Telefono se encuentra Vacio");
            respuesta.put("campo","TxtTelefono.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getFechaNacimiento().equals("")) {
            respuesta.put("Mensaje","El campo de Fecha se encuentra Vacio");
            respuesta.put("campo","DCFechaNac.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getUsuario().equals("")) {
            respuesta.put("Mensaje","El campo de Usuario se encuentra Vacio");
            respuesta.put("campo","TxtUsuario.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getContrasena().equals("")) {
            respuesta.put("Mensaje","El campo de Contraseña se encuentra Vacio");
            respuesta.put("campo","TxtContrasena.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getPregunta() <= 0) {
            respuesta.put("Mensaje","Debe Seleccionar Pregunta de Seguridad");
            respuesta.put("campo","CbxPregunta.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getRespuesta().equals("")) {
            respuesta.put("Mensaje","El campo de Respuesta secreta se encuentra Vacio");
            respuesta.put("campo","TxtRespuesta.requestFocusInWindow()");
            return respuesta;
        } 
        if (U.getRoll().equals("")) {
            respuesta.put("Mensaje","Debe darle privilegios al usuario");
            respuesta.put("campo","BtnPrivilegios.requestFocusInWindow()");
            return respuesta;
        } 
        
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR SUCURSAL" defaultstate="collapsed">
    public Map validarCamposSucursales(Map respuesta){
        
        Sucursales S = (Sucursales)respuesta.get("Sucursal");
        
        if (S.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID de la Sucursal");
            return respuesta;
        } 
        if (S.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (S.getDireccion().equals("")) {
            respuesta.put("Mensaje","El campo Dirección se encuentra Vacio");
            respuesta.put("campo","TxtDireccion.requestFocusInWindow()");
            return respuesta;
        } 
        if (S.getZona() <= 0) {
            respuesta.put("Mensaje","Debe Seleccionar Una Zona");
            respuesta.put("campo","CbxZona.requestFocusInWindow()");
            return respuesta;
        } 
        if (S.getTelefono().equals("")) {
            respuesta.put("Mensaje","El campo Telefono se encuentra Vacio");
            respuesta.put("campo","TxtTelefono.requestFocusInWindow()");
            return respuesta;
        }         
        
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
}