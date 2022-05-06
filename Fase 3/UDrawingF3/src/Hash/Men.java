/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Recursos.TbHash;
import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class Men {

    public String nombres, apellidos, licencia, genero, telefono, direccion;
    public BigInteger dpi;
    public Men siguiente;

    public Men(BigInteger dpi, String nombres, String apellidos, String licencia, String genero, String telefono, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.licencia = licencia;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dpi = dpi;
        //this.siguiente = siguiente;
    }
}
