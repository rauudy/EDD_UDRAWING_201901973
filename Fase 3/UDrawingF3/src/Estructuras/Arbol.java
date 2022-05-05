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
public class Arbol {
    
    public class nodo{
        int id;
        int num;
        String hash1;
        String hash2;
        nodo izquierda;
        nodo derecha;

        public nodo() {
            id = 0;
            num = 0;
            hash1 = "";
            hash2 = "";
            izquierda = null;
            derecha = null;
        }
    }
    
    nodo raiz;

    public Arbol() {
        this.raiz = null;
    }
    
    public void crear(){
        
    }
    
    public void unir(){
        
    }
    
}
