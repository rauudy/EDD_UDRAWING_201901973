/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;
import Estructuras.MatrizDispersa;
import Recursos.*;
import UDrawingF2.*;

/**
 *
 * @author DELL
 */
public class ABB {
    NodoABB raiz;

    public ABB() {
        raiz = null;
    }
    
    public void insertar(Object info){
        raiz = addRecur(info,raiz);
    }
    
    public static NodoABB addRecur(Object inf, NodoABB raiz){
        if(raiz == null){
            return new NodoABB(inf);
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
        NodoABB aux = raiz;
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
    
    public MatrizDispersa imgInO(NodoABB raiz){
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
    
    public MatrizDispersa imgPost(NodoABB raiz){
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
    
    public MatrizDispersa imgPre(NodoABB raiz){
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
    
    public int contar(NodoABB raiz){
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
    
}
