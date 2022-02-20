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
    private String nombre_cliente;
    private int id_cliente;
    private int img_color;
    private int img_bw;
    private int impr_color;
    private int impr_bw;
    private int pasos;
    private int ventanilla;
    
    private Cliente sig;
    private Cliente ant;
        
    private PilaImage pilaImg;

    public Cliente() {
        this.nombre_cliente = "";
        this.id_cliente = 0;
        this.img_color = 0;
        this.img_bw = 0;
        this.impr_color = 0;
        this.impr_bw = 0;
        this.pasos = 0;
        this.ventanilla = 0;
        this.sig = null;
        this.ant = null;
        this.pilaImg = null;
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

    /**
     * @return the impr_color
     */
    public int getImpr_color() {
        return impr_color;
    }

    /**
     * @param impr_color the impr_color to set
     */
    public void setImpr_color(int impr_color) {
        this.impr_color = impr_color;
    }

    /**
     * @return the impr_bw
     */
    public int getImpr_bw() {
        return impr_bw;
    }

    /**
     * @param impr_bw the impr_bw to set
     */
    public void setImpr_bw(int impr_bw) {
        this.impr_bw = impr_bw;
    }

    /**
     * @return the pasos
     */
    public int getPasos() {
        return pasos;
    }

    /**
     * @param pasos the pasos to set
     */
    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    /**
     * @return the ventanilla
     */
    public int getVentanilla() {
        return ventanilla;
    }

    /**
     * @param ventanilla the ventanilla to set
     */
    public void setVentanilla(int ventanilla) {
        this.ventanilla = ventanilla;
    }

    /**
     * @return the sig
     */
    public Cliente getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Cliente sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public Cliente getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(Cliente ant) {
        this.ant = ant;
    }

    /**
     * @return the pilaImg
     */
    public PilaImage getPilaImg() {
        return pilaImg;
    }

    /**
     * @param pilaImg the pilaImg to set
     */
    public void setPilaImg(PilaImage pilaImg) {
        this.pilaImg = pilaImg;
    }
    
    
    
    
}
