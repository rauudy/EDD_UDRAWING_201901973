/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;

import java.io.UnsupportedEncodingException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

/**
 *
 * @author DELL
 */
public class Block {

    private String hash;
    private String hash_ant;
    private String data;
    private long timeStamp;
    private int nonce;
    private Block siguiente;

    public Block() {
        this.data = "";
        this.hash_ant = hash_ant;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
        this.siguiente = null;
    }

    public String calculateBlockHash() {
        String dataToHash = getHash_ant()
                + Long.toString(getTimeStamp())
                + Integer.toString(getNonce())
                + getData();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            //logger.log(Level.SEVERE, ex.getMessage());
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();

    }

    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            setNonce(getNonce() + 1);
            setHash(calculateBlockHash());
        }
        return getHash();
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

    /**
     * @return the hash_ant
     */
    public String getHash_ant() {
        return hash_ant;
    }

    /**
     * @param hash_ant the hash_ant to set
     */
    public void setHash_ant(String hash_ant) {
        this.hash_ant = hash_ant;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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
     * @return the siguiente
     */
    public Block getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Block siguiente) {
        this.siguiente = siguiente;
    }
}
