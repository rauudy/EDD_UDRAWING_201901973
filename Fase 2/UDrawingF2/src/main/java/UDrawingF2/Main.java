/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDrawingF2;
import Recursos.*;
import Arboles.*;
import Interfaz.*;
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