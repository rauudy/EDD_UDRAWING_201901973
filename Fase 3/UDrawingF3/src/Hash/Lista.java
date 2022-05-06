/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Recursos.TbHash;

/**
 *
 * @author DELL
 */
public class Lista {

    // encabezado de la lista de enlaces
    public Men head;
    
    // agregar
    public void add(Men emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Men temp = head;
        while (temp.siguiente != null) {
            // hacia atrás
            temp = temp.siguiente;
        }
        temp.siguiente = emp;
    }

    // eliminar
    public void deleteEmpById(int dpi) {
        if (head == null) {
            return;
        }
        Men temp = head;

        while (true) {
            if (temp.dpi.equals(dpi)) {
                // eliminar
                head = temp.siguiente;
                break;
            }

            if (temp.siguiente == null) {
                break;
            }

            if (temp.siguiente.dpi.equals(dpi)) {
                // Eliminar el nodo emp
                temp.siguiente = temp.siguiente.siguiente;
                break;
            }

            // hacia atrás
            temp = temp.siguiente;
        }
    }

    // Encuentra
    public Men findEmpById(int id) {
        if (head == null) {
            return null;
        }
        Men temp = head;
        while (true) {
            if (temp.dpi.equals(id)) {
                break;
            }
            if (temp.siguiente == null) {
                temp = null;
                break;
            }
            // hacia atrás
            temp = temp.siguiente;
        }
        return temp;
    }

    // atravesar
    public void list(int no) {
        if (head == null) {
            System.out.println("Sección" + (no + 1) + "La lista vinculada está vacía");
            return;
        }
        System.out.print("Sección" + (no + 1) + "Información de la lista vinculada para");
        Men temp = head;
        while (true) {
            System.out.print(temp + " --> ");
            if (temp.siguiente == null) {
                break;
            }
            // hacia atrás
            temp = temp.siguiente;
        }
        System.out.println();
    }

    
}
