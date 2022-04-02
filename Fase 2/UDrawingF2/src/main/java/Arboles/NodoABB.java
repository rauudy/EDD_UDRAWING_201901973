/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

/**
 *
 * @author DELL
 */
public class NodoABB {

    Object info;
    NodoABB derecha;
    NodoABB izquierda;

    public NodoABB(Object info) {
        this.info = info;
        this.derecha = null;
        this.izquierda = null;
    }
}
