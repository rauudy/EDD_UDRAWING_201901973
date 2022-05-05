/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDrawing;
import Interfaz.*;
import Recursos.*;
import Estructuras.*;
/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int cont = 0;
    public static ArbolB clientes = new ArbolB();
    public static Cliente actual;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Inicio in = new Inicio();
        in.setVisible(true);
    }
    
    public static void graficarDot(String title){
       try {
           String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
           String fileInputPath = System.getProperty("user.dir") + "\\"+title+".txt";
           String fileOutputPath = System.getProperty("user.dir") + "\\"+title+".png";

           String tParam = "-Tpng";
           String tOParam = "-o";
           String[] cmd = new String[5];
           cmd[0] = dotPath;
           cmd[1] = tParam;
           cmd[2] = fileInputPath;
           cmd[3] = tOParam;
           cmd[4] = fileOutputPath;
           Runtime rt = Runtime.getRuntime();
           rt.exec( cmd );
           
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    
}
