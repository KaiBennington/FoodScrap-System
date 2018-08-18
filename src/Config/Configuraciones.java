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
   // setIconImage(new ImageIcon(getClass().getResource("/img/Titles/IconoLogo.png")).getImage());
    
    public static void limiteCaracteres(JTextField Input,int Limite, java.awt.event.KeyEvent evt){
        if (Input.getText().length() >= Limite) {
            evt.consume();
        }
    }
    
    public static void soloNumeros(java.awt.event.KeyEvent evt, JTextField Text) {
        char car = evt.getKeyChar();
        if (((car < '0' || car > '9')) && (car != KeyEvent.VK_BACK_SPACE)
                && (car != '.' || Text.getText().contains("."))) {
            evt.consume();
        }
    }
    
    public static void soloLetras(java.awt.event.KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
}
