package Estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ColaRecepcion {
    private Cliente primero;
    private int tamanio,tam2;

    public ColaRecepcion() {
        primero = null;
        tamanio=0;
        tam2=0;
    }
    
    public boolean estaVacio(){
        return primero == null;
    }
    
    public int obtenerCola(){
        return tam2;
    }
    
    public void insertarR(int id_cliente, String nombre, int color, int bw, int paso) {
        Cliente nuevo = new Cliente();
        nuevo.setId_cliente(id_cliente);
        nuevo.setNombre_cliente(nombre);
        nuevo.setImg_color(color);
        nuevo.setImg_bw(bw);
        nuevo.setImpr_color(color);
        nuevo.setImpr_bw(bw);
        nuevo.setPasos(paso);
        
        if (estaVacio()) {
            primero = nuevo;
        } else {
            Cliente aux = primero;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
        }
        tamanio+=1;
        tam2++;
        System.out.println(nombre + " Ingresa a la Cola Recepción");
    }
    
    public Cliente desencolar() {
        Cliente aux = primero;
        if (estaVacio()) {
            System.out.println("-- No Hay Clientes --");
        } else {
            Cliente auxx = aux.getSig();
            primero = auxx;
        }
        tamanio--;
        return aux;
    }
    
    public void imprimirCola(){
        if (tamanio == 0) {
            System.out.println("Pila vacia");
        } else {
            Cliente temp = primero;
            while (temp != null) {
                System.out.println("Id:" + temp.getId_cliente());
                System.out.println("Nombre:" + temp.getNombre_cliente());
                System.out.println("Color:" + temp.getImg_color());
                System.out.println("BW:" + temp.getImg_bw());
                System.out.println("");
                temp = temp.getSig();
            }

        }
    }
    
    public void graphviz_recepcion(int valor) {
        String dot = "";
        if (valor == 1) {
            dot = "digraph G{ rankdir=TB; labelloc=t; label=\"COLA RECEPCION \"; fontsize=35;\n";
        }
        Cliente temp = primero;
        int contador = 0;
        while (temp != null) {
            if (valor == 1) {
                dot = dot + String.valueOf(contador) + "[label= \"Id Cliente: " + String.valueOf(temp.getId_cliente()) + "\n Nombre: " + temp.getNombre_cliente()+ "\n Impresiones Color: " + String.valueOf(temp.getImg_color()) + "\n Impresiones BN: " + String.valueOf(temp.getImg_bw()) + "\" shape=trapezium fontsize=25];\n";
            }
            contador++;
            temp = temp.getSig();
        }
        temp = primero;
        int contadoraux = 0;
        while (temp != null) {
            Cliente temp2 = temp.getSig();
            if (temp2 != null) {
                dot = dot + String.valueOf(contadoraux) + "->" + String.valueOf(contadoraux + 1) + ";\n";
            }
            contadoraux++;
            temp = temp.getSig();
        }
        dot = dot + "}";
        try {
            String Contenido = dot;
            File file = null;
            file = new File("ColaRecepcion.dot");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "ColaRecepcion.png", "ColaRecepcion.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        } catch (IOException e) {
        }

        

    }
    
    
    
    public void graphviz_atendidos() {
        String dot = "";
        dot = "digraph G{ rankdir=TB; labelloc=t; label=\"LISTA DE ATENDIDOS\"; fontsize=35;\n";
        Cliente temp = primero;
        int contador = 0;
        while (temp != null) {
            dot = dot + String.valueOf(contador) + "[label= \"Id Cliente: " + String.valueOf(temp.getId_cliente()) + "\n Nombre: " + temp.getNombre_cliente()+ "\n Ventanilla Que Atendió: " + String.valueOf(temp.getVentanilla()) + "\n  Total de imagenes impresas: " + String.valueOf(temp.getImpr_color()+ temp.getImpr_bw()) + "\n  Cantidad de Pasos en el Sistema: " + String.valueOf(temp.getPasos()) + "\" shape=square fontsize=25];\n";
            contador++;
            temp = temp.getSig();
        }

        temp = primero;
        int contadoraux = 0;
        while (temp != null) {
            Cliente temp2 = temp.getSig();
            if (temp2 != null) {
                dot = dot + String.valueOf(contadoraux) + "->" + String.valueOf(contadoraux + 1) + ";";
            }
            contadoraux++;
            temp = temp.getSig();
        }
        dot = dot + "}";

        try {
            String Contenido = dot;
            File file = null;
            file = new File("ListAtendidos.dot");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
            ProcessBuilder proceso = null;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "ListAtendidos.png", "ListAtendidos.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        } catch (IOException e) {
        }

    }
    
    
    
    
    

    
}
