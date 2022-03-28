/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

/**
 *
 * @author DELL
 */
public class ArbolBB<E extends Comparable<E>>{
    NodoBB<E> raiz;

    public ArbolBB() {
        this.raiz=null;
    }
    
    public void insertar(E dato){
        raiz = insertarNodo(raiz, dato);
    }
    
    private NodoBB<E> insertarNodo(NodoBB<E> raiz, E dato){
        if (raiz==null) 
            raiz= new NodoBB<E>(dato);
        else if(dato.compareTo(raiz.dato)<0)
            raiz.izquierdo=insertarNodo(raiz.izquierdo,dato);
        else if(dato.compareTo(raiz.dato)>0)
            raiz.derecho=insertarNodo(raiz.derecho, dato);
        return raiz;
    }
    
    public void preOrden(){
        preOrden(this.raiz);
    }
    
    public void inOrden(){
        inOrden(this.raiz);
    }
    
    public void postOrden(){
        postOrden(this.raiz);
    }
    
    private void preOrden(NodoBB<E> raiz){
        if(raiz!=null){
            System.out.print(raiz.dato.toString() + ", ");
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
        }
    }
    
    private void inOrden(NodoBB<E> raiz){
        if(raiz!=null){
            inOrden(raiz.izquierdo);
            System.out.print(raiz.dato.toString() + ", ");
            inOrden(raiz.derecho);
        }
    }
    
    private void postOrden(NodoBB<E> raiz){
        if(raiz!=null){
            postOrden(raiz.izquierdo);
            postOrden(raiz.derecho);
            System.out.print(raiz.dato.toString() + ", ");
        }
    }
}

class NodoBB<E>{
    E dato;
    NodoBB<E> izquierdo, derecho;
    boolean id;

    public NodoBB(E dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    
}
