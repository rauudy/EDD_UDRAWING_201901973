/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class ListaAdyacencia {

    private final int MAXIMO_VERTICES;
    private final int MAXIMO_ARISTAS;
    private int aristas;
    private int matrix[][];
    
    public ListaAdyacencia(int nroVertices, int nroAristas) {
        MAXIMO_VERTICES = nroVertices;
        MAXIMO_ARISTAS = nroAristas;

        this.aristas = 0;

        matrix = new int[MAXIMO_VERTICES][MAXIMO_VERTICES];

        for (int i = 0; i < getMAX_VERTICES(); i++) {
            for (int j = 0; j < getMAX_VERTICES(); j++) {
                matrix[i][j] = 0;
            }
        }
    }

    //---------------------------------------------------
    
    public ListaAdyacencia(int nroVertices) {
        this(nroVertices, nroVertices);
    }

    public int getMAX_VERTICES() {
        return MAXIMO_VERTICES;
    }

    public int getMAX_ARISTAS() {
        return MAXIMO_ARISTAS;
    }
    
    public void insertaArista(int v1, int v2, int dist)
            throws ArrayIndexOutOfBoundsException, UnsupportedOperationException {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (aristas == MAXIMO_ARISTAS) {
            throw new UnsupportedOperationException("No se puede añadir más aristas");
        } else {
            matrix[v1][v2] = dist;
        }
    }
    
    public boolean existeArista(int v1, int v2) {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (matrix[v1][v2] != 0) {
            return true;
        }
        return false;
    }

    /**
     * Eliminar arista
     *
     * @param v1 vertice1
     * @param v2 vertice2
     */
    public void eliminaArista(int v1, int v2) {
        if (v1 >= MAXIMO_VERTICES || v2 >= MAXIMO_VERTICES) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (getMAX_VERTICES() - 1));
        } else if (matrix[v1][v2] == 0) {
            System.err.println("La arista NO existe");
        } else {
            matrix[v1][v2] = 0;
        }
    }

    public void borrarGrafo() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void impMatrix() {
        System.out.print(" ");
        for (int i = 0; i < MAXIMO_VERTICES; i++) {
            System.out.printf("  %3d", i);
        }
        System.out.println();
        for (int i = 0; i < MAXIMO_VERTICES; i++) {
            System.out.printf(" %3d", i);
            for (int j = 0; j < MAXIMO_VERTICES; j++) {
                System.out.printf(" %3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

// ----- Operaciones para obtener Lista de Adyacencia ----- //
    public boolean grafoVerticesAdyacentes(int v) {
        int auxiliar = 0;
        boolean estavacia = true;

        while (auxiliar < MAXIMO_VERTICES && estavacia) {
            if (matrix[v][auxiliar] == 1) {
                estavacia = false;
            } else {
                auxiliar = auxiliar + 1;
            }
        }

        return estavacia;
    }

    public int primeroListaAdy(int v) throws RuntimeException {
        int auxiliar = 0;
        boolean estavacia = true;

        while (auxiliar < MAXIMO_VERTICES && estavacia) {
            if (matrix[v][auxiliar] == 1) {
                estavacia = false;
            } else {
                auxiliar = auxiliar + 1;
            }
        }

        if (auxiliar == MAXIMO_VERTICES) {
            throw new RuntimeException("La lista de Adyacencia esta vacía");
        }
        return auxiliar;
    }

    public int proxAdy(int v, int ady) {
        int proximo = ady + 1;
        while (proximo < MAXIMO_VERTICES && matrix[v][proximo] == 0) {
            proximo = proximo + 1;
        }
        if (proximo == MAXIMO_VERTICES) {
            return -1;
        }
        return proximo;
    }

}
