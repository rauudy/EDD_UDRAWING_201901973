/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Block.*;

/**
 *
 * @author DELL
 */
public class Blockchain {
    Block inicio;
    int tamanio;
    
    public Blockchain() {
        
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public void agregarAlFinal(String valor) {
        Block nuevo = new Block();
        nuevo.setData(valor);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            Block aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }
    
    public String getValor(int posicion) throws Exception{
        if(posicion>=0 && posicion<tamanio){
            if (posicion == 0) {
                return inicio.getData();
            }else{
                Block aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getData();
            }
        } else {
            throw new Exception("No existe.");
        }
    }
    
    public boolean buscar(String referencia){
        Block aux = inicio;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getData()){
                encontrado = true;
            }
            else{
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }

}
