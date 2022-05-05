/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.PrintWriter;
import UDrawing.*;

/**
 *
 * @author DELL
 */
public class Routes {
    
    PrintWriter writer;
    public static String route_routes="";
    Nodo head;
    
    public class Nodo{
        //Variables para almacenar los datos
        int start,end,weight;
        //Nodo siguiente 
        Nodo next;
        public Nodo(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.next = null;
        }
    }
    
    public void addRoutes(int start, int end, int wight){
        Nodo _new = new Nodo(start,end,wight);
        if(head==null){
            head=_new;
        }else{
            Nodo tmp = head;
            while(tmp.next != null){
                tmp=tmp.next;            
            }
            tmp.next=_new;
        }
    }
    
    public void createGrafoMap(String user) {
        try {
            writer = new PrintWriter("grafo.txt", "UTF-8");
            writer.println("graph G{");
            writer.println("     layout= neato;");
            writer.println("     node[shape=circle]");
            Nodo tmp = head;
            while(tmp!=null){
                writer.println("      "+tmp.start+"--"+tmp.end+"  [label=\""+tmp.weight+"\"];");
                tmp=tmp.next;
            }
            writer.println("}");
            writer.close();
            
            
            
            Main.graficarDot("grafo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
