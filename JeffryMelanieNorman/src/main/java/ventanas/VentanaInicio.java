/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import Componentes.ListaProcesos;
import Componentes.RAM;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Ventana que muestra los procesos en ejecucion y permite asignarlos a un CPU
 *
 * @author Melanie
 * 
 * VentanaInicio
 */
public class VentanaInicio extends javax.swing.JFrame {
    /**
     * RAM para asignar los procesos a los CPUs
     */
    RAM ram;
    /**
     * Thread para ejecutar los procesos
     */
    Thread threadram;
    /**
     * Lista de procesos
     */
    ListaProcesos lista;
    
    private final String RUTA_DIRECTORIO = "./src/main/java/PRS";
    /**
     * Creates new form Inicio
     */
    public VentanaInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setLocation(new java.awt.Point(500, 0));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventana Inicio");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad de CPUs:");

        jButton1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton1.setText("Asignar a CPU");
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jButton2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton2.setText("Subir archivos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton3.setText("Ejecutar");
        jButton3.setVisible(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.setVisible(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se encarga de asignar un proceso a un CPU
     * @param evt - Evento de accion
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setVisible(false);
        jButton3.setVisible(true);
        jButton4.setVisible(true);
        int n=(int) jComboBox1.getSelectedIndex()+1;
        ram=new RAM(n,lista);
        lista.cargarProcesos();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Metodo que se encarga de subir archivos
     * @param evt - Evento de accion
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new java.io.File("./src/main/java/PRS"));

        fileChooser.setMultiSelectionEnabled(true);

        int returnVal = fileChooser.showOpenDialog(this); 

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            jButton1.setVisible(true);
            java.io.File[] files = fileChooser.getSelectedFiles();
            ArrayList<String> fileNames = new ArrayList<>();
            lista=new ListaProcesos();
        
            // Recorrer cada archivo en el array files
            for (File file : files) {
                // Agregar el nombre del archivo al ArrayList
                fileNames.add(RUTA_DIRECTORIO + "/" +file.getName());
            }
            lista.setPrss(fileNames);
            lista.cargarProcesos();
            
            System.out.println(lista.getProcesos().get(0).getNombre());
            for(java.io.File file: files){
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Operación de selección de archivo cancelada por el usuario.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Metodo que se encarga de ejecutar los procesos
     * @param evt - Evento de accion
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(ram!=null){
            threadram=new Thread(ram);
            threadram.start();
            ram.ejecutar();
            
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Error al ejecutar procesos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Metodo que se encarga de cancelar la asignacion de un proceso a un CPU
     * @param evt - Evento de accion
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setVisible(false);
        jButton1.setVisible(true);
        jButton4.setVisible(false);
        lista.getVentana().setVisible(false);
        ram.cerrarVentana();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Metodo que se encarga de asignar un proceso a un CPU
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
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     * Boton para asignar un proceso a un CPU
     */
    private javax.swing.JButton jButton1;
    /**
     * Boton para ejecutar los procesos
     */
    private javax.swing.JButton jButton2;
    /**
     * Boton para cancelar la asignacion de un proceso a un CPU
     */
    private javax.swing.JButton jButton3;
    /**
     * Boton para subir archivos
     */
    private javax.swing.JButton jButton4;
    /**
     * ComboBox para seleccionar la cantidad de CPUs
     */
    private javax.swing.JComboBox<String> jComboBox1;
    /**
     * Label para mostrar el numero de CPU
     */
    private javax.swing.JLabel jLabel1;
    /**
     * Label para mostrar el numero de CPU
     */
    private javax.swing.JLabel jLabel2;
    /**
     * Label para mostrar el numero de CPU
     */
    private javax.swing.JLabel jLabel3;
    /**
     * Label para mostrar el numero de CPU
     */
    private javax.swing.JLabel jLabel4;
    /**
     * Panel principal de la ventana
     */
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
