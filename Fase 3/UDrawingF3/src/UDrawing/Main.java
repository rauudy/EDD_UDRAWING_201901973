/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDrawing;

import Interfaz.*;
import Recursos.*;
import Estructuras.*;
import Block.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.Timer;

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
    public static int cantCeros = 4;
    public static Lista rutas = new Lista();

    public static Blockchain blockchein = new Blockchain();
    public static Merkle arbol = new Merkle();
    public static ArrayList<Entrega> entregas = new ArrayList<Entrega>();

    public static ArrayList<Mensajero> mensajeros = new ArrayList<Mensajero>();
    public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
    public static ListaAdyacencia listaAD = new ListaAdyacencia();

    public static ArrayList<Cliente> clientesC = new ArrayList<Cliente>();

    public static void main(String[] args) {
        // TODO code application logic here
        Inicio in = new Inicio();
        in.setVisible(true);
    }

    public static String convertirSHA256(String password) {
        MessageDigest ms = null;
        try {
            ms = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = ms.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void graficarDot(String title) {
        try {
            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            String fileInputPath = System.getProperty("user.dir") + "\\" + title + ".txt";
            String fileOutputPath = System.getProperty("user.dir") + "\\" + title + ".png";
            String tParam = "-Tpng";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addMensajero(Mensajero nuevo){
        long dpi = nuevo.getDpi(); 
        verTamanio();
        int tamanio = mensajeros.size();
        int pos = Math.toIntExact(dpi%tamanio);
        if(pos<=tamanio-1){
            Mensajero mm = mensajeros.get(pos);
            if(mm==null){
                mensajeros.set(pos, nuevo);
            }else{
                addMensajeroR(nuevo,1);
            }
        }else{
            System.out.println("Error");
        }       
    }
    
    public static void addMensajeroR(Mensajero nuevo, int i){
        long dpi = nuevo.getDpi();
        int tamanio = mensajeros.size();
        int pos = Math.toIntExact((dpi%7+1)*i);
        if(pos<=tamanio-1){
            Mensajero mm = mensajeros.get(pos);
            if(mm==null){
                mensajeros.set(pos, nuevo);
            }else{
                addMensajeroR(nuevo,i+1);               
            }
        }else{
            System.out.println("Error");
        }   
    }
    
    public static void verTamanio(){
        int tamanio = mensajeros.size();
        int porcentaje = Math.toIntExact(Math.round(tamanio*0.75));
        int cant = 0;
        for(int i = 0;i<tamanio;i++){
            Mensajero m = mensajeros.get(i);
            if(m!=null){
                cant += 1;
            }
        }
        if(cant>=porcentaje){
            int nuevaCant = tamanio +1;
            while (!esPrimo(nuevaCant)) {                
                nuevaCant += 1;
            }
            int mas = nuevaCant-tamanio;
            for(int j=0;j<mas;j++){
                mensajeros.add(null);
            };
        }
    } 
    
    public static boolean esPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
          return false;
        }
        for (int x = 2; x < numero / 2; x++) {
          if (numero % x == 0){
              return false;
          }         
        }
        return true;
    }

    public static Timer tiempooooo = new Timer(180000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Generando Bloque ...");
            blockchein.crearBloque();
        }
    });

    public static void graphMensajeros() {
        String dott = "digraph G{\nlabel=\"Mensajeros\";\n";
        dott += "N0[shape=record,label=\"{";
        for (int i = 0; i < mensajeros.size(); i++) {
            Mensajero a = mensajeros.get(i);
            if (a != null) {
                dott += "DPI:" + a.getDpi() + "\\nNOMBRE: " + a.getNombres() + "\\nAPELLIDO: " + a.getApellidos() + "\\nENTREGAS: " + a.getEntregas() + "|";
            } else {
                dott += "-" + i + "-|";
            }
        }
        dott = dott.substring(0, dott.length() - 1);
        dott += "}\"];\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\mensajeros.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dott);
            bw.close();
            graficarDot("mensajeros");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
