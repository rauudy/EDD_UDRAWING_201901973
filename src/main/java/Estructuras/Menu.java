package Estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Menu {

    private boolean flag = true;
    static int pasos=0;
    Scanner sc = new Scanner(System.in);
    Scanner vn = new Scanner(System.in);
    ColaRecepcion colaR = new ColaRecepcion();
    static PilaImage pilaC = new PilaImage();
    static PilaImage pilaBW = new PilaImage();
    

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
                    System.out.println("--- Carga de Clientes ---");
                    leerJson();
                    break;
                case 2:
                    System.out.println("--- Cantidad de Ventanillas ---");
                    crearVentanillas();                   
                    break;
                case 3:
                    System.out.println("--- Ejecutar Paso ---");
                    avanzarPasos();
                    break;
                case 4:
                    System.out.println("--- Estado en memoria de estructuras ---");
                    estados_Estruct();
                    break;
                case 5:
                    System.out.println("--- Reportes ---");
                    break;
                case 6:
                    System.out.println("--- Acerca de ---");
                    System.out.println("Raudy Cabrera\n201901973");
                    break;
                case 7:
                    System.out.println("** Adios **");
                    flag = false;
                    break;
                default:
                    System.out.println("xxx- Ingresar opcion valida -xxx");
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
                
                colaR.insertar(Integer.parseInt(id),nombre,Integer.parseInt(color),Integer.parseInt(bw),pasos);
            }
            
            System.out.println("Carga de clientes: Exitosa");
            
            System.out.println("----- COLA -----");
            colaR.imprimirCola();
            
            
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
        Scanner gg = new Scanner(System.in);
        int opp = gg.nextInt();
        
        switch (opp) {
            case 1:
                System.out.println("------ Cola Recepcion");
                break;
            case 2:
                System.out.println("------ Lista Ventanillas");
                break;
            case 3:
                System.out.println("------ Cola Clientes Atendidos");
                break;
            case 4:
                System.out.println("------ Cola Impresoras");
                pilaC.GraphvizColor();
                break;
            case 5:
                System.out.println("------ Lista Clientes en Espera");
                break;
            case 6:
                System.out.println("------ Saliendo...");
                break;

            default:
                System.out.println("vvv Ingrese opcion valida vvv");
                break;
        }
        
        
    }
    
    public void crearVentanillas() {
        
        System.out.println("Numero de ventanillas: ");
        Scanner as = new Scanner(System.in);
        int no_venta = as.nextInt();
        int ventanilla = 0;

        while (no_venta != 0) {

            ventanilla++;
            //crear ventanilla

            no_venta--;
        }
    }
    
    public void avanzarPasos(){
        pasos++;

        System.out.println("_______ Paso " + String.valueOf(pasos) + " _______");
        
        Imprimir();
    }
    
    public void Imprimir() {

        pilaBW.menosPasos();
        pilaC.menosPasos();
        Image IBw = pilaBW.pop();
        Image ICl = pilaC.pop();
    }

    

}
