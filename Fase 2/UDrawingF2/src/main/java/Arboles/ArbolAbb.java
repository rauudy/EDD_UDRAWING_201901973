/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;
import Estructuras.MatrizDispersa;
import Recursos.*;
import UDrawingF2.*;
import Interfaz.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ArbolAbb {
    NodoAbb raiz;

    public ArbolAbb() {
        raiz = null;
    }
    
    public void insertar(Object info){
        raiz = addRecur(info,raiz);
    }
    
    public static NodoAbb addRecur(Object inf, NodoAbb raiz){
        if(raiz == null){
            return new NodoAbb(inf);
        }else{
            int id = ((Capa)inf).getId();
            int actual = ((Capa)raiz.info).getId();
            if(id < actual){
                raiz.izquierda = addRecur(inf,raiz.izquierda);
            }else if(actual < id){
                raiz.derecha = addRecur(inf,raiz.derecha);
            }
            return raiz;
        }       
    }
    
    public MatrizDispersa buscar(int n){
        NodoAbb aux = raiz;
        while(aux != null){
            if(((Capa)aux.info).getId() == n){
                return((Capa)aux.info).getPixels();
            }else if(n<((Capa)aux.info).getId()){
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
        }
        return null;
    }
    
    public MatrizDispersa crearImagen(String t){
        MatrizDispersa img = null;
        switch(t){
            case "In":
                img = imgInO(raiz);
                break;
            case "Post":
                img = imgPost(raiz);
                break;
            case "Pre":
                img = imgPre(raiz);
                break;
            default:
                System.out.println("--------------->ERROR");
                break;
        }
        return img;
    }
    
    public MatrizDispersa imgInO(NodoAbb raiz){
        MatrizDispersa img = new MatrizDispersa();
        int no;
        if(raiz == null){
            img = null;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            no = ((Capa)raiz.info).getId();
            img.agregarCapa(Main.actual.getCapas().buscar(no));
        }else{ 
            no = ((Capa)raiz.info).getId();
            img.agregarCapa(imgInO(raiz.izquierda));
            img.agregarCapa(Main.actual.getCapas().buscar(no));
            img.agregarCapa(imgInO(raiz.derecha));
        }
        return img;
    }
    
    public MatrizDispersa imgPost(NodoAbb raiz){
        MatrizDispersa img = new MatrizDispersa();
        
        int no;
        if(raiz == null){
            img = null;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            no = ((Capa)raiz.info).getId();
            img = Main.actual.getCapas().buscar(no);
        }else{             
            
            no = ((Capa)raiz.info).getId();
            
            img.agregarCapa(imgInO(raiz.izquierda));
            img.agregarCapa(imgInO(raiz.derecha));
            img.agregarCapa(Main.actual.getCapas().buscar(no));                     
        }
        return img;
    }
    
    public MatrizDispersa imgPre(NodoAbb raiz){
        MatrizDispersa img = new MatrizDispersa();
        int no;
        if(raiz == null){
            img = null;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            no = ((Capa)raiz.info).getId();
            img.agregarCapa(Main.actual.getCapas().buscar(no));
        }else{
            no = ((Capa)raiz.info).getId();
            img.agregarCapa(Main.actual.getCapas().buscar(no));   
            img.agregarCapa(imgPre(raiz.izquierda));
            img.agregarCapa(imgPre(raiz.derecha));
        }
        
        return img;
    }
    
    public int contarCapas(){
        return contar(raiz);
    }
    
    public int contar(NodoAbb raiz){
        int n = 0;
        if(raiz == null){
            n= 0;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            n = 1;
        }else{
            n += contar(raiz.derecha) + contar(raiz.izquierda) + 1;
        }       
        return n;
    }
    
    public void mostrarCapas(Menu men){
        mostrarCapas(men,raiz);
    }
    
    public void mostrarCapas(Menu men,NodoAbb raiz){
        int no ;
        if(raiz == null){
            return;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            no = ((Capa)raiz.info).getId();
            men.comboCapa.addItem(""+no);
        }else{
            no = ((Capa)raiz.info).getId();
            men.comboCapa.addItem(""+no);   
            mostrarCapas(men,raiz.izquierda);
            mostrarCapas(men,raiz.derecha);
        }
    }
    
    public void graficar(String title){
        String dott="digraph G{\nlabel=\""+title+"\";\nnode [shape=circle];\n"; 
        dott += recorrerGra(raiz).get(1);
        dott+="}\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
            Main.graficarDot(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Main.cont = 0;
    }
    
    public static ArrayList<String> recorrerGra(NodoAbb raiz){
        ArrayList<String> respuesta = new ArrayList<String>();
        int numero;
        if(raiz == null){
            respuesta.add("");
            respuesta.add("");
        }else if(raiz.izquierda == null && raiz.derecha == null){
            numero = ((Capa)raiz.info).getId();           
            respuesta.add("N"+Main.cont);
            respuesta.add("N"+Main.cont+"[label=\""+numero+"\"]\n");
            Main.cont += 1;
        }else{
            numero = ((Capa)raiz.info).getId();
            String conj = "";
            ArrayList<String> izquierda = recorrerGra(raiz.izquierda);
            ArrayList<String> derecha = recorrerGra(raiz.derecha);
            conj += "N"+Main.cont+"[label=\""+numero+"\"]\n";
            if(!izquierda.get(0).equals("")){
                conj += "N"+Main.cont + "->" + izquierda.get(0) + ";\n";
            }
            if(!derecha.get(0).equals("")){
                conj += "N"+Main.cont + "->" + derecha.get(0) + ";\n";
            }
            respuesta.add("N"+Main.cont);
            respuesta.add(conj + izquierda.get(1) + derecha.get(1));
            Main.cont += 1;
        }
        return respuesta;
    }
    
    public void generarTablaCapasHojas(String title){
        String dott="digraph G{\nN0[shape=record, label=\"{CAPAS HOJAS"+hojas(raiz)+"}\"];\n}"; 
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.cont = 0;
    }
    
    public String hojas(NodoAbb raiz){
        String con = "";
        if(raiz == null){
            con = "";
        }else if(raiz.derecha == null &&  raiz.izquierda == null){
            con = "|Capa "+((Capa)raiz.info).getId();
        }else{
            con = hojas(raiz.derecha) + hojas(raiz.izquierda);
        }
        return con;
    }
    
    public void graficarRecorridos(String title){
        String dott="digraph G{\nN0[shape=record, label=\"{ | InOrden|PostOrden|PreOrden }|{RECORRIDO|"+preorden(raiz, true)+"|"+inorden(raiz, true)+"|"+postorden(raiz, true)+"}\"];\n}";              
        
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Main.cont = 0;
    }
    
    public String inorden(NodoAbb raiz, boolean primero){
        String con = "";
        if(raiz == null){
            con = "";
        }else if(raiz.izquierda==null && raiz.derecha == null){
            if(!primero){
                con += ",";
            }
            con += +((Capa)raiz.info).getId();
        }else{
            con += inorden(raiz.izquierda,primero);
            con += ","+((Capa)raiz.info).getId();           
            con += inorden(raiz.derecha,false);
        }
        
        return con;
    }
    
    public String postorden(NodoAbb raiz, boolean primero){
        String con = "";
        
        if(raiz == null){
            con = "";
        }else if(raiz.izquierda==null && raiz.derecha == null){
            if(!primero){
                con += ",";
            }
            con += +((Capa)raiz.info).getId();
        }else{
            con += postorden(raiz.izquierda,primero);                     
            con += postorden(raiz.derecha,false);
            con += ","+((Capa)raiz.info).getId(); 
        }
        
        return con;
    }
    
    public String preorden(NodoAbb raiz, boolean primero){
        String con = "";
        if(raiz == null){
            con = "";
        }else if(raiz.izquierda==null && raiz.derecha == null){
            if(!primero){
                con += ",";
            }
            con += +((Capa)raiz.info).getId();
        }else{
            if(!primero){
                con += ",";
            }
            con += ((Capa)raiz.info).getId();
            con += preorden(raiz.izquierda,false);
            con += preorden(raiz.derecha,false);
        }
        return con;
    }
    
    public int profundidad(NodoAbb raiz){
        int con = 0;
        if(raiz == null){
            con = 0;
        }else if(raiz.derecha == null &&  raiz.izquierda == null){
            con = 1;
        }else{
            int der = profundidad(raiz.derecha);
            int izq = profundidad(raiz.izquierda);
            
            if(der>izq){
                con = der +1;
            }else{
                con = izq +1;
            }
        }
        return con;
    }
    
    public void generarProfundidad(String title){
        String dott="digraph G{\nN0[shape=record, label=\"{PROFUNDIDAD|"+profundidad(raiz)+", Niveles}\"];\n}";      
        try {
            String ruta = System.getProperty("user.dir") + "\\"+title+".txt";
            File file = new File(ruta);
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Main.cont = 0;
    }
    
    
    
}
