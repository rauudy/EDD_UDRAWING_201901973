package Arboles;

/**
 *
 * @author DELL
 */
public class NodoAVL {

    Object valor;
    int equilibrio;
    NodoAVL derecha;
    NodoAVL izquierda;

    public NodoAVL(Object valor) {
        this.valor = valor;
        this.equilibrio = 0;
        this.derecha = null;
        this.izquierda = null;

    }

}
