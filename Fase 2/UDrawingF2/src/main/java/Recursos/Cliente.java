/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

/**
 *
 * @author DELL
 */
public class Cliente {
    
    private long dpi;
    private String nombre;
    private String pass;

    public Cliente(long dpi, String nombre, String pass) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.pass = pass;
    }

    /**
     * @return the dpi
     */
    public long getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(long dpi) {
        this.dpi = dpi;
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void imprimir(){
        System.out.println("--------------------------------");
        System.out.println("DPI: " + dpi);
        System.out.println("Nombre: " + nombre);
        System.out.println("Password: " + pass);
    }
    
    public void abrirVentana(){
        
    }
    
}
