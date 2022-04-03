/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Recursos.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import UDrawingF2.*;

/**
 *
 * @author DELL
 */
public class ArbolB {
    
    NodoB raiz;
    
    public ArbolB(){
        raiz = new NodoB();
    }
    
    public void insertar(Cliente cl){
        Cliente n = brecursivo(cl.getDpi(),raiz);
        if(n!=null){
            JOptionPane.showMessageDialog(null, "El Cliente con DPI: "+n.getDpi()+", Ya Existe","CLIENTE",JOptionPane.ERROR_MESSAGE);
        }else{
            NodoB aur = raiz;
            insertarLL(raiz,cl);
            if(lleno(raiz)){
                NodoB aus = new NodoB();
                aus.hoja = false;
                raiz = aus;
                raiz.n0 = aur;
                split(raiz,0,aur);
            }
        }
 
    }
    
    public void insertarLL(NodoB n, Cliente cl){
        if(n.hoja){
            if(n.info1 == null || n.info1.getDpi()>cl.getDpi() ){
                n.info5 = n.info4;
                n.info4 = n.info3;
                n.info3 = n.info2;
                n.info2 = n.info1;
                n.info1 = cl;
            }else if(n.info2 == null || n.info2.getDpi()>cl.getDpi()){
                n.info5 = n.info4;
                n.info4 = n.info3;
                n.info3 = n.info2;
                n.info2 = cl;
            }else if(n.info3 == null || n.info3.getDpi()>cl.getDpi()){
                n.info5 = n.info4;
                n.info4 = n.info3;
                n.info3 = cl;
            }else if(n.info4 == null || n.info4.getDpi()>cl.getDpi()){
                n.info5 = n.info4;
                n.info4 = cl;
            }else{
                n.info5 = cl;
            }
        }else{
            if(n.info1.getDpi()>cl.getDpi()){
                insertarLL(n.n0,cl);
                if(lleno(n.n0)){
                    split(n,0,n.n0);
                }                  
            }else if(n.info2 == null || n.info2.getDpi()>cl.getDpi()){
                insertarLL(n.n1,cl);
                if(lleno(n.n1)){
                    split(n,1,n.n1);
                }               
            }else if(n.info3 == null ||n.info3.getDpi()>cl.getDpi()){
                insertarLL(n.n2,cl);
                if(lleno(n.n2)){
                    split(n,2,n.n2);
                } 

            }else if(n.info4 == null ||n.info4.getDpi()>cl.getDpi()){
                insertarLL(n.n3,cl);
                if(lleno(n.n3)){
                    split(n,3,n.n3);
                }
            }else{
                insertarLL(n.n4,cl);
                if(lleno(n.n4)){
                    split(n,4,n.n4);
                }              
            }
        }
    }
    
    public void split(NodoB n, int i, NodoB na){
        NodoB ne = new NodoB();
        ne.hoja = na.hoja;
        
        ne.info1 = na.info4;
        ne.info2 = na.info5;
        
        if(!na.hoja){
            ne.n0 = na.n3;
            ne.n1 = na.n4;
            ne.n2 = na.n5;
        }

        if(i==0){
            n.n5 = n.n4;
            n.n4 = n.n3;
            n.n3 = n.n2;
            n.n2 = n.n1;
            n.n1 = ne;

        }else if(i==1){
            n.n5 = n.n4;
            n.n4 = n.n3;
            n.n3 = n.n2;
            n.n2 = ne;
        }else if(i==2){
            n.n5 = n.n4;
            n.n4 = n.n3;
            n.n3 = ne;
        }else if(i==3){
            n.n5 = n.n4;
            n.n4 = ne;
        }else if(i==4){
            n.n5 = ne;
        }
        
        if(i==0){
            n.info5 = n.info4;
            n.info4 = n.info3;
            n.info3 = n.info2;
            n.info2 = n.info1;
            n.info1 = na.info3;
        }else if(i==1){
            n.info5 = n.info4;
            n.info4 = n.info3;
            n.info3 = n.info2;
            n.info2 = na.info3;
        }else if(i==2){
            n.info5 = n.info4;
            n.info4 = n.info3;
            n.info3 = na.info3;
        }else if(i==3){
            n.info5 = n.info4;
            n.info4 = na.info3;
        }else if(i==4){
            n.info5 = na.info3;
        }
        
        na.info3 = na.info4 = na.info5 = null;
        na.n3 = na.n4 = na.n5 = null;
    }
    
    public boolean lleno(NodoB raiz){
        if(raiz.info5 != null){
            return true;
        }else{
            return false;
        }
    }  
        
    public Cliente buscar(long dpi){
        return brecursivo(dpi,raiz);
    }
    
    public Cliente brecursivo(long dpi, NodoB raiz){
        NodoB aux = raiz;
        if(aux.info1 != null && aux.info1.getDpi() == dpi){
            return aux.info1;
        }else if( aux.info2 != null && aux.info2.getDpi() == dpi){
            return aux.info2;
        }else if(aux.info3 != null && aux.info3.getDpi() == dpi){
            return aux.info3;
        }else if(aux.info4 != null && aux.info4.getDpi() == dpi){
            return aux.info4;
        }else{
            if(hijos(aux)){
                if(aux.info1 == null || (aux.n0 != null && aux.info1.getDpi() > dpi)){
                    return brecursivo(dpi,aux.n0);
                }else if(aux.info2 == null || (aux.n1 != null && aux.info2.getDpi() > dpi)){
                    return brecursivo(dpi,aux.n1);
                }else if(aux.info3 == null || (aux.n2 != null && aux.info3.getDpi() > dpi)){
                    return brecursivo(dpi,aux.n2);
                }else if(aux.info4 == null || (aux.n3 != null && aux.info4.getDpi() > dpi)){
                    return brecursivo(dpi,aux.n3);
                }else{
                    return brecursivo(dpi,aux.n4);
                }   
            }else{
                return null;
            }
        }
    }
    
    public boolean hijos(NodoB nod){
        if(nod.n0 != null || nod.n1 != null || nod.n2 != null || nod.n3 != null || nod.n4 != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void actualizar(Cliente cl){
        actualizarRecur(cl,raiz);
    }
    
    public void actualizarRecur(Cliente cl, NodoB raiz){
        NodoB aux = raiz;
        if(aux.info1 != null && aux.info1.getDpi() == cl.getDpi()){
            aux.info1 = cl;
        }else if( aux.info2 != null && aux.info2.getDpi() == cl.getDpi()){
            aux.info2 = cl;
        }else if(aux.info3 != null && aux.info3.getDpi() == cl.getDpi()){
            aux.info3 = cl;
        }else if(aux.info4 != null && aux.info4.getDpi() == cl.getDpi()){
            aux.info4 = cl;
        }else{
            if(hijos(aux)){
                if(aux.info1 == null || (aux.n0 != null && aux.info1.getDpi() > cl.getDpi())){
                    actualizarRecur(cl,aux.n0);
                }else if(aux.info2 == null || (aux.n1 != null && aux.info2.getDpi() > cl.getDpi())){
                    actualizarRecur(cl,aux.n1);
                }else if(aux.info3 == null || (aux.n2 != null && aux.info3.getDpi() > cl.getDpi())){
                    actualizarRecur(cl,aux.n2);
                }else if(aux.info4 == null || (aux.n3 != null && aux.info4.getDpi() > cl.getDpi())){
                    actualizarRecur(cl,aux.n3);
                }else{
                    actualizarRecur(cl,aux.n4);
                }   
            }else{
                JOptionPane.showMessageDialog(null, "No Se Guardo","Cliente",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void graficar(String title){
        String dott="digraph G{\nlabel=\""+title+"\";\n";  
        if(raiz.info1!=null){
            dott += recorrerRecur(raiz,"");
        }
        dott+="\n}";
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
    
    public String recorrerRecur(NodoB raiz, String padre){
        String nodos = "";
        String conexiones = "";
        int c = Main.cont;
        Main.cont += 1;
        if(!padre.equals("")){
            conexiones += padre + "->N"+ c+";\n";
        }
        String r2="x",r3="x",r4="x";
        if(raiz.info2 != null){
            r2 = "" + raiz.info2.getDpi();
        }
        if(raiz.info3 != null){
            r3 = "" + raiz.info3.getDpi();
        }
        if(raiz.info4 != null){
            r4 = "" + raiz.info4.getDpi();
        }
        nodos += "N"+ c+"[shape=record,label=\"<N"+c+"_0>|{"+raiz.info1.getDpi()+"}|<N"+c+"_1>|{"+r2+"}|<N"+c+"_2>|{"+r3+"}|<N"+c+"_3>|{"+r4+"}|<N"+c+"_4>\"];\n";
        if(raiz.n0!=null){
            conexiones += recorrerRecur(raiz.n0,"N"+c+":N"+c+"_0");
        }
        if(raiz.n1!=null){
            conexiones += recorrerRecur(raiz.n1,"N"+c+":N"+c+"_1");
        }
        if(raiz.n2!=null){
            conexiones += recorrerRecur(raiz.n2,"N"+c+":N"+c+"_2");
        }
        if(raiz.n3!=null){
            conexiones += recorrerRecur(raiz.n3,"N"+c+":N"+c+"_3");
        }
        if(raiz.n4!=null){
            conexiones += recorrerRecur(raiz.n4,"N"+c+":N"+c+"_4");
        }         
        return nodos+conexiones;
    }
    
}
