
package Estructuras;

public class Image {
    private int id_cliente;
    private int id_img;
    private int pasos;
    private String color;
    private Image sig;


    public Image() {
        this.id_cliente = 0;
        this.id_img = 0;
        this.pasos = 0;
        this.color = "";
        this.sig = null;
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
     * @return the id_img
     */
    public int getId_img() {
        return id_img;
    }

    /**
     * @param id_img the id_img to set
     */
    public void setId_img(int id_img) {
        this.id_img = id_img;
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the sig
     */
    public Image getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Image sig) {
        this.sig = sig;
    }
    
    
}
