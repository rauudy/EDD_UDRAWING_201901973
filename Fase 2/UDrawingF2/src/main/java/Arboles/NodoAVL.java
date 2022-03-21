package Arboles;

/**
 *
 * @author DELL
 */
public class NodoAVL {
    Comparable valor;
    NodoAVL izquierda;
    NodoAVL derecha;
    int altura;
    int correlativo = 1;
    int id;
    
    
    public NodoAVL(Comparable valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
        this.id=correlativo++;
    }
    
    
}
