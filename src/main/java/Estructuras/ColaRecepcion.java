package Estructuras;

public class ColaRecepcion {
    private Cliente primero;
    private int tamanio,tam2;

    public ColaRecepcion() {
        primero = null;
        tamanio=0;
    }
    
    public boolean estaVacio(){
        return primero == null;
    }
    
    public int obtenerCola(){
        return tam2;
    }
    
    public void insertar(int id_cliente, String nombre, int color, int bw, int paso) {
        Cliente nuevo = new Cliente();
        nuevo.setId_cliente(id_cliente);
        nuevo.setNombre_cliente(nombre);
        nuevo.setImg_color(color);
        nuevo.setImg_bw(bw);
        nuevo.setImpr_color(color);
        nuevo.setImpr_bw(bw);
        nuevo.setPasos(paso);
        

        if (estaVacio()) {
            primero = nuevo;
        } else {
            Cliente temp = primero;

            while (temp.getSig() != null) {
                temp = temp.getSig();
            }
            temp.setSig(nuevo);
        }
        tamanio+=1;
        tam2++;
        
    }
    
    public Cliente desencolar() {
        Cliente temp = primero;
        if (estaVacio()) {
            System.out.println("-- No Hay Clientes --");
        } else {
            Cliente temp2 = temp.getSig();
            primero = temp2;
        }
        tamanio--;
        return temp;
    }
    
    public void imprimirCola(){
        if (tamanio == 0) {
            System.out.println("Pila vacia");
        } else {
            Cliente temp = primero;
            while (temp != null) {
                System.out.println("Id:" + temp.getId_cliente());
                System.out.println("Nombre:" + temp.getNombre_cliente());
                System.out.println("Color:" + temp.getImg_color());
                System.out.println("BW:" + temp.getImg_bw());
                System.out.println("");
                temp = temp.getSig();
            }

        }
    }
    
    
    
    

    
}
