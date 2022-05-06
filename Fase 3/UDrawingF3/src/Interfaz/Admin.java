/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Estructuras.ListaAdyacencia;
import Estructuras.Routes;
import Hash.Men;
import Hash.Tabla;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Recursos.*;
import UDrawing.*;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author DELL
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        super("EL ADMIN");
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imagenMostrada = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnBloquee = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        imagenMostrada.setText("Vacio");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBloquee.setText("Crear Bloque");
        btnBloquee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloqueeActionPerformed(evt);
            }
        });

        jButton1.setText("Mod Tiempo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBloquee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(69, 69, 69)
                .addComponent(imagenMostrada, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(imagenMostrada, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnBloquee, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(15, 15, 15))
        );

        jMenu3.setText("Carga Masiva");

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Lugares");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Mensajeros");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Rutas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Graficos");

        jMenuItem5.setText("Tabla");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Grafo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Lista Adyacente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Nodos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Blockchain");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("Cliente");

        jMenuItem10.setText("Crear");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Actualizar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Buscar");
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Arbol");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Inicio in = new Inicio();
        in.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String t = "";
        try {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                if (cont == 0) {
                    t += entrada.nextLine();
                } else {
                    t += "\n" + entrada.nextLine();
                }
                cont++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }

        addClientes(t);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        analizarLugares();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            analizarMensajeros();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        analizarRutas();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Main.graphMensajeros();
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon ic = new ImageIcon(System.getProperty("user.dir") + "\\mensajeros.png");
        Image es = ic.getImage().getScaledInstance(imagenMostrada.getWidth(), imagenMostrada.getHeight(), Image.SCALE_SMOOTH);
        Icon esss = new ImageIcon(es);
        imagenMostrada.setIcon(esss);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        CrearC crearClientes = new CrearC();
        crearClientes.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        String dp = JOptionPane.showInputDialog("Número de DPI:");
        try {
            long dpi = Long.parseLong(dp);
            Cliente objetivo = Main.clientes.buscar(dpi);
            if (objetivo != null) {
                ModCliente mod = new ModCliente();
                mod.llenarlo(dpi, objetivo.getNombre(), objetivo.getUsuario(), objetivo.getCorreo(), objetivo.getContraseña(), objetivo.getTelefono(), objetivo.getDireccion(), objetivo.getIdMuni());
                mod.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "DPI no encontrado.", "ADMIN", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DPI incorrecto.", "ADMIN", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Main.clientes.graficar("Clientes");
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        ImageIcon imgg = new ImageIcon(System.getProperty("user.dir") + "\\Clientes.png");
        java.awt.Image imgfull = imgg.getImage().getScaledInstance(imagenMostrada.getWidth(), imagenMostrada.getHeight(), java.awt.Image.SCALE_SMOOTH);
        Icon full = new ImageIcon(imgfull);
        imagenMostrada.setIcon(full);

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void btnBloqueeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloqueeActionPerformed
        // TODO add your handling code here:
        Main.blockchein.crearBloque();
        JOptionPane.showMessageDialog(null, "Se creo un bloque manualmente", "Admin", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnBloqueeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String t = JOptionPane.showInputDialog("Ingrese tiempo en milisegundos");
            int tim = Integer.parseInt(t);
            Main.tiempooooo.stop();
            Main.tiempooooo.setDelay(tim);
            Main.tiempooooo.start();
            JOptionPane.showMessageDialog(null, "El tiempo de creación cambio a " + tim + " milisegundos.", "Admin", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese bien.", "Admin", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if (Main.rutas.tamanio() != 0) {
            Main.listaAD = new ListaAdyacencia();
            Main.listaAD.generar(Main.rutas);
            Main.listaAD.graficar();
            try {
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            ImageIcon ico = new ImageIcon(System.getProperty("user.dir") + "\\adyacencia.png");
            Image esc = ico.getImage().getScaledInstance(imagenMostrada.getWidth(), imagenMostrada.getHeight(), Image.SCALE_SMOOTH);
            Icon ess = new ImageIcon(esc);
            imagenMostrada.setIcon(ess);
        } else {
            JOptionPane.showMessageDialog(null, "No hay rutasss", "Admin", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if (Main.rutas.tamanio() != 0) {
            Main.rutas.grafo();
            try {
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            ImageIcon ico = new ImageIcon(System.getProperty("user.dir") + "\\grafo.png");
            Image es = ico.getImage().getScaledInstance(imagenMostrada.getWidth(), imagenMostrada.getHeight(), Image.SCALE_SMOOTH);
            Icon esss = new ImageIcon(es);
            imagenMostrada.setIcon(esss);
        } else {
            JOptionPane.showMessageDialog(null, "No hay rutas", "Admin", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquee;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imagenMostrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public static void addClientes(String text) {
        JsonParser pr = new JsonParser();
        JsonArray arr = pr.parse(text).getAsJsonArray();
        for (JsonElement obj : arr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            long dpi = Long.parseLong(gsonObj.get("dpi").getAsString());
            long tel = Long.parseLong(gsonObj.get("telefono").getAsString());
            long muni = Long.parseLong(gsonObj.get("id_municipio").getAsString());
            String nombre = gsonObj.get("nombre_cliente").getAsString();
            String contra = gsonObj.get("password").getAsString();
            String correo = gsonObj.get("correo").getAsString();
            String direc = gsonObj.get("direccion").getAsString();
            String user = gsonObj.get("usuario").getAsString();
            Cliente n = new Cliente(dpi, nombre, user, correo, contra, tel, direc, muni);
            Main.clientes.insertar(n);
            
            String password = BCrypt.withDefaults().hashToString(12, contra.toCharArray());
            Cliente ccc = new Cliente(dpi,nombre,user,correo, password, tel, direc, muni);
            Main.clientesC.add(ccc);
            
            
        }
        JOptionPane.showMessageDialog(null, "Clientes Generados Correctamente.", "ADMIN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void verCliente(Cliente cliente) {
        String resultado = "digraph G{\n";
        resultado += "N0[shape=record,label=\"{DPI|NOMBRE|USER|CORREO|CONTRAEÑA|TELEFONO|DIRECCION|ID_MUNICIPIO}|{" + cliente.getDpi() + "|" + cliente.getNombre() + "|" + cliente.getUsuario() + "|" + cliente.getCorreo() + "|" + cliente.getContraseña() + "|" + cliente.getTelefono() + "|" + cliente.getDireccion() + "|" + cliente.getIdMuni() + "}\"]";
        resultado += "\n}";
        try {
            String ruta = System.getProperty("user.dir") + "\\cliente.txt";
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(resultado);
            bw.close();
            Main.graficarDot("cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.cont = 0;
    }

    public void cargar_lugares(File archivo) {
        try {
            JSONParser parser = new JSONParser();
            FileReader leido = new FileReader(archivo);
            Object ob = parser.parse(leido);
            JSONObject js = (JSONObject) ob;
            String key = "";
            JSONObject job;
            key = "" + js.get("Lugares");
            Object obj = parser.parse(key);
            JSONArray array = (JSONArray) obj;
            //System.out.println("Tamaño: " + array.size());
            for (int i = 0; i < array.size(); i++) {
                System.out.println("-----**LUGAR**------");
                job = (JSONObject) array.get(i);
                String id = job.get("id").toString();
                String nombre = job.get("nombre").toString();
                String depa = job.get("departamento").toString();
                String sucursal = job.get("sn_sucursal").toString();
                System.out.println("Departamento: " + depa + ", Nombre: " + nombre + ", Sucursal: " + sucursal);
                System.out.println("No." + (i + 1));

                System.out.println("");
                int idd = Integer.parseInt(id);

                Lugar lgr = new Lugar(idd, depa, nombre, sucursal);
                Main.lugares.add(lgr);

                if (sucursal.equals("si")) {
                    //Menu.comboSucursal.addItem(""+depa+", "+ name);
                } else {
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargar_mensajeros(File archivo) throws FileNotFoundException, ParseException {
        Scanner le = new Scanner(archivo);
        String linea = "";
        while (le.hasNextLine()) {
            linea += le.nextLine() + "\n";
        }
        JSONParser parser = new JSONParser();
        Object ob = parser.parse(linea);
        JSONArray array = (JSONArray) ob;
        JSONObject job;
        String dpi = "", nombres = "", apellidos = "", licencia = "", genero = "", direccion = "", telefono = "";
        //TablaHash tb = new TablaHash(array.size());
        //TbHash hh = new TbHash(array.size());
        Tabla tttt = new Tabla(array.size());

        for (int i = 0; i < array.size(); i++) {
            System.out.println("* * M E N S A J E R O S * *");
            job = (JSONObject) array.get(i);
            dpi = job.get("dpi").toString();
            nombres = job.get("nombres").toString();
            apellidos = job.get("apellidos").toString();
            licencia = job.get("tipo_licencia").toString();
            genero = job.get("genero").toString();
            direccion = job.get("direccion").toString();
            telefono = job.get("telefono").toString();
            BigInteger dp = new BigInteger(dpi);

            System.out.println("Nombre: " + nombres + ", Licencia Tipo:" + licencia);
            System.out.println("Numero Mensajero: " + (i + 1));

            Mensajero n = new Mensajero(Long.parseLong(dpi), nombres, apellidos, licencia, genero, telefono, direccion);
            Men nn = new Men(dp, nombres, apellidos, licencia, genero, telefono, direccion);

            Mensajero nm = new Mensajero(Long.parseLong(dpi), nombres, apellidos, licencia, genero, direccion, telefono);
            Main.addMensajero(nm);

            //Menu.comboMensajero.addItem(""+nombres+" "+ apellidos);
            //tb.insertar(dp, n);
            //tttt.add(nn);
        }
    }

    public void cargar_rutas(File archivo) {
        try {
            JSONParser parser = new JSONParser();
            FileReader read = new FileReader(archivo);
            Object ob = parser.parse(read);
            JSONObject js = (JSONObject) ob;
            String key = "";
            JSONObject job;
            key = "" + js.get("Grafo");
            Object obj = parser.parse(key);
            JSONArray array = (JSONArray) obj;
            System.out.println("Tamaño: " + array.size());

            //Routes rut = new Routes();
            //ListaAdyacencia la = new ListaAdyacencia(array.size());
            for (int i = 0; i < array.size(); i++) {
                System.out.println("* * R U T A * *");
                job = (JSONObject) array.get(i);
                String inicio = job.get("inicio").toString();
                String fin = job.get("final").toString();
                String peso = job.get("peso").toString();

                System.out.println("Inicio: " + inicio + ", Final: " + fin + ", Peso: " + peso);
                System.out.println("Numero Lugar: " + (i + 1));

                int ini = Integer.parseInt(inicio);
                int fn = Integer.parseInt(fin);
                int wg = Integer.parseInt(peso);

                //rut.addRoutes(Integer.parseInt(inicio), Integer.parseInt(fin), Integer.parseInt(peso));
                //System.out.println("CARGADO");
                //la.insertaArista(Integer.parseInt(inicio), Integer.parseInt(fin), Integer.parseInt(peso));
                Ruta rutaa = new Ruta(ini, fn, wg);
                Main.rutas.add(rutaa);
            }
            //rut.createGrafoMap("Admin");
            //la.impMatrix();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void analizarLugares() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        File f = new File(ruta);
        cargar_lugares(f);
        //JOptionPane.showMessageDialog(null, "Lugares Generados Correctamente.", Main.actual.getUsuario(), JOptionPane.INFORMATION_MESSAGE);

    }

    public void analizarMensajeros() throws FileNotFoundException, ParseException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        File f = new File(ruta);
        cargar_mensajeros(f);
        //JOptionPane.showMessageDialog(null, "Mensajeros Generados Correctamente.", Main.actual.getUsuario(), JOptionPane.INFORMATION_MESSAGE);
    }

    public void analizarRutas() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        File f = new File(ruta);
        cargar_rutas(f);
        //JOptionPane.showMessageDialog(null, "Rutas Generados Correctamente.", Main.actual.getUsuario(), JOptionPane.INFORMATION_MESSAGE);
    }
}
