/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_s2_3;

import New_Desain.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
//import javax.swing.table.DefaultTableModel;import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * /**
 *
 * @author USER
 */
public class Transaksi_Jual1 extends javax.swing.JFrame {

    private Connection con;

    /**
     * Creates new form Transaksi_Jual
     */
    public Transaksi_Jual1() {
        initComponents();
        datatable();
        Tampil_Tanggal();
        totalsemua();
        kembalian();
        update();
        hapus();
        kosongkanfield();
//        datatable();

    }

    public void hapus() {
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = "DELETE FROM keranjang_jual ";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);

        } catch (Exception e) {

        }
    }

    public void Tampil_Tanggal() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd");
        String Tanggal = smpdtfmt.format(tglsekarang);
        tanggal.setText(Tanggal);
    }

    public void update() {
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = "UPDATE detail_jual SET Total_Semua='"
                    + total.getText() + "' ,Kembalian='" + kembalian.getText() + "' ,Bayar='" + bayar.getText() + "'WHERE Kode_jual = '" + kdjual.getText() + "'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);

        } catch (Exception e) {

        }
    }

//    public void Tampil_Tanggal() {
//    java.util.Date tglsekarang = new java.util.Date();
//    SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//    String tanggal = smpdtfmt.format(tglsekarang);
//    this.tanggal.setText(tanggal);
//    }
    public void totalsemua() {
        int sum = 0;
        for (int i = 0; i < tabel.getRowCount(); i++) {
            sum = sum + Integer.parseInt(tabel.getValueAt(i, 5).toString());
        }
        total.setText(Integer.toString(sum));
    }

    public void kembalian() {
        try {
            int sum = 0;
            for (int i = 0; i < tabel.getRowCount(); i++) {
                sum = sum + Integer.parseInt(tabel.getValueAt(i, 5).toString());
            }
            total.setText(Integer.toString(sum));
            int Bayar = Integer.parseInt(bayar.getText());
            int Kembalian = Bayar - sum;
            kembalian.setText(Integer.toString(Kembalian));
        } catch (Exception e) {

        }
    }

    public void kosongkanfield() {
        kdjual.setText(null);
        kdbarang.setText(null);
        tanggal.setText(null);
        harga.setText(null);
        jumlah.setText(null);
        nmbarang.setText(null);
    }

    public void datatable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Transaksi");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Kode Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Jumlah");
        tbl.addColumn("Total");
        tabel.setModel(tbl);
        try {
            int no = 1;
            String sql = "SELECT * FROM keranjang_jual ORDER BY Kode_Jual DESC";
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_Jual"),
                    res.getString("Tanggal_Jual"),
                    res.getString("Kode_Barang"),
                    res.getString("Nama_Barang"),
                    res.getString("Jumlah"),
                    res.getString("Total"),});
                tabel.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
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

        nmbarang = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        tanggal = new javax.swing.JTextField();
        kdbarang = new javax.swing.JTextField();
        kdjual = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cek = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jumlah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cetak = new javax.swing.JButton();
        harga1 = new javax.swing.JTextField();
        tambah1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 280, 30));
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 280, 30));

        tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalActionPerformed(evt);
            }
        });
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 280, 30));

        kdbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kdbarangKeyReleased(evt);
            }
        });
        getContentPane().add(kdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 280, 30));
        getContentPane().add(kdjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 280, 30));

        total.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 220, 80));

        bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });
        getContentPane().add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, 180, 30));

        kembalian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 620, 180, 30));

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
        jScrollPane2.setViewportView(tabel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 790, 130));

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
        getContentPane().add(cek, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 290, 120, 40));

        hapus.setBackground(new java.awt.Color(255, 51, 51));
        hapus.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 120, 40));
        getContentPane().add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 280, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/logo_baru-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        cetak.setBackground(new java.awt.Color(255, 255, 51));
        cetak.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        cetak.setText("Cetak");
        cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cetakMouseClicked(evt);
            }
        });
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, 120, 40));

        harga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga1ActionPerformed(evt);
            }
        });
        harga1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                harga1KeyReleased(evt);
            }
        });
        getContentPane().add(harga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 280, 30));

        tambah1.setBackground(new java.awt.Color(204, 204, 255));
        tambah1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        tambah1.setText("Tambah");
        tambah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah1MouseClicked(evt);
            }
        });
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });
        getContentPane().add(tambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 120, 40));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/TRANSAKSI_juAL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());

        String KDtransaksi = tabel.getValueAt(baris, 0).toString();
        kdjual.setText(KDtransaksi);

        String Tanggal = tabel.getValueAt(baris, 1).toString();
        tanggal.setText(Tanggal);

        String KodeBarang = tabel.getValueAt(baris, 2).toString();
        kdbarang.setText(KodeBarang);

        String Nama_Barang = tabel.getValueAt(baris, 3).toString();
        nmbarang.setText(Nama_Barang);

        String Jumlah = tabel.getValueAt(baris, 4).toString();
        jumlah.setText(Jumlah);
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void cekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cekMouseClicked

    private void cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekActionPerformed
        String Harga = harga.getText();
        String Jumlah = jumlah.getText();
        int totalsewa = Integer.parseInt(Harga) * Integer.parseInt(Jumlah);      // TODO add your handling code here:
        harga1.setText(Integer.toString(totalsewa));
        // TODO add your handling code here:
    }//GEN-LAST:event_cekActionPerformed

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
        String Kode_Jual = kdjual.getText();
        try {
            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = ("DELETE FROM keranjang_jual where Kode_Jual=('" + Kode_Jual + "');");

            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute(sql);

            String Tanggal_Jual = tanggal.getText();
            String Kode_Barang = kdbarang.getText();
            String Nama_Barang = nmbarang.getText();
            String Jumlah = jumlah.getText();

            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
        kosongkanfield();
    }//GEN-LAST:event_hapusMouseClicked

    private void cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakMouseClicked

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed

        try {

            //        java.sql.Connection con = (null);
            //        try{
            //            String jdbcDriver = "com.mysql.jdbc.Driver";
            //            Class.forName(jdbcDriver);
            //
            //            String url = "jdbc:mysql://localhost:3306//project_semester2";
            //            String user = "root";
            //            String pass = "";
            //
            //            con = DriverManager.getConnection(url, user, pass);
            //            Statement stm = con.createStatement();
            update();
            con = (Connection) New_Desain.SKP.configDB();
            try {

                String report = "src/New_Desain/report2.jrxml";
                HashMap hash = new HashMap();
                hash.put("kode", kdjual.getText());
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, con);
                JasperViewer.viewReport(JPrint, false);
            } catch (JRException rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
            //        } catch (Exception e){
            //            System.out.println(e);
            //        }

            //            try {
            //                java.sql.Connection conn=(Connection)SKP.configDB();
            //            String sql = ("D:\\proyek semester 2\\Project_S2_5\\src\\New_Desain\\report2.jrxml");
            //
            //            HashMap hash = new HashMap();
            //            hash.put("kode", kdtransaksi.getText());
            //            JasperReport JRpt = JasperCompileManager.compileReport(sql);
            //            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
            //            JasperViewer.viewReport( JPrint, false);
            //            }catch(Exception rptexcpt){
            //                System.out.println("Report Can't view because : " + rptexcpt);
            //            }
            //
            // TODO add your handling code here:
            hapus();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Beli.class.getName()).log(Level.SEVERE, null, ex);

        }

        //        } catch (Exception e){
        //            System.out.println(e);
        //        }
        //            try {
        //                java.sql.Connection conn=(Connection)SKP.configDB();
        //            String sql = ("D:\\proyek semester 2\\Project_S2_5\\src\\New_Desain\\report2.jrxml");
        //
        //            HashMap hash = new HashMap();
        //            hash.put("kode", kdtransaksi.getText());
        //            JasperReport JRpt = JasperCompileManager.compileReport(sql);
        //            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
        //            JasperViewer.viewReport( JPrint, false);
        //            }catch(Exception rptexcpt){
        //                System.out.println("Report Can't view because : " + rptexcpt);
        //            }
        //
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakActionPerformed

    private void kdbarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdbarangKeyReleased
        try {

            String sql = "select * from barang where Kode_Barang='" + kdbarang.getText() + "'";
            con = (Connection) SKP.configDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                nmbarang.setText(res.getString("Nama_Barang"));
                harga.setText(res.getString("Harga_Jual_Satuan"));

            }
        } catch (Exception e) {
        }
        if (kdbarang.getText().equals("")) {
            nmbarang.setText(null);
            kdbarang.setText(null);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_kdbarangKeyReleased

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        kembalian();       // TODO add your handling code here:
    }//GEN-LAST:event_bayarKeyReleased

    private void harga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga1ActionPerformed
//String Harga = harga.getText();
//String Jumlah = jumlah.getText();
//DecimalFormat DF = new DecimalFormat();
//int totalsewa = Integer.parseInt(Harga) * Integer.parseInt(Jumlah);// TODO add your handling code here:
    }//GEN-LAST:event_harga1ActionPerformed

    private void harga1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_harga1KeyReleased
        String Harga = harga.getText();
        String Jumlah = jumlah.getText();
        DecimalFormat DF = new DecimalFormat();
        int totalsewa = Integer.parseInt(Harga) * Integer.parseInt(Jumlah);        // TODO add your handling code here:
    }//GEN-LAST:event_harga1KeyReleased

    private void tambah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambah1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tambah1MouseClicked

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
        DefaultTableModel tbl = new DefaultTableModel();

        String Kode_Jual = kdjual.getText();
        String Total_Semua = total.getText();
        String Tanggal_Jual = tanggal.getText();
//        String Tgl_Jual = tanggal.getText();
        String Kembalian = kembalian.getText();
        String Bayar = bayar.getText();
        String Kode_Barang = kdbarang.getText();
        String Nama_Barang = nmbarang.getText();
        String Total = harga1.getText();
        String Jumlah = jumlah.getText();

        try {

            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
            String sql = "select * from transaksi_juall where Kode_Jual = '" + kdjual.getText() + "'";
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String sql1 = "INSERT INTO transaksi_juall VALUES ('" + Kode_Barang + "','" + Jumlah + "','"
                        + Tanggal_Jual + "','" + Nama_Barang + "','" + Kode_Jual + "','" + Total + "')";
                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
                pstl.execute();
                String sql3 = "INSERT INTO keranjang_jual VALUES ('" + Kode_Jual + "','"
                        + Tanggal_Jual + "','" + Kode_Barang + "','" + Nama_Barang + "','" + Jumlah + "','" + Total + "')";
                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
                pst2.execute();

            } else {
                String sql2 = "INSERT INTO detail_jual VALUES ('" + Kode_Jual + "','" + Tanggal_Jual + "','" + Kembalian + "','" + Total_Semua + "','" + Bayar + "')";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql2);
                pst.execute();
                String sql1 = "INSERT INTO transaksi_juall VALUES ('" + Kode_Barang + "','" + Jumlah + "','"
                        + Tanggal_Jual + "','" + Nama_Barang + "','" + Kode_Jual + "','" + Total + "')";
                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
                pstl.execute();
                String sql3 = "INSERT INTO keranjang_jual VALUES ('" + Kode_Jual + "','"
                        + Tanggal_Jual + "','" + Kode_Barang + "','" + Nama_Barang + "','" + Jumlah + "','" + Total + "')";
                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
                pst2.execute();

            }

            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//        try {
//
//            java.sql.Connection conn = (Connection) New_Desain.SKP.configDB();
//            String sql = "select * from transaksi_juall where Kode_Jual = '" + kdjual.getText() + "'";
//            java.sql.Statement st = conn.createStatement();
//            java.sql.ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                String sql1 = "INSERT INTO transaksi_juall VALUES ('" + Kode_Barang + "','" + Jumlah + "','"
//                        + Tanggal_Jual + "','" + Nama_Barang + "','" + Kode_Jual + "','" + Total + "')";
//                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
//                pstl.execute();
//                String sql3 = "INSERT INTO keranjang_jual VALUES ('" + Kode_Jual + "','"
//                        + Tanggal_Jual + "','" + Kode_Barang + "','" + Nama_Barang + "','" + Jumlah + "','" + Total + "')";
//                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
//                pst2.execute();
//
//            } else {
//                String sql2 = "INSERT INTO detail_jual VALUES ('" + Kode_Jual + "','" + Tanggal_Jual + "')";
//                java.sql.PreparedStatement pst = conn.prepareStatement(sql2);
//                pst.execute();
//                String sql1 = "INSERT INTO transaksi_juall VALUES ('" + Kode_Barang + "','" + Jumlah + "','"
//                        + Tanggal_Jual + "','" + Nama_Barang + "','" + Kode_Jual + "','" + Total + "')";
//                java.sql.PreparedStatement pstl = conn.prepareStatement(sql1);
//                pstl.execute();
//                String sql3 = "INSERT INTO keranjang_jual VALUES ('" + Kode_Jual + "','"
//                        + Tanggal_Jual + "','" + Kode_Barang + "','" + Nama_Barang + "','" + Jumlah + "','" + Total + "')";
//                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql3);
//                pst2.execute();
//            }
//
//            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }

        datatable();
//        hapus();
        kosongkanfield();
        totalsemua();
        kembalian();
        // TODO add your handling code here:
    }//GEN-LAST:event_tambah1ActionPerformed

    private void tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi_Jual1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Jual1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton cek;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField harga1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JTextField kdjual;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nmbarang;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah1;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
