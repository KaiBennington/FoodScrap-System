/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Lista {
    
    
    private List PermisosUsuario;

    public Lista(List PermisosUsuario) {
        this.PermisosUsuario = PermisosUsuario;
    }

    public Lista() {
    }

    public List getPermisosUsuario() {
        return PermisosUsuario;
    }

    public void setPermisosUsuario(List PermisosUsuario) {
        this.PermisosUsuario = PermisosUsuario;
    }

    
    
    
    
}
