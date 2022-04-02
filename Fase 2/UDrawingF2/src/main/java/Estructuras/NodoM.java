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
    
    int i,j;
    Object info;
    NodoM arriba;
    NodoM abajo;
    NodoM derecha;
    NodoM izquierda;
    NodoM siguiente;
    NodoM anterior;

    public NodoM(Object info) {
        info = info;
        i = 0;
        j = 0;
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
        anterior = null;
        siguiente = null;
    }
    
    public NodoM(Object info,int i, int j) {
        info = info;
        i = i;
        j = j;
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
        anterior = null;
        siguiente = null;
        
        
    }

    
    
    
    
    @Override
    public String toString(){
        String f = "["+i + ","+ j +"]"+"INFO: "+info;
        return f;
    }
}
