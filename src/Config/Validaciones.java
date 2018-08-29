
package Config;

import Model.Categorias;
import Model.CierreSucursal;
import Model.Gastos;
import Model.Ingredientes;
import Model.Platos;
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
 * @author KAI BENNINGTON - MediaSoft Developers
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
    
    //<editor-fold desc="VALIDAR PRODUCTO" defaultstate="collapsed">
    public Map validarCamposProductos(Map respuesta){
        
        Productos P = (Productos)respuesta.get("Producto");
        
        if (P.getCodigo().equals("")) {
            respuesta.put("Mensaje","Error en el ID del Proveedor");
            return respuesta;
        } 
        if (P.getIdProveedor().equals(Integer.toString(0))) {
            respuesta.put("Mensaje","Debe seleccionar un Proveedor");
            respuesta.put("campo","CbxProveedor.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getIdCategoria().equals(Integer.toString(0))) {
            respuesta.put("Mensaje","Debe seleccionar una Categoria");
            respuesta.put("campo","CbxCategoria.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getPrecioCosto()< 0 || "".equals(P.getPrecioCosto())) {
            respuesta.put("Mensaje","El campo Precio Costo debe contener un valor valido");
            respuesta.put("campo","TxtPrecioCosto.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getCantidad()<= 0) {
            respuesta.put("Mensaje","El campo Cantidad debe contener como minimo 1");
            respuesta.put("campo","TxtCantidad.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getIdUMedida().equals(Integer.toString(0))) {
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
    
    //<editor-fold desc="VALIDAR PLATOS" defaultstate="collapsed">
    public Map validarCamposPlatos(Map respuesta){
        
        Platos P = (Platos)respuesta.get("Plato");
        
        if (P.getIdPlato().equals("") || P.getIdPlato() == null) {
            respuesta.put("Mensaje","Error en el ID del Plato");
            return respuesta;
        } 
        if (P.getCodigoPlato().equals("")) {
            respuesta.put("Mensaje","El campo Codigo se encuentra Vacio");
            respuesta.put("campo","TxtCodigo.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getSeccion().equals("") || P.getSeccion().equalsIgnoreCase("Seleccione...")) {
            respuesta.put("Mensaje","Debe seleccionar una Seccion valida");
            respuesta.put("campo","CbxSeccion.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getNombre().equals("")) {
            respuesta.put("Mensaje","El campo Nombre se encuentra Vacio");
            respuesta.put("campo","TxtNombre.requestFocusInWindow()");
            return respuesta;
        } 
        if (P.getValor() < 1 || "".equals(P.getValor())) {
            respuesta.put("Mensaje","El campo Valor se encuentra Vacio o contiene un valor no valido");
            respuesta.put("campo","TxtValor.requestFocusInWindow()");
            return respuesta;
        } 
//        if (P.getPrecioCosto()< 0 || "".equals(P.getPrecioCosto())) {
//            respuesta.put("Mensaje","El campo Precio Costo debe contener un valor valido");
//            respuesta.put("campo","TxtPrecioCosto.requestFocusInWindow()");
//            return respuesta;
//        } 
//        if (P.getCantidad()<= 0) {
//            respuesta.put("Mensaje","El campo Cantidad debe contener como minimo 1");
//            respuesta.put("campo","TxtCantidad.requestFocusInWindow()");
//            return respuesta;
//        }           
        
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
    
    //<editor-fold desc="VALIDAR INGREDIENTES" defaultstate="collapsed">
    public Map validarCamposIngredientes(Map respuesta){
        
        Ingredientes In = (Ingredientes)respuesta.get("Ingrediente");
        
        if (In.getIdPlato().equalsIgnoreCase("")) {
            respuesta.put("Mensaje","Error en el ID del Ingrediente");
            return respuesta;
        } 
        if (In.getIngrediente().equalsIgnoreCase("")) {
            respuesta.put("Mensaje","Debe seleccionar un Ingrediente valido");
            respuesta.put("campo","CbxIngrediente.requestFocusInWindow()");
            return respuesta;
        }
        if (In.getCantidad().equalsIgnoreCase("") || In.getCantidad() == null) {
            respuesta.put("Mensaje","Verifique que haya digitado una cantidad valida");
            respuesta.put("campo","TxtCantidad.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
//        boolean val = respuesta.isEmpty();
//        System.out.println("valor vacio "+val);
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR GASTOS" defaultstate="collapsed">
    public Map validarCamposGastos(Map respuesta){
        
        Gastos Gs = (Gastos)respuesta.get("Gasto");
        
        if (Gs.getIdFactura() <= 0 || "".equals(Gs.getIdFactura())) {
            respuesta.put("Mensaje","Error en el Numero de Factura");
            return respuesta;
        } 
        if (Gs.getDescripcion().equalsIgnoreCase("")) {
            respuesta.put("Mensaje","El campo Descripción se encuentra vacio");
            respuesta.put("campo","TxtDescripcionGasto.requestFocusInWindow()");
            return respuesta;
        }
        if (Gs.getValor() <= 0 || "".equals(Gs.getValor())) {
            respuesta.put("Mensaje","El campo Valor se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtValorGasto.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
        return respuesta;
    }
    //</editor-fold>
    
    //<editor-fold desc="VALIDAR CIERRE SUCURSALES" defaultstate="collapsed">
    public Map validarCamposCierreSucursal(Map respuesta){
        
        CierreSucursal Cs = (CierreSucursal)respuesta.get("CierreSucursal");
        
        if (Cs.getNumFactura() <= 0 || "".equals(Cs.getNumFactura())) {
            respuesta.put("Mensaje","Error en el Numero de Factura");
            return respuesta;
        } 
        if (Cs.getFechaFactura() == null) {
            respuesta.put("Mensaje","El campo Fecha se encuentra vacio");
            respuesta.put("campo","LblFecha.requestFocusInWindow()");
            return respuesta;
        }
        if (Cs.getSucursal() == null || Cs.getSucursal().equalsIgnoreCase("") || Cs.getSucursal().equalsIgnoreCase("Seleccione...")) {
            respuesta.put("Mensaje","El campo Sucursal se encuentra vacio");
            respuesta.put("campo","CbxSucursal.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getP_Sale()) || Cs.getP_Sale() == 0 ) {
            respuesta.put("Mensaje","El campo Papa Sale se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtPapaSale.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getP_Devuelve())) {
            respuesta.put("Mensaje","El campo Papa Devuelve se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtPapaDevuelve.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getBaseInicial())) {
            respuesta.put("Mensaje","El campo Base Inicial se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtBaseInicial.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getAlcancia()) || Cs.getAlcancia() < 0 ) {
            respuesta.put("Mensaje","El campo Alcancia se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtAlcancia.requestFocusInWindow()");
            return respuesta;
        }   
        if (Cs.getNetoExistente()< 0 || "".equals(Cs.getNetoExistente())) {
            respuesta.put("Mensaje","El campo Neto Existente se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtNetoExistente.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getTotalNeto())) {
            respuesta.put("Mensaje","El campo Total Neto se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtTotalNeto.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getTotalBruto())) {
            respuesta.put("Mensaje","El campo Total Bruto se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","TxtTotalBruto.requestFocusInWindow()");
            return respuesta;
        }
        if (Cs.getTotalBruto() <= 0) {
            respuesta.put("Mensaje","No se efectuaron ventas para generar un cierre\nVerifique la pestaña de platos vendidos");
            respuesta.put("campo","TxtTotalBruto.requestFocusInWindow()");
            return respuesta;
        }
        if ("".equals(Cs.getResta())) {
            respuesta.put("Mensaje","El campo Resta se encuentra vacio ó\n Contiene un valor incorrecto");
            respuesta.put("campo","Lbl_Resta.requestFocusInWindow()");
            return respuesta;
        }
        respuesta.remove("Mensaje");
        return respuesta;
    }
    //</editor-fold>
    
}
