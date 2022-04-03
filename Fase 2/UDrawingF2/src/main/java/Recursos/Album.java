/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import Estructuras.*;

/**
 *
 * @author DELL
 */

public class Album {
    
    private String nombre;
    private List images;

    public Album(String nombre, List images) {
        this.nombre = nombre;
        this.images = images;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the images
     */
    public List getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List images) {
        this.images = images;
    }    
}
