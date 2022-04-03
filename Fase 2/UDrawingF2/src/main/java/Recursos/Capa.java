/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

import Estructuras.MatrizDispersa;

/**
 *
 * @author DELL
 */

public class Capa {
    private int id;
    private MatrizDispersa pixels;

    public Capa(int id, MatrizDispersa pixels) {
        this.id = id;
        this.pixels = pixels;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pixels
     */
    public MatrizDispersa getPixels() {
        return pixels;
    }

    /**
     * @param pixels the pixels to set
     */
    public void setPixels(MatrizDispersa pixels) {
        this.pixels = pixels;
    }
    
    
}
