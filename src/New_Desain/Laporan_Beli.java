/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Desain;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static project_s2_3.struk.struksewa;
import static project_s2_3.Transaksi_Beli.kdbarang;
import static project_s2_3.Transaksi_Beli.nmbarang;
import static project_s2_3.Transaksi_Beli.tgl;
import static project_s2_3.Transaksi_Beli.jam;
import static project_s2_3.Transaksi_Beli.jumlah;
import static project_s2_3.Transaksi_Beli.hrgbarang;

public class Laporan_Beli extends javax.swing.JFrame {

    /**
     * Creates new form Laporan_Beli
     */
    public Laporan_Beli() {
        initComponents();
        datatable();
    }

    public void struk () {
                struksewa.setText(struksewa.getText()+ "\t                project_semeter2\n");
        struksewa.setText(struksewa.getText()+ "      TOKO BU JAMILAH YEPPO\n");
        struksewa.setText(struksewa.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"Kode Sewa     "+kdbarang.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"Tanggal    "+nmbarang.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"ID Kasir    "+hrgbarang.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"ID Kasir    "+tgl.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"ID Kasir    "+jam.getText()+ "\n");
        struksewa.setText(struksewa.getText()+"ID Kasir    "+jumlah.getText()+ "\n");
        struksewa.setText(struksewa.getText()+ "----------------------------------------------------------------------------------------------\n");
        struksewa.setText(struksewa.getText()+ "\n");
            String Kode = kdbarang.getText();
            String Nama = nmbarang.getText();
            String Harga = hrgbarang.getText();
            String Tgl= tgl.getText();
            String Jam = jam.getText();
            String Jumlah= jumlah.getText();
        struksewa.setText(struksewa.getText()+"\t"+"ID Customer"+"\t"+":"+"\t"+kdbarang+"\n");
        struksewa.setText(struksewa.getText()+"\t"+"Kode Buku"+"\t"+":"+"\t"+nmbarang+"\n");
        struksewa.setText(struksewa.getText()+"\t"+"Judul Buku"+"\t"+":"+"\t"+hrgbarang+"\n");
        struksewa.setText(struksewa.getText()+"\t"+"Jumlah"+"\t"+":"+"\t"+tgl+"\n");
        struksewa.setText(struksewa.getText()+"\t"+"Jumlah"+"\t"+":"+"\t"+jam+"\n");
        struksewa.setText(struksewa.getText()+"\t"+"Jumlah"+"\t"+":"+"\t"+jumlah+"\n");
        
        
        struksewa.setText(struksewa.getText()+ "----------------------------------------------------------------------------------------------\n");
        String Total = jumlah.getText();
        struksewa.setText(struksewa.getText()+"\t                       "+"Total"+"\t"+":"+"\t"+Total+"\n");
        struksewa.setText(struksewa.getText()+ "----------------------------------------------------------------------------------------------\n");
        struksewa.setText(struksewa.getText()+ "\n");
        struksewa.setText(struksewa.getText()+ "                  Terimakasih Telah Membeli Di Toko Kami");
        struksewa.setText(struksewa.getText()+ "\n");
        struksewa.setText(struksewa.getText()+ "\n");
    }
    
public void datatable(){
    DefaultTableModel tbl=new DefaultTableModel();
    tbl.addColumn("Kode Suplier");
    tbl.addColumn("Kode Barang");
    tbl.addColumn("Jumlah");
    tbl.addColumn("Kode Beli");
    tbl.addColumn("Barang");
    tabel.setModel(tbl);
    try{
        int no=1;
        String sql = "SELECT * FROM transaksi_belii ORDER BY Kode_Beli DESC; ";
        java.sql.Connection conn=(Connection)New_Desain.SKP.configDB();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet res=stm.executeQuery(sql);
        while(res.next())
        {
            tbl.addRow(new Object[]{
                res.getString("Kode_Sup"),
                res.getString("Kode_Barang"),
                res.getString("Jumlah"),
                res.getString("Kode_Beli"),
                res.getString("Nama_Barang"),
                
                
            });
                    tabel.setModel(tbl);
    }
}catch (Exception e){
    JOptionPane.showMessageDialog(rootPane, "salah");
}
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cetak = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 790, 310));

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
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 120, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cari");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 240, -1));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/LAPORAN BELI.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakMouseClicked

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_cetakActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

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

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
DefaultTableModel table = (DefaultTableModel) tabel.getModel();
        String search = cari.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tabel.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));        // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyReleased

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
            java.util.logging.Logger.getLogger(Laporan_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
