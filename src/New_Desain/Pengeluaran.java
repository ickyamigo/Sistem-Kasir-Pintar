/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Desain;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;

/**
 *
 * @author USER
 */
public class Pengeluaran extends javax.swing.JFrame {

    /**
     * Creates new form Pengeluaran
     */
    public Pengeluaran() {
        initComponents();
        tampil_combobox();
        Tampil_Tanggal();
        datatable();
        kosongkanfield();
    }

    public void kosongkanfield(){
kdkluar.setText(null);
tgl.setText(null) ;
jenis.setSelectedItem(null);
total.setText(null);
    }

    public void tampil_combobox(){
    try{
        String sql = "Select * from transaksi_pengeluaran";
        java.sql.Connection conn = (Connection)New_Desain.SKP.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            jenis.addItem(rs.getString("jenis_pengeluaran"));
        }
        rs.last();
        int jumlahdata = rs.getRow();
        rs.first();
    }catch(Exception e){
        
    }
        }
    
    public void Tampil_Tanggal() {
    java.util.Date tglsekarang = new java.util.Date();
    SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    String tanggal = smpdtfmt.format(tglsekarang);
    this.tgl.setText(tanggal);
    }
    
    public void datatable(){
    DefaultTableModel tbl=new DefaultTableModel();
    tbl.addColumn("Kode Pengeluaran");
    tbl.addColumn("Tgl Pengeluaran");
    tbl.addColumn("jenis_pengeluaran");
    tbl.addColumn("Total");
    tabel.setModel(tbl);
    try{
        int no=1;
        String sql = "SELECT * FROM transaksi_pengeluaran ORDER BY id_pengeluaran DESC; ";
        java.sql.Connection conn=(Connection)New_Desain.SKP.configDB();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet res=stm.executeQuery(sql);
        while(res.next())
        {
            tbl.addRow(new Object[]{
                res.getString("id_pengeluaran"),
                res.getString("tgl_pengeluaran"),
                res.getString("jenis_pengeluaran"),
                res.getString("Total"),
            });
                    tabel.setModel(tbl);
    }
}catch (Exception e){
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

        kdkluar = new javax.swing.JTextField();
        tgl = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jenis = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(kdkluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 290, 30));
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 290, 30));
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 290, 30));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 770, 160));

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 200, 120, 40));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jButton1.setText("Hapus");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 260, 120, 40));

        getContentPane().add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 290, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/logo_baru-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/home-removebg-preview.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/Frame_159__1_-removebg-preview.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/Frame_159__2_-removebg-preview.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/LOGOUT-removebg-preview.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Baru/pengeluaran.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        DefaultTableModel tbl=new DefaultTableModel();

        String id_pengeluaran = kdkluar.getText();
        String tgl_pengeluaran = tgl.getText() ;
        String jenis_pengeluaran = (String) jenis.getSelectedItem();
        String Total = total.getText();
        try{
            java.sql.Connection conn=(Connection)New_Desain.SKP.configDB();
            String sql = "INSERT INTO transaksi_pengeluaran VALUES ('" + id_pengeluaran + "','" + tgl_pengeluaran + "','" + jenis_pengeluaran + "','"
            + Total + "')";

            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute(sql);

            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        datatable();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String Kode_pengeluaran = kdkluar.getText();
        try {
            java.sql.Connection conn=(Connection)New_Desain.SKP.configDB();
            String sql = ("DELETE FROM transaksi_pengeluaran where id_pengeluaran=('" + Kode_pengeluaran + "');");

            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute(sql);

            String id_pengeluaran = kdkluar.getText();
            String tgl_pengeluaran = tgl.getText() ;
            String jenis_pengeluaran = (String) jenis.getSelectedItem();
            String Total = total.getText();

            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.rowAtPoint(evt.getPoint());

        String Kdkluar = tabel.getValueAt(baris, 0).toString();
        kdkluar.setText(Kdkluar);

        String Tgl = tabel.getValueAt(baris, 1).toString();
        tgl.setText(Tgl);

        String Jenis = tabel.getValueAt(baris, 2).toString();
        jenis.setSelectedItem(Jenis);

        String Total = tabel.getValueAt(baris, 3).toString();
        total.setText(Total);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengeluaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField kdkluar;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tgl;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
