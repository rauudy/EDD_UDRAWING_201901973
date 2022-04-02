/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDrawingF2;
import Recursos.*;
import Arboles.*;
import Interfaz.*;
/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int cont = 0;
    public static ArbolB clientes = new ArbolB();
    public static Cliente actual ;
    
    public static void main(String[] args) {
        Inicio in = new Inicio();
        in.setVisible(true);
    }
    
}