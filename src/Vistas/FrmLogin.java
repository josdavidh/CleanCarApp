/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);

        ImageIcon user = new ImageIcon("src\\Recursos\\login.png");
        users.setIcon(new ImageIcon(user.getImage().getScaledInstance(users.getWidth(), users.getHeight(), Image.SCALE_DEFAULT)));

        ImageIcon logos = new ImageIcon("src\\Recursos\\logoazul.jpeg");
        this.logo.setIcon(new ImageIcon(logos.getImage().getScaledInstance(logo.getWidth() - 2, logo.getHeight() - 2, Image.SCALE_DEFAULT)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        x = new javax.swing.JTextField();
        Jpassword = new javax.swing.JPasswordField();
        btnIgresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(246, 246, 251));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setBackground(new java.awt.Color(246, 246, 251));
        users.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        users.setForeground(new java.awt.Color(0, 0, 0));
        users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 140, 140));

        jLabel2.setBackground(new java.awt.Color(246, 246, 251));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(246, 246, 251));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        x.setEditable(false);
        x.setBackground(new java.awt.Color(246, 246, 251));
        x.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        x.setForeground(new java.awt.Color(0, 102, 102));
        x.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        x.setText("X");
        x.setBorder(null);
        x.setCaretColor(new java.awt.Color(0, 102, 102));
        x.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });
        jPanel2.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, -1));

        Jpassword.setBackground(new java.awt.Color(246, 246, 251));
        Jpassword.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Jpassword.setBorder(null);
        Jpassword.setCaretColor(new java.awt.Color(0, 102, 102));
        Jpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(Jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 220, -1));

        btnIgresar.setBackground(new java.awt.Color(0, 102, 102));
        btnIgresar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnIgresar.setText("Ingresar");
        btnIgresar.setBorder(null);
        btnIgresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIgresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIgresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 120, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 210, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 210, 10));

        txtUsuario.setBackground(new java.awt.Color(246, 246, 251));
        txtUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(0, 102, 102));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 210, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 440, 400));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 180, 180));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 246, 251));
        jLabel4.setText("Clean Car");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 246, 251));
        jLabel5.setText("•  Software que permite gestionar los   ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 246, 251));
        jLabel6.setText("•  Brinda un mayor soporte a la hora de");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 246, 251));
        jLabel7.setText("•  Brindar un mayor control entre los    ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(246, 246, 251));
        jLabel8.setText(" lavaderos de barrio. ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(246, 246, 251));
        jLabel9.setText(" administrar.");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(246, 246, 251));
        jLabel10.setText("empleados y los clientes. ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
        this.dispose();
    }//GEN-LAST:event_xMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

    }//GEN-LAST:event_jPanel2MousePressed

    int xx, xy;
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void btnIgresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgresarActionPerformed

    }//GEN-LAST:event_btnIgresarActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel3MouseDragged

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPasswordField Jpassword;
    public javax.swing.JButton btnIgresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    public javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel users;
    public javax.swing.JTextField x;
    // End of variables declaration//GEN-END:variables
}
