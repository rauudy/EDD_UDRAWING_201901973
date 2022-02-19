/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

import Estructuras.PilaImage;

/**
 *
 * @author DELL
 */
public class NodoListaSimple {
    public Object infor;
    //PilaImage pila;
    public NodoListaSimple siguiente;

    public NodoListaSimple(Object infor) {
        this.infor = infor;
        this.siguiente = null;
        //this.pila = pila;
    }
}
