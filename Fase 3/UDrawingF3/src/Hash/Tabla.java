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
public class Tabla {
    private Lista[] empLinkedListArray;
    private int size;

    public Tabla(int size) {
        this.empLinkedListArray = new Lista[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new Lista();
        }
    }

    // Eliminar información emp de la tabla hash de acuerdo con la identificación
    public void deleteById(int id) {
        int is = hashFun(id);
        empLinkedListArray[is].deleteEmpById(id);
    }

    // Encuentra información emp de la tabla hash según id
    public void findEmpById(int id) {
        int is = hashFun(id);
        Men emp = empLinkedListArray[is].findEmpById(id);
        if (emp != null) {
            System.out.println("id valor correspondiente:" + emp);
        }
    }

    // Recorrer la tabla hash
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void add(Men emp) {
        int a = emp.dpi.intValue();
        int empLinkedListNO = hashFun(a);
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // Escribe una función hash y usa un método de módulo simple
    private int hashFun(int id) {
        return id % size;
    }
}
