/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class ListM {
    NodoM raiz, ultimo;

    public ListM(){
        this.raiz = null;
        this.ultimo = null;
    }

    public void insertar(int n) {
        NodoM nuevo = new NodoM(n);
        if (raiz == null) {
            raiz = ultimo = nuevo;
        } else {
            ordenar(nuevo);
        }
    }

    public void ordenar(NodoM nodo) {
        NodoM aux = raiz;

        while (aux != null) {
            if ((int) aux.info < (int) nodo.info) {
                aux = aux.siguiente;
            } else {
                if (aux == raiz) {
                    nodo.siguiente = aux;
                    aux.anterior = nodo;
                    raiz = nodo;
                    return;
                } else {
                    nodo.anterior = aux.anterior;
                    aux.anterior.siguiente = nodo;
                    nodo.siguiente = aux;
                    aux.anterior = nodo;
                    return;
                }
            }
        }

        if (ultimo == raiz) {
            nodo.anterior = raiz;
            raiz.siguiente = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
            nodo.anterior = ultimo;
            ultimo = nodo;
        }
    }

    public NodoM buscar(int valor) {
        NodoM aux = raiz;
        while (aux != null) {
            if ((int) aux.info == valor) {
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public void imprimir() {
        NodoM aux = raiz;
        while (aux != null) {
            System.out.println("Cabecera: " + aux.info);
            aux = aux.siguiente;
        }
    }

    public int max() {
        NodoM aux = raiz;
        while (aux.siguiente != null) {
            aux = aux.siguiente;
        }
        return (int) aux.info;
    }
}
