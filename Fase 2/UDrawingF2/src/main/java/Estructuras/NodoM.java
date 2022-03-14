/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class NodoM {
    NodoM arriba;
    NodoM abajo;
    NodoM anterior;
    NodoM siguiente;
    int i,j;
    String info;

    public NodoM(int i, int j, String info) {
        arriba = null;
        abajo = null;
        anterior = null;
        siguiente = null;
        i = i;
        j = j;
        info = info;
    }
    
    @Override
    public String toString(){
        String f = "["+i + ","+ j +"]"+"INFO: "+info;
        return f;
    }
}
