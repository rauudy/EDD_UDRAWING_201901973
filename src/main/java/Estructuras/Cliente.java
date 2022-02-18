/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author DELL
 */
public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private int img_color;
    private int img_bw;

    public Cliente(int id_cliente, String nombre_cliente, int img_color, int img_bw) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_color = img_color;
        this.img_bw = img_bw;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the nombre_cliente
     */
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    /**
     * @param nombre_cliente the nombre_cliente to set
     */
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    /**
     * @return the img_color
     */
    public int getImg_color() {
        return img_color;
    }

    /**
     * @param img_color the img_color to set
     */
    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    /**
     * @return the img_bw
     */
    public int getImg_bw() {
        return img_bw;
    }

    /**
     * @param img_bw the img_bw to set
     */
    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

    @Override
    public String toString() {
        return "Cliente\n id: "+id_cliente+" Nombre: "+nombre_cliente+" ImgColor: "+img_color+" ImgB&N: "+img_bw;
    }
    
    
}
