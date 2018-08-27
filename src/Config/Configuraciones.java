/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;



/**
 *
 * @author USUARIO
 */
public class Configuraciones {
    
    // Metodo para Limitar el numero de caracteres Digitados en un campo de texto
    public static void limiteCaracteres(JTextField Input,int Limite, java.awt.event.KeyEvent evt){
        if (Input.getText().length() >= Limite) {
            evt.consume();
        }
    }
    
    // Metodo para validar que un campo de texto solo reciba numeros
    public static void soloNumeros(java.awt.event.KeyEvent evt, JTextField Text) {
        char car = evt.getKeyChar();
        if (((car < '0' || car > '9')) && (car != KeyEvent.VK_BACK_SPACE)
                && (car != '.' || Text.getText().contains("."))) {
            evt.consume();
        }
    }
    
    // Metodo para validar que un campo de texto solo reciba Letras
    public static void soloLetras(java.awt.event.KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
}
