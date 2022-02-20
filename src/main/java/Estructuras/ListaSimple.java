/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

public class ListaSimple {
    private Cliente inicio;
    private int tamanio;

    public ListaSimple() {
        inicio=null;
        tamanio=0;
    }
       
    public boolean estaVacia(){
        return inicio==null;
    }
    
    public void insertar(int id, String nombre, int pasos, int ventanilla, int bw, int color){
        Cliente nuevo = new Cliente();

        nuevo.setId_cliente(id);
        nuevo.setNombre_cliente(nombre);
        nuevo.setImpr_color(color);
        nuevo.setImpr_bw(bw);
        nuevo.setPasos(Menu.pasos - pasos);
        
        
    }
    
    
}
