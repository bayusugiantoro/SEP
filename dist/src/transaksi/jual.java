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
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import koneksi.koneksi;
import popup.popuppelanggan;
import popup.popupkaryawan;
import popup.popupbarang;
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
public class jual extends javax.swing.JFrame {
public String idpelanggan, nmpelanggan, jenis, nohp, alamat;
public String nik, nmkaryawan, jabatan, nohpk, alamatk;
public String kdbarang, nmbarang, merk, type, stok, hb, hj, tahun;
public String ket;
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode; 

    //JasperReport jasperReport;
    //JasperDesign jasperDesign;
    //JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    /**
     * Creates new form jual
     */
    public jual() {
        initComponents();
        kosong();
        aktif();
        autonumber();
        kosongt();
        java.util.Date date = new java.util.Date();
        jtanggal.setDate(date);
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }
    
    protected void aktif(){
        txttahunproses.requestFocus();
        Object[] Baris ={"Kode Barang","Nama Barang","Merk","Type","Stok Tersedia","Harga Barang","Tahun Barang","QTY","Sub Total Harga","Diskon","Ket. Diskon","Total Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tblpenjualan.setModel(tabmode);  
        cbjabatan.setSelectedItem("Item1");
        cbmerk.setSelectedItem("Item1");
    }
    
    protected void kosongt(){
        txttahunproses.setText("");
        txtqty.setText("");
    }
    
    protected void kosong(){
        txtidpelanggan.setText("");
        txtnmpelanggan.setText("");
        txthp.setText("");
        txtalamat.setText("");
        txtnik.setText("");
        txtnmkaryawan.setText("");
        cbjabatan.setSelectedItem("-Pilih Jabatan-");
        txtkd.setText("");
        txtnmbarang.setText("");
        cbmerk.setSelectedItem("-Pilih Merk-");
        txttype.setText("");
        txtstok.setText("");
        txtharga.setText("");
        txttahun.setText("");
        txttahunproses.setText("");
        txtqty.setText("");
        txtsubtotal.setText("");
        txtdiskon.setText("");
        txtketdiskon.setText("");
        txttotalharga.setText("");
        txtgrandtotal.setText("");
    }
    
    protected void autonumber(){
        try {
            String sql = "SELECT idnota FROM nota order by idnota asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtidnota.setText("OUT0001");
            while (rs.next()) {
                String id_nota = rs.getString("idnota").substring(3);
                int AN = Integer.parseInt(id_nota) + 1;
                String Nol = ""; 
 
                  if(AN<10)
                  {Nol = "000";}
                  else if(AN<100)
                  {Nol = "00";}
                  else if(AN<1000)
                  {Nol = "0";}
                  else if(AN<10000)
                  {Nol = "";} 
 
                  txtidnota.setText("OUT" + Nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" +e);
        }
    }

    
    public void itemTerpilihpelanggan(){
        popuppelanggan Pp = new popuppelanggan();
        Pp.pelanggan = this;
        txtidpelanggan.setText(idpelanggan);
        txtnmpelanggan.setText(nmpelanggan);
        txthp.setText(nohp);
        txtalamat.setText(alamat);
    
    } 
    
    public void itemTerpilihkaryawan(){
        popupkaryawan Pp = new popupkaryawan();
        Pp.karyawan = this;
        txtnik.setText(nik);
        txtnmkaryawan.setText(nmkaryawan);
        cbjabatan.setSelectedItem(jabatan);
    } 
   
    public void itemTerpilihbarang(){
        popupbarang Pp = new popupbarang();
        Pp.barang = this;
        txtkd.setText(kdbarang);
        txtnmbarang.setText(nmbarang);
        cbmerk.setSelectedItem(merk);
        txttype.setText(type);
        txtstok.setText(stok);
        txtharga.setText(hj);
        txttahun.setText(tahun);
    }
    
    
     public void proses(){
        int xthb = Integer.parseInt(txttahun.getText());
        int xthp = Integer.parseInt(txttahunproses.getText());
        int xhgb = Integer.parseInt(txtsubtotal.getText());
        int g = xthp-xthb;
        int disc = 0;
        
        
        if ( g >=8 ){
            disc = (xhgb*30)/100;
            ket = "30 Persen";
    } else if ( g >= 5 && g < 8 ){
             disc = (xhgb*20)/100;
             ket = "20 Persen";
    } else if ( g >= 3 && g < 5 ){
             disc = (xhgb*10)/100;
             ket = "10 Persen";
    } else if ( g < 3 ){
             ket = "Tidak Ada";
    }else {
        ket = "Tidak Ada";
    }
               
        txtdiskon.setText(String.valueOf(disc));
        txtketdiskon.setText(String.valueOf(ket));     
    }    
     
     
       public void subtotal(){        
        int xhrgb=Integer.parseInt(txtharga.getText());
        int xqty=Integer.parseInt(txtqty.getText());
        int xtotal=xhrgb*xqty;
        txtsubtotal.setText(String.valueOf(xtotal));
       }
       
       public void totalharga(){
           int xsubtotal = Integer.parseInt(txtsubtotal.getText());
           int disc = Integer.parseInt(txtdiskon.getText());
           int xtotalharga = xsubtotal-disc;
           txttotalharga.setText(String.valueOf(xtotalharga));
           
       }
       
       public void hitung(){
           int total = 0;
            for (int i =0; i< tblpenjualan.getRowCount(); i++){
            int amount = Integer.valueOf(tblpenjualan.getValueAt(i, 11).toString());
            total += amount;
            }
        txtgrandtotal.setText(Integer.toString(total));
       }
       
       public void cetak(){      
         try {            
             File file = new File("./src/ireport/jual.jrxml"); //JasperDesign = JRXmlLoader.load(file);
             HashMap parameter = new HashMap();     
             parameter.put("idnota",txtidnota.getText());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidpelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnmpelanggan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        bcaripelanggan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtidnota = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtkd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnmbarang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        bcaribarang = new javax.swing.JButton();
        txttahun = new javax.swing.JTextField();
        cbmerk = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtnik = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtnmkaryawan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbjabatan = new javax.swing.JComboBox<>();
        bcarikaryawan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txttahunproses = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtdiskon = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtketdiskon = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        bproses = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txttotalharga = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpenjualan = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        txtgrandtotal = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jtanggal = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setPreferredSize(new java.awt.Dimension(2200, 2297));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(1441, 1040));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 2295));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.green);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("PENJUALAN");
        jLabel1.setToolTipText("");
        jPanel3.add(jLabel1);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("ID Pelanggan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtidpelanggan.setEditable(false);
        txtidpelanggan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtidpelanggan.setToolTipText("");
        jPanel2.add(txtidpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 90, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Nama Pelanggan");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmpelanggan.setEditable(false);
        txtnmpelanggan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtnmpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmpelangganActionPerformed(evt);
            }
        });
        jPanel2.add(txtnmpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 155, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("No. Handphone");
        jLabel5.setToolTipText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        txthp.setEditable(false);
        txthp.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txthp.setToolTipText("");
        txthp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthpActionPerformed(evt);
            }
        });
        jPanel2.add(txthp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 155, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Alamat");
        jLabel6.setToolTipText("");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, -1, -1));

        txtalamat.setEditable(false);
        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, 110));

        bcaripelanggan.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaripelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaripelanggan.setText("Cari");
        bcaripelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripelangganActionPerformed(evt);
            }
        });
        jPanel2.add(bcaripelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 320, 280));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("ID Nota");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        txtidnota.setEditable(false);
        txtidnota.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtidnota.setToolTipText("");
        jPanel1.add(txtidnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 38, 70, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("Kode Barang");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtkd.setEditable(false);
        txtkd.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdActionPerformed(evt);
            }
        });
        jPanel4.add(txtkd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 95, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("Nama Barang");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmbarang.setEditable(false);
        txtnmbarang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtnmbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmbarangActionPerformed(evt);
            }
        });
        jPanel4.add(txtnmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 133, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel10.setText("Merk");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Type");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, -1, -1));

        txttype.setEditable(false);
        txttype.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });
        jPanel4.add(txttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 133, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setText("Stok Tersedia");
        jLabel12.setToolTipText("");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, -1, -1));

        txtstok.setEditable(false);
        txtstok.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });
        jPanel4.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 133, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel13.setText("Harga");
        jLabel13.setToolTipText("");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, -1, -1));

        txtharga.setEditable(false);
        txtharga.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel4.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 133, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel15.setText("Tahun");
        jLabel15.setToolTipText("");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 273, -1, -1));

        bcaribarang.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcaribarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcaribarang.setText("Cari");
        bcaribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribarangActionPerformed(evt);
            }
        });
        jPanel4.add(bcaribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        txttahun.setEditable(false);
        txttahun.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel4.add(txttahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 133, -1));

        cbmerk.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbmerk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Merk-", "SHARP", "BEKO", "POLYTRON", "TOSHIBA", "SAMSUNG" }));
        jPanel4.add(cbmerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 310, 310));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel16.setText("Tanggal");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 43, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kasir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel14.setText("NIK");
        jLabel14.setToolTipText("");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txtnik.setEditable(false);
        txtnik.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel5.add(txtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 90, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel17.setText("Nama Kasir");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtnmkaryawan.setEditable(false);
        txtnmkaryawan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtnmkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmkaryawanActionPerformed(evt);
            }
        });
        jPanel5.add(txtnmkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 155, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel18.setText("Jabatan");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        cbjabatan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Jabatan-", "Pemilik", "Kasir", "Pramuniaga", "Bagian Gudang" }));
        jPanel5.add(cbjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        bcarikaryawan.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bcarikaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_30p.png"))); // NOI18N
        bcarikaryawan.setText("Cari");
        bcarikaryawan.setToolTipText("");
        bcarikaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarikaryawanActionPerformed(evt);
            }
        });
        jPanel5.add(bcarikaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 320, 150));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel19.setText("Tahun Ini");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 33, -1, -1));

        txttahunproses.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel6.add(txttahunproses, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 130, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel20.setText("QTY");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtqty.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        jPanel6.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 130, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel21.setText("Diskon");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, -1, -1));

        txtdiskon.setEditable(false);
        txtdiskon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel6.add(txtdiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel22.setText("Ket. Diskon");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, -1, -1));

        txtketdiskon.setEditable(false);
        txtketdiskon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel6.add(txtketdiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel23.setText("Sub Total Harga");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        txtsubtotal.setEditable(false);
        txtsubtotal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        jPanel6.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, -1));

        btambah.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tambah_30px.png"))); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        jPanel6.add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 120, -1, -1));

        bproses.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bproses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/proses_30px.png"))); // NOI18N
        bproses.setText("Proses");
        bproses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesActionPerformed(evt);
            }
        });
        jPanel6.add(bproses, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel9.setText("Total Harga");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, -1, -1));

        txttotalharga.setEditable(false);
        txttotalharga.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txttotalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalhargaActionPerformed(evt);
            }
        });
        jPanel6.add(txttotalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 130, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 370, 270));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        tblpenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpenjualanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblpenjualan);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1310, 110));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("GRAND TOTAL");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 155, -1, -1));

        txtgrandtotal.setEditable(false);
        txtgrandtotal.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        txtgrandtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgrandtotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtgrandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 150, 130, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 1330, 200));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bsimpan.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save_30px.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel8.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        bhapus.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hapus_30px.png"))); // NOI18N
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel8.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        bbatal.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancelit_30px.png"))); // NOI18N
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel8.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 20, -1, -1));

        bkeluar.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exitsign_30px.png"))); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });
        jPanel8.add(bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 325, 125));

        jtanggal.setDateFormatString("dd MMMM yyyy");
        jtanggal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jtanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 40, 140, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.jpg"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HOME.jpg"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 100, -1, -1));

        jScrollPane3.setViewportView(jPanel1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnmpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmpelangganActionPerformed

    private void txthpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthpActionPerformed

    private void txtkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkdActionPerformed

    private void txtnmbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmbarangActionPerformed

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttypeActionPerformed

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

    private void bcaripelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripelangganActionPerformed
        // TODO add your handling code here:
        popuppelanggan Pp = new popuppelanggan();
        Pp.pelanggan = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaripelangganActionPerformed

    private void bcaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribarangActionPerformed
        // TODO add your handling code here:
        popupbarang Pp = new popupbarang();
        Pp.barang = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcaribarangActionPerformed

    private void bcarikaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarikaryawanActionPerformed
        // TODO add your handling code here:
        popupkaryawan Pp = new popupkaryawan();
        Pp.karyawan = this;
        Pp.setVisible(true);
        Pp.setResizable(false);
    }//GEN-LAST:event_bcarikaryawanActionPerformed

    private void txtnmkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmkaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmkaryawanActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
        subtotal();
        proses();
        totalharga();
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void txtgrandtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgrandtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrandtotalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
        new start.home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabel = (DefaultTableModel) tblpenjualan.getModel();
        for (int i = 0; i<tblpenjualan.getRowCount(); i++){
            
            try{
                String kdbarang = tblpenjualan.getValueAt(i,0).toString();
                String stokk = tblpenjualan.getValueAt(i,4).toString();
                int hasil = 0;
                hasil = Integer.valueOf(stokk);
                String sql = "update barang set "+"stok='"+stokk+"'"+" where " + "kdbarang='"+kdbarang+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate(sql);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+e.getMessage());
            }
        }
        kosong();
        kosongt();
        aktif();
        autonumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bprosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesActionPerformed
        // TODO add your handling code here:
        subtotal();
        proses();
        totalharga();
    }//GEN-LAST:event_bprosesActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        try{
            String kdbarang = txtkd.getText();
            int stokk = Integer.parseInt(txtstok.getText());
            int qty = Integer.parseInt(txtqty.getText());
            int hasil = 0;
            hasil = stokk - qty;
            String sql = "update barang set "+"stok='"+hasil+"'"+" where " + "kdbarang='"+kdbarang+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate(sql);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+e.getMessage());
        }
        
        try{   
            String kode = txtkd.getText();
            String nama = txtnmbarang.getText();
            String merk = cbmerk.getSelectedItem().toString();
            String type = txttype.getText();
            String stok = txtstok.getText();
            String harga = txtharga.getText();
            String tahun = txttahun.getText();
            int qty = Integer.parseInt(txtqty.getText());
            int subtotal = Integer.parseInt(txtsubtotal.getText());
            int diskon = Integer.parseInt(txtdiskon.getText());
            String ket = txtketdiskon.getText();
            int totalharga = Integer.parseInt(txttotalharga.getText());
            tabmode.addRow(new Object[]{kode,nama,merk,type,stok,harga,tahun,qty,subtotal,diskon,ket,totalharga});
            tblpenjualan.setModel(tabmode);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
        }
        txtkd.setText("");
        txtnmbarang.setText("");
        cbmerk.setSelectedItem("-Pilih Merk-");
        txttype.setText("");
        txtstok.setText("");
        txtharga.setText("");
        txttahun.setText("");
        txtqty.setText("");
        txtsubtotal.setText("");
        txtdiskon.setText("");
        txtketdiskon.setText("");
        txttotalharga.setText("");
        hitung();
        kosongt();
    }//GEN-LAST:event_btambahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(jtanggal.getDate());
        String sql = "insert into nota values (?,?,?,?,?,?,?,?,?)";
        String zsql = "insert into isi values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
             PreparedStatement stat = conn.prepareStatement(sql);
             stat.setString(1, txtidnota.getText());
             stat.setString(2, fd);
             stat.setString(3, txtidpelanggan.getText());
             stat.setString(4, txtnmpelanggan.getText());
             stat.setString(5, txthp.getText());
             stat.setString(6, txtalamat.getText());
             stat.setString(7, txtnik.getText());
             stat.setString(8, txtnmkaryawan.getText());
             stat.setString(9,cbjabatan.getSelectedItem().toString());
             stat.executeUpdate();
             int t = tblpenjualan.getRowCount();
             for(int i=0; i < t ; i++)
                 {
                String kd = tblpenjualan.getValueAt(i,0).toString();
                String nmbarang = tblpenjualan.getValueAt(i,1).toString();
                String merk = tblpenjualan.getValueAt(i,2).toString();
                String type = tblpenjualan.getValueAt(i,3).toString();
                String stok = tblpenjualan.getValueAt(i,4).toString();
                String harga = tblpenjualan.getValueAt(i,5).toString();
                String tahun = tblpenjualan.getValueAt(i,6).toString();
                String qty = tblpenjualan.getValueAt(i,7).toString();
                String subtotal = tblpenjualan.getValueAt(i,8).toString();
                String diskon = tblpenjualan.getValueAt(i,9).toString();
                String ket = tblpenjualan.getValueAt(i,10).toString();
                String totalharga = tblpenjualan.getValueAt(i,11).toString();
                
                PreparedStatement stat2 = conn.prepareStatement(zsql);
                stat2.setString(1, txtidnota.getText());
                stat2.setString(2, kd);
                stat2.setString(3, nmbarang);
                stat2.setString(4, merk);
                stat2.setString(5, type);
                stat2.setString(6, stok);
                stat2.setString(7, harga);
                stat2.setString(8, tahun);
                stat2.setString(9, qty);
                stat2.setString(10, subtotal);
                stat2.setString(11, diskon);
                stat2.setString(12, ket);
                stat2.setString(13, totalharga);
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
        DefaultTableModel tabel = (DefaultTableModel) tblpenjualan.getModel();
        for (int i = 0; i<tblpenjualan.getRowCount(); i++){
            
            try{
                String kdbarang = tblpenjualan.getValueAt(i,0).toString();
                String stokk = tblpenjualan.getValueAt(i,4).toString();
                int hasil = 0;
                hasil = Integer.valueOf(stokk);
                String sql = "update barang set "+"stok='"+stokk+"'"+" where " + "kdbarang='"+kdbarang+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate(sql);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+e.getMessage());
            }
        }
        int index = tblpenjualan.getSelectedRow();
        tabmode.removeRow(index);
        tblpenjualan.setModel(tabmode);
        hitung();
        aktif();
        proses();
        subtotal();
        totalharga();
    }//GEN-LAST:event_bhapusActionPerformed

    private void tblpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpenjualanMouseClicked
        // TODO add your handling code here:
        int bar = tblpenjualan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();
        String k = tabmode.getValueAt(bar, 10).toString();
        String l = tabmode.getValueAt(bar, 11).toString();
        
        txtkd.setText(a);
        txtnmbarang.setText(b);
        cbmerk.setSelectedItem(c);
        txttype.setText(d);
        txtstok.setText(e);
        txtharga.setText(f);
        txttahun.setText(g);
        txtqty.setText(h);
        txtsubtotal.setText(i);
        txtdiskon.setText(j);
        txtketdiskon.setText(k);
        txttotalharga.setText(l);
    }//GEN-LAST:event_tblpenjualanMouseClicked

    private void txttotalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalhargaActionPerformed

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
            java.util.logging.Logger.getLogger(jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcaribarang;
    private javax.swing.JButton bcarikaryawan;
    private javax.swing.JButton bcaripelanggan;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jtanggal;
    private javax.swing.JTable tblpenjualan;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtdiskon;
    private javax.swing.JTextField txtgrandtotal;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txthp;
    private javax.swing.JTextField txtidnota;
    private javax.swing.JTextField txtidpelanggan;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtketdiskon;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtnmbarang;
    private javax.swing.JTextField txtnmkaryawan;
    private javax.swing.JTextField txtnmpelanggan;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttahun;
    private javax.swing.JTextField txttahunproses;
    private javax.swing.JTextField txttotalharga;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables
}
