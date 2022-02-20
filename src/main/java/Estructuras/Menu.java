package Estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Menu {

    private boolean flag = true;
    static int pasos=0;
    Scanner sc = new Scanner(System.in);
    Scanner vn = new Scanner(System.in);
    ColaRecepcion colaR = new ColaRecepcion();
    ListaSimpleVenta listaVen = new ListaSimpleVenta();
    static PilaImage pilaC = new PilaImage();
    static PilaImage pilaBW = new PilaImage();
    ListList listaEspera = new ListList();
    ColaRecepcion listaAtentidos = new ColaRecepcion();
    
    String[] nombres = { "Hugo", "Martín", "Lucas",  "Mateo", "Leo",  "Daniel",  "Alejandro",  "Pablo", "Manuel", "Álvaro", "Adrián",  "David",  "Mario",  "Enzo",  "Diego",  "Marcos",  "Izan", "Javier",  "Marco",  "Álex" };
    String[] apellidos = {"Cabrera","Hernández","García","Martínez","López","González","Pérez","Rodriguéz","Sánchez","Ramírez","Cruz","Galindo","Ortega","Soto","Chinchilla","Juarez","Reyes","Izquierdo","Gill","Messi"};

    public Menu() {
        while (flag) {
            System.out.println("------------ UDrawing Paper ---------");
            System.out.println("---------------- MENU ---------------");
            System.out.println(" 1. Carga de Clientes");
            System.out.println(" 2. Cantidad de Ventanillas");
            System.out.println(" 3. Ejecutar Paso ");
            System.out.println(" 4. Estado en memoria de estructuras");
            System.out.println(" 5. Reportes");
            System.out.println(" 6. Acerca de");
            System.out.println(" 7. Salir ");
            System.out.println("--Ingrese una opccion: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("--->> Carga de Clientes <<---");
                    leerJson();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("--->> Cantidad de Ventanillas <<---");
                    crearVentanillas();
                    System.out.println();
                    break;
                case 3:
                    //System.out.println("--- Ejecutar Paso ---");
                    avanzarPasos();
                    break;
                case 4:
                    System.out.println("--->> Estado en memoria de estructuras <<---");
                    estados_Estruct();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("--->> Reportes <<---");
                    reportes();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("--->> Acerca de <<---");
                    System.out.println("Raudy Cabrera\n201901973\n");
                    break;
                case 7:
                    System.out.println("** Adios **\n");
                    flag = false;
                    break;
                default:
                    System.out.println("xxx- Ingresar opcion valida -xxx");
                    System.out.println();
                    break;
            }
        }
    }
    
    public void leerJson(){
        int cargaMasiva;
        JSONParser parser = new JSONParser();
        try{
            Object ob = parser.parse(new FileReader("Entrada.json"));
            JSONObject jsonObject = (JSONObject)ob;
            String key;
            JSONObject Job;
            
            for(int i=1;i<=jsonObject.size();i++){
                key = ""+jsonObject.get("Cliente"+Integer.toString(i));
                
                Object obj = parser.parse(key);
                Job = (JSONObject)obj;
                cargaMasiva=jsonObject.size();
                
                String id = (Job.get("id_cliente")).toString();
                String nombre = (Job.get("nombre_cliente")).toString();
                String color = (Job.get("img_color")).toString();
                String bw = (Job.get("img_bw")).toString();
                int pasos = 0;
                
                colaR.insertarR(Integer.parseInt(id),nombre,Integer.parseInt(color),Integer.parseInt(bw),pasos);
            }
            System.out.println(">>> Carga de clientes: Exitosa");
            //System.out.println("----- COLA -----");
            //colaR.imprimirCola();           
        }catch(FileNotFoundException e) { 
            System.out.println("***** Archivo No Encontrado *****");
        }
        catch(IOException e) { }
        catch(org.json.simple.parser.ParseException e) { }
    }
    
    public void estados_Estruct(){
        System.out.println("-- 1. Cola Recepción");
        System.out.println("-- 2. Ventanillas");
        System.out.println("-- 3. Clientes Atendidos");
        System.out.println("-- 4. Cola Impresoras");
        System.out.println("-- 5. Clientes en Espera");
        System.out.println("-- 6. Salir");
        System.out.println("-- Ingrese una opcion: ");
        Scanner gg = new Scanner(System.in);
        int opp = gg.nextInt();
        
        switch (opp) {
            case 1:
                System.out.println("------ Cola Recepcion");
                colaR.graphviz_recepcion(1);
                System.out.println();
                break;
            case 2:
                System.out.println("------ Lista Ventanillas");
                listaVen.GraphvizVentanillas();
                System.out.println();
                break;
            case 3:
                System.out.println("------ Cola Clientes Atendidos");
                listaAtentidos.graphviz_atendidos();
                System.out.println();
                break;
            case 4:
                System.out.println("------ Cola Impresoras");
                pilaC.GraphvizColor();
                System.out.println();
                break;
            case 5:
                System.out.println("------ Lista Clientes en Espera");
                listaEspera.graphiz_listEspera();
                System.out.println();
                break;
            case 6:
                System.out.println("------ Saliendo...");
                System.out.println();
                break;

            default:
                System.out.println("vvv Ingrese opcion valida vvv");
                System.out.println();
                break;
        }
        
        
    }
    
    public void crearVentanillas() {
        System.out.println("--Numero de ventanillas: ");
        Scanner as = new Scanner(System.in);
        int no_venta = as.nextInt();
        int ventanilla = 0;
        while (no_venta != 0) {
            ventanilla++;
            listaVen.insertar(ventanilla);
            no_venta--;
        }
        System.out.println();
    }
    
    public void avanzarPasos(){
        pasos++;
        System.out.println("_____________________________________");
        System.out.println("____________ Paso No." + String.valueOf(pasos) + " _____________");
        listaEspera.eliminar();
        imprimir();
        liberar_vent();
        listaVen.atender();
        listaVen.RecibirFotos();
        ingresar_recepcion();
        ingresar_aVentanilla();
        
        System.out.println();
    }
    
    public void imprimir() {

        pilaBW.menosPasos();
        pilaC.menosPasos();
        Image IBw = pilaBW.pop();
        Image ICl = pilaC.pop();
        if (IBw != null) {
            listaEspera.insetar_imagen(IBw.getId_cliente(), IBw);
        }
        if (ICl != null) {
            listaEspera.insetar_imagen(ICl.getId_cliente(), ICl);
        }
    }
    
    public void ingresar_recepcion() {
        int no_ramd = num_random();
        int color = num_random();
        int bw = num_random();
        int actual = colaR.obtenerCola();
        while (no_ramd != 0) {
            actual++;
            colaR.insertarR(actual, nombre_random(nombres)+ " " + nombre_random(apellidos), color, bw, pasos);
            no_ramd--;
        }
    }
    
    public void ingresar_aVentanilla() {
        int VentanillasLibres = listaVen.vent_disponibles();
        if (VentanillasLibres != 0) {
            Cliente cliente = colaR.desencolar();
            listaVen.clienteVentanilla(cliente);
        }

    }
    
    public int num_random() {
        int min = 0;
        int max = 4;
        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        return value;        
    }
    
    public String nombre_random(String[] nombre){
        String n="";
        int min = 1;
        int max = nombre.length - 1;
        for (int i = min; i <= max; i++) {
            n = nombres[(int)(Math.random()*(max - min))];
        }
        return n;
    }
    
    public void liberar_vent(){
        int tam = listaVen.tamanio();
        while (tam != 0) {
            Cliente cliente_aEspera = listaVen.sacarClienteVentanilla();
            PilaImage pila = listaVen.IngresarImpresionesAcola();
            if (pila != null) {
                int sizeImagenes = pila.no_nodos();
                while (sizeImagenes != 0) {
                    Image img = pila.pop();
                    if ("Color".equals(img.getColor())) {
                        pilaC.push_Impr(img.getId_cliente(), img.getId_img(), 2, img.getColor());
                    } else {
                        pilaBW.push_Impr(img.getId_cliente(), img.getId_img(), 1, img.getColor());
                    }
                    sizeImagenes--;
                }
            }
            if (cliente_aEspera != null) {
                listaEspera.insertar_listEspera(cliente_aEspera.getId_cliente(), cliente_aEspera.getNombre_cliente(), cliente_aEspera.getImpr_color(), cliente_aEspera.getImpr_bw(), cliente_aEspera.getVentanilla(), cliente_aEspera.getPasos());
            }
            tam--;
        }  
    }
    
    public void reportes(){
        System.out.println("------- Reportes -------");
        System.out.println("** 1. Top 5 de clientes con mayor cantidad de imágenes a color.");
        System.out.println("** 2. Top 5 de clientes con menor cantidad de imágenes en blanco y negro.");
        System.out.println("** 3. Información del cliente que más pasos estuvo en el sistema.");
        System.out.println("** 4. Datos de un cliente en específico");
        System.out.println("** 5. Salir");
        System.out.println("** Ingrese una opcion: ");
        Scanner op = new Scanner(System.in);
        int rep = op.nextInt();
        switch (rep) {
            case 1:
                System.out.println("--- Top 5 de clientes con mayor cantidad de imágenes a color ---");
                break;
            case 2:
                System.out.println("--- Top 5 de clientes con menor cantidad de imágenes en blanco y negro ---");
                break;
            case 3:
                System.out.println("--- Información del cliente que más pasos estuvo en el sistema ---");
                break;
            case 4:
                System.out.println("--- Datos de un cliente en específico ---");
                break;
            case 5:
                System.out.println("--- Saliendo ---");
                break;
            default:
                System.out.println("-*-* Ingrese opcion valida *-*-");
                break;
        }
        
    }

    

}
