/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Recursos.*;
import UDrawingF2.*;
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
        String dott="digraph G{\nlabel=\""+title+"\";\nnode [shape=square];\n";        
        String nodos = "";
        String conexiones = "";
        String rank = "rank=same{";
        int cont = 0;
        Nodo aux = raiz;
        String ant = "";
        while(aux!=null){
            nodos += "N"+aux.hashCode()+"[label=\""+((Album)aux.datoM).getNombre()+"\"];\n";
            if(cont==0){
                rank += "N"+aux.hashCode();
            }else{
                rank += ",N"+aux.hashCode();
            }
            if(!ant.equals("")){
                conexiones += ant+"->N"+aux.hashCode()+";\n";
                conexiones += "N"+aux.hashCode()+"->"+ant+";\n";
            }
            Nodo temp = ((Album)aux.datoM).getImages().raiz;
            String ant2 = "";
            while(temp != null){
                nodos += "N"+temp.hashCode()+"[label=\""+((int)temp.datoM)+"\"];\n";
                if(!ant2.equals("")){
                    conexiones += ant2 + "->N"+temp.hashCode()+";\n";
                }else{
                    conexiones += "N"+aux.hashCode() + "->N"+temp.hashCode()+";\n";
                }
                ant2 = "N"+temp.hashCode();
                temp = temp.siguiente;
            }
            
            ant = "N"+aux.hashCode();
            aux = aux.siguiente;
            cont++;
        }
        dott+=nodos + rank + "};\n" + conexiones+"\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void graficarTop5(String title){
        String dott="digraph G{\nN0[shape=record,label=\"{Top|1|2|3|4|5}";              
        String nombres = "{Img";
        String cantidad = "{Cantidad";
        Nodo aux = raiz;
        for(int i = 0; i<5; i++){
            if(aux!=null){
                nombres += "|Imagen "+ ((Image)aux.datoM).getId();
                cantidad += "|"+((Image)aux.datoM).getSize()+ " capas";
                aux = aux.siguiente;
            }else{
                nombres += "|";
                cantidad += "|";
            }
        }
        nombres += "}";
        cantidad += "}";
        dott += "|" + nombres + "|" + cantidad + "\"];";
        
        dott += "\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.cont = 0;
    }
    

}
