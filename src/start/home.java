/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;
import javax.swing.JFrame;
/**
 *
 * @author Asus
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
    setVisible(true);
    setResizable(false);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("SEMPURNA ELEKTRONIK");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 100, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pelanggan_50px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganMouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("PELANGGAN");
        jPanel4.add(jLabel4);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/barang_50px.png"))); // NOI18N
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangMouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("BARANG");
        jPanel5.add(jLabel6);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/karyawan_50px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                karyawanMouseClicked(evt);
            }
        });
        jPanel6.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("KARYAWAN");
        jPanel6.add(jLabel8);

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supplier50px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supllierMouseClicked(evt);
            }
        });
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("SUPPLIER");
        jPanel7.add(jLabel10);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, 60));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 270));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/report_50px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanMouseClicked(evt);
            }
        });
        jPanel8.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("LAPORAN");
        jPanel8.add(jLabel12);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 150, 60));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/penjualan_50px.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jualMouseClicked(evt);
            }
        });
        jPanel10.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("PENJUALAN");
        jPanel10.add(jLabel14);

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 60));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pembelian_50px.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beliMouseClicked(evt);
            }
        });
        jPanel11.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("PEMBELIAN");
        jPanel11.add(jLabel16);

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 60));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 170, 160));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exitsign_30px.png"))); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 570, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganMouseClicked
        // TODO add your handling code here:
        new master.pelanggan().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pelangganMouseClicked

    private void barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangMouseClicked
        // TODO add your handling code here:
        new master.barang().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_barangMouseClicked

    private void karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawanMouseClicked
        // TODO add your handling code here:
        new master.karyawan().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_karyawanMouseClicked

    private void supllierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supllierMouseClicked
        // TODO add your handling code here:
        new master.supllier().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_supllierMouseClicked

    private void jualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jualMouseClicked
        // TODO add your handling code here:
        new transaksi.jual().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jualMouseClicked

    private void beliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliMouseClicked
        // TODO add your handling code here:
        new transaksi.beli().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_beliMouseClicked

    private void laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMouseClicked
        // TODO add your handling code here:
        new start.laporan().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_laporanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new start.login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
