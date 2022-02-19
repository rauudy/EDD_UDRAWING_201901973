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
public class PilaImage {
    private NodoPila cima;
    private int tamanio;

    public PilaImage() {
        cima=null;
        tamanio=0;
    }
    
       
    public boolean estaVacia(){
        return cima==null;
    }
    
    public void push(Object inf){
        NodoPila nuevo = new NodoPila(inf);
        
        if (estaVacia()) {
            cima = nuevo;
        } else {
            nuevo.siguiente = cima;
            cima = nuevo;
        }
        tamanio+=1;
    }
    
    public void cima(){
        System.out.println("El que esta en la cima es: "+cima.inf);
    }
}
