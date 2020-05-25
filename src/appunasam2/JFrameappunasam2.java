package appunasam2;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JFrameappunasam2 extends javax.swing.JFrame {

     private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "GB11SR4LM10";
    private static String URL = "jdbc:mysql://localhost:3306/dbprueba"+"?useTimezone=true&serverTimezone=UTC";

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return con;
    }

    public JFrameappunasam2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBUSCAR = new javax.swing.JButton();
        jTextFieldbuscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldEDAD = new javax.swing.JTextField();
        jTextFieldNOMBRE = new javax.swing.JTextField();
        jTextFieldSEXO = new javax.swing.JTextField();
        jButtonReporte = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBUSCAR.setText("BUSCAR");
        jButtonBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBUSCARActionPerformed(evt);
            }
        });
        jButtonBUSCAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBUSCARKeyPressed(evt);
            }
        });
        getContentPane().add(jButtonBUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 132, -1, -1));

        jTextFieldbuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldbuscadorKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldbuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 72, 170, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 172, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 174, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EDAD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SEXO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jTextFieldID.setEditable(false);
        getContentPane().add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 206, 58, -1));

        jTextFieldEDAD.setEditable(false);
        getContentPane().add(jTextFieldEDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 206, 58, -1));

        jTextFieldNOMBRE.setEditable(false);
        getContentPane().add(jTextFieldNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 73, -1));

        jTextFieldSEXO.setEditable(false);
        getContentPane().add(jTextFieldSEXO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 206, 56, -1));

        jButtonReporte.setText("Generar Reporte");
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appunasam2/futuro.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBUSCARActionPerformed

        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM persona WHERE nombre=?");

            ps.setString(1, jTextFieldbuscador.getText());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                jTextFieldID.setText(rs.getString("id"));
                jTextFieldNOMBRE.setText(rs.getString("nombre"));
                jTextFieldEDAD.setText(rs.getString("edad"));
                jTextFieldSEXO.setText(rs.getString("sexo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe" + JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButtonBUSCARActionPerformed

    private void jTextFieldbuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldbuscadorKeyPressed

         int cod = evt.getExtendedKeyCode();
        if (cod == KeyEvent.VK_ENTER) {
            jButtonBUSCAR.grabFocus();
        }
    }//GEN-LAST:event_jTextFieldbuscadorKeyPressed

    private void jButtonBUSCARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBUSCARKeyPressed
      
        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM persona WHERE nombre=?");

            ps.setString(1, jTextFieldbuscador.getText());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                jTextFieldID.setText(rs.getString("id"));
                jTextFieldNOMBRE.setText(rs.getString("nombre"));
                jTextFieldEDAD.setText(rs.getString("edad"));
                jTextFieldSEXO.setText(rs.getString("sexo"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe" + JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButtonBUSCARKeyPressed

    private void jButtonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteActionPerformed
       
        
        Connection con = null;
         try {
             
             con = getConnection();
             
             JasperReport reporte = null;
             reporte = (JasperReport) JRLoader.loadObjectFromFile("src\\appunasam2\\report1.jasper");
            
             
             
             JasperPrint jprint = JasperFillManager.fillReport(reporte,null,con);
             
             JasperViewer view = new JasperViewer(jprint,false);
             
             //Para evitar que se quede la hoja de reportes
             
             view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
             
             //Para que sea visible el reporte
             view.setVisible(true);
             
             
             
         } catch (JRException ex) {
             Logger.getLogger(JFrameappunasam2.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }//GEN-LAST:event_jButtonReporteActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameappunasam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameappunasam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameappunasam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameappunasam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameappunasam2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBUSCAR;
    private javax.swing.JButton jButtonReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldEDAD;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNOMBRE;
    private javax.swing.JTextField jTextFieldSEXO;
    private javax.swing.JTextField jTextFieldbuscador;
    // End of variables declaration//GEN-END:variables
}
