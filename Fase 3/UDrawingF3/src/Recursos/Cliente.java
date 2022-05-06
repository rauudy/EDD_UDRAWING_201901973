/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Interfaz.Menu;

/**
 *
 * @author DELL
 */
public class Cliente {
    private long dpi;
    private long telefono;
    private long idMuni;
    private String nombre;
    private String usuario;
    private String correo;
    private String contraseña;
    private String direccion;
    int solucitudes = 0;
    

    public Cliente(long dpi, String nombre, String usuario, String correo, String contraseña, long telefono, String direccion, long idMuni) {
        this.dpi = dpi;
        this.telefono = telefono;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.idMuni = idMuni;
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
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
     * @return the idMuni
     */
    public long getIdMuni() {
        return idMuni;
    }

    /**
     * @param idMuni the idMuni to set
     */
    public void setIdMuni(long idMuni) {
        this.idMuni = idMuni;
    }

    
    
    
    //--------------------------------------------------
    
    public void abrirVentana(){
        Menu men = new Menu();
        men.setVisible(true);
        //capas.mostrarCapas(men);
        //imagenes.mostrarImgs(men);
    }

    public void solicitar(){
        solucitudes += 1;
    }

   
    
}
