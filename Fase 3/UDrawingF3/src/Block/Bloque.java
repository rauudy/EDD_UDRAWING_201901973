/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;

import Recursos.Entrega;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Bloque {
    int index;
    String timestamp;
    int nonce;
    ArrayList<Entrega> entregas;
    String previusHash;
    String rootMerkle;
    String hash;

    public Bloque(int index, String timestamp, String previusH, int nonce, String rootMerkle, String hash, ArrayList<Entrega> entregas) {
        this.index = index;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.previusHash = previusH;
        this.rootMerkle = rootMerkle;
        this.hash = hash;
        this.entregas = entregas;
    }

    public void imprimir() {
        System.out.println("INDEX: " + index);
        System.out.println("TIMESTAMP: " + timestamp);
        System.out.println("NONCE: " + nonce);
        System.out.println("PHASH: " + previusHash);
        System.out.println("ROOTM: " + rootMerkle);
        System.out.println("HASH: " + hash);
    }
    
}
