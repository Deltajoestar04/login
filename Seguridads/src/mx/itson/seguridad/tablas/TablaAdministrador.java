/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.seguridad.tablas;

import Entidades.Administrador;
import Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TablaAdministrador extends javax.swing.JFrame {
Administrador as= new Administrador();
    /**
     * Método para llenar la tabla con todos los usuarios y sus tareas.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public void llenartabla() throws SQLException {
        // Obtener el modelo de la tabla
        DefaultTableModel _modelo = (DefaultTableModel) tbadmin.getModel();
        _modelo.setRowCount(0); // Limpiar la tabla

        // Obtener todos los usuarios y sus tareas y agregarlos a la tabla
        for (Usuario us : Usuario.getAll("")) {
            _modelo.addRow(new Object[]{us.getId(), us.getUsername(), us.getTarea()});
        }
        // Establecer el modelo de la tabla
        tbadmin.setModel(_modelo);
    }

    /**
     * Método para llenar la tabla con una lista específica de administradores y sus puestos.
     * @param administradores la lista de administradores a mostrar en la tabla.
     */
    public void llenarTablaBuscar(List<Administrador> administradores) {
        // Obtener el modelo de la tabla
        DefaultTableModel _modelo = (DefaultTableModel) tbadmin.getModel();
        _modelo.setRowCount(0); // Limpiar la tabla

        // Agregar cada administrador y su puesto a la tabla
        for (Administrador ad : administradores) {
            _modelo.addRow(new Object[]{ad.getId(), ad.getUsername(), ad.getPuesto()});
        }
        // Establecer el modelo de la tabla
        tbadmin.setModel(_modelo);
    }

    /**
     * Constructor de la clase TablaAdministrador.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    public TablaAdministrador() throws SQLException {
        initComponents(); // Inicializar los componentes de la interfaz gráfica
        actualizarTabla(); // Actualizar la tabla al iniciar la ventana
    }

    /**
     * Método privado para actualizar la tabla con todos los administradores y sus puestos.
     * @throws SQLException si ocurre un error al acceder a la base de datos.
     */
    private void actualizarTabla() throws SQLException {
        DefaultTableModel datosTabla = new DefaultTableModel();
        
        // Agregar las columnas a la tabla
        datosTabla.addColumn("ID");
        datosTabla.addColumn("Nombre");
        datosTabla.addColumn("Puesto");
        
        // Obtener todos los administradores y sus puestos y agregarlos a la tabla
        for (Administrador a : Administrador.getAll("")) {
            datosTabla.addRow(new Object[]{a.getId(), a.getUsername(), a.getPuesto()});
        }   
    
        // Establecer el modelo de la tabla
        tbadmin.setModel(datosTabla);
    }

    // Otro código de la interfaz gráfica generado automáticamente...

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbadmin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbadmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nombre", "Puesto"
            }
        ));
        jScrollPane1.setViewportView(tbadmin);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TablaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TablaAdministrador().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TablaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbadmin;
    // End of variables declaration//GEN-END:variables
}
