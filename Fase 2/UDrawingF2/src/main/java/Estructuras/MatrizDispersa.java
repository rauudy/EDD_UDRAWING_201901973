/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class MatrizDispersa {
    NodoM raiz;

    public MatrizDispersa() {
        raiz = new NodoM(-1, -1, "Raiz");
    }

    public NodoM insertarEnFila(NodoM nuevo, NodoM cabeceraFila) {
        NodoM actual = cabeceraFila;
        boolean mayorEncontrado = false;
        while (true) {
            if (actual.i > nuevo.i) {
                mayorEncontrado = true;
                break;
            }
            if (actual.siguiente != null) {
                actual = actual.siguiente;
            } else {
                break;
            }
        }
        if (mayorEncontrado) {
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        } else {
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
        return nuevo;
    }

    public NodoM insertarEnColumna(NodoM nuevo, NodoM cabeceraColumna) {
        NodoM actual = cabeceraColumna;
        boolean mayorEncontrado = false;
        while (true) {
            if (actual.j > nuevo.j) {
                mayorEncontrado = true;
                break;
            }
            if (actual.abajo != null) {
                actual = actual.abajo;
            } else {
                break;
            }
        }
        if (mayorEncontrado) {
            nuevo.abajo = actual;
            nuevo.arriba = actual.arriba;
            actual.arriba.abajo = nuevo;
            actual.arriba = nuevo;
        } else {
            actual.abajo = nuevo;
            nuevo.arriba = actual;
        }
        return nuevo;
    }

    public void imprimirFila() {
        NodoM actual = raiz;
        while (actual != null) {
            System.out.println(String.valueOf(actual.info) + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void imprimirColumna() {
        NodoM actual = raiz;
        while (actual != null) {
            System.out.println(String.valueOf(actual.info));
            actual = actual.abajo;
        }
        System.out.println();
    }

    public NodoM buscarColumna(int i) {
        NodoM actual = raiz;
        while (actual != null) {
            if (actual.i == i) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public NodoM buscarFila(int j) {
        NodoM actual = raiz;
        while (actual != null) {
            if (actual.j == j) {
                return actual;
            }
            actual = actual.abajo;
        }
        return null;
    }

    public NodoM crearColumna(int i) {
        return insertarEnFila(new NodoM(i, -1, "Col"), raiz);
    }

    public NodoM crearFila(int j) {
        return insertarEnColumna(new NodoM(-1, j, "Row"), raiz);
    }

    public void insertarNodoM(int i, int j, String info) {
        NodoM nuevo = new NodoM(i, j, info);

        NodoM columna = buscarColumna(i);
        NodoM fila = buscarFila(j);

        //Caso 1
        if (columna == null && fila == null) {
            columna = crearColumna(i);
            fila = crearFila(j);

            nuevo = insertarEnFila(nuevo, fila);
            nuevo = insertarEnColumna(nuevo, columna);
        }
        //Caso 2
        if (columna != null && fila == null) {
            fila = crearFila(j);
            nuevo = insertarEnFila(nuevo, fila);
            nuevo = insertarEnColumna(nuevo, columna);
        }
        //Caso 3
        if (columna == null && fila != null) {
            columna = crearColumna(i);
            nuevo = insertarEnFila(nuevo, fila);
            nuevo = insertarEnColumna(nuevo, columna);
        } //Caso 4
        else {
            nuevo = insertarEnFila(nuevo, fila);
            nuevo = insertarEnColumna(nuevo, columna);
        }
    }
}
