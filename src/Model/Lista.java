/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Lista {
    
    private ArrayList<Ingredientes> ListaIngredientes = new ArrayList<>();

    public Lista() {
    }

    public ArrayList<Ingredientes> getListaIngredientes() {
        return ListaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingredientes> ListaIngredientes) {
        this.ListaIngredientes = ListaIngredientes;
    }
    
    
    
}
