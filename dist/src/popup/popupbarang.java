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
import transaksi.jual;
import koneksi.koneksi;

/**
 *
 * @author Asus
 */
public class popupbarang extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;

public jual barang = null;

    /**
     * Creates new form popupbarang
     */
    public popupbarang() {
        initComponents();
        datatable();
    }
    
    protected void datatable(){
        Object[] Baris = {"Kode Barang","Nama Barang","Merk","Type","Stok","Harga Beli","Harga Jual","Tahun"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem=txtcaripopupbarang.getText();
        try {
            String sql = "SELECT * FROM barang where kdbarang like '%"+cariitem+"%' or nmbarang like '%"+cariitem+"%' order by kdbarang asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                     hasil.getString(1),
                     hasil.getString(2),
                     hasil.getString(3),
                     hasil.getString(4),
                     hasil.getString(5),
                     hasil.getString(6),
                     hasil.getString(7),
                     hasil.getString(8)
                });
            }
            tblpopupbarang.setModel(tabmode);
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
        txtcaripopupbarang = new javax.swing.JTextField();
        bcaripopupbarang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpopupbarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pop Up Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcaripopupbarang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtcaripopupbarang.setToolTipText("");
        txtcaripopupbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaripopupbarangKeyPressed(evt);
            }
        });
        jPanel2.add(txtcaripopupbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 28, 110, -1));

        bcaripopupbarang.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaripopupbarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaripopupbarang.setText("Cari");
        bcaripopupbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripopupbarangActionPerformed(evt);
            }
        });
        jPanel2.add(bcaripopupbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 18, -1, -1));

        tblpopupbarang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblpopupbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpopupbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpopupbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpopupbarang);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1150, 110));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("DATA BARANG");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1180, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaripopupbarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaripopupbarangKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtcaripopupbarangKeyPressed

    private void bcaripopupbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripopupbarangActionPerformed
        // TODO add your handling code here:
        datatable();
    }//GEN-LAST:event_bcaripopupbarangActionPerformed

    private void tblpopupbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpopupbarangMouseClicked
        // TODO add your handling code here:
        int tabelbarang=tblpopupbarang.getSelectedRow();
        barang.kdbarang = tblpopupbarang.getValueAt(tabelbarang, 0).toString();
        barang.nmbarang = tblpopupbarang.getValueAt(tabelbarang, 1).toString();
        barang.merk = tblpopupbarang.getValueAt(tabelbarang, 2).toString();
        barang.type = tblpopupbarang.getValueAt(tabelbarang, 3).toString();
        barang.stok = tblpopupbarang.getValueAt(tabelbarang, 4).toString();
        barang.hb = tblpopupbarang.getValueAt(tabelbarang, 5).toString();
        barang.hj = tblpopupbarang.getValueAt(tabelbarang, 6).toString();
        barang.tahun = tblpopupbarang.getValueAt(tabelbarang, 7).toString();
        barang.itemTerpilihbarang();
        this.dispose();
    }//GEN-LAST:event_tblpopupbarangMouseClicked

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
            java.util.logging.Logger.getLogger(popupbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popupbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popupbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popupbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popupbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcaripopupbarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpopupbarang;
    private javax.swing.JTextField txtcaripopupbarang;
    // End of variables declaration//GEN-END:variables
}
