/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

/**
 *
 * @author DELL
 */
public class NodoAbb {

    Object info;
    NodoAbb derecha;
    NodoAbb izquierda;

    public NodoAbb(Object info) {
        this.info = info;
        this.derecha = null;
        this.izquierda = null;
    }
}
