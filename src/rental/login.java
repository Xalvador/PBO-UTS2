/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cordo
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
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

        jPanel5 = new javax.swing.JPanel();
        user = new javax.swing.JTextField();
        mas = new javax.swing.JButton();
        daf = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user);
        user.setBounds(110, 80, 180, 40);

        mas.setBackground(new java.awt.Color(153, 255, 153));
        mas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        mas.setText("Login");
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });
        getContentPane().add(mas);
        mas.setBounds(200, 160, 90, 40);

        daf.setBackground(new java.awt.Color(255, 255, 153));
        daf.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        daf.setText("Register");
        daf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dafActionPerformed(evt);
            }
        });
        getContentPane().add(daf);
        daf.setBounds(110, 160, 90, 40);
        getContentPane().add(pass);
        pass.setBounds(110, 120, 180, 40);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 70, 20);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 80, 60, 30);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 30, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 360, 90);

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 350, 40);

        jPanel3.setBackground(new java.awt.Color(51, 255, 204));
        jPanel3.setLayout(null);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 350, 40);

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 160, 350, 40);

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 200, 350, 40);

        setBounds(0, 0, 362, 267);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void dafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dafActionPerformed
        // TODO add your handling code here:
        String username = user.getText();
        String password = pass.getText();
        
        try{
            try (Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("insert into akun(username,password)VALUES('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Akun anda telah terdaftar,Silahkan Login!" );
        } catch (Exception t){
            JOptionPane.showMessageDialog(null, "Akun anda gagal terdaftar,Silahkan Cobalagi");
        }
    
    
    }//GEN-LAST:event_dafActionPerformed

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, user.getText());
            ps.setString(2, pass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new cruddata().show();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane,"Username atau password salah.");
                pass.setText("");
                user.requestFocus();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    
    }//GEN-LAST:event_masActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton daf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton mas;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
