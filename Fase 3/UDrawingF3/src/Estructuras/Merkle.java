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
public class Merkle {
    
    
    public class NodoAbb {

    Object info;
    NodoAbb derecha;
    NodoAbb izquierda;

    public NodoAbb(Object info) {
        this.info = info;
        this.derecha = null;
        this.izquierda = null;
    }
}
    
    
    NodoAbb raiz;

    public Merkle() {
        raiz = null;
    }
    
    public void insertar(Object info){
        raiz = addRecur(info,raiz);
    }
    
    public NodoAbb addRecur(Object inf, NodoAbb raiz){
        if(raiz == null){
            return new NodoAbb(inf);
        }else{
            int id = 1;
            int actual = 0;
            if(id < actual){
                raiz.izquierda = addRecur(inf,raiz.izquierda);
            }else if(actual < id){
                raiz.derecha = addRecur(inf,raiz.derecha);
            }
            return raiz;
        }       
    }
    
}
