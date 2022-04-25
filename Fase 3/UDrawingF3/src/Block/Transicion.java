/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;


import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Transicion {

    // Hash de la transacción e identificador único de ésta
    private byte[] hash;

    // Clave pública del emisor de la transacción
    private byte[] emisor;

    // Clave pública del destinatario de la transacción
    private byte[] destinatario;

    // Valor a ser transferido
    private double cantidad;

    // Firma con la clave privada para verificar que la transacción fue realmente enviada por el emisor
    private byte[] firma;

    // Timestamp de la creación de la transacción en milisegundos desde el 1/1/1970
    private long timestamp;

    // Constructores
    public Transicion() {
    }

    public Transicion(byte[] emisor, byte[] receptor, double cantidad, byte[] firma) {
        this.emisor = emisor;
        this.destinatario = receptor;
        this.cantidad = cantidad;
        this.firma = firma;
        this.timestamp = System.currentTimeMillis();
        this.hash = calcularHashTransaccion();
    }

    // Getters y setters
    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public byte[] getEmisor() {
        return emisor;
    }

    public void setEmisor(byte[] emisor) {
        this.emisor = emisor;
    }

    public byte[] getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(byte[] destinatario) {
        this.destinatario = destinatario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * El contenido de la transaccion que es firmado por el emisor con su clave
     * privada
     *
     * @return byte[] Array de bytes representando el contenido de la
     * transaccion
     */
    public byte[] getContenidoTransaccion() {
        byte[] contenido;
        return contenido;
    }

    /**
     * Calcular el hash del contenido de la transacción y que pasa a ser el
     * identificador de la transacción
     *
     * @return Hash SHA256
     */
    public byte[] calcularHashTransaccion() {
        return DigestUtils.sha256(getContenidoTransaccion());
    }

    /**
     * Comprobar si una transacción es válida
     *
     * @return true si tiene un hash válido y la firma es válida
     */
    public boolean esValida() {
        // verificar hash
        if (!Arrays.equals(getHash(), calcularHashTransaccion())) {
            return false;
        }

        // verificar firma
        try {
            if (!UtilidadesFirma.validarFirma(getContenidoTransaccion(), getFirma(), emisor)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Transicion tr = (Transicion) o;

        return Arrays.equals(hash, tr.hash);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(hash);
    }

    @Override
    public String toString() {
        return "{" + hash + ", " + emisor + ", " + destinatario + ", " + cantidad + ", " + firma + ", " + new Date(timestamp) + "}";
    }
}
