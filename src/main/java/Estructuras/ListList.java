
package Estructuras;

public class ListList {
    private Cliente primero;
    private int tamanio;

    public ListList() {
        primero = null;
        tamanio=0;
    }
    
    public boolean estaVacio(){
        return primero == null;
    }
    
    public void insertar(int id_cliente, String nombre, int color, int bw, int vent, int pasos){
        Cliente nuevo = new Cliente();
        
        nuevo.setId_cliente(id_cliente);
        nuevo.setNombre_cliente(nombre);
        nuevo.setImg_color(0);
        nuevo.setImg_bw(0);
        nuevo.setImpr_color(color);
        nuevo.setImpr_bw(bw);
        nuevo.setVentanilla(vent);
        nuevo.setPasos(pasos);
        nuevo.setPilaImg(new PilaImage());
        
        if (estaVacio()) {
            primero = nuevo;
            primero.setAnt(primero);
            primero.setSig(primero);
            System.out.println("-- Cliente " + nombre + " Ingresa a Lista de Espera");
            tamanio++;
        } else {

            nuevo.setSig(primero);
            nuevo.setAnt(primero.getAnt());
            primero.setAnt(nuevo);

            nuevo.getAnt().setSig(nuevo);

            primero = nuevo;
            System.out.println("-- Cliente " + nombre + " Ingresa a Lista de Espera");
            tamanio++;
        }
    }
    
    public void eliminar() {
        Cliente temp = primero;
        if (temp != null) {
            for (int i = 0; i < tamanio + 1; i++) {
                if (temp.getImpr_color()+ temp.getImpr_bw()== temp.getPilaImg().no_nodos()) {

                    Cliente temp2 = temp;

                    temp.getAnt().setSig(temp2.getSig());
                    temp.getSig().setAnt(temp2.getAnt());

                   //-----Menu.ListaAtendidos.insertarOrden(temp.getId_cliente(), temp.getNombre_cliente(), temp.getPasos(), temp.getVentanilla(), temp.getImpr_bw(), temp.getImpr_color());
                    System.out.println("Cliente " + temp.getNombre_cliente() + " atendido");
                    tamanio--;
                    break;
                }
                temp = temp.getSig();
            }
        }
    }
    
    
    
    
    
    
}
