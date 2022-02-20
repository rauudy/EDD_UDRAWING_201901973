package Estructuras;

import Proyecto1.*;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PilaImage {

    private Image cima;
    private int tamanio;

    public PilaImage() {
        cima = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(int id_cliente, int id_img, String color) {
        Image nuevo = new Image(id_cliente,id_img,0,color,null);

        if (estaVacia()) {
            cima = nuevo;
        } else {
            Image aux = cima;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);

        }
        tamanio += 1;
    }
    
    public int no_nodos(){
        return tamanio;
    }
    
    public Image pop() {
        Image temp = cima;
        String Color = "";
        if (cima == null) {

        } else {
            if (cima.getPasos()== 0) {
                Image temp2 = temp.getSig();

                cima = temp2;
                //Cliente Duenio = Menu.LEspera.buscar(temp.getId_cliente());
                if (temp.getColor().equals("Color")) {
                    Color = "Color";
                } else {
                    Color = "Blanco y Negro";
                }
                try {
                  //  System.out.println("Imagen a " + Color + " Entregada al cliente " + Duenio.getNombre_cliente());
                } catch (Exception e) {

                    System.out.println("Error");
                }
                tamanio--;
            } else {
                return null;

            }

        }

        return temp;

    }

    public void cima() {
        System.out.println("El que esta en la cima es: " + cima.getId_img());
    }

    public void push_Impr(int id_cliente, int id_img, int pasos, String color) {
        Image nuevo = new Image(id_cliente,id_img,pasos,color,null);
        
        nuevo.setId_cliente(id_cliente);
        nuevo.setId_img(id_img);
        nuevo.setColor(color);
        nuevo.setPasos(pasos);
        
        if (estaVacia()) {
            cima = nuevo;
        } else {
            Image aux = cima;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
        }
        tamanio += 1;
    }
    
    

    public void imprimir_Pila() {
        if (estaVacia()) {
            System.out.println("------ La PILA esta Vacia ------");
        } else {
            Image aux = cima;
            while (aux != null) {
                System.out.println("Id_Cliente: " + String.valueOf(aux.getId_cliente()));
                System.out.println("Id_Imagen: " + String.valueOf(aux.getId_img()));
                System.out.println("color: " + aux.getColor() + "\n");
                aux = aux.getSig();
            }

        }
    }

    public void menosPasos() {
        if (cima != null) {
            cima.setPasos(cima.getPasos() - 1);
        }
    }

    

    public void GraphvizColor() {
        Image aux = cima;
        int cont = 0;
        String dot = "";
        dot = "digraph G{ rankdir=TB; labelloc=t; label=\"Colas Impresion\"; fontsize=50; \n U[label=\"Impresora Color\" shape=square fontsize=30]";

        while (aux != null) {
            dot = dot + String.valueOf(cont) + "[label= \"Cliente: " + String.valueOf(aux.getId_cliente()) + " ,Id Imagen: " + String.valueOf(aux.getId_img()) + " ,Imagen A Color\"];  \n";
            cont++;
            aux = aux.getSig();
        }
        dot = dot + "U->0; \n";
        aux = cima;

        int cont2 = 0;

        while (aux != null) {
            Image aux2 = aux.getSig();
            if (aux2 != null) {

                dot = dot + String.valueOf(cont2) + "->" + String.valueOf(cont2 + 1) + ";";
            }
            cont2++;
            aux = aux.getSig();
        }
        String dot2 = Menu.pilaC.GraphvizBw();
        dot = dot + "\n \n" + dot2 + "}";
        System.out.println(dot);
        
        try {
            String Contenido = dot;
            File file = null;

            file = new File("Impresoras.dot");

            if (!file.exists()) {

                file.createNewFile();

            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
            
            ProcessBuilder proceso = null;

            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "impr.png", "Impresoras.dot");

            proceso.redirectErrorStream(true);
            proceso.start();

        } catch (Exception e) {
        }
        

    }
    
    public String GraphvizBw() {
        Image aux = cima;
        int contador = 0;
        String dot = "";
        dot = " \n N[label=\"Impresora BN\" shape=square fontsize=30]\n";
        while (aux != null) {
            dot = dot + String.valueOf(contador) + "5[label= \"Cliente: " + String.valueOf(aux.getId_cliente()) + " ,Id Imagen: " + String.valueOf(aux.getId_img()) + " ,Imagen BlancoNegro\"];  \n";
            contador++;
            aux = aux.getSig();
        }
        dot = dot + "\n N->5; ";
        aux = cima;
        int contador2 = 0;

        while (aux != null) {
            Image temp2 = aux.getSig();
            if (temp2 != null) {
                dot = dot + String.valueOf(contador2) + "5->" + String.valueOf(contador2 + 1) + "5;";
            }
            contador2++;
            aux = aux.getSig();
        }
        return dot;
    }

}
