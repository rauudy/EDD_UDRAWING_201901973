/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;

import Estructuras.Merkle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Recursos.*;
import UDrawing.*;

/**
 *
 * @author DELL
 */
public class Blockchain {
    
    Nodo genesis;
    int index;
    
    public Blockchain() {
        genesis = null;
        index = 0;
    }   
    
    public class Nodo{
        Nodo next;
        Bloque info;
        
        public Nodo(Bloque info){
            this.info = info;
            this.next = null;
        }
    }
    
    public void agregar(Bloque info){
        if(genesis == null){
            genesis = new Nodo(info);
        }else{
            Nodo aux = genesis;
            while(aux.next!=null){
                aux = aux.next;
            }
            aux.next = new Nodo(info);
        }
    }
    
    public String ultimoH(){
        if(genesis == null){
            return "0000";
        }else{
            Nodo aux = genesis;
            while(aux.next!=null){
                aux = aux.next;
            }
            return aux.info.getHash();
        }
    }
    
    public void imprimir(){
        Nodo aux = genesis;
        while(aux!=null){
            aux.info.imprimir();
            aux = aux.next;
        }
    }
    
    public void crearBloque(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy::HH:mm:ss");
        String hora = dtf.format(LocalDateTime.now());
        
        String previusH = ultimoH();
        
        Main.arbol.generarArbol();
        String rooth = Main.arbol.getMerkleRoot();
        
        int nonce = 0;      
        String hash = Main.convertirSHA256(index+hora+previusH+rooth+nonce);
        char[] aCaracteres = hash.toCharArray();
        boolean correcto = false;
        
        int cant = Main.cantCeros;
        int ss = 0;
               
        while (!correcto) {           
            for(int i = 0;i<cant;i++){
                if(aCaracteres[i] == '0'){
                    ss++;
                }
            }
            if(ss==cant){
                correcto = true;
            }else{
                nonce++;
                hash = Main.convertirSHA256(index+hora+previusH+rooth+nonce);
                aCaracteres = hash.toCharArray();
                ss = 0;
            }
        }
        
        ArrayList<Entrega> et = Main.entregas;
        Bloque n = new Bloque(index,hora,previusH,nonce,rooth,hash,et);
        agregar(n);
        Main.arbol = new Merkle();
        Main.entregas = new ArrayList<Entrega>();
        generarJson(n);
        index++;
    }
    
    public void generarJson(Bloque n){
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(n));
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            String ruta = System.getProperty("user.dir") + "\\blockchain\\Bloques\\"+n.getIndex()+".json";
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.println(prettyGson.toJson(n));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
