/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popup;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import transaksi.beli;
import koneksi.koneksi;

/**
 *
 * @author Asus
 */
public class popuppetugas extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

public beli petugas = null;
    /**
     * Creates new form popuppetugas
     */
    public popuppetugas() {
        initComponents();
        datatable();
    }
    
    protected void datatable(){
        Object[] Baris ={"NIK","Nama Karyawan","Jabatan","No. Handphone","Alamat"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=txtcaripopuppetugas.getText();
        try {
            String sql = "SELECT * FROM karyawan where nik like '%"+cariitem+"%' or nmkaryawan like '%"+cariitem+"%' order by nik asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5)
                });
            }
            tblpopuppetugas.setModel(tabmode);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
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
        jPanel2 = new javax.swing.JPanel();
        txtcaripopuppetugas = new javax.swing.JTextField();
        bcaripopuppetugas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpopuppetugas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pop Up Data Petugas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcaripopuppetugas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtcaripopuppetugas.setToolTipText("");
        txtcaripopuppetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaripopuppetugasActionPerformed(evt);
            }
        });
        txtcaripopuppetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaripopuppetugasKeyPressed(evt);
            }
        });
        jPanel2.add(txtcaripopuppetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 28, 110, -1));

        bcaripopuppetugas.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaripopuppetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaripopuppetugas.setText("Cari");
        bcaripopuppetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripopuppetugasActionPerformed(evt);
            }
        });
        jPanel2.add(bcaripopuppetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 18, -1, -1));

        tblpopuppetugas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblpopuppetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblpopuppetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpopuppetugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpopuppetugas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 570, 110));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("DATA PETUGAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaripopuppetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaripopuppetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaripopuppetugasActionPerformed

    private void txtcaripopuppetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaripopuppetugasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcaripopuppetugasKeyPressed

    private void bcaripopuppetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripopuppetugasActionPerformed
        // TODO add your handling code here:
        datatable();
    }//GEN-LAST:event_bcaripopuppetugasActionPerformed

    private void tblpopuppetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpopuppetugasMouseClicked
        // TODO add your handling code here:
        int tabelpetugas=tblpopuppetugas.getSelectedRow();
        petugas.nik = tblpopuppetugas.getValueAt(tabelpetugas, 0).toString();
        petugas.nmkaryawan = tblpopuppetugas.getValueAt(tabelpetugas, 1).toString();
        petugas.jabatan = tblpopuppetugas.getValueAt(tabelpetugas, 2).toString();
        petugas.nohpk = tblpopuppetugas.getValueAt(tabelpetugas, 3).toString();
        petugas.alamatk = tblpopuppetugas.getValueAt(tabelpetugas, 4).toString();
        petugas.itemTerpilihpetugas();
        this.dispose();
    }//GEN-LAST:event_tblpopuppetugasMouseClicked

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
            java.util.logging.Logger.getLogger(popuppetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popuppetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popuppetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popuppetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popuppetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcaripopuppetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpopuppetugas;
    private javax.swing.JTextField txtcaripopuppetugas;
    // End of variables declaration//GEN-END:variables
}
