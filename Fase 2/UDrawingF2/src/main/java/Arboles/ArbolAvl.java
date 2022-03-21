package Arboles;
/**
 *
 * @author DELL
 */
public class ArbolAvl {
    
    private NodoAVL raiz;
    public ArbolAvl() {
        raiz=null;
    }
    
    public void insertar(Comparable valor) {
        raiz = insertar(valor,raiz);
    }
    
    public void inorden(){
        System.out.println("Recorrido inorden del árbol binario de búsqueda:");
        inorden(raiz);
        System.out.println();
    }
    
    private void inorden(NodoAVL a){
        if(a==null)
            return;
        inorden(a.izquierda);
        System.out.print(a.valor+",");
        inorden(a.derecha);
    }
    
    private NodoAVL insertar(Comparable valor, NodoAVL raiz){
        if(raiz == null){
            raiz = new NodoAVL(valor);
        }else if(valor.compareTo(raiz.valor) < 0){
            raiz.izquierda = insertar(valor, raiz.izquierda);            
            if(altura(raiz.derecha)-altura(raiz.izquierda) == -2)
                if(valor.compareTo(raiz.izquierda.valor) < 0)
                    raiz = IzquierdaIzquierda(raiz);
                else
                    raiz = IzquierdaDerecha(raiz);
        }
        else if(valor.compareTo(raiz.valor)>0)
        {          
            raiz.derecha=insertar(valor, raiz.derecha);            
            if(altura(raiz.derecha)-altura(raiz.izquierda) == 2)
                if(valor.compareTo(raiz.derecha.valor) > 0)                  
                    raiz = DerechaDerecha(raiz);
                else
                    raiz = DerechaIzquierda(raiz);
        }
        else  
        System.err.println("No se permiten los valores duplicados: \"" 
                +  String.valueOf(valor)+"\".");       
        raiz.altura = mayor(altura(raiz.izquierda), altura(raiz.derecha))+1;
        return raiz;
    }
    
    private int altura( NodoAVL nodo )
    {
        if(nodo==null)
            return -1;
        else
            return nodo.altura;
    }
    
    private int mayor(int n1, int n2)
    {
        if(n1 > n2)
            return n1;
        return n2;
    }
    
    private NodoAVL IzquierdaIzquierda(NodoAVL n1){
        NodoAVL n2 = n1.izquierda;
        n1.izquierda = n2.derecha;
        n2.derecha = n1;
        n1.altura = mayor(altura(n1.izquierda), altura(n1.derecha))+1;
        n2.altura = mayor(altura(n2.izquierda), n1.altura)+1;
        return n2;
    }
    
    private NodoAVL DerechaDerecha( NodoAVL n1 ){
        NodoAVL n2 = n1.derecha;
        n1.derecha = n2.izquierda;
        n2.izquierda = n1;
        n1.altura = mayor(altura(n1.izquierda), altura(n1.derecha))+1;
        n2.altura = mayor(altura(n2.derecha), n1.altura)+1;
        return n2;
    }
    
    private NodoAVL IzquierdaDerecha(NodoAVL n1){
        n1.izquierda = DerechaDerecha(n1.izquierda);
        return IzquierdaIzquierda(n1);
    }
    
    private NodoAVL DerechaIzquierda(NodoAVL n1 ){
        n1.derecha = IzquierdaIzquierda(n1.derecha);
        return DerechaDerecha(n1);
    }
}
