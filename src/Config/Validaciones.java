/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Model.Categorias;
import Model.Productos;
import Model.Proveedores;
import Model.Roles;
import Model.Sucursales;
import Model.TipoDocumento;
import Model.UnidadMedidas;
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
        if (U.getRoll()<= 0) {
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
    
    //<editor-fold desc="VALIDAR PROVEEDOR" defaultstate="collapsed">
    public Map validarCamposProveedores(Map respuesta){
        
        Proveedores P = (Proveedores)respuesta.get("Proveedor");
        
        if (P.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID del Proveedor");
            return respuesta;
        } 
        if (P.getNit().equals("")) {
            respuesta.put("Mensaje","El campo Nit se encuentra Vacio");
            respuesta.put("campo","TxtNit.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getRazonSocial().equals("")) {
            respuesta.put("Mensaje","El campo Razon Social se encuentra Vacio");
            respuesta.put("campo","TxtRazonSocial.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getCorreo().equals("")) {
            respuesta.put("Mensaje","El campo Correo Electronico se encuentra Vacio");
            respuesta.put("campo","TxtCorreo.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getDireccion().equals("")) {
            respuesta.put("Mensaje","El campo Dirección se encuentra Vacio");
            respuesta.put("campo","TxtDireccion.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getTelefono().equals("")) {
            respuesta.put("Mensaje","El campo Telefono se encuentra Vacio");
            respuesta.put("campo","TxtTelefono.requestFocusInWindow()");
            return respuesta;
        }         
//        if (P.getFax().equals("")) {
//            respuesta.put("Mensaje","El campo Fax se encuentra Vacio");
//            respuesta.put("campo","TxtFax.requestFocusInWindow()");
//            return respuesta;
//        }         
        
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR PROVEEDOR" defaultstate="collapsed">
    public Map validarCamposProductos(Map respuesta){
        
        Productos P = (Productos)respuesta.get("Producto");
        
        if (P.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID del Proveedor");
            return respuesta;
        } 
        if (P.getIdProveedor().equals("")) {
            respuesta.put("Mensaje","Debe seleccionar un Proveedor");
            respuesta.put("campo","CbxProveedor.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getIdCategoria().equals("")) {
            respuesta.put("Mensaje","Debe seleccionar una Categoria");
            respuesta.put("campo","CbxCategoria.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getPrecioCosto()< 0) {
            respuesta.put("Mensaje","El campo Precio Costo debe contener un valor valido");
            respuesta.put("campo","TxtPrecioCosto.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getCantidad()<= 0) {
            respuesta.put("Mensaje","El campo Cantidad debe contener como minimo 1");
            respuesta.put("campo","TxtCantidad.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getIdUMedida().equals("")) {
            respuesta.put("Mensaje","Debe seleccionar una Unidad de Medida");
            respuesta.put("campo","CbxUndMedida.requestFocusInWindow()");
            return respuesta;
        }         
        if (P.getStock()<0) {
            respuesta.put("Mensaje","El campo Stock Contiene un valor no valido");
            respuesta.put("campo","TxtStock.requestFocusInWindow()");
            return respuesta;
        }         
        
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR TIPO DOCUMENTO" defaultstate="collapsed">
    public Map validarCamposTDocumento(Map respuesta){
        
        TipoDocumento T = (TipoDocumento)respuesta.get("TDocumento");
        
        if (T.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID del Tipo documento");
            return respuesta;
        } 
        if (T.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (T.getSiglas().equals("")) {
            respuesta.put("Mensaje","El campo Siglas se encuentra Vacio");
            respuesta.put("campo","TxtSiglas.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR UNIDAD MEDIDAS" defaultstate="collapsed">
    public Map validarCamposUndMedida(Map respuesta){
        
        UnidadMedidas Um = (UnidadMedidas)respuesta.get("UndMedidas");
        
        if (Um.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID de la Unidad de Medida");
            return respuesta;
        } 
        if (Um.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (Um.getSiglas().equals("")) {
            respuesta.put("Mensaje","El campo Siglas se encuentra Vacio");
            respuesta.put("campo","TxtSiglas.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR CATEGORIAS" defaultstate="collapsed">
    public Map validarCamposCategorias(Map respuesta){
        
        Categorias Ct = (Categorias)respuesta.get("Categorias");
        
        if (Ct.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID de la Categoria");
            return respuesta;
        } 
        if (Ct.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR ROLES" defaultstate="collapsed">
    public Map validarCamposRoles(Map respuesta){
        
        Roles Rl = (Roles)respuesta.get("Roles");
        
        if ((""+Rl.getIdRol()).equals("")) {
            respuesta.put("Mensaje","Error en el ID de la Categoria");
            return respuesta;
        } 
        if (Rl.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        }
        if (Rl.getSiglas().equals("")) {
            respuesta.put("Mensaje","El campo Siglas se encuentra Vacio");
            respuesta.put("campo","TxtSiglas.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
}
