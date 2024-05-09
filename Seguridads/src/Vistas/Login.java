/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mx.itson.Sguridad.conexxion.MySQLConnection;
import mx.itson.seguridad.tablas.TablaUsuario;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
    initComponents(); // Inicializa los componentes de la interfaz de usuario
    this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
    
    // Agrega un WindowListener para detectar cuando se cierra la ventana
    this.addWindowListener(new java.awt.event.WindowAdapter() {
        // Sobreescribe el método windowClosing para definir el comportamiento al cerrar la ventana
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            dispose(); // Cierra la ventana
        }
    });
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
        txtname = new javax.swing.JTextField();
        btenter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btregistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        cbregisR = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        btenter.setText("Enter");
        btenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btenterActionPerformed(evt);
            }
        });

        jLabel2.setText("¿No tienes cuenta?, registrate:");

        btregistrar.setText("Registrar");
        btregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Usser Name");

        jLabel4.setText("Password");

        cbregisR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));
        cbregisR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbregisRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btenter))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbregisR, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btregistrar)))))
                .addGap(0, 103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtpassword)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbregisR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btenter)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btregistrar))
                .addGap(0, 58, Short.MAX_VALUE))
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

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
 
        {   
    }    }//GEN-LAST:event_txtnameActionPerformed
    // Método para manejar el evento del botón de ingresar
    private void btenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btenterActionPerformed
 // Obtener el nombre de usuario y la contraseña ingresados por el usuario
        String name = txtname.getText();
        String password = txtpassword.getText();  
        String texto = txtpassword.getText();  
        Connection conexion = MySQLConnection.get(); // Obtener la conexión a la base de datos
        
        try {
            // Cifrar la contraseña utilizando AES
            SecretKeySpec secretKey = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String texto64 = Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes()));
    
            // Verificar si el usuario es un usuario normal o un administrador
            if (cbregisR.getSelectedItem().equals("Usuario")) {
                // Consulta para verificar las credenciales del usuario
                PreparedStatement statement = conexion.prepareStatement("SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?");
                statement.setString(1, name);
                statement.setString(2, texto64);
                
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Si las credenciales son válidas, mostrar la ventana del usuario
                    VistasUsuario newFrame = new VistasUsuario();
                    newFrame.setVisible(true);
                } else {   
                    // Si las credenciales son inválidas, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "contraseña y/o usuario incorrecto", "error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (cbregisR.getSelectedItem().equals("Administrador")) {
                // Consulta para verificar las credenciales del administrador
                PreparedStatement statement = conexion.prepareStatement("SELECT * FROM administrador WHERE nombre = ? AND contraseña = ?");
                statement.setString(1, name);
                statement.setString(2, texto64);
                
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Si las credenciales son válidas, mostrar la ventana de confirmación del administrador
                    ConfirmarAdmin newFrame = new ConfirmarAdmin();
                    newFrame.setVisible(true);
                } else {   
                    // Si las credenciales son inválidas, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "contraseña y/o usuario incorrecto", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            // Si ocurre algún error durante el proceso, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "contraseña y/o usuario incorrecto", "error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                                        

    }//GEN-LAST:event_btenterActionPerformed
    // Método para manejar el evento del botón de registro
    private void btregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistrarActionPerformed
        // Abrir la ventana de registro
        Registro registro= new Registro();
        registro.setVisible(true);
    }//GEN-LAST:event_btregistrarActionPerformed

    private void cbregisRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbregisRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbregisRActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btenter;
    private javax.swing.JButton btregistrar;
    private javax.swing.JComboBox<String> cbregisR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}