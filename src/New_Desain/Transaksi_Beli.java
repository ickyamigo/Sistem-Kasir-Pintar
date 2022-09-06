/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Desain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class Transaksi_Beli extends javax.swing.JFrame {

    private Connection con;


    public void kosongkanfield() {
        kdtransaksi.setText(null);
        kdbarang.setText(null);
        kdsuplier.setSelectedItem(null);
        tanggal.setText(null);
        harga.setText(null);
        jumlah.setText(null);
        bayar.setText(null);
        kembalian.setText(null);
        nmbarang.setText(null);
        total.setText(null);
    }

    /**
     * Creates new form Transaksi_Beli
     */
    public Transaksi_Beli() {
        initComponents();
        datatable();
        kosongkanfield();
        totalsemua();
//        totalsemua();
        Tampil_Tanggal();
        tampil_combobox();
        kembalian();
//        hapustabel();
    }

    public void Tampil_Tanggal() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String Tanggal = smpdtfmt.format(tglsekarang);
        tanggal.setText(Tanggal);
    }
    
    public void datatable() {
        
    DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Transaksi");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Kode Suplier");
        tbl.addColumn("Kode Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Jumlah");
        tbl.addColumn("Total");
        tabel.setModel(tbl);
        try {
            int no = 1;
            String sql = "SELECT * FROM keranjang_beli";
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_Beli"),
                    res.getString("Tgl_beli"),
                    res.getString("Kode_Sup"),
                    res.getString("Kode_Barang"),
                    res.getString("Nama_Barang"),
                    res.getString("Jumlah"),
                    res.getString("Total"),});

            }
            tabel.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }

    public void tampil_combobox() {
        try {
            String sql = "Select * from suplier";
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                kdsuplier.addItem(rs.getString("Kode_Sup"));
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        } catch (Exception e) {

        }
    }

    public void hapus() {
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = "DELETE FROM keranjang_beli";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

        } catch (Exception e) {
        }
        datatable();
    }

    

    public void totalsemua() {
        int sum = 0;
        for (int i = 0; i < tabel.getRowCount(); i++) {
            sum = sum + Integer.parseInt(tabel.getValueAt(i, 6).toString());
        }
        total.setText(Integer.toString(sum));
    }

    public void kembalian() {
        try {
            int sum = 0;
            for (int i = 0; i < tabel.getRowCount(); i++) {
                sum = sum + Integer.parseInt(tabel.getValueAt(i, 6).toString());
            }
            total.setText(Integer.toString(sum));
            int Bayar = Integer.parseInt(bayar.getText());
            int Kembalian = Bayar - sum;
            kembalian.setText(Integer.toString(Kembalian));
        } catch (Exception e) {

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        kdtransaksi = new javax.swing.JTextField();
        kdbarang = new javax.swing.JTextField();
        tanggal = new javax.swing.JTextField();
        nmbarang = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        kdsuplier = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        totalharga1 = new javax.swing.JTextField();
        hapus1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cek = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 790, 150));
        getContentPane().add(kdtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 290, 30));

        kdbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kdbarangKeyReleased(evt);
            }
        });
        getContentPane().add(kdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 290, 30));
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 290, 30));

        nmbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmbarangActionPerformed(evt);
            }
        });
        getContentPane().add(nmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 290, 30));
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 290, 30));

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 290, 30));

        tambah.setBackground(new java.awt.Color(204, 204, 255));
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
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 120, 40));

        clear.setBackground(new java.awt.Color(255, 255, 51));
        clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        clear.setText("Clear");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, 120, 40));
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 220, 80));

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });
        getContentPane().add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 180, 30));
        getContentPane().add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 180, 30));

        getContentPane().add(kdsuplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 290, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/logo_baru-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        totalharga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalharga1ActionPerformed(evt);
            }
        });
        getContentPane().add(totalharga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 290, 30));

        hapus1.setBackground(new java.awt.Color(255, 51, 51));
        hapus1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        hapus1.setText("Hapus");
        hapus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus1MouseClicked(evt);
            }
        });
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        getContentPane().add(hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 210, 120, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/home-removebg-preview.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/Frame_159__1_-removebg-preview.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/Frame_159__2_-removebg-preview.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/LOGOUT-removebg-preview.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, -1, -1));

        cek.setBackground(new java.awt.Color(0, 255, 204));
        cek.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        cek.setText("CHEK");
        cek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cekMouseClicked(evt);
            }
        });
        cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekActionPerformed(evt);
            }
        });
        getContentPane().add(cek, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/TRNSAKSIBELI.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1310, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nmbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmbarangActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        DefaultTableModel tbl = new DefaultTableModel();

        String Kode_Sup = (String) kdsuplier.getSelectedItem();
        String Kode_Beli = kdtransaksi.getText();
        String Tgl_beli = tanggal.getText();
        String Id_Petugas = harga.getText();
        String Kode_Barang = kdbarang.getText();
        String Jumlah = jumlah.getText();
        String Nama_Barang = nmbarang.getText();
        String Total = harga.getText();

        try {

            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = "select * from transaksi_belii where Kode_Beli = '" + kdtransaksi.getText() + "'";
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sql1 = "INSERT INTO transaksi_belii VALUES ('" + Kode_Sup + "','" + Kode_Barang + "','"
                        + Jumlah + "','" + Kode_Beli + "','" + Nama_Barang + "')";
                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
                pstl.execute();
                String sql3 = "INSERT INTO keranjang_beli VALUES ('" + Kode_Beli + "','"
                        + Tgl_beli + "','" + Kode_Barang + "','" + Kode_Sup + "','" + Jumlah + "','"
                        + Nama_Barang + "','" + Total + "')";
                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
                pst2.execute();

            } else {
                String sql2 = "INSERT INTO detail_beli VALUES ('" + Kode_Beli + "','" + Tgl_beli + "')";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql2);
                pst.execute();
                String sql1 = "INSERT INTO transaksi_belii VALUES ('" + Kode_Sup + "','" + Kode_Barang + "','"
                        + Jumlah + "','" + Kode_Beli + "','" + Nama_Barang + "')";
                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
                pstl.execute();
                String sql3 = "INSERT INTO keranjang_beli VALUES ('" + Kode_Beli + "','"
                        + Tgl_beli + "','" + Kode_Barang + "','" + Kode_Sup + "','" + Jumlah
                        + "','" + Nama_Barang + "','" + Total + "')";
                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
                pst2.execute();
            }
            
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

datatable();
kosongkanfield();
totalsemua();
        
//        hapus();
        
//        kembalian();
//        kosongkanfield();        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
//        String Kode_Beli = kdtransaksi.getText();
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = ("DELETE FROM keranjang_beli ");

            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);

//        String Tgl_Beli = tanggal.getText();
//        String Kode_Barang = kdbarang.getText();
//        String Kode_Sup = jumlah.getText() ;
//        String Jumlah = totalharga1.getText() ;
//        String Nama_Barang = bayar.getText() ;
//        String Total = total.getText() ;
//            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
        kosongkanfield();
    }//GEN-LAST:event_clearMouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());

        String Kdsup = tabel.getValueAt(baris, 2).toString();
        kdsuplier.setSelectedItem(Kdsup);

        String Kdbeli = tabel.getValueAt(baris, 0).toString();
        kdtransaksi.setText(Kdbeli);

        String KdBarang = tabel.getValueAt(baris, 1).toString();
        tanggal.setText(KdBarang);

        String Tanggal = tabel.getValueAt(baris, 3).toString();
        kdbarang.setText(Tanggal);

        String Idpetugas = tabel.getValueAt(baris, 5).toString();
        jumlah.setText(Idpetugas);

        String NamaBarang = tabel.getValueAt(baris, 4).toString();
        nmbarang.setText(NamaBarang);// TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void kdbarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdbarangKeyReleased
        try {

            String sql = "select * from barang where Kode_Barang='" + kdbarang.getText() + "'";
            con = (Connection) New_Desain.SKP.configDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                nmbarang.setText(res.getString("Nama_Barang"));
                harga.setText(res.getString("Harga_Jual_Satuan"));
                kdsuplier.setSelectedItem(res.getString("Kode_Sup"));
            }
        } catch (Exception e) {
        }
        if (kdbarang.getText().equals("")) {
            nmbarang.setText(null);
            harga.setText(null);
            kdsuplier.setSelectedItem(null);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_kdbarangKeyReleased

    private void totalharga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalharga1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalharga1ActionPerformed

    private void hapus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapus1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus1MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
        String Kode_Beli = kdtransaksi.getText();
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = ("DELETE FROM keranjang_beli where Kode_Beli=('" + Kode_Beli + "');");

            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);

            String Kode_Sup = (String) kdsuplier.getSelectedItem();
            String Kode_Barang = kdbarang.getText();
            String Jumlah = jumlah.getText();
            String Nama_Barang = nmbarang.getText();
            String Total = harga.getText();

            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
        kosongkanfield();      // TODO add your handling code here:
    }//GEN-LAST:event_hapus1ActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        kembalian();        // TODO add your handling code here:
    }//GEN-LAST:event_bayarKeyReleased

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.setVisible(false);
        new Home().setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.setVisible(false);
        new Suplier().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        this.setVisible(false);
        new Petugas().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        this.setVisible(false);
        new Login().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void cekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cekMouseClicked

    private void cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekActionPerformed
        String Harga = harga.getText();
        String Jumlah = jumlah.getText();
        int totalsewa = Integer.parseInt(Harga) * Integer.parseInt(Jumlah);      // TODO add your handling code here:
        totalharga1.setText(Integer.toString(totalsewa));
        // TODO add your handling code here:
    }//GEN-LAST:event_cekActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton cek;
    private javax.swing.JButton clear;
    private javax.swing.JButton hapus1;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JComboBox<String> kdsuplier;
    private javax.swing.JTextField kdtransaksi;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nmbarang;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalharga1;
    // End of variables declaration//GEN-END:variables
}
