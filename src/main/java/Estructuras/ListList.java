
package Estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListList {
    private Cliente primero;
    private int tamanio;

    public ListList() {
        primero = null;
        tamanio=0;
    }
    
    public boolean estaVacio(){
        return primero == null;
    }
    
    public void insertar_listEspera(int id_cliente, String nombre, int color, int bw, int vent, int pasos){
        Cliente nuevo = new Cliente();
        
        nuevo.setId_cliente(id_cliente);
        nuevo.setNombre_cliente(nombre);
        nuevo.setImg_color(0);
        nuevo.setImg_bw(0);
        nuevo.setImpr_color(color);
        nuevo.setImpr_bw(bw);
        nuevo.setVentanilla(vent);
        nuevo.setPasos(pasos);
        nuevo.setPilaImg(new PilaImage());
        
        if (estaVacio()) {
            primero = nuevo;
            primero.setAnt(primero);
            primero.setSig(primero);
            System.out.println("-- Cliente " + nombre + " Ingresa a Lista de Espera");
            tamanio++;
        } else {

            nuevo.setSig(primero);
            nuevo.setAnt(primero.getAnt());
            primero.setAnt(nuevo);
            nuevo.getAnt().setSig(nuevo);
            primero = nuevo;
            System.out.println("-- Cliente " + nombre + " Ingresa a Lista de Espera");
            tamanio++;
        }
    }
    
    public void insetar_imagen(int id_cliente, Image image){
        Cliente aux = primero;
        if (aux != null) {
            for (int i = 0; i < tamanio; i++) {
                if (aux.getId_cliente()== id_cliente) {
                    aux.getPilaImg().push(image.getId_cliente(), image.getId_img(), image.getColor());
                    break;
                }
                aux = aux.getSig();
            }
        }
    }
    
    public void eliminar() {
        Cliente aux = primero;
        if (aux != null) {
            for (int i = 0; i < tamanio + 1; i++) {
                if (aux.getImpr_color()+ aux.getImpr_bw()== aux.getPilaImg().no_nodos()) {
                    Cliente aux2 = aux;
                    aux.getAnt().setSig(aux2.getSig());
                    aux.getSig().setAnt(aux2.getAnt());

                   //-----Menu.ListaAtendidos.insertarOrden(aux.getId_cliente(), aux.getNombre_cliente(), aux.getPasos(), aux.getVentanilla(), aux.getImpr_bw(), aux.getImpr_color());
                    System.out.println("Cliente " + aux.getNombre_cliente() + " atendido");
                    tamanio--;
                    break;
                }
                aux = aux.getSig();
            }
        }
    }
    
    public void graphiz_listEspera() {
        String dot = "";
        dot = "digraph G{ rankdir=TB; labelloc=t; label=\"LISTA CLIENTES EN ESPERA\"; fontsize=50; ";
        Cliente aux = primero;
        for (int i = 0; i < tamanio; i++) {
            dot = dot + String.valueOf(i) + "[label= \"Id Cliente: " + String.valueOf(aux.getId_cliente()) + " - Nombre: " + aux.getNombre_cliente()+ "\" shape=rectangle fontsize=30]; \n";
            aux = aux.getSig();
        }
        aux = primero;
        int contadoraux = 0;
        for (int i = 0; i < tamanio; i++) {
            Cliente aux2 = aux.getSig();
            if (i != tamanio - 1) {
                dot = dot + String.valueOf(contadoraux) + "->" + String.valueOf(contadoraux + 1) + " [constraint=false]; \n";
            }
            contadoraux++;
            aux = aux.getSig();
        }

        aux = primero;

        for (int i = 0; i < tamanio; i++) {
            int aux2 = aux.getPilaImg().no_nodos();
            if (aux2 != 0) {
                dot = dot + aux.getPilaImg().graphviz_pila(String.valueOf(i));
            }
            aux = aux.getSig();

        }

        dot = dot + String.valueOf(tamanio - 1) + "-> 0 [constraint=false] \n   0 ->" + String.valueOf(tamanio - 1) + "[constraint=false]\n";
        dot = dot + "}";

        try {
            String Contenido = dot;
            File file = null;
            file = new File("List_Espera.dot");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
            
            ProcessBuilder proceso = null;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "ListEspera.png", "List_Espera.dot");
            proceso.redirectErrorStream(true);
            proceso.start();

        } catch (IOException e) {
        }

        
    }
    
    public Cliente buscar_susImage(int id){
        Cliente aux = primero;
        if (primero.getAnt().getId_cliente()== id) {
            return primero.getAnt();
        }
        if (aux != null) {
            for (int i = 0; i < 100; i++) {
                if (aux.getId_cliente()== id) {
                    return aux;
                }
                aux = aux.getSig();
            }

        }
        return aux; 
    }
    
}
