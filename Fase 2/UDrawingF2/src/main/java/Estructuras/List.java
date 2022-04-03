/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Recursos.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author DELL
 */
public class List {
    
    public class Nodo{        
        Object datoM;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(Object datoM) {
            this.datoM = datoM;
            this.siguiente = null;
            this.anterior = null;
        }       
    }

    Nodo raiz;

    public List() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public int tamanio() {
        Nodo aux = raiz;
        int total = 0;
        while (aux != null) {
            total += 1;
            aux = aux.siguiente;
        }
        return total;
    }

    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacio()) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public void ordenar(Nodo nodo) {
        Nodo aux1 = raiz;
        Nodo aux2 = null;
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
        Nodo nuevo = new Nodo(img);
        if (estaVacio()) {
            raiz = nuevo;
        } else {
            ordenar(nuevo);
        }
    }
    
    public void eliminar(int i){
        raiz = deleteRecur( i, raiz);
    }
    
    public Nodo deleteRecur(int n, Nodo nodo){
        Nodo aux = nodo;
        while(aux != null){
            Album miLista = (Album)aux.datoM;
            List imgs = miLista.getImages();
            aux = aux.siguiente;
        }
        return nodo;
    }
    
    public void graficar(String title){
        String resultado="digraph G{\nlabel=\""+title+"\";\nnode [shape=square];\n";        
        String nodos = "";
        String conexiones = "";
        String rank = "rank=same{";
        int c = 0;
        Nodo aux = raiz;
        String anterior = "";
        while(aux!=null){
            nodos += "N"+aux.hashCode()+"[label=\""+((Album)aux.datoM).getNombre()+"\"];\n";
            if(c==0){
                rank += "N"+aux.hashCode();
            }else{
                rank += ",N"+aux.hashCode();
            }
            if(!anterior.equals("")){
                conexiones += anterior+"->N"+aux.hashCode()+";\n";
                conexiones += "N"+aux.hashCode()+"->"+anterior+";\n";
            }
            Nodo auxiliar = ((Album)aux.datoM).getImages().raiz;
            String anterior2 = "";
            while(auxiliar != null){
                nodos += "N"+auxiliar.hashCode()+"[label=\""+((int)auxiliar.datoM)+"\"];\n";
                if(!anterior2.equals("")){
                    conexiones += anterior2 + "->N"+auxiliar.hashCode()+";\n";
                }else{
                    conexiones += "N"+aux.hashCode() + "->N"+auxiliar.hashCode()+";\n";
                }
                anterior2 = "N"+auxiliar.hashCode();
                auxiliar = auxiliar.siguiente;
            }
            
            anterior = "N"+aux.hashCode();
            aux = aux.siguiente;
            c++;
        }
        resultado+=nodos + rank + "};\n" + conexiones+"\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    

}
