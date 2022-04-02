/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import Estructuras.*;
import Arboles.*;
/**
 *
 * @author DELL
 */
public class Cliente {
    
    private long dpi;
    private String nombre;
    private String pass;
    
    private List albumes;
    private ABB capas;
    private ArbolAvl imagenes;
    
    

    public Cliente(long dpi, String nombre, String pass) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.pass = pass;
        albumes = new List();
        capas = new ABB();
        imagenes = new ArbolAvl();
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
    
    /**
     * @return the albumes
     */
    public List getAlbumes() {
        return albumes;
    }

    /**
     * @param albumes the albumes to set
     */
    public void setAlbumes(List albumes) {
        this.albumes = albumes;
    }
    
    public void abrirVentana(){
        
    }
    
    /**
     * @return the capas
     */
    public ABB getCapas() {
        return capas;
    }

    /**
     * @param capas the capas to set
     */
    public void setCapas(ABB capas) {
        this.capas = capas;
    }

    /**
     * @return the imagenes
     */
    public ArbolAvl getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(ArbolAvl imagenes) {
        this.imagenes = imagenes;
    }
    
    
    //----------------------------------------------------
    
    public void imprimir(){
        System.out.println("--------------------------------");
        System.out.println("DPI: " + getDpi());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Password: " + getPass());
    }
    
    public void agregarAlbum(Album nAlbum){
        getAlbumes().insertar(nAlbum);
    }
    
    public int contarAlbumes(){
        return getAlbumes().tamanio();
    }
    
    public void agregarCapa(Capa capa){
        capas.insertar(capa);
    }
    
    public int contarCapas(){
        return capas.contarCapas();
    }
    
    public void agregarImagen(Image img){
        imagenes.insertar(img);
    }
    
    public void eliminarImagen(int n){
        imagenes.raiz = imagenes.eliminar(n,imagenes.raiz);
    }
    
    public int contarImagenes(){
        return imagenes.contar();
    }
    
    
    
    
    
    
}
