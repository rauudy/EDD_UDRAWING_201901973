/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

/**
 *
 * @author DELL
 */
public class ArbolB {
    final int orden_arbol = 5;
    PaginaB raiz;
    
    public ArbolB() {
        this.raiz = new PaginaB();
    }
    public void insertar(int id) {
        NodoB nodo = new NodoB(id);
        NodoB obj = insertar_en_pagina(nodo, raiz);
        if (obj != null) {
            raiz = new PaginaB();
            raiz.insertar(obj);
            raiz.hoja = false;
        }
    }

    private NodoB insertar_en_pagina(NodoB nodo, PaginaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            return  (rama.contador == orden_arbol)? dividir(rama): null;
        } else {
            NodoB temp = rama.primero;
            do {
                if (nodo.id == temp.id) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_pagina(nodo, temp.izquierda);
                    return validar_division(obj, rama);
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_pagina(nodo, temp.derecha);
                    return validar_division(obj, rama);
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    private NodoB validar_division(NodoB obj, PaginaB rama){
        if (obj instanceof NodoB) {
            rama.insertar((NodoB) obj);
            if (rama.contador == orden_arbol) {
                return dividir(rama);
            }
        }
        return null;
    }

    private NodoB dividir(PaginaB rama) {
        int val = -999;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        PaginaB rderecha = new PaginaB();
        PaginaB rizquierda = new PaginaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            if (cont < 3) {
                temp = new NodoB(aux.id, aux.izquierda,aux.siguiente.izquierda);
                rizquierda.hoja= !(temp.derecha != null && temp.izquierda != null);
                rizquierda.insertar(temp);
            } else if (cont == 3) {
                val = aux.id;
            } else {
                temp = new NodoB(aux.id, aux.izquierda,aux.derecha);
                rderecha.hoja= !(temp.derecha != null && temp.izquierda != null);
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val,rizquierda,rderecha);
        return Nuevito;
    }
}
