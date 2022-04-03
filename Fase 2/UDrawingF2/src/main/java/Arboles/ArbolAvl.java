package Arboles;

import javax.swing.JOptionPane;
import Recursos.*;
import Interfaz.*;
import Estructuras.*;
import UDrawingF2.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ArbolAvl {
    
    public NodoAVL raiz;

    public ArbolAvl() {
        raiz = null;
    }
    
    public void insertar(Object info){
       NodoAVL nuevo= new NodoAVL(info);
       if(raiz==null){
           raiz=nuevo;
       }else{
           raiz=insertar(nuevo, raiz);
       }
    }
    
    public NodoAVL insertar(NodoAVL nuevo, NodoAVL subarr){
        NodoAVL padreN=subarr;
        int dato = ((Image)nuevo.valor).getId();
        int act = ((Image)subarr.valor).getId();
        if(dato<act){
            if(subarr.izquierda==null){
                subarr.izquierda=nuevo;
            }else{
                subarr.izquierda=insertar(nuevo, subarr.izquierda);
                if((factorEquilibrio(subarr.izquierda)-factorEquilibrio(subarr.derecha)==2)){
                    if(dato<(((Image)subarr.izquierda.valor).getId())){
                        padreN=rotacionIzquierda(subarr);
                    }else{
                        padreN=rotacionDobleIzquierda(subarr);
                    }
                }
            }
        }else if(dato>act){
            if(subarr.derecha==null){
                subarr.derecha=nuevo;
            }else{
                subarr.derecha=insertar(nuevo, subarr.derecha);
                if((factorEquilibrio(subarr.derecha)-factorEquilibrio(subarr.izquierda)==2)){
                    if(dato>(((Image)subarr.derecha.valor).getId())){
                        padreN=rotacionDerecha(subarr);
                    }else{
                        padreN=rotacionDobleDerecha(subarr);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hay nodos iguales");
        }
        
        if((subarr.izquierda==null)&&(subarr.derecha!=null)){
            subarr.equilibrio=subarr.derecha.equilibrio+1;
        }else if((subarr.derecha==null)&&(subarr.izquierda!=null)){
            subarr.equilibrio=subarr.izquierda.equilibrio+1;
        }else{
            subarr.equilibrio=Math.max(factorEquilibrio(subarr.izquierda), factorEquilibrio(subarr.derecha))+1;
        }
        return padreN;
    }
    
    public int factorEquilibrio(NodoAVL n){
        if(n==null){
            return -1;
        }else{
            return n.equilibrio;
        }
    }
    
    public NodoAVL rotacionDerecha(NodoAVL nodo){
        NodoAVL aux=nodo.derecha;
        nodo.derecha=aux.izquierda;
        aux.izquierda=nodo;
        nodo.equilibrio=Math.max(factorEquilibrio(nodo.izquierda), factorEquilibrio(nodo.derecha))+1;
        aux.equilibrio=Math.max(factorEquilibrio(aux.izquierda), factorEquilibrio(aux.derecha))+1;
        return aux;
    }
    
    public NodoAVL rotacionIzquierda(NodoAVL nodo){
        NodoAVL aux=nodo.izquierda;
        nodo.izquierda=aux.derecha;
        aux.derecha=nodo;
        nodo.equilibrio=Math.max(factorEquilibrio(nodo.izquierda), factorEquilibrio(nodo.derecha))+1;
        aux.equilibrio=Math.max(factorEquilibrio(aux.izquierda), factorEquilibrio(aux.derecha))+1;
        return aux;
    }
    
    public NodoAVL rotacionDobleDerecha(NodoAVL nodo){
        NodoAVL aux;
        nodo.derecha= rotacionIzquierda(nodo.derecha);
        aux=rotacionDerecha(nodo);
        return aux;
    }
    
    public NodoAVL rotacionDobleIzquierda(NodoAVL nodo){
        NodoAVL aux;
        nodo.izquierda= rotacionDerecha(nodo.izquierda);
        aux=rotacionIzquierda(nodo);
        return aux;
    }
    
    public ArbolAbb buscar(int n){
        NodoAVL aux = raiz;
        while(aux != null){
            if(((Image)aux.valor).getId() == n){
                return((Image)aux.valor).getCapas();
            }else if(((Image)aux.valor).getId() > n){
                aux = aux.izquierda;
            }else{
                aux = aux.derecha;
            }
        }
        return null;
    }
    
    public Image obtenerMayor(NodoAVL nodo){
        if(nodo.derecha == null){
            Image valor = (Image)nodo.valor;
            return valor;
        }else{
            return obtenerMayor(nodo.derecha);
        }
    }
    
    public NodoAVL eliminar(int n, NodoAVL raiz){
        if(((Image)raiz.valor).getId() == n){
            if(raiz.izquierda == null && raiz.derecha == null){
                raiz = null;
            }else if(raiz.izquierda != null){
                Image x = obtenerMayor(raiz.izquierda);
                raiz.valor = x;
                raiz.izquierda = eliminar(x.getId(),raiz.izquierda);
            }else{
                raiz = raiz.derecha;
            }
        }else{
            if(((Image)raiz.valor).getId()<n){
                raiz.derecha = eliminar(n,raiz.derecha);
            }else{
                raiz.izquierda = eliminar(n,raiz.izquierda);
            }
        }
        return raiz;
    }
    
    public int contar(){
        return contarImg(raiz);
    }
    
    public int contarImg(NodoAVL raiz){
        int n = 0;
        if(raiz == null){
            n= 0;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            n = 1;
        }else{
            n += contarImg(raiz.derecha) + contarImg(raiz.izquierda) + 1;
        }       
        return n;
    }
    
    public void mostrarImgs(Menu men){
        mostrarImgs(men,raiz);
    }
    
    public void mostrarImgs(Menu men,NodoAVL raiz){
        int no ;
        if(raiz == null){
            return;
        }else if(raiz.izquierda == null && raiz.derecha == null){
            no = ((Image)raiz.valor).getId();
            men.comboImagen.addItem(""+no);
        }else{
            no = ((Image)raiz.valor).getId();
            men.comboImagen.addItem(""+no);   
            mostrarImgs(men,raiz.izquierda);
            mostrarImgs(men,raiz.derecha);
        }
    }
    
    public void graficar(String title){
        String dott="digraph G{\nlabel=\""+title+"\";\nnode [shape=circle];\n";  
        dott += recorrerRecur(raiz).get(1);
        dott+="}\n}";
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
    
    public static ArrayList<String> recorrerRecur(NodoAVL raiz){
        ArrayList<String> respuesta = new ArrayList<String>();
        int numero;
        if(raiz == null){
            respuesta.add("");
            respuesta.add("");
        }else if(raiz.izquierda == null && raiz.derecha == null){
            numero = ((Image)raiz.valor).getId();           
            respuesta.add("N"+Main.cont);
            respuesta.add("N"+Main.cont+"[label=\""+numero+","+raiz.equilibrio+"\"]\n");
            Main.cont += 1;
        }else{
            numero = ((Image)raiz.valor).getId();
            String conj = "";
            ArrayList<String> izquierda = recorrerRecur(raiz.izquierda);
            ArrayList<String> derecha = recorrerRecur(raiz.derecha);
            conj += "N"+Main.cont+"[label=\""+numero+","+raiz.equilibrio+"\"]\n";
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
    
    public List top5(){
        return recorrerTop5(raiz);
    }
    
    public List recorrerTop5(NodoAVL raiz){
        List tt = new List();
        Image aux;
        if(raiz==null){
        }else if(raiz.izquierda==null && raiz.derecha==null){
            aux = new Image(((Image)raiz.valor).getId(),((Image)raiz.valor).getCapas().contarCapas());
            tt.insertarOrdenado(aux);
        }else{
            aux = new Image(((Image)raiz.valor).getId(),((Image)raiz.valor).getCapas().contarCapas());
            tt.insertarOrdenado(aux);
            tt.insertar(recorrerTop5(raiz.izquierda));
            tt.insertar(recorrerTop5(raiz.derecha));
        }
        return tt;
    }
    
}
