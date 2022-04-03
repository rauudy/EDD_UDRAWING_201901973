/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;
import Estructuras.*;
import Arboles.*;
import Interfaz.*;
import UDrawingF2.*;

/**
 *
 * @author DELL
 */

public class Cliente {
    
    private long dpi;
    private String nombre;
    private String pass;
    
    private List albumes;
    private ArbolAbb capas;
    private ArbolAvl imagenes;    

    public Cliente(long dpi, String nombre, String pass) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.pass = pass;
        albumes = new List();
        capas = new ArbolAbb();
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
    
    //Metodos
    
    public void abrirVentana(){
        Menu men = new Menu();
        men.setVisible(true);
        capas.mostrarCapas(men);
        imagenes.mostrarImgs(men);
    }
    
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
    
    //Generar los Graphiz
    
    public void graficarAlbum(){
        albumes.graficar(dpi+"_Albumes");
        Main.graficarDot(dpi+"_Albumes");
    }
    
    public void graficarACapas(){
        capas.graficar(dpi+"_Capas");
    }
    
    public void graficarImagenes(){
        imagenes.graficar(dpi+"_Imagenes");
        Main.graficarDot(dpi+"_Imagenes");
    }
    
    public void generarImagen(int n, String t){
        ArbolAbb capss = imagenes.buscar(n);
        MatrizDispersa img;
        img = capss.crearImagen(t);
        img.graficarMatriz(dpi+"_img"+n);
        Main.graficarDot(dpi+"_img"+n);
    }
    
    public void generarArbol_CapaDeImagen(int n){
        ArbolAbb capas = imagenes.buscar(n);
        capas.graficar(dpi+"_ac_img"+n);
        Main.graficarDot(dpi+"_ac_img"+n);
    }
    
    public void generarTop5(){
        List top = imagenes.top5();
        top.graficarTop5(dpi+"_top5");
        Main.graficarDot(dpi+"_top5");
    }
    
    public void capas_Hojas(){
        capas.generarTablaCapasHojas(dpi+"_capasHojas");
        Main.graficarDot(dpi+"_capasHojas");
    }
    
    public void recorridos(){
        capas.graficarRecorridos(dpi+"_recorridos");
        Main.graficarDot(dpi+"_recorridos");      
    }
    
    public void profundidad(){
        capas.generarProfundidad(dpi+"_profundidad");
        Main.graficarDot(dpi+"_profundidad");
    }
    
    
}
