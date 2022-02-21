
package Estructuras;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ListaSimpleVenta {
    private Ventanilla primero;
    private int tamanio;
    private PilaImage pilai;

    public void Lista() {
        primero = null;
        tamanio = 0;
    }

    public void insertar(int ventan) {
        Ventanilla nuevo = new Ventanilla();
        nuevo.setVent(ventan);
        if (primero == null) {
            primero = nuevo;
        } else {
            Ventanilla aux = primero;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
        }
        tamanio = tamanio + 1;
        System.out.println("-------> La Ventanilla No." + String.valueOf(tamanio) + " Creada");
    }

    public void clienteVentanilla(Cliente cliente) {
        Ventanilla aux = primero;
        while (aux != null) {
            if (aux.getActual()== null) {
                aux.setActual(cliente);
                System.out.println("ID:"+cliente.getId_cliente()+" - Cliente " + cliente.getNombre_cliente()+ " ingresa a ventanilla No." + String.valueOf(aux.getVent()));
                break;
            }
            aux = aux.getSig();
        }

    }

    public int vent_disponibles() {
        Ventanilla aux = primero;
        int no = 0;
        while (aux != null) {
            if (aux.getActual()== null) {
                no++;
            }
            aux = aux.getSig();
        }
        return no;

    }

    public void RecibirFotos() {
        Ventanilla aux = primero;
        while (aux != null) {
            if (aux.getActual()!= null) {
                if (aux.getActual().isAtendido()== true) {
                    if (aux.getActual().getImg_color()!= 0) {
                        if (aux.getPila()== null) {
                            aux.setPila(new PilaImage());
                        }
                        aux.getPila().push(aux.getActual().getId_cliente(), aux.getPila().no_nodos()+ 1, "Color");
                        aux.getActual().setImg_color(aux.getActual().getImg_color()- 1);
                        System.out.println("---> Imagen a color del Cliente " + aux.getActual().getNombre_cliente()+ " va a la ventanilla no." + String.valueOf(aux.getVent()));
                    } else if (aux.getActual().getImg_bw()!= 0) {
                        aux.getPila().push(aux.getActual().getId_cliente(), aux.getPila().no_nodos()+ 1, "Bw");
                        aux.getActual().setImg_bw(aux.getActual().getImg_bw()- 1);
                        System.out.println("---> Imagen a blanco y negro del Cliente " + aux.getActual().getNombre_cliente()+ " va a la ventanilla no. " + String.valueOf(aux.getVent()));
                    }

                }

            }
            aux = aux.getSig();
        }

    }

    public Cliente sacarClienteVentanilla() {//sin impresiones
        Ventanilla aux = primero;
        for (int i = 0; i < tamanio + 1; i++) {
            if (aux != null) {
                if (aux.getActual() != null) {
                    if (aux.getActual().getImg_color()== 0 && aux.getActual().getImg_bw()== 0) {
                        Cliente clienteEspera = aux.getActual();
                        aux.setActual(null);
                        pilai = aux.getPila();
                        aux.setPila(new PilaImage());
                        clienteEspera.setVentanilla(aux.getVent());
                        return clienteEspera;
                    }
                }
                aux = aux.getSig();
            }
        }
        return null;
    }

    public PilaImage IngresarImpresionesAcola() {
        return pilai;
    }

    public void atender() {
        Ventanilla aux = primero;
        while (aux != null) {
            if (aux.getActual() != null) {
                aux.getActual().setAtendido(true);
                aux.getActual().setVentanilla(aux.getVent());
            }
            aux = aux.getSig();
        }
    }

    public int tamanio() {
        return tamanio;
    }

    public void GraphvizVentanillas() {
        String dot = "";
        dot = "digraph G{ rankdir=TB; labelloc=t; label=\"LISTA VENTANILLAS\"; fontsize=30;\n";
        Ventanilla aux = primero;
        for (int i = 0; i < tamanio; i++) {
            if (aux.getActual() != null) {
                dot = dot + String.valueOf(i) + "[label= \"Ventanilla No." + String.valueOf(aux.getVent()) + " ,Cliente Actual: " + aux.getActual().getNombre_cliente()+ "\" shape=cds fontsize=25]; \n";
            } else {
                dot = dot + String.valueOf(i) + "[label= \"Ventanilla No." + String.valueOf(aux.getVent()) + " ,No Hay Cliente" + "\" shape=cds fontsize=25]; \n";
            }
            aux = aux.getSig();
        }
        aux = primero;
        int contadoraux = 0;
        while (aux != null) {
            Ventanilla aux2 = aux.getSig();
            if (aux2 != null) {
                dot = dot + String.valueOf(contadoraux) + "->" + String.valueOf(contadoraux + 1) + ";\n";
            }
            contadoraux++;
            aux = aux.getSig();
        }
        aux = primero;
        for (int i = 0; i < tamanio; i++) {
            if (aux.getActual() != null) {
                int aux2 = aux.getPila().no_nodos();
                if (aux2 != 0) {
                    dot = dot + aux.getPila().graphviz_pila(String.valueOf(i));
                }
                aux = aux.getSig();
            }

        }

        dot = dot + "}";
        System.out.println(dot);

        try {
            String Contenido = dot;
            File file = null;
            file = new File("Ventanillas.dot");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
        } catch (Exception e) {
        }

        try {
            ProcessBuilder proceso = null;

            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "Ventanilla.png", "Ventanillas.dot");

            proceso.redirectErrorStream(true);
            proceso.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
