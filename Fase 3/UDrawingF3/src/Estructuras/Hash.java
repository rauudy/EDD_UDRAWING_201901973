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
public class Hash {
    
    private BigInteger llave;
    private int indice;
    private Mensajero mensajero;

    public Hash(BigInteger llave, Mensajero mensajero) {
        this.llave = llave;
        this.mensajero = mensajero;
    }

    /**
     * @return the llave
     */
    public BigInteger getLlave() {
        return llave;
    }

    /**
     * @param llave the llave to set
     */
    public void setLlave(BigInteger llave) {
        this.llave = llave;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return the mensajero
     */
    public Mensajero getMensajero() {
        return mensajero;
    }

    /**
     * @param mensajero the mensajero to set
     */
    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }
    
    
    
    
    
    
}
