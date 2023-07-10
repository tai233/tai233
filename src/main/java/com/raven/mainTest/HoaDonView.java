package com.raven.mainTest;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.HoaDonChiTiet;
import com.raven.service.*;
import com.raven.serviceImpl.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class HoaDonView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();

    public HoaDonView() {
        initComponents();
        LoadTableHoaDon((ArrayList<HoaDon>) hoaDonService.getAll());
    }

    private void LoadTableHoaDon(ArrayList<HoaDon> listHD) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel = (DefaultTableModel) table_HoaDon.getModel();
        defaultTableModel.setColumnIdentifiers(new String[]{
            "ID", "Mã HD", "NGÀY TẠO", "HÌNH THỨC THANH TOÁN", "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "MÃ NHÂN VIÊN",
            "TỔNG TIỀN", "TRANG THÁI"});
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : listHD) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getId(),
                hoaDon.getMaHoaDon(),
                hoaDon.getNgayTao(),
                hoaDon.getHinhThucThanhToan(),
                hoaDon.getKhachHang().getMaKhachHang(),
                hoaDon.getKhachHang().getHoTen(),
                hoaDon.getNhanVien().getHoTen(),
                hoaDon.getTongTien(), hoaDon.getTrangThai() == 2 ? "Đã Thanh Toán" : "Chưa Thanh Toán",});
        }
    }

    private void LoadTableHoaDonChiTiet(ArrayList<HoaDonChiTiet> listHD) {
        System.out.println("listHD" + listHD.toString());
        defaultTableModel = (DefaultTableModel) table_HoaDonChiTiet.getModel();

        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Mã HDCT", "MÃ HD", "MÃ SẢN PHẨM CT",
            "TÊN SẢN PHẨM", "MÀU SẮC", "KÍCH THƯỚC", "SỐ LƯỢNG", "GIÁ",
            "THÀNH TIỀN"});

        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet hoaDon : listHD) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getId(),
                hoaDon.getMaHoaDonChiTiet(),
                hoaDon.getHoaDon().getMaHoaDon(),
                hoaDon.getChiTietSanPham().getMaSanPhamChiTiet(),
                hoaDon.getChiTietSanPham().getSanPham().getTenSanPham(),
                hoaDon.getChiTietSanPham().getMauSac().getTenMauSac(),
                hoaDon.getChiTietSanPham().getKichThuoc().getTenKichThuoc(),
                hoaDon.getSoLuong(), hoaDon.getChiTietSanPham().getGia(),
                hoaDon.getSoLuong() * hoaDon.getChiTietSanPham().getGia()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.button.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HoaDonChiTiet = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_HoaDon = new javax.swing.JTable();
        btnClose = new com.raven.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hóa Đơn");

        table_HoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_HoaDonChiTiet);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Hóa Đơn Chi Tiết");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Hóa Đơn");

        table_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        table_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_HoaDon);

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HoaDonMouseClicked
        // TODO add your handling code here:

        int row = table_HoaDon.getSelectedRow();
        Integer id = Integer.parseInt(table_HoaDon.getValueAt(row, 0).toString());
        LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(id));


    }//GEN-LAST:event_table_HoaDonMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.raven.button.PanelBorder panelBorder1;
    private javax.swing.JTable table_HoaDon;
    private javax.swing.JTable table_HoaDonChiTiet;
    // End of variables declaration//GEN-END:variables
}
