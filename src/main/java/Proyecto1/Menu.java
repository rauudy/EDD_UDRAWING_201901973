package Proyecto1;

import java.util.Scanner;
public class Menu {

    boolean flag = true;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        while (flag) {
            System.out.println("------------ UDrawing Paper ---------");
            System.out.println("---------------- MENU ---------------");
            System.out.println(" 1. Carga de Clientes");
            System.out.println(" 2. Cantidad de Centanillas");
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
                    break;
                case 2:
                    System.out.println("--- Cantidad de Ventanillas ---");
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

}
