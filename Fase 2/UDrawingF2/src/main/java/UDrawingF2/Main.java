/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDrawingF2;
import Estructuras.*;
/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrizDispersa matriz = new MatrizDispersa();
        matriz.insertarNodoM(9,5,"a");
        matriz.insertarNodoM(0,4,"b");
        matriz.insertarNodoM(8,9,"c");
        matriz.insertarNodoM(8,10,"d");
        matriz.insertarNodoM(5,4,"e");
        matriz.insertarNodoM(5,9,"f");
        matriz.imprimirFila();
        matriz.imprimirColumna();
    }
    
}
