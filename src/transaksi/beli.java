/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;
import java.sql.*; 
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import koneksi.koneksi;
import popup.popupsupplier;
import popup.popuppetugas;
import popup.popupbarangbeli;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Asus
 */
public class beli extends javax.swing.JFrame {
public String idsupplier, nmsupplier, nohps, alamats;
public String nik, nmkaryawan, jabatan, nohpk, alamatk;
public String kdbarang, nmbarang, merk, type, stok, hb, hj, tahun;
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode; 
    /**
     * Creates new form beli
     */
    public beli() {
        initComponents();
        kosong();
        aktif();
        autonumber();
        java.util.Date date = new java.util.Date();
        jtanggal.setDate(date);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }
    
    protected void aktif(){
        txtqty.requestFocus();
        Object[] Baris ={"Kode Barang","Nama Barang","Merk","Type","Harga Beli","Tahun Barang","QTY","Sub Total Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tblbelanja.setModel(tabmode);  
        cbjabatan.setSelectedItem("Item1");
        cbmerk.setSelectedItem("Item1");
    }
    
    protected void kosong(){
        txtidsupplier.setText("");
        txtnmsupplier.setText("");
        txthps.setText("");
        txtnik.setText("");
        txtnmpetugas.setText("");
        cbjabatan.setSelectedItem("-Pilih Jabatan-");
        txtkd.setText("");
        txtnmbarang.setText("");
        cbmerk.setSelectedItem("-Pilih Merk-");
        txttype.setText("");
        txthb.setText("");
        txttahun.setText("");
        txtqty.setText("");
        txtsubtotal.setText("");
        txttotalbarang.setText("");
        txttotalbelanja.setText("");
    }
    
    protected void autonumber(){
        try {
            String sql = "SELECT kdfaktur FROM faktur order by kdfaktur asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtkdfaktur.setText("INBRG0001");
            while (rs.next()) {
                String kd_faktur = rs.getString("kdfaktur").substring(5);
                int AN = Integer.parseInt(kd_faktur) + 1;
                String Nol = ""; 
 
                  if(AN<10)
                  {Nol = "000";}
                  else if(AN<100)
                  {Nol = "00";}
                  else if(AN<1000)
                  {Nol = "0";}
                  else if(AN<10000)
                  {Nol = "";} 
 
                  txtkdfaktur.setText("INBRG" + Nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }
    
    
    public void subtotal(){        
        int xhrgb=Integer.parseInt(txthb.getText());
        int xqty=Integer.parseInt(txtqty.getText());
        int xtotal=xhrgb*xqty;
        txtsubtotal.setText(String.valueOf(xtotal));
       }
    
    public void hitung(){
           int totalbelanja = 0;
            for (int i =0; i< tblbelanja.getRowCount(); i++){
            int amount = Integer.valueOf(tblbelanja.getValueAt(i, 7).toString());
            totalbelanja += amount;
            }
        txttotalbelanja.setText(Integer.toString(totalbelanja));
        
        int totalbarang = 0;
        for (int i =0; i< tblbelanja.getRowCount(); i++){
            int amount = Integer.valueOf(tblbelanja.getValueAt(i, 6).toString());
            totalbarang += amount;
        }
        txttotalbarang.setText(Integer.toString(totalbarang));
       }
    
    
    public void itemTerpilihbarangbeli(){
        popupbarangbeli Pp = new popupbarangbeli();
        Pp.barang = this;
        txtkd.setText(kdbarang);
        txtnmbarang.setText(nmbarang);
        cbmerk.setSelectedItem(merk);
        txttype.setText(type);
        txthb.setText(hb);
        txttahun.setText(tahun);
    }
    
    public void itemTerpilihpetugas(){
        popuppetugas Pp = new popuppetugas();
        Pp.petugas = this;
        txtnik.setText(nik);
        txtnmpetugas.setText(nmkaryawan);
        cbjabatan.setSelectedItem(jabatan);
    }
    
    public void itemTerpilihsupplier(){
        popupsupplier Pp = new popupsupplier();
        Pp.supplier = this;
        txtidsupplier.setText(idsupplier);
        txtnmsupplier.setText(nmsupplier);
        txthps.setText(nohps);
    }
    
    public void cetak(){      
         try {            
             File file = new File("./src/ireport/beli.jrxml"); //JasperDesign = JRXmlLoader.load(file);
             HashMap parameter = new HashMap();     
             parameter.put("kdfaktur",txtkdfaktur.getText());
             JasperDesign jasperDesign = JRXmlLoader.load(file);
             JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
             JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter,conn);
            JasperViewer.viewReport(jasperPrint, false);          
     } catch (Exception ex) {           
         JOptionPane.showMessageDialog(null,"DokumenTidak Ada "+ex);        
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidsupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnmsupplier = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthps = new javax.swing.JTextField();
        bcarisupplier = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtnik = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnmpetugas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbjabatan = new javax.swing.JComboBox<>();
        bcaripetugas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtkdfaktur = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtkd = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtnmbarang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txthb = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txttahun = new javax.swing.JTextField();
        cbmerk = new javax.swing.JComboBox<>();
        bcaribarangbeli = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtanggal = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bproses = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        txttotalbarang = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbelanja = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txttotalbelanja = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1247, 2297));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(914, 2295));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.green);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("PEMBELIAN");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("ID Supplier");
        jLabel2.setToolTipText("");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtidsupplier.setEditable(false);
        txtidsupplier.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(txtidsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 90, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Nama Supplier");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmsupplier.setEditable(false);
        txtnmsupplier.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(txtnmsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 155, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("No. Handphone");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        txthps.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(txthps, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 155, -1));

        bcarisupplier.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcarisupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcarisupplier.setText("Cari");
        bcarisupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarisupplierActionPerformed(evt);
            }
        });
        jPanel3.add(bcarisupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 320, 150));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Petugas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("NIK");
        jLabel4.setToolTipText("");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtnik.setEditable(false);
        txtnik.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel4.add(txtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 90, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Nama Petugas");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmpetugas.setEditable(false);
        txtnmpetugas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel4.add(txtnmpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 155, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Jabatan");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        cbjabatan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jabatan-", "Pemilik", "Kasir", "Pramuniaga", "Bagian Gudang" }));
        jPanel4.add(cbjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        bcaripetugas.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaripetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaripetugas.setText("Cari");
        bcaripetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripetugasActionPerformed(evt);
            }
        });
        jPanel4.add(bcaripetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 245, 320, 150));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("Tanggal");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 43, -1, -1));

        txtkdfaktur.setEditable(false);
        txtkdfaktur.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtkdfaktur.setToolTipText("");
        jPanel1.add(txtkdfaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 40, 85, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel17.setText("Kode Barang");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtkd.setEditable(false);
        txtkd.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdActionPerformed(evt);
            }
        });
        jPanel6.add(txtkd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 95, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel18.setText("Nama Barang");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmbarang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtnmbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmbarangActionPerformed(evt);
            }
        });
        jPanel6.add(txtnmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 133, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel19.setText("Merk");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel20.setText("Type");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, -1, -1));

        txttype.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });
        jPanel6.add(txttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 133, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel21.setText("Harga Beli");
        jLabel21.setToolTipText("");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, -1, -1));

        txthb.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txthb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthbActionPerformed(evt);
            }
        });
        jPanel6.add(txthb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 133, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel22.setText("Tahun");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, -1, -1));

        txttahun.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel6.add(txttahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 133, -1));

        cbmerk.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbmerk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Merk-", "SHARP", "BEKO", "POLYTRON", "TOSHIBA", "SAMSUNG" }));
        jPanel6.add(cbmerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        bcaribarangbeli.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaribarangbeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaribarangbeli.setText("Cari");
        bcaribarangbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribarangbeliActionPerformed(evt);
            }
        });
        jPanel6.add(bcaribarangbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 320, 270));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Kode Faktur");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 43, -1, -1));
        jPanel1.add(jtanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 40, 130, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel9.setText("QTY");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtqty.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        jPanel5.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 30, 120, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel10.setText("Sub Total Harga");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        bproses.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bproses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/proses_30px.png"))); // NOI18N
        bproses.setText("Proses");
        bproses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesActionPerformed(evt);
            }
        });
        jPanel5.add(bproses, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel12.setText("TOTAL BARANG");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        txtsubtotal.setEditable(false);
        txtsubtotal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel5.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 70, 120, -1));

        txttotalbarang.setEditable(false);
        txttotalbarang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel5.add(txttotalbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 110, 120, -1));

        btambah.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tambah_30px.png"))); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        jPanel5.add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 365, 390, 150));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bsimpan.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save_30px.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel7.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        bhapus.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hapus_30px.png"))); // NOI18N
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel7.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        bbatal.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancelit_30px.png"))); // NOI18N
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel7.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 20, -1, -1));

        bkeluar.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exitsign_30px.png"))); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });
        jPanel7.add(bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 325, 125));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Belanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblbelanja.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbelanjaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbelanja);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1300, 100));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel13.setText("TOTAL BELANJA");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 142, -1, -1));

        txttotalbelanja.setEditable(false);
        txttotalbelanja.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel8.add(txttotalbelanja, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 138, 120, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1320, 180));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.jpg"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.jpg"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkdActionPerformed

    private void txtnmbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmbarangActionPerformed

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttypeActionPerformed

    private void txthbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthbActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
        subtotal();
    }//GEN-LAST:event_txtqtyActionPerformed

    private void bcarisupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarisupplierActionPerformed
        // TODO add your handling code here:
        popupsupplier Pp = new popupsupplier();
        Pp.supplier = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcarisupplierActionPerformed

    private void bcaripetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripetugasActionPerformed
        // TODO add your handling code here:
        popuppetugas Pp = new popuppetugas();
        Pp.petugas = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaripetugasActionPerformed

    private void bcaribarangbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribarangbeliActionPerformed
        // TODO add your handling code here:
        popupbarangbeli Pp = new popupbarangbeli();
        Pp.barang = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaribarangbeliActionPerformed

    private void bprosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesActionPerformed
        // TODO add your handling code here:
        subtotal();
    }//GEN-LAST:event_bprosesActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        try{   
            String kode = txtkd.getText();
            String nama = txtnmbarang.getText();
            String merk = cbmerk.getSelectedItem().toString();
            String type = txttype.getText();
            String hargabeli = txthb.getText();
            String tahun = txttahun.getText();
            int qty = Integer.parseInt(txtqty.getText());
            int subtotal = Integer.parseInt(txtsubtotal.getText());
            tabmode.addRow(new Object[]{kode,nama,merk,type,hargabeli,tahun,qty,subtotal});
            tblbelanja.setModel(tabmode);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
        }
        txtkd.setText("");
        txtnmbarang.setText("");
        cbmerk.setSelectedItem("-Pilih Merk-");
        txttype.setText("");
        txthb.setText("");
        txttahun.setText("");
        txtqty.setText("");
        txtsubtotal.setText("");
        hitung();
    }//GEN-LAST:event_btambahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(jtanggal.getDate());
        String sql = "insert into faktur values (?,?,?,?,?,?,?,?)";
        String zsql = "insert into isifaktur values (?,?,?,?,?,?,?,?,?)";
        try{
             PreparedStatement stat = conn.prepareStatement(sql);
             stat.setString(1, txtkdfaktur.getText());
             stat.setString(2, fd);
             stat.setString(3, txtidsupplier.getText());
             stat.setString(4, txtnmsupplier.getText());
             stat.setString(5, txthps.getText());
             stat.setString(6, txtnik.getText());
             stat.setString(7, txtnmpetugas.getText());
             stat.setString(8,cbjabatan.getSelectedItem().toString());
             stat.executeUpdate();
             int t = tblbelanja.getRowCount();
             for(int i=0; i < t ; i++)
                 {
                String kd = tblbelanja.getValueAt(i,0).toString();
                String nmbarang = tblbelanja.getValueAt(i,1).toString();
                String merk = tblbelanja.getValueAt(i,2).toString();
                String type = tblbelanja.getValueAt(i,3).toString();
                String hargabeli = tblbelanja.getValueAt(i,4).toString();
                String tahun = tblbelanja.getValueAt(i,5).toString();
                String qty = tblbelanja.getValueAt(i,6).toString();
                String subtotal = tblbelanja.getValueAt(i,7).toString();
                
                PreparedStatement stat2 = conn.prepareStatement(zsql);
                stat2.setString(1, txtkdfaktur.getText());
                stat2.setString(2, kd);
                stat2.setString(3, nmbarang);
                stat2.setString(4, merk);
                stat2.setString(5, type);
                stat2.setString(6, hargabeli);
                stat2.setString(7, tahun);
                stat2.setString(8, qty);
                stat2.setString(9, subtotal);
                stat2.executeUpdate();          
            }
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            cetak();
        }catch(SQLException e){ 
            JOptionPane.showMessageDialog(null,"Data gagal disimpan"+e);  
        }
        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        int index = tblbelanja.getSelectedRow();
        tabmode.removeRow(index);
        tblbelanja.setModel(tabmode);
        hitung();
        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bhapusActionPerformed

    private void tblbelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbelanjaMouseClicked
        // TODO add your handling code here:
        int bar = tblbelanja.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        
        txtkd.setText(a);
        txtnmbarang.setText(b);
        cbmerk.setSelectedItem(c);
        txttype.setText(d);
        txthb.setText(e);
        txttahun.setText(f);
        txtqty.setText(g);
        txtsubtotal.setText(h);
    }//GEN-LAST:event_tblbelanjaMouseClicked

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
        kosong();
        aktif();
        autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
        new start.home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcaribarangbeli;
    private javax.swing.JButton bcaripetugas;
    private javax.swing.JButton bcarisupplier;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bproses;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JComboBox<String> cbmerk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jtanggal;
    private javax.swing.JTable tblbelanja;
    private javax.swing.JTextField txthb;
    private javax.swing.JTextField txthps;
    private javax.swing.JTextField txtidsupplier;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtkdfaktur;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtnmbarang;
    private javax.swing.JTextField txtnmpetugas;
    private javax.swing.JTextField txtnmsupplier;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttahun;
    private javax.swing.JTextField txttotalbarang;
    private javax.swing.JTextField txttotalbelanja;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables
}
