/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.math.BigInteger;
import Recursos.*;

/**
 *
 * @author DELL
 */
public class TablaHash {

    private Hash hashArray[];
    private int sizeTable, countElements;

    public TablaHash(int sizeTable) {
        this.sizeTable = sizeTable;
        hashArray = new Hash[sizeTable];
    }

    public boolean insertar(BigInteger llave, Mensajero valor) {
        Hash hashitem = new Hash(llave, valor);
        int indice = HashDispersion(hashitem.getLlave());
        int i = 0;
        while (true) {
            if (SeInserta(indice, llave) == true) {
                hashitem.setIndice(indice);
                hashArray[indice] = hashitem;
                this.countElements++;
                break;
            } else {
                indice = Colision(llave);
            }
        }
        return false;
    }

    int HashDispersion(BigInteger llave) {
        int funcion = llave.mod(new BigInteger(llave.toString())).intValue();
        return funcion;
    }

    boolean SeInserta(int indice, BigInteger llave) {
        while (hashArray[indice] != null && hashArray[indice].getLlave() != null) {
            if (hashArray[indice].getLlave() == llave) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    boolean ValidateSize() {
        float c = (float) (0.75 * this.sizeTable);
        return this.countElements > c;
    }

    public int Colision(BigInteger llave) {
        int i = 1;
        int indice = (llave.mod(new BigInteger("7")).intValue() + 1) * i;
        return indice;
    }
}
