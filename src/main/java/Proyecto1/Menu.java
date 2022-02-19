package Proyecto1;

import Estructuras.ColaRecepcion;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Menu {

    boolean flag = true;
    Scanner sc = new Scanner(System.in);
    Scanner vn = new Scanner(System.in);
    ColaRecepcion colaR = new ColaRecepcion();

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
                    System.out.println("Numero de ventanillas: ");
                    int vt = vn.nextInt();
                    
                    //Crear Lista Ventanillas, nodos con pilas de image
                    
                    break;
                case 3:
                    System.out.println("--- Ejecutar Paso ---");
                    break;
                case 4:
                    System.out.println("--- Estado en memoria de estructuras ---");
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
                
                colaR.Insertar((Job.get("id_cliente")).toString(),(Job.get("nombre_cliente")).toString(),
                        (Job.get("img_color")).toString(),(Job.get("img_bw")).toString());
            }
            
            System.out.println("Carga de clientes: Exitosa");
            
            
        }catch(FileNotFoundException e) { 
            System.out.println("***** Archivo No Encontrado *****");
        }
        catch(IOException e) { }
        catch(org.json.simple.parser.ParseException e) { }
    }
    
    

}
