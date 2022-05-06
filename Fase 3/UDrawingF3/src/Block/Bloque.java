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
    private int index;
    private String timestamp;
    private int nonce;
    private ArrayList<Entrega> entregas;
    private String previusHash;
    private String rootMerkle;
    private String hash;

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
        System.out.println("INDEX: " + getIndex());
        System.out.println("TIMESTAMP: " + getTimestamp());
        System.out.println("NONCE: " + getNonce());
        System.out.println("PHASH: " + getPreviusHash());
        System.out.println("ROOTM: " + getRootMerkle());
        System.out.println("HASH: " + getHash());
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the nonce
     */
    public int getNonce() {
        return nonce;
    }

    /**
     * @param nonce the nonce to set
     */
    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    /**
     * @return the entregas
     */
    public ArrayList<Entrega> getEntregas() {
        return entregas;
    }

    /**
     * @param entregas the entregas to set
     */
    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }

    /**
     * @return the previusHash
     */
    public String getPreviusHash() {
        return previusHash;
    }

    /**
     * @param previusHash the previusHash to set
     */
    public void setPreviusHash(String previusHash) {
        this.previusHash = previusHash;
    }

    /**
     * @return the rootMerkle
     */
    public String getRootMerkle() {
        return rootMerkle;
    }

    /**
     * @param rootMerkle the rootMerkle to set
     */
    public void setRootMerkle(String rootMerkle) {
        this.rootMerkle = rootMerkle;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }
    
    
    
}
