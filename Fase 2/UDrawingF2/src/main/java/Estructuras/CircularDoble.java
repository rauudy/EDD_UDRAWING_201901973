/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class CircularDoble {

    NodoCD head;

    public CircularDoble() {
        head = null;
    }

    public void insertar(Object dato) {
        do {
            NodoCD p = new NodoCD(dato);
            if (head == null) {
                head = p;
                p.anterior = head;
                p.siguiente = head;
            } else {
                p.anterior = head.anterior;
                p.anterior.siguiente = p;
                p.siguiente = head;
                head.anterior = p;
            }
        } while (head!=null);
    }
    
    public void recorrer(){
        NodoCD p;
        if (head != null) {
            p = head;
            do {                
                System.out.println(p.datoM);
                p = p.siguiente;
            } while (p!=head);
        }else{
            System.out.println("Vacia");
        }
    }
    
    public int tamanio(){
        NodoCD p;
        int total=0;
        if (head != null) {
            p = head;
            total = 1;
            while (p.siguiente != head) {                
                p = p.siguiente;
                total++;
            }
        }else{
            System.out.println("vacia");
        }
        return total;
    }

}
