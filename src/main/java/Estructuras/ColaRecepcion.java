package Estructuras;
import Nodos.*;

public class ColaRecepcion {
    private NodoCola inicioCola, finalCola;
    String Cola ="";

    public ColaRecepcion(){
        inicioCola = null;
        finalCola = null;

    }

    public boolean ColaVacia(){
        if (inicioCola == null) {
            return true;            
        } else {
            return false;            
        }
    }

    public void Insertar(String id_cliente,String nombre_cliente,String img_color,String img_bw){
        NodoCola nuevo_nodo = new NodoCola();
        nuevo_nodo.id_cliente = id_cliente;
        nuevo_nodo.nombre_cliente = nombre_cliente;
        nuevo_nodo.img_color = img_color;
        nuevo_nodo.img_bw = img_bw;
        nuevo_nodo.siguiente = null;

        if (ColaVacia()) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;            
        }
    }

    public NodoCola Extraer(){
        if (!ColaVacia()) {
            String id_cliente = inicioCola.id_cliente;
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                NodoCola aux = inicioCola;
                inicioCola = inicioCola.siguiente;
                return aux;
            }
        } else {
            System.out.println("Cola vacia.");
        }
        return null;
    }
    
    public void MostrarContenido(){
        NodoCola recorrido = inicioCola;
        String ColaInvertida ="";
        while(recorrido != null){
            Cola +="ID: "+recorrido.id_cliente+" - Nombre: "+recorrido.nombre_cliente+" - Color: "+recorrido.img_color+" - BW: "+recorrido.img_bw+"->" ;
            recorrido = recorrido.siguiente;
        }
        String cadena [] = Cola.split("->");

        for(int i = cadena.length-1; i>=0;i--){
            ColaInvertida += " -> "+cadena[i];
        }
        System.out.println(ColaInvertida);
        Cola="";
    }
}
