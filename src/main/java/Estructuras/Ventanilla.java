
package Estructuras;

public class Ventanilla {
    private int vent;
    private PilaImage pila;
    private Cliente actual;
    private Ventanilla sig;

    public Ventanilla() {
        this.vent = 0;
        this.pila = new PilaImage();
        this.actual = null;
        this.sig = null;
    }

    /**
     * @return the vent
     */
    public int getVent() {
        return vent;
    }

    /**
     * @param vent the vent to set
     */
    public void setVent(int vent) {
        this.vent = vent;
    }

    /**
     * @return the pila
     */
    public PilaImage getPila() {
        return pila;
    }

    /**
     * @param pila the pila to set
     */
    public void setPila(PilaImage pila) {
        this.pila = pila;
    }

    /**
     * @return the actual
     */
    public Cliente getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(Cliente actual) {
        this.actual = actual;
    }

    /**
     * @return the sig
     */
    public Ventanilla getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Ventanilla sig) {
        this.sig = sig;
    }
    
}
