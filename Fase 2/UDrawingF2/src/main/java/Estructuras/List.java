/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Recursos.*;

/**
 *
 * @author DELL
 */
public class List {

    NodoL raiz;

    public List() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public int tamanio() {
        NodoL aux = raiz;
        int total = 0;
        while (aux != null) {
            total += 1;
            aux = aux.siguiente;
        }
        return total;
    }

    public void insertar(Object dato) {
        NodoL nuevo = new NodoL(dato);
        if (estaVacio()) {
            raiz = nuevo;
        } else {
            NodoL aux = raiz;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void ordenar(NodoL nodo) {
        NodoL aux1 = raiz;
        NodoL aux2 = null;
        while (aux1 != null) {
            aux2 = aux1;
            if (((Image) aux1.datoM).getSize() > ((Image) nodo.datoM).getSize()) {
                aux1 = aux1.siguiente;
            } else {
                if (aux1 == raiz) {
                    nodo.siguiente = aux1;
                    aux1.anterior = nodo;
                    raiz = nodo;
                    return;
                } else {
                    nodo.anterior = aux1.anterior;
                    aux1.anterior.siguiente = nodo;
                    nodo.siguiente = aux1;
                    aux1.anterior = nodo;
                    return;
                }
            }
        }

        if (aux2 == raiz) {
            nodo.anterior = raiz;
            raiz.siguiente = nodo;
        } else {
            aux2.siguiente = nodo;
            nodo.anterior = aux2;
        }
    }

    public void insertarOrdenado(Image img) {
        NodoL nuevo = new NodoL(img);
        if (estaVacio()) {
            raiz = nuevo;
        } else {
            ordenar(nuevo);
        }
    }
    
    public void eliminar(int i){
        raiz = deleteRecur( i, raiz);
    }
    
    public NodoL deleteRecur(int n, NodoL nodo){
        NodoL aux = nodo;
        while(aux != null){
            Album miLista = (Album)aux.datoM;
            List imgs = miLista.getImages();
            aux = aux.siguiente;
        }
        return nodo;
    }
    

}
