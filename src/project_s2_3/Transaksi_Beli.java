package project_s2_3;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class Transaksi_Beli extends javax.swing.JFrame {
public void kosongkanfield(){
    nmbarang.setText(null);
    kdbarang.setText(null);
    tgl.setText(null);
    jam.setText(null);
    txt_total.setText(null);
    txt_bayar.setText(null);
    txt_kembali.setText(null);
    hrgbarang.setText(null);
}
Connection con;
    PreparedStatement pst;
public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_semester2", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Transaksi_Jual.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transaksi_Beli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
 
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            Transaksi_Beli.jam.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }
public void Tampil_Tanggal() {
    java.util.Date tglsekarang = new java.util.Date();
    SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    String tanggal = smpdtfmt.format(tglsekarang);
    tgl.setText(tanggal);
}
public void munculdata(){            
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        try { 
            int qty = Integer.parseInt(jumlah.getText());
                String sql = "select * from barang where Nama_Barang='"+nmbarang.getText()+"'";
                java.sql.Connection conn=(Connection)SKP.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                while (res.next()) {
                    int harga_satuan = Integer.parseInt(res.getString(4));
                    int sub_total = qty * harga_satuan;
                    model.addRow(new Object[] {res.getString(1),
                            res.getString(2), qty,res.getString(4),sub_total});
            }
        } catch (Exception e) {    
        }
    
    }
public void totalsemua(){
        int sum =0;
        for (int i=0; i<tabel.getRowCount(); i++) {
            sum = sum + Integer.parseInt(tabel.getValueAt(i, 4).toString());}
        txt_total.setText(Integer.toString(sum));
    }
public void kembalian(){
        try{
        int sum =0;
        for (int i=0; i<tabel.getRowCount(); i++) {
            sum = sum + Integer.parseInt(tabel.getValueAt(i, 4).toString());}
        txt_total.setText(Integer.toString(sum));
        int bayar = Integer.parseInt(txt_bayar.getText());
        int kembalian = bayar - sum;
        txt_kembali.setText(Integer.toString(kembalian));  
        }catch(Exception e){
            
        } 
    }
public void simpandata(){
        try {
            String sql = "INSERT INTO `barang`(`Kode_Barang`, `Nama_Barang`, 'jumlah', 'Harga_Jual_Satuan', 'Harga_Jual_Grosir', 'Harga_Beli', Kode_Sup) VALUES (?,?,?,?,?,?,?)";  
            java.sql.Connection conn=(Connection)SKP.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, kdbarang.getText());
            pst.setString(2, nmbarang.getText());
            pst.setString(3, tgl.getText());
            pst.setString(4, jumlah.getText());
            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            pst.execute();
            
            
            JOptionPane.showMessageDialog(this, "Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
    }
private void penambahan_stok() {
        try {
                String sql = "select * from barang where Nama_Barang ='"+nmbarang.getText()+"'";
                java.sql.Connection conn=(Connection)SKP.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);  
                while (res.next()) {
                int oldqty = Integer.parseInt(res.getString(3));
                int newqty = oldqty + Integer.parseInt(jumlah.getText());                  
                String sqll = "UPDATE `barang`" + "SET `Jumlah`='"+newqty+"' WHERE `Nama_Barang` = '"+nmbarang.getText()+"'";
                java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                pstl.execute();
                }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public Transaksi_Beli() {
        initComponents();
        Tampil_Jam();
        Tampil_Tanggal();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_kembali = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        hapus = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(20, 63, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo SKPP Dash.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SKP");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sistem Kasir Pintar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, -1));

        jPanel3.setBackground(new java.awt.Color(165, 165, 230));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 32)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(12, 66, 121));
        jLabel16.setText("Home");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Homee dash (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, 50));

        jPanel4.setBackground(new java.awt.Color(165, 165, 230));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(12, 66, 121));
        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 32)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(12, 66, 121));
        jLabel17.setText("Petugas");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Profileee (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 50));

        jPanel5.setBackground(new java.awt.Color(165, 165, 230));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 32)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(12, 66, 121));
        jLabel18.setText("Supplier");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Suppl (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 150, 50));

        jPanel6.setBackground(new java.awt.Color(165, 165, 230));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 32)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(12, 66, 121));
        jLabel19.setText("Logout");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluarr (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 690));

        jPanel2.setBackground(new java.awt.Color(71, 116, 234));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel1.setText("Transaksi Beli");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(402, 402, 402))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 960, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jumlah.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel7.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 220, 30));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel14.setText("Jumlah");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 90, -1));

        jam.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel7.add(jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel10.setText("Tanggal Transaksi");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel11.setText("Kode Barang");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel5.setText("Harga");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 120, -1));

        nmbarang.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        nmbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmbarangActionPerformed(evt);
            }
        });
        nmbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbarangKeyReleased(evt);
            }
        });
        jPanel7.add(nmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 220, 30));

        kdbarang.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel7.add(kdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 220, 30));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "QTY", "Jumlah", "Sub Total"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 780, 180));

        txt_total.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel7.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 400, 80));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel12.setText("Bayar");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 60, -1));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel15.setText("Total");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 60, 40));

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel22.setText("Kembali");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 590, 80, 30));

        txt_kembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_kembaliKeyReleased(evt);
            }
        });
        jPanel7.add(txt_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 170, 30));

        tgl.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPanel7.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 110, 30));

        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
        });
        jPanel7.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 170, 30));

        hapus.setBackground(new java.awt.Color(255, 51, 51));
        hapus.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        jPanel7.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        tambah.setBackground(new java.awt.Color(51, 51, 255));
        tambah.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        tambah.setText("Tambah");
        tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahMouseClicked(evt);
            }
        });
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel7.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 120, 40));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 29)); // NOI18N
        jLabel6.setText("Nama Barang");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 120, -1));

        hrgbarang.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        hrgbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrgbarangActionPerformed(evt);
            }
        });
        jPanel7.add(hrgbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 220, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nmbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmbarangActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        munculdata();
        totalsemua();
        penambahan_stok();
    }//GEN-LAST:event_tambahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int baris = tabel.rowAtPoint(evt.getPoint());
        String kode_penjualan = kdbarang.getText();
        kdbarang.setText(kode_penjualan);
        kdbarang.disable();
        if (tabel.getValueAt(baris, 1)==null) {
            nmbarang.setText("");
        } else {
            nmbarang.setText(tabel.getValueAt(baris, 1).toString());
        }
        if (tabel.getValueAt(baris, 2)==null) {
            jumlah.setText("");
        } else {
            jumlah.setText(tabel.getValueAt(baris, 2).toString());
        }
        if (tabel.getValueAt(baris, 3)==null) {
            hrgbarang.setText("");
        } else {
            hrgbarang.setText(tabel.getValueAt(baris, 3).toString());
        }

    
    }//GEN-LAST:event_tabelMouseClicked

    private void hrgbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrgbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrgbarangActionPerformed

    private void nmbarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbarangKeyReleased
        // TODO add your handling code here:
        try {

                String sql = "select * from barang where Nama_Barang='"+nmbarang.getText()+"'";
                java.sql.Connection conn=(Connection)SKP.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                while(res.next()) {
                hrgbarang.setText(res.getString("Harga_Jual_Satuan"));
                kdbarang.setText(res.getString("Kode_Barang"));
                }            
        } catch (Exception e) {
        }
        if (nmbarang.getText().equals("")) {
            hrgbarang.setText(null);
            kdbarang.setText(null);
        }
    }//GEN-LAST:event_nmbarangKeyReleased

    private void txt_kembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kembaliKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliKeyReleased

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        try {
            int rs[] = tabel.getSelectedRows();
            for (int i=0; i<rs.length; i++) {
                String sql = "select * from barang where Nama_Barang ='"+model.getValueAt(i, 1).toString()+"'";
                java.sql.Connection conn=(Connection)SKP.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);  
                while (res.next()) {
                int oldqty = Integer.parseInt(res.getString(3));
                int newqty = oldqty + Integer.parseInt(model.getValueAt(i, 2).toString());                  
                String sqll = "UPDATE `barang`" + "SET `Jumlah`='"+newqty+"' WHERE `Nama_Barang` = '"+model.getValueAt(i, 1).toString()+"'";
                java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                pstl.execute();                        
                    }
                }
        } catch(Exception e) {

        }
        int[] rows = tabel.getSelectedRows();
        for(int i=0;i<rows.length;i++){
            model.removeRow(rows[i]-i);
        }
        
        if  (tabel.getRowCount()==0) {
            txt_total.setText("0");
            txt_bayar.setText("0");
            txt_kembali.setText("0");
        }
        totalsemua();
    }//GEN-LAST:event_hapusMouseClicked

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        // TODO add your handling code here:
        kembalian();
    }//GEN-LAST:event_txt_bayarKeyReleased

    private void tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
this.setVisible(false);
new Dashboard().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
this.setVisible(false);
new Petugas().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
this.setVisible(false);
new Login().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    
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
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    public static final javax.swing.JTextField hrgbarang = new javax.swing.JTextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTextField jam = new javax.swing.JTextField();
    public static final javax.swing.JTextField jumlah = new javax.swing.JTextField();
    public static final javax.swing.JTextField kdbarang = new javax.swing.JTextField();
    public static final javax.swing.JTextField nmbarang = new javax.swing.JTextField();
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    public static final javax.swing.JTextField tgl = new javax.swing.JTextField();
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
