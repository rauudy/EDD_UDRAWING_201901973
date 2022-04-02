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

    ListM fila = new ListM();
    ListM col = new ListM();

    public void MatrizDispersa() {
        fila = new ListM();
        col = new ListM();
    }

    public void insertar(String valor, int i, int j) {
        NodoM fil = fila.buscar(i);
        NodoM com = col.buscar(j);
        String nuevoColor = buscar_Color(i, j);
        if (nuevoColor.equals("")) {
            if (fil == null && com == null) {
                //No existe Fila ni Columna
                caso1(valor, i, j);
            } else if (fil == null && com != null) {
                //Solo existe Col
                caso2(valor, i, j);
            } else if (fil != null && com == null) {
                //Solo existe Fila
                caso3(valor, i, j);
            } else {
                //Existe Fila y Columna
                caso4(valor, i, j);
            }
        } else {
            //Siguiente color
            siguienteColor(valor, i, j);
        }
    }

    public String buscar_Color(int i, int j) {
        NodoM cabecera = fila.raiz;
        while (cabecera != null) {
            NodoM aux = cabecera.abajo;
            while (aux != null) {
                if (aux.i == i && aux.j == j) {
                    return (String) aux.info;
                }
                aux = aux.abajo;
            }
            cabecera = cabecera.siguiente;
        }
        return "";
    }
    
    public void siguienteColor(String nColor, int i, int j){
        NodoM cabecera = fila.raiz;
        while(cabecera != null){
            NodoM aux = cabecera.abajo;
            while(aux != null){
                if(aux.i == i && aux.j == j){
                    aux.info = nColor;
                }
                aux = aux.abajo;
            }
            cabecera = cabecera.siguiente;
        }
    }

    public void caso1(String valor, int i, int j) {
        fila.insertar(i);
        col.insertar(j);

        NodoM fil = fila.buscar(i);
        NodoM com = col.buscar(j);
        NodoM nuevo = new NodoM(valor, i, j);

        fil.abajo = nuevo;
        nuevo.arriba = fil;
        com.derecha = nuevo;
        nuevo.izquierda = com;
    }


    public void caso2(String valor, int i, int j) {
        fila.insertar(i);

        NodoM fil = fila.buscar(i);
        NodoM com = col.buscar(j);
        boolean agregado = false;
        NodoM n = new NodoM(valor, i, j);
        NodoM aux = com.derecha;
        int cabecera;

        while (aux != null) {
            cabecera = aux.i;
            if (cabecera < i) {
                aux = aux.derecha;
            } else {
                n.derecha = aux;
                n.izquierda = aux.izquierda;
                aux.izquierda.derecha = n;
                aux.izquierda = n;
                agregado = true;
                break;
            }
        }
        if (agregado == false) {
            aux = com.derecha;
            while (aux.derecha != null) {
                aux = aux.derecha;
            }
            n.izquierda = aux;
            aux.derecha = n;
        }
        
        fil.abajo = n;
        n.arriba = fil;

    }

    
    public void caso3(String valor, int i, int j) {
        col.insertar(j);

        NodoM fil = fila.buscar(i);
        NodoM com = col.buscar(j);
        boolean agregado = false;
        NodoM nuevo = new NodoM(valor, i, j);
        NodoM aux = fil.abajo;
        int cabecera;

        while (aux != null) {
            cabecera = aux.j;
            if (cabecera < j) {
                aux = aux.abajo;
            } else {
                nuevo.abajo = aux;
                nuevo.arriba = aux.arriba;
                aux.arriba.abajo = nuevo;
                aux.arriba = nuevo;
                agregado = true;
                break;
            }
        }
        if (agregado == false) {
            aux = fil.abajo;
            while (aux.abajo != null) {
                aux = aux.abajo;
            }

            nuevo.arriba = aux;
            aux.abajo = nuevo;
        }
        
        com.derecha = nuevo;
        nuevo.izquierda = com;

    }

    
    public void caso4(String valor, int i, int j) {
        NodoM com = col.buscar(j);
        NodoM fil = fila.buscar(i);
        NodoM n = new NodoM(valor, i, j);
        boolean insertado = false;
        NodoM aux = com.derecha;
        int cabecera;

        while (aux != null) {
            cabecera = aux.i;
            if (cabecera < i) {
                aux = aux.derecha;
            } else {
                n.derecha = aux;
                n.izquierda = aux.izquierda;
                aux.izquierda.derecha = n;
                aux.izquierda = n;
                insertado = true;
                break;
            }
        }
        if (insertado == false) {
            aux = com.derecha;
            while (aux.derecha != null) {
                aux = aux.derecha;
            }
            n.izquierda = aux;
            aux.derecha = n;
        }

        insertado = false;
        aux = fil.abajo;

        while (aux != null) {
            cabecera = aux.j;
            if (cabecera < j) {
                aux = aux.abajo;
            } else {
                n.abajo = aux;
                n.arriba = aux.arriba;
                aux.arriba.abajo = n;
                aux.arriba = n;
                insertado = true;
                break;
            }
        }

        if (insertado == false) {
            aux = fil.abajo;
            while (aux.abajo != null) {
                aux = aux.abajo;
            }

            n.arriba = aux;
            aux.abajo = n;
        }
    }
    
    public void imprimir(){
        NodoM cabecera = fila.raiz;
        while(cabecera != null){
            NodoM aux = cabecera.abajo;
            while(aux != null){
                System.out.println("-----------------------------");
                System.out.println(aux.info + ", i= " + aux.i + ", j= " +aux.j);
                aux = aux.abajo;
            }
            cabecera = cabecera.siguiente;
        }
    }
    
    public void agregarCapa(MatrizDispersa nueva){
        if(nueva != null){
            NodoM cabecera = nueva.fila.raiz;
            while(cabecera != null){
                NodoM aux = cabecera.abajo;
                while(aux != null){
                    String color = buscar_Color(aux.i,aux.j);
                    if(color.equals("")){
                        this.insertar((String)aux.info,aux.i,aux.j);
                    }else{
                        siguienteColor((String)aux.info, aux.i,aux.j);
                    }

                    aux = aux.abajo;
                }
                cabecera = cabecera.siguiente;
            }
        }
    }
}
