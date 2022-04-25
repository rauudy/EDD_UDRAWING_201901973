/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;

/**
 *
 * @author DELL
 */
public class Bloque {
    private int index;
    private String timestamp;
    private int nonce;
    private Data data;
    private long previuoshash;
    private String hash;

    public Bloque() {
        this.index = index;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.data = data;
        this.previuoshash = previuoshash;
        this.hash = hash;
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
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * @return the previuoshash
     */
    public long getPreviuoshash() {
        return previuoshash;
    }

    /**
     * @param previuoshash the previuoshash to set
     */
    public void setPreviuoshash(long previuoshash) {
        this.previuoshash = previuoshash;
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
