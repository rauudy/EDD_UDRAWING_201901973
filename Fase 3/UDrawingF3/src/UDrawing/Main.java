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
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
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

    public static Timer tiempooooo = new Timer(180000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Generando Bloque ...");
            blockchein.crearBloque();
        }
    });

    public static void graphMensajeros() {
        String resultado = "digraph G{\nlabel=\"Mensajeros\";\n";
        resultado += "N0[shape=record,label=\"{";
        for (int i = 0; i < mensajeros.size(); i++) {
            Mensajero a = mensajeros.get(i);
            if (a != null) {
                resultado += "DPI:" + a.getDpi() + "\\nNOMBRE: " + a.getNombres() + "\\nAPELLIDO: " + a.getApellidos() + "\\nENTREGAS: " + a.getEntregas() + "|";
            } else {
                resultado += "-" + i + "-|";
            }
        }
        resultado = resultado.substring(0, resultado.length() - 1);
        resultado += "}\"];\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\mensajeros.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.close();
            graficarDot("mensajeros");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
