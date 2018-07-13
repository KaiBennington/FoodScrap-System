/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author USUARIO
 */
public class Generador {
    private static String clave;

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        Generador.clave = clave;
    }
    
    
    public static boolean generarContraseña() {
       String caracteres[] = {
           "q","w","e","r","t","y","u","i","o","p",
           "a","s","d","f","g","h","j","k","l","ñ",
           "z","x","c","v","b","n","m",
           "1","2","3","4","5","6","7","8","9","0",
           "Q","A","Z","X","S","W","E","D","C","V",
           "F","R","T","G","B","N","H","Y","U","J",
           "M","I","K","O","L","P","Ñ"
       };
        
        String Generado = "";
        boolean Rta = false ;
        for (int i = 0; i < 10; i++) {
            int Aleatorio = (int)Math.floor(Math.random()*(63 - 0)+ 0);          
            if (Generado.length() < 7 ) {
                Generado = Generado + caracteres[Aleatorio];
                clave = Generado;
                Rta = true;
            }	
        }
        return Rta;			
        }
    }

