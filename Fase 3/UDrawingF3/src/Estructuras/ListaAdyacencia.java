/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Recursos.Ruta;
import UDrawing.Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import Estructuras.Lista;
import Estructuras.Lista.Nodo;


/**
 *
 * @author DELL
 */
public class ListaAdyacencia {

    Lista vertices;

    public class Vertice {

        int vert;
        Lista destinos;

        public Vertice(int vert) {
            this.vert = vert;
            destinos = new Lista();
        }

        public void agregarDestino(Destino des) {
            destinos.add(des);
        }
    }

    public class Destino {

        int des;
        int peso;

        public Destino(int des, int peso) {
            this.des = des;
            this.peso = peso;
        }
    }

    public ListaAdyacencia() {
        vertices = new Lista();
    }

    public void generar(Lista rutas) {
        Nodo aux = rutas.raiz;
        while (aux != null) {
            Ruta nruta = (Ruta) aux.info;
            if (vertices.existeVertice(nruta.getInicio())) {
                Destino nDestino = new Destino(nruta.getFin(), nruta.getPeso());
                addDestino(nruta.getInicio(), nDestino);
            } else {
                Vertice nVertice = new Vertice(nruta.getInicio());
                Destino nDestino = new Destino(nruta.getFin(), nruta.getPeso());
                nVertice.agregarDestino(nDestino);
                vertices.add(nVertice);
            }

            if (vertices.existeVertice(nruta.getFin())) {
                Destino nDestino = new Destino(nruta.getInicio(), nruta.getPeso());
                addDestino(nruta.getFin(), nDestino);
            } else {
                Vertice nVertice = new Vertice(nruta.getFin());
                Destino nDestino = new Destino(nruta.getInicio(), nruta.getPeso());
                nVertice.agregarDestino(nDestino);
                vertices.add(nVertice);
            }

            aux = aux.next;
        }
    }

    public void addDestino(int d, Destino n) {
        Nodo aux = vertices.raiz;
        while (aux != null) {
            Vertice miVertice = (Vertice) aux.info;
            if (miVertice.vert == d) {
                miVertice.agregarDestino(n);
            }
            aux = aux.next;
        }
    }

    public void imprimir() {
        Nodo aux = vertices.raiz;
        while (aux != null) {
            Vertice miVertice = (Vertice) aux.info;
            String a = "" + miVertice.vert;
            Nodo auxiliar = miVertice.destinos.raiz;
            while (auxiliar != null) {
                Destino b = (Destino) auxiliar.info;
                a += "->" + b.des;
                auxiliar = auxiliar.next;
            }
            System.out.println(a);
            aux = aux.next;
        }
    }

    public void graficar() {
        String resultado = "digraph G{\nlabel=\"Lista De Adyacencia\";\nnode[shape=square];\nrankdir=\"LR\";\n";
        String nodos = "";
        String conexiones = "";
        Nodo aux = vertices.raiz;
        while (aux != null) {
            Vertice nv = (Vertice) aux.info;
            nodos += "N" + aux.hashCode() + "[label=\"" + nv.vert + "\",style=\"filled\", fillcolor=\"#A4EEFB\"];\n";
            String anterior = "N" + aux.hashCode();

            Nodo destino = nv.destinos.raiz;

            while (destino != null) {
                nodos += "\nN" + destino.hashCode() + "[label=\"" + ((Destino) destino.info).des + "\"];";
                conexiones += anterior + "->N" + destino.hashCode() + ";\n";
                anterior = "N" + destino.hashCode();
                destino = destino.next;
            }
            aux = aux.next;
        }
        resultado += nodos + conexiones;
        resultado += "\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\adyacencia.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.close();
            Main.graficarDot("adyacencia");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
