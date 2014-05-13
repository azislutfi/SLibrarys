/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Finally
 */
public class gMenuPetugas extends javax.swing.JFrame implements InterfaceView{

    /**
     * Creates new form gMenuPetugas
     */
    public gMenuPetugas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btKelMahasiswa = new javax.swing.JButton();
        btKelBuku = new javax.swing.JButton();
        btKelKategori = new javax.swing.JButton();
        btKelTataLetak = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        btInputPeminjaman = new javax.swing.JButton();
        btInputPengembalian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btKelMahasiswa.setText("Kelola Mahasiswa");
        btKelMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKelMahasiswaActionPerformed(evt);
            }
        });

        btKelBuku.setText("Kelola Buku");
        btKelBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKelBukuActionPerformed(evt);
            }
        });

        btKelKategori.setText("Kelola Kategori");
        btKelKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKelKategoriActionPerformed(evt);
            }
        });

        btKelTataLetak.setText("Kelola TataLetak");
        btKelTataLetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKelTataLetakActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(53, 197, 205));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Menu");

        btLogout.setText("Log Out");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLogout)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btInputPeminjaman.setText("Input Peminjaman");
        btInputPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputPeminjamanActionPerformed(evt);
            }
        });

        btInputPengembalian.setText("Input Pengembalian");
        btInputPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputPengembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btKelMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKelBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btKelTataLetak, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInputPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInputPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKelMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKelBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKelTataLetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btInputPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btInputPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btKelBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKelBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btKelBukuActionPerformed

    private void btKelMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKelMahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btKelMahasiswaActionPerformed

    private void btKelKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKelKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btKelKategoriActionPerformed

    private void btKelTataLetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKelTataLetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btKelTataLetakActionPerformed

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btInputPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInputPeminjamanActionPerformed

    private void btInputPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputPengembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInputPengembalianActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInputPeminjaman;
    private javax.swing.JButton btInputPengembalian;
    private javax.swing.JButton btKelBuku;
    private javax.swing.JButton btKelKategori;
    private javax.swing.JButton btKelMahasiswa;
    private javax.swing.JButton btKelTataLetak;
    private javax.swing.JButton btLogout;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btKelBuku.addActionListener(e);
        btKelKategori.addActionListener(e);
        btKelMahasiswa.addActionListener(e);
        btKelTataLetak.addActionListener(e);
        
    }

    @Override
    public void viewErrorMsg(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
    public Object getMahasiswa(){
        return btKelMahasiswa;
    }
    public Object getBuku(){
        return btKelBuku;
    }
    public Object getKategori(){
        return btKelKategori;
    }
    public Object getTataLetak(){
        return btKelTataLetak;
    }
    public Object getLogout(){
        return btLogout;
    }
    private int petu;
    @Override
    public void setPetu(int x){
        petu=x;
    }
    @Override
    public int getPetu(){
        return petu;
    }        
}
