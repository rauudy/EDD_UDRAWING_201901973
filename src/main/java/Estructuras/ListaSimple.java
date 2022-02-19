/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import Nodos.*;

/**
 *
 * @author DELL
 */
public class ListaSimple {
    private NodoListaSimple inicio;
    private int tamanio;

    public ListaSimple() {
        inicio=null;
        tamanio=0;
    }
    
       
    public boolean estaVacia(){
        return inicio==null;
    }
    
    public void insertar(Object inf){
        NodoListaSimple nuevo = new NodoListaSimple(inf);
        NodoListaSimple puntero=inicio;
        
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            while (puntero.siguiente!=null) {                
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nuevo;
        }
        tamanio+=1;
    }
    
    public void imprimir(){
        NodoListaSimple actual = inicio;
        
        while (actual!=null) {            
            System.out.println(actual.infor + ",");
            actual = actual.siguiente;
        }
    }
}
