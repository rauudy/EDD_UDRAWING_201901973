/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import Arboles.*;

/**
 *
 * @author DELL
 */
public class Image {
    private int id;
    private int size;
    private ArbolAbb capas;

    public Image(int id, ArbolAbb capas) {
        this.id = id;
        this.capas = capas;
    }
    
    public Image(int id, int size) {
        this.id = id;
        this.size = size;
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
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the capas
     */
    public ArbolAbb getCapas() {
        return capas;
    }

    /**
     * @param capas the capas to set
     */
    public void setCapas(ArbolAbb capas) {
        this.capas = capas;
    }
}
