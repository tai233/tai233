
package com.raven.mainTest;

import com.raven.domainModel.KhachHang;
import com.raven.repository.KhachHangRepository;
import com.raven.service.KhachHangService;
import com.raven.service.LoaiKhachHangService;
import com.raven.serviceImpl.KhachHangServiceImpl;
import com.raven.serviceImpl.LoaiKhachHangServiceImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haiz2
 */
public class KhachHangTable extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private LoaiKhachHangService loaiKhachHangService = new LoaiKhachHangServiceImpl();
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    private StringBuilder sb;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public KhachHangTable() {
        initComponents();
        LoadTable((ArrayList<KhachHang>) khachHangRepository.getAllConHoatDong());
    }

    private String doiNgay(Date d) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        String ngaySinh = format.format(d);
        return ngaySinh;
    }

    private void LoadTable(ArrayList<KhachHang> listkHangs) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel = (DefaultTableModel) table_KhachHang.getModel();
        defaultTableModel.setColumnIdentifiers(new String[]{
            "ID", "Mã KH", "TÊN KHÁCH HÀNG", "ĐỊA CHỈ", "SDT", "GiỚI TÍNH", "EMAIL",
            "NGÀY SINH", "Trang Thai", "LOẠI KH"});
        defaultTableModel.setRowCount(0);
        for (KhachHang khachHang : listkHangs) {
            defaultTableModel.addRow(new Object[]{
                khachHang.getId(),
                khachHang.getMaKhachHang(),
                khachHang.getHoTen(),
                khachHang.getDiaChi(),
                khachHang.getSdt(),
                khachHang.getGioiTinh() == 1 ? "Nam" : "Nữ",
                khachHang.getEmail(),
                doiNgay(khachHang.getNgaySinh()),
                khachHang.getTrangThai() == 1 ? "Còn hoạt động" : "Ngừng hoạt động",
                khachHang.getLoaiKhachHang().getTenLoaiKhachHang()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        table_KhachHang = new javax.swing.JTable();
        btnClose = new com.raven.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        table_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma", "Ho Ten", "Email", "Sdt", "Dia Chi", "Ngay Sinh", "Gioi Tinh", "Mật Khẩu", "Trạng Thái", "Vai Tro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_KhachHang.setOpaque(false);
        table_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_KhachHang);

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KhachHangMouseClicked
        // TODO add your handling code here:
        int row = table_KhachHang.getSelectedRow();

        String id = table_KhachHang.getValueAt(row, 0).toString();
        String ma = table_KhachHang.getValueAt(row, 1).toString();
        String ten = table_KhachHang.getValueAt(row, 2).toString();
         String loaiKH = table_KhachHang.getValueAt(row, 9).toString();
        BanHangView frame1 = new BanHangView();
        frame1.setTextFieldValues(id, ma, ten , loaiKH);
        frame1.setVisible(true);
        dispose();

    }//GEN-LAST:event_table_KhachHangMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHangTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable table_KhachHang;
    // End of variables declaration//GEN-END:variables
}
