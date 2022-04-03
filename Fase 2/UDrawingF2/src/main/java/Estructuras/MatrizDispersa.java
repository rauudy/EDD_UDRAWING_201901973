/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author DELL
 */
public class MatrizDispersa {
    
    //NODO DE LISTA
    
    public class Nodo{        
        Object info;
        Nodo izquierda, derecha, arriba, abajo;
        Nodo sig, ant;
        int x,y;

        public Nodo(Object info) {
            this.info = info;
            x = y = 0;
            this.sig= null;
            this.ant = null;
            this.izquierda = null;
            this.derecha = null;
            this.abajo = null;
            this.arriba = null;
        }   
        
        public Nodo(Object info,int x, int y) {
            this.info = info;
            this.x = x;
            this.y = y;
            this.sig= null;
            this.ant = null;
            this.izquierda = null;
            this.derecha = null;
            this.abajo = null;
            this.arriba = null;;
        }
    }
    
    //LISTA DE CABECERA
    
    public class Lista{
        Nodo raiz, ultimo;
        public Lista(){
            this.raiz = null;
            this.ultimo = null;
        }
        
        public void insertar(int no){
            Nodo nuevo = new Nodo(no);
            if(raiz == null){
                raiz = ultimo = nuevo;
            }else{
                ordenar(nuevo);
            }
        }
        
        public void ordenar(Nodo nodo){
            Nodo aux = raiz;
            while(aux != null){
                if((int)aux.info < (int)nodo.info){
                    aux = aux.sig;
                }else{
                    if(aux == raiz){
                        nodo.sig =aux;
                        aux.ant = nodo;                       
                        raiz = nodo;
                        return;
                    }else{
                        nodo.ant = aux.ant;
                        aux.ant.sig = nodo;
                        nodo.sig = aux;
                        aux.ant = nodo;
                        return;
                    }
                }
            }
            
            if(ultimo == raiz){
                nodo.ant = raiz;
                raiz.sig = nodo;
                ultimo = nodo;               
            }else{
                ultimo.sig = nodo;
                nodo.ant = ultimo;
                ultimo = nodo; 
            }                               
        }
        
        public Nodo buscarList(int valor){
            Nodo temp = raiz;
            while(temp != null){
                if((int)temp.info == valor){
                    return temp;
                }
                temp = temp.sig;
            }
            return null;
        }
        
        public void imprimir(){
            Nodo temp = raiz;
            while(temp != null){
                System.out.println("Cabecera: " + temp.info);
                temp = temp.sig;
            }
        }
        
        public int max(){
            Nodo temp = raiz;
            while (temp.sig != null) {
                temp = temp.sig;
            }
            return (int)temp.info;
        }
    }
    //---------------------------------------------------------------
    
    Lista fila = new Lista();
    Lista col = new Lista();

    public void MatrizDispersa() {
        fila = new Lista();
        col = new Lista();
    }

    public void insertar(String valor, int i, int j) {
        Nodo fil = fila.buscarList(i);
        Nodo com = col.buscarList(j);
        String nuevoColor = buscar_Color(i, j);
        if (nuevoColor.equals("")) {
            if (fil == null && com == null) {
                //No existe Fila ni Columna
                caso1(valor, i, j);
            } else if (fil == null && com != null) {
                //Solo existe Col
                caso2(valor, i, j);
            } else if (fil != null && com == null) {
                //Solo existe Fila
                caso3(valor, i, j);
            } else {
                //Existe Fila y Columna
                caso4(valor, i, j);
            }
        } else {
            //Siguiente color
            siguienteColor(valor, i, j);
        }
    }

    public String buscar_Color(int i, int j) {
        Nodo cabecera = fila.raiz;
        while (cabecera != null) {
            Nodo aux = cabecera.abajo;
            while (aux != null) {
                if (aux.x == i && aux.y == j) {
                    return (String) aux.info;
                }
                aux = aux.abajo;
            }
            cabecera = cabecera.sig;
        }
        return "";
    }
    
    public void siguienteColor(String nColor, int i, int j){
        Nodo cabecera = fila.raiz;
        while(cabecera != null){
            Nodo aux = cabecera.abajo;
            while(aux != null){
                if(aux.x == i && aux.y == j){
                    aux.info = nColor;
                }
                aux = aux.abajo;
            }
            cabecera = cabecera.sig;
        }
    }

    public void caso1(String valor, int i, int j) {
        fila.insertar(i);
        col.insertar(j);

        Nodo fil = fila.buscarList(i);
        Nodo com = col.buscarList(j);
        Nodo nuevo = new Nodo(valor, i, j);

        fil.abajo = nuevo;
        nuevo.arriba = fil;
        com.derecha = nuevo;
        nuevo.izquierda = com;
    }


    public void caso2(String valor, int i, int j) {
        fila.insertar(i);

        Nodo fil = fila.buscarList(i);
        Nodo com = col.buscarList(j);
        boolean agregado = false;
        Nodo n = new Nodo(valor, i, j);
        Nodo aux = com.derecha;
        int cabecera;

        while (aux != null) {
            cabecera = aux.x;
            if (cabecera < i) {
                aux = aux.derecha;
            } else {
                n.derecha = aux;
                n.izquierda = aux.izquierda;
                aux.izquierda.derecha = n;
                aux.izquierda = n;
                agregado = true;
                break;
            }
        }
        if (agregado == false) {
            aux = com.derecha;
            while (aux.derecha != null) {
                aux = aux.derecha;
            }
            n.izquierda = aux;
            aux.derecha = n;
        }
        
        fil.abajo = n;
        n.arriba = fil;

    }

    
    public void caso3(String valor, int i, int j) {
        col.insertar(j);

        Nodo fil = fila.buscarList(i);
        Nodo com = col.buscarList(j);
        boolean agregado = false;
        Nodo nuevo = new Nodo(valor, i, j);
        Nodo aux = fil.abajo;
        int cabecera;

        while (aux != null) {
            cabecera = aux.y;
            if (cabecera < j) {
                aux = aux.abajo;
            } else {
                nuevo.abajo = aux;
                nuevo.arriba = aux.arriba;
                aux.arriba.abajo = nuevo;
                aux.arriba = nuevo;
                agregado = true;
                break;
            }
        }
        if (agregado == false) {
            aux = fil.abajo;
            while (aux.abajo != null) {
                aux = aux.abajo;
            }

            nuevo.arriba = aux;
            aux.abajo = nuevo;
        }
        
        com.derecha = nuevo;
        nuevo.izquierda = com;

    }

    
    public void caso4(String valor, int i, int j) {
        Nodo com = col.buscarList(j);
        Nodo fil = fila.buscarList(i);
        Nodo n = new Nodo(valor, i, j);
        boolean insertado = false;
        Nodo aux = com.derecha;
        int cabecera;

        while (aux != null) {
            cabecera = aux.x;
            if (cabecera < i) {
                aux = aux.derecha;
            } else {
                n.derecha = aux;
                n.izquierda = aux.izquierda;
                aux.izquierda.derecha = n;
                aux.izquierda = n;
                insertado = true;
                break;
            }
        }
        if (insertado == false) {
            aux = com.derecha;
            while (aux.derecha != null) {
                aux = aux.derecha;
            }
            n.izquierda = aux;
            aux.derecha = n;
        }

        insertado = false;
        aux = fil.abajo;

        while (aux != null) {
            cabecera = aux.y;
            if (cabecera < j) {
                aux = aux.abajo;
            } else {
                n.abajo = aux;
                n.arriba = aux.arriba;
                aux.arriba.abajo = n;
                aux.arriba = n;
                insertado = true;
                break;
            }
        }

        if (insertado == false) {
            aux = fil.abajo;
            while (aux.abajo != null) {
                aux = aux.abajo;
            }

            n.arriba = aux;
            aux.abajo = n;
        }
    }
    
    public void imprimir(){
        Nodo cabecera = fila.raiz;
        while(cabecera != null){
            Nodo aux = cabecera.abajo;
            while(aux != null){
                System.out.println("-----------------------------");
                System.out.println(aux.info + ", i= " + aux.x + ", j= " +aux.y);
                aux = aux.abajo;
            }
            cabecera = cabecera.sig;
        }
    }
    
    public void agregarCapa(MatrizDispersa nueva){
        if(nueva != null){
            Nodo cabecera = nueva.fila.raiz;
            while(cabecera != null){
                Nodo aux = cabecera.abajo;
                while(aux != null){
                    String color = buscar_Color(aux.x,aux.y);
                    if(color.equals("")){
                        this.insertar((String)aux.info,aux.x,aux.y);
                    }else{
                        siguienteColor((String)aux.info, aux.x,aux.y);
                    }
                    aux = aux.abajo;
                }
                cabecera = cabecera.sig;
            }
        }
    }
    
    public void graficarMatriz(String title){
        String resultado="digraph G{\nlabel=\""+ title +"\" ;\nnode [shape=square];\n";        
        String conexiones="";
        String nodos="";
        
        nodos += "INICIO[shape=Msquare,label=\""+title+"\",group=0];\n";
        String rs = "rank = same {INICIO";
        int maxColumnas = fila.max();
        int maxFilas = col.max();
        
        for(int i = 0; i<maxColumnas+1; i++){
            nodos += "C"+i+"[group="+(i+1)+"];\n";
            if(i==0){
                conexiones += "INICIO -> C0;\n";
                rs += ",C0";
            }else{
                rs += ",C"+i;
            } 
            
            if(i!=maxColumnas){
                conexiones += "C"+i+"->C"+(i+1)+";\n";
            }
        }
        rs += "}\n";
        nodos += rs;
        
        for(int j = 0 ; j<maxFilas+1 ; j++){
            nodos += "F"+j+"[group=0];\n";
            if(j==0){
               conexiones += "INICIO -> F0;\n"; 
            }
            if(j!=maxFilas){
                conexiones += "F"+j+"->F"+(j+1)+";\n";
            }
        }
        
        boolean primero;
        for(int j = 0; j<maxFilas+1;j++){ 
            String rank = "rank=same{F"+j;
            primero = true;
            String ant = "";
            for(int i=0;i<maxColumnas+1;i++){
                String color = buscar_Color(i, j);
                if(!color.equals("")){
                    rank +=",C"+i+"F"+j ;
                    nodos += "C"+i+"F"+j+"[label=\"\",style=filled,color=\""+color+"\",group="+(i+1)+"];\n";
                    if(primero == true){
                        conexiones += "F"+j+"->C"+i+"F"+j+";\n";
                        conexiones += "C"+i+"F"+j+"->F"+j+";\n";
                        primero = false;
                        ant = "C"+i+"F"+j;
                    }else{
                        conexiones += ant + "->C"+i+"F"+j+";\n";
                        conexiones += "C"+i+"F"+j+"->"+ant+";\n";
                        ant = "C"+i+"F"+j;
                    }                    
                }          
            } 
            rank +="};\n";
            nodos += rank;
        }
        
        for(int i = 0; i<maxColumnas+1;i++){ 
            primero = true;
            String ant = "";
            for(int j=0;j<maxFilas+1;j++){
                String color = buscar_Color(i, j);
                if(!color.equals("")){
                    if(primero == true){
                        conexiones += "C"+i+"->C"+i+"F"+j+";\n";
                        conexiones += "C"+i+"F"+j+"->C"+i+";\n";
                        primero = false;
                        ant = "C"+i+"F"+j;
                    }else{
                        conexiones += ant + "->C"+i+"F"+j+";\n";
                        conexiones += "C"+i+"F"+j+"->"+ant+";\n";
                        ant = "C"+i+"F"+j;
                    }                    
                }          
            } 
        }
        
        resultado+= "//Agregando nodods\n";
        resultado+=nodos+"\n";
        resultado+= "//Agregando conexiones\n";
        resultado+=conexiones+"\n";
        
        resultado+="\n}";
        
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.close(); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
