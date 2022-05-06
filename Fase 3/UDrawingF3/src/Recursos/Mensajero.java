/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class Mensajero {
    
    private String nombres;
    private String apellidos;
    //Mensajero siguiente;
    private String licencia;
    private String genero;
    private String telefono;
    private String direccion;
    private long dpi;
    private int entregas = 0;

    public Mensajero(long dpi, String nombres, String apellidos, String licencia, String genero, String telefono, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.licencia = licencia;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dpi = dpi;
        //this.siguiente = siguiente;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the licencia
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * @param licencia the licencia to set
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public void entregar(){
        setEntregas(getEntregas() + 1);
    }

    /**
     * @return the entregas
     */
    public int getEntregas() {
        return entregas;
    }

    /**
     * @param entregas the entregas to set
     */
    public void setEntregas(int entregas) {
        this.entregas = entregas;
    }

    

    
    
}
