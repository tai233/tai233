package com.raven.mainTest;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.KhachHang;
import com.raven.domainModel.PhieuGiaoHang;
import com.raven.repository.PhieuGiaoHangRepository;
import com.raven.service.HoaDonService;
import com.raven.service.PhieuGiaoHangService;
import com.raven.serviceImpl.HoaDonServiceImpl;
import com.raven.serviceImpl.PhieuGiaoHangServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PhieuGiaoHangView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private PhieuGiaoHangService phieuGiaoHangService = new PhieuGiaoHangServiceImpl();
    private PhieuGiaoHangRepository phieuGiaoHangRepository = new PhieuGiaoHangRepository();

    public PhieuGiaoHangView() {
        initComponents();
        loadHoaDon(hoaDonService.getAll());
        LoadTablePhieuGiaoHang((ArrayList<PhieuGiaoHang>) phieuGiaoHangService.getAll());

    }

    private void loadHoaDon(List<HoaDon> listHoaDon) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_HoaDon.getModel();
        for (HoaDon hoaDon : listHoaDon) {
            defaultComboBoxModel.addElement(hoaDon.getMaHoaDon());
        }
    }

    private void LoadTablePhieuGiaoHang(ArrayList<PhieuGiaoHang> listPhieuGiaoHang) {
        defaultTableModel = (DefaultTableModel) table_PhieuGiaoHang.getModel();

        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Mã PHIÉU GIAO HÀNG", "TÊN NGƯỜI GIAO HÀNG", "ĐỊA CHỈ",
            "GHI CHÚ", "SDT", "NGÀY XUẤT HÀNG", "NGÀY GIAO HÀNG", "PHƯƠNG THỨC GIAO HÀNG", "TRẠNG THÁI", "MÃ HÓA ĐƠN"});
        System.out.println("22222");
        defaultTableModel.setRowCount(0);
        for (PhieuGiaoHang phieuGiaoHang : listPhieuGiaoHang) {
            defaultTableModel.addRow(new Object[]{
                phieuGiaoHang.getId(),
                phieuGiaoHang.getMaPhieuGiaoHang(),
                phieuGiaoHang.getTenNguoiGiaoHang(),
                phieuGiaoHang.getDiaChi(),
                phieuGiaoHang.getGhiChu(),
                phieuGiaoHang.getSoDienThoaiNguoiNhan(),
                phieuGiaoHang.getNgayXuatHang(),
                phieuGiaoHang.getNgayGiaoHang(),
                phieuGiaoHang.getPhuongThucGiaoHang(),
                phieuGiaoHang.htTrangThai(),
                phieuGiaoHang.getHoaDon().getMaHoaDon(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.button.PanelBorder();
        jLabel18 = new javax.swing.JLabel();
        cbx_HoaDon = new com.raven.button.Combobox();
        jLabel19 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTen = new com.raven.button.TextField();
        jLabel22 = new javax.swing.JLabel();
        txtDiaCHi = new com.raven.button.TextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtGhiChu = new com.raven.button.TextField();
        cbxPhuongThuc = new com.raven.button.Combobox();
        txtSDT = new com.raven.button.TextField();
        btn_TaoPhieui2 = new com.raven.button.Button();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_PhieuGiaoHang = new javax.swing.JTable();
        btn_DaLayHang2 = new com.raven.button.Button();
        btn_DangGiao2 = new com.raven.button.Button();
        btn_DaGiao2 = new com.raven.button.Button();
        btnClose = new com.raven.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setText("Hóa Đơn");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setText("ID");

        txtID.setText("...............");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setText("Mã Phiếu Giao Hàng");

        txtMa.setText("...............");

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setText("Tên Giao Hàng");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setText("Địa Chỉ");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setText("SDT");

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setText("Phương Thức Giao Hàng");

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setText("Ghi Chú");

        cbxPhuongThuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Express", "Standard" }));
        cbxPhuongThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPhuongThuccbxPhuongThucActionPerformed(evt);
            }
        });

        btn_TaoPhieui2.setText("Tạo Phiếu Giao Hàng");
        btn_TaoPhieui2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoPhieui2btn_TaoPhieuiActionPerformed(evt);
            }
        });

        table_PhieuGiaoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table_PhieuGiaoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_PhieuGiaoHangtable_PhieuGiaoHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_PhieuGiaoHang);

        btn_DaLayHang2.setText("Đã Lấy Hàng");
        btn_DaLayHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DaLayHang2btn_DaLayHangActionPerformed(evt);
            }
        });

        btn_DangGiao2.setText("Dang Giao Hang");
        btn_DangGiao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangGiao2btn_DangGiaoActionPerformed(evt);
            }
        });

        btn_DaGiao2.setText("Đã Giao Hang");
        btn_DaGiao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DaGiao2btn_DaGiaoActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(0, 1062, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(188, 188, 188)))
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addGap(100, 100, 100)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(btn_TaoPhieui2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_DaLayHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(163, 163, 163)
                                        .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(157, 157, 157)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbx_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(256, 256, 256)
                                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbxPhuongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))))
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel24)))
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(btn_DangGiao2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)
                                    .addComponent(btn_DaGiao2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(77, 77, 77)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 706, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(cbx_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(txtID))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMa)
                                        .addComponent(jLabel20))
                                    .addGap(14, 14, 14))
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(cbxPhuongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel25)))
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel21))
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22))))))
                    .addGap(18, 18, 18)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_TaoPhieui2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addComponent(btn_DaLayHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_DaGiao2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                            .addComponent(btn_DangGiao2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPhuongThuccbxPhuongThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPhuongThuccbxPhuongThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPhuongThuccbxPhuongThucActionPerformed

    private void btn_TaoPhieui2btn_TaoPhieuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoPhieui2btn_TaoPhieuiActionPerformed
        // TODO add your handling code here:

        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setMaPhieuGiaoHang(genMa());
        phieuGiaoHang.setTenNguoiGiaoHang(txtTen.getText());
        int maHD = cbx_HoaDon.getSelectedIndex();
        HoaDon hoaDon = phieuGiaoHangService.getHoaDon().get(maHD);
        phieuGiaoHang.setHoaDon(hoaDon);

        phieuGiaoHang.setDiaChi(txtDiaCHi.getText());

        String ghiChu = txtGhiChu.getText();

        if (ghiChu.isEmpty()) {
            phieuGiaoHang.setGhiChu("Khong Co");
        } else {
            phieuGiaoHang.setGhiChu(ghiChu);
        }

        phieuGiaoHang.setSoDienThoaiNguoiNhan(txtSDT.getText());
        phieuGiaoHang.setNgayXuatHang(null);
        phieuGiaoHang.setNgayGiaoHang(null);
        phieuGiaoHang.setTrangThai(0);

        phieuGiaoHang.setPhuongThucGiaoHang(cbxPhuongThuc.getSelectedItem().toString());

        KhachHang khachHang = phieuGiaoHangRepository.getKhachHangByHoaDonId(hoaDon.getKhachHang().getId());
        System.out.println("KhachHang" + khachHang);

        phieuGiaoHang.setKhachHang(khachHang);
        phieuGiaoHang.setNhanVien(UserLogin.getNhanVien());

        if (phieuGiaoHangService.save(phieuGiaoHang)) {
            JOptionPane.showMessageDialog(this, "Tao phieu thành công");
            LoadTablePhieuGiaoHang((ArrayList<PhieuGiaoHang>) phieuGiaoHangService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_TaoPhieui2btn_TaoPhieuiActionPerformed

    private void table_PhieuGiaoHangtable_PhieuGiaoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_PhieuGiaoHangtable_PhieuGiaoHangMouseClicked
        // TODO add your handling code here:
        int row = table_PhieuGiaoHang.getSelectedRow();
        txtID.setText(table_PhieuGiaoHang.getValueAt(row, 0).toString());
        txtMa.setText(table_PhieuGiaoHang.getValueAt(row, 1).toString());
        txtTen.setText(table_PhieuGiaoHang.getValueAt(row, 2).toString());
        txtDiaCHi.setText(table_PhieuGiaoHang.getValueAt(row, 3).toString());
        txtGhiChu.setText(table_PhieuGiaoHang.getValueAt(row, 4).toString());
        txtSDT.setText(table_PhieuGiaoHang.getValueAt(row, 5).toString());
        cbxPhuongThuc.getModel().setSelectedItem(table_PhieuGiaoHang.getValueAt(row, 8));
        cbx_HoaDon.getModel().setSelectedItem(table_PhieuGiaoHang.getValueAt(row, 10));
    }//GEN-LAST:event_table_PhieuGiaoHangtable_PhieuGiaoHangMouseClicked

    private void btn_DaLayHang2btn_DaLayHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DaLayHang2btn_DaLayHangActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtID.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn pieu giao hang");
            return;
        }

        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setId(id);
        phieuGiaoHang.setMaPhieuGiaoHang(genMa());
        phieuGiaoHang.setTenNguoiGiaoHang(txtTen.getText());
        int tenHoaDon = cbx_HoaDon.getSelectedIndex();
        HoaDon hoaDon = phieuGiaoHangService.getHoaDon().get(tenHoaDon);
        phieuGiaoHang.setHoaDon(hoaDon);

        phieuGiaoHang.setDiaChi(txtDiaCHi.getText());

        String ghiChu = txtGhiChu.getText();

        if (ghiChu.isEmpty()) {
            phieuGiaoHang.setGhiChu("Khong Co");
        } else {
            phieuGiaoHang.setGhiChu(ghiChu);
        }

        phieuGiaoHang.setSoDienThoaiNguoiNhan(txtSDT.getText());
        phieuGiaoHang.setNgayXuatHang(new Date());
        phieuGiaoHang.setNgayGiaoHang(null);
        phieuGiaoHang.setTrangThai(1);
        phieuGiaoHang.setPhuongThucGiaoHang(cbxPhuongThuc.getSelectedItem().toString());

        KhachHang khachHang = phieuGiaoHangRepository.getKhachHangByHoaDonId(hoaDon.getKhachHang().getId());
        System.out.println("KhachHang" + khachHang);

        phieuGiaoHang.setKhachHang(khachHang);
        phieuGiaoHang.setNhanVien(UserLogin.getNhanVien());

        if (phieuGiaoHangService.save(phieuGiaoHang)) {
            JOptionPane.showMessageDialog(this, "Lay Hang thành công");
            LoadTablePhieuGiaoHang((ArrayList<PhieuGiaoHang>) phieuGiaoHangService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_DaLayHang2btn_DaLayHangActionPerformed

    private void btn_DangGiao2btn_DangGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangGiao2btn_DangGiaoActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtID.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn pieu giao hang");
            return;
        }

        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();

        phieuGiaoHang.setId(id);
        phieuGiaoHang.setMaPhieuGiaoHang(genMa());
        phieuGiaoHang.setTenNguoiGiaoHang(txtTen.getText());
        int tenHoaDon = cbx_HoaDon.getSelectedIndex();

        HoaDon hoaDon = phieuGiaoHangService.getHoaDon().get(tenHoaDon);
        phieuGiaoHang.setHoaDon(hoaDon);

        phieuGiaoHang.setDiaChi(txtDiaCHi.getText());

        String ghiChu = txtGhiChu.getText();

        if (ghiChu.isEmpty()) {
            phieuGiaoHang.setGhiChu("Khong Co");
        } else {
            phieuGiaoHang.setGhiChu(ghiChu);
        }

        phieuGiaoHang.setSoDienThoaiNguoiNhan(txtSDT.getText());
        phieuGiaoHang.setNgayXuatHang(new Date());
        phieuGiaoHang.setNgayGiaoHang(null);
        phieuGiaoHang.setTrangThai(2);
        phieuGiaoHang.setPhuongThucGiaoHang(cbxPhuongThuc.getSelectedItem().toString());
        KhachHang khachHang = phieuGiaoHangRepository.getKhachHangByHoaDonId(hoaDon.getKhachHang().getId());
        System.out.println("KhachHang" + khachHang);

        phieuGiaoHang.setKhachHang(khachHang);
        phieuGiaoHang.setNhanVien(UserLogin.getNhanVien());

        if (phieuGiaoHangService.save(phieuGiaoHang)) {
            JOptionPane.showMessageDialog(this, "Lay Hang thành công");
            LoadTablePhieuGiaoHang((ArrayList<PhieuGiaoHang>) phieuGiaoHangService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_DangGiao2btn_DangGiaoActionPerformed

    private void btn_DaGiao2btn_DaGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DaGiao2btn_DaGiaoActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtID.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn pieu giao hang");
            return;
        }

        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setId(id);
        phieuGiaoHang.setMaPhieuGiaoHang(genMa());
        phieuGiaoHang.setTenNguoiGiaoHang(txtTen.getText());
        int tenHoaDon = cbx_HoaDon.getSelectedIndex();
        HoaDon hoaDon = phieuGiaoHangService.getHoaDon().get(tenHoaDon);
        phieuGiaoHang.setHoaDon(hoaDon);

        phieuGiaoHang.setDiaChi(txtDiaCHi.getText());

        String ghiChu = txtGhiChu.getText();

        if (ghiChu.isEmpty()) {
            phieuGiaoHang.setGhiChu("Khong Co");
        } else {
            phieuGiaoHang.setGhiChu(ghiChu);
        }

        phieuGiaoHang.setSoDienThoaiNguoiNhan(txtSDT.getText());
        phieuGiaoHang.setNgayXuatHang(new Date());
        phieuGiaoHang.setNgayGiaoHang(new Date());
        phieuGiaoHang.setTrangThai(3);
        phieuGiaoHang.setPhuongThucGiaoHang(cbxPhuongThuc.getSelectedItem().toString());
        KhachHang khachHang = phieuGiaoHangRepository.getKhachHangByHoaDonId(hoaDon.getKhachHang().getId());
        System.out.println("KhachHang" + khachHang);

        phieuGiaoHang.setKhachHang(khachHang);
        phieuGiaoHang.setNhanVien(UserLogin.getNhanVien());

        if (phieuGiaoHangService.save(phieuGiaoHang)) {
            JOptionPane.showMessageDialog(this, "Lay Hang thành công");
            LoadTablePhieuGiaoHang((ArrayList<PhieuGiaoHang>) phieuGiaoHangService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_DaGiao2btn_DaGiaoActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private String genMa() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "PGH" + randomNumber;

    }

    private void clearForm() {
        txtMa.setText("");
        txtDiaCHi.setText("");
        txtGhiChu.setText("");
        txtSDT.setText("");
        txtTen.setText("");
        cbxPhuongThuc.setSelectedIndex(0);
    }

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
            java.util.logging.Logger.getLogger(PhieuGiaoHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuGiaoHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuGiaoHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private com.raven.button.Button btn_DaGiao2;
    private com.raven.button.Button btn_DaLayHang2;
    private com.raven.button.Button btn_DangGiao2;
    private com.raven.button.Button btn_TaoPhieui2;
    private com.raven.button.Combobox cbxPhuongThuc;
    private com.raven.button.Combobox cbx_HoaDon;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane5;
    private com.raven.button.PanelBorder panelBorder1;
    private javax.swing.JTable table_PhieuGiaoHang;
    private com.raven.button.TextField txtDiaCHi;
    private com.raven.button.TextField txtGhiChu;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtMa;
    private com.raven.button.TextField txtSDT;
    private com.raven.button.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
