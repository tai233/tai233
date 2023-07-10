package com.raven.mainTest;

import com.raven.domainModel.DotGiamGia;
import com.raven.domainModel.HoaDonChiTiet;
import com.raven.repository.DotGiamGiaRepository;
import com.raven.service.DotGiamGiaService;
import com.raven.serviceImpl.DotGiamGiaServiceImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haiz2
 */
public class DotGiamGiaView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;

    private DotGiamGiaService dotGiamGiaService = new DotGiamGiaServiceImpl();
    private DotGiamGiaRepository dotGiamGiaRepository = new DotGiamGiaRepository();
    private StringBuilder sb;

    public DotGiamGiaView() {
        initComponents();
        LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
    }

    private void LoadTableDotGiamGia(ArrayList<DotGiamGia> listDotGiamGia) {
        defaultTableModel = (DefaultTableModel) tbDotGiamGia.getModel();

        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Mã GIAM GIÁ", "TÊN ĐỢT GIẢM GIÁ", "NGÀY BẮT ĐẦU",
            "NGÀY KẾT THÚC", "GIÁ MIN", "GIÁ MAX", "PHẦN TRĂM GIẢM GIÁ", "TRANG THÁI",});

        defaultTableModel.setRowCount(0);
        for (DotGiamGia dotGiamGia : listDotGiamGia) {
            defaultTableModel.addRow(new Object[]{
                dotGiamGia.getId(),
                dotGiamGia.getMaGiamGia(),
                dotGiamGia.getTenDotGiamGia(),
                dotGiamGia.getNgayBatDau(),
                dotGiamGia.getNgayKetThuc(),
                dotGiamGia.getGiaTriNhoNhat(),
                dotGiamGia.getGiaTriLonNhat(),
                dotGiamGia.getPhanTramGiamGia(),
                dotGiamGia.htTrangThai()

            });
        }
    }

    private StringBuilder validator() {
        sb = new StringBuilder();

        if (txtTenDotGiam.getText().isEmpty()) {
            sb.append("Tên không được để trống\n");
        }
        if (txtMax.getText().isEmpty()) {
            sb.append("Giá trị hóa đơn tối thiểu được áp dụng không được để trống\n");
        } else {
            try {
                int max = Integer.parseInt(txtMax.getText());
                int min = Integer.parseInt(txtMin.getText());
                if (min < 0) {
                    sb.append("Giá trị tối thiểu lớn hơn 0\n");
                } else if (min > max) {
                    sb.append("Giá trị tối thiểu phải nhỏ hơn giá trị tối đa\n");
                }
            } catch (Exception e) {
                sb.append("Giá trị tối thiểu phải là số\n");
            }
        }
        if (txtMin.getText().isEmpty()) {
            sb.append("Giá trị hóa đơn tối đa được áp dụng không được để trống\n");
        } else {
            try {
                int max = Integer.parseInt(txtMax.getText());
                int min = Integer.parseInt(txtMin.getText());
                if (max < min) {
                    sb.append("Giá trị tối đa phải lớn hơn giá trị tối thiểu\n");
                }
            } catch (Exception e) {
                sb.append("Giá trị áp dụng tối đa phải là số\n");
            }
        }
        if (txtGiaTriGiam.getText().isEmpty()) {
            sb.append("Mức giảm không được để trống\n");
        } else {
            try {
                int mucGiam = Integer.parseInt(txtGiaTriGiam.getText());
                if (mucGiam < 0) {
                    sb.append("Mức giảm lớn hơn 0\n");
                }
            } catch (Exception e) {
                sb.append("Mức giảm phải là số\n");
            }
        }
        if (!txtBatDau.getJCalendar().isEnabled()) {
            sb.append("Phải chọn ngày bắt đầu\n");
        }
        if (!txtKetThuc.getJCalendar().isEnabled()) {
            sb.append("Phải chọn ngày kết thúc\n");
        }
        return sb;
    }

    public void checkTrangThai() {
        Date date = new Date();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    dotGiamGiaRepository.auto1();
                    dotGiamGiaRepository.auto2();
                    dotGiamGiaRepository.auto3();
                    LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        };
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.raven.button.PanelBorder();
        panelBorder2 = new com.raven.button.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDotGiamGia = new javax.swing.JTable();
        btn_them = new com.raven.button.Button();
        txtGiaTriGiam = new com.raven.button.TextField();
        jLabel2 = new javax.swing.JLabel();
        btn_Xoa = new com.raven.button.Button();
        btn_Sua = new com.raven.button.Button();
        button4 = new com.raven.button.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTim = new com.raven.button.TextField();
        jLabel8 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        txtTenDotGiam = new com.raven.button.TextField();
        txtMax = new com.raven.button.TextField();
        txtMin = new com.raven.button.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        button6 = new com.raven.button.Button();
        button7 = new com.raven.button.Button();
        btnClose = new com.raven.button.Button();
        txtId = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đợt Giảm Giá");

        tbDotGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDotGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDotGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDotGiamGia);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("ID");

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        button4.setText("ClearForm");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Ngày Kết Thúc");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Ngày Bắt Đầu");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Mã Đợt GG");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Giá Trị Tối Đa");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Tên Đợt GG");

        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Phần Trăm (%)");

        txtTenDotGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDotGiamActionPerformed(evt);
            }
        });

        txtMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxActionPerformed(evt);
            }
        });

        txtMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setText("Giá Trị Tối Thiểu");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setText("TÌm Kiếm");

        button6.setText("Tìm Kiếm Theo Tên");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setText("Load");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtId.setText("...........");

        txtMaGiamGia.setText("...........");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(65, 65, 65)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(txtTenDotGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(264, 264, 264)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtId)))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 52, Short.MAX_VALUE)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(txtMaGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDotGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTenDotGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDotGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDotGiamActionPerformed

    private void txtMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxActionPerformed

    private void txtMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        ClearForm();
    }//GEN-LAST:event_button4ActionPerformed


    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:

        if (validator().length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        DotGiamGia dotGiamGia = new DotGiamGia();

        dotGiamGia.setMaGiamGia(genMa());
        dotGiamGia.setTenDotGiamGia(txtTenDotGiam.getText());
        int giaMin = Integer.parseInt(txtMin.getText());
        int giaMax = Integer.parseInt(txtMax.getText());
        dotGiamGia.setGiaTriLonNhat(giaMax);
        dotGiamGia.setGiaTriNhoNhat(giaMin);

        dotGiamGia.setNgayBatDau(txtBatDau.getDate());
        dotGiamGia.setNgayKetThuc(txtKetThuc.getDate());
        dotGiamGia.setPhanTramGiamGia(Integer.parseInt(txtGiaTriGiam.getText()));

        checkTrangThai();

        if (dotGiamGiaService.add(dotGiamGia)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
            ClearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private String genMa() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "DGG" + randomNumber;

    }


    private void tbDotGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDotGiamGiaMouseClicked
        // TODO add your handling code here:
        int row = tbDotGiamGia.getSelectedRow();
        txtId.setText(tbDotGiamGia.getValueAt(row, 0).toString());
        txtMaGiamGia.setText(tbDotGiamGia.getValueAt(row, 1).toString());
        txtTenDotGiam.setText(tbDotGiamGia.getValueAt(row, 2).toString());
        try {
            Date ngayS = new SimpleDateFormat("dd-MM-yyyy").parse(tbDotGiamGia.getValueAt(row, 3).toString());
            txtBatDau.setDate(ngayS);
        } catch (Exception e) {
        }
        try {
            Date ngayS = new SimpleDateFormat("dd-MM-yyyy").parse(tbDotGiamGia.getValueAt(row, 4).toString());
            txtKetThuc.setDate(ngayS);
        } catch (Exception e) {
        }
        txtMin.setText(tbDotGiamGia.getValueAt(row, 5).toString());
        txtMax.setText(tbDotGiamGia.getValueAt(row, 6).toString());
        txtGiaTriGiam.setText(tbDotGiamGia.getValueAt(row, 7).toString());

    }//GEN-LAST:event_tbDotGiamGiaMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtId.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn đợt giảm giá để xóa");
        } else if (dotGiamGiaService.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
            ClearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int index = tbDotGiamGia.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }
        DotGiamGia dotGiamGia = new DotGiamGia();
        dotGiamGia.setId(Integer.parseInt(txtId.getText()));
        dotGiamGia.setMaGiamGia(txtId.getText());
        dotGiamGia.setTenDotGiamGia(txtTenDotGiam.getText());
        dotGiamGia.setNgayBatDau(txtBatDau.getDate());
        dotGiamGia.setNgayKetThuc(txtKetThuc.getDate());
        dotGiamGia.setGiaTriNhoNhat(Integer.parseInt(txtMin.getText()));
        dotGiamGia.setGiaTriLonNhat(Integer.parseInt(txtMax.getText()));
        dotGiamGia.setPhanTramGiamGia(Integer.parseInt(txtGiaTriGiam.getText()));
        checkTrangThai();
        if (dotGiamGiaService.update(dotGiamGia)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
            ClearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        String ten = txtTim.getText();
        ArrayList<DotGiamGia> listTK = (ArrayList<DotGiamGia>) dotGiamGiaService.timTen(ten);
        LoadTableDotGiamGia(listTK);
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:  
        LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
    }//GEN-LAST:event_button7ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void ClearForm() {
        txtId.setText("");
        txtMaGiamGia.setText("");
        txtTenDotGiam.setText("");
        txtBatDau.setCalendar(null);
        txtKetThuc.setCalendar(null);
        txtMax.setText("");
        txtMin.setText("");
        txtGiaTriGiam.setText("");

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
            java.util.logging.Logger.getLogger(DotGiamGiaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DotGiamGiaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DotGiamGiaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DotGiamGiaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DotGiamGiaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private com.raven.button.Button btn_Sua;
    private com.raven.button.Button btn_Xoa;
    private com.raven.button.Button btn_them;
    private com.raven.button.Button button4;
    private com.raven.button.Button button6;
    private com.raven.button.Button button7;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.button.PanelBorder panelBorder1;
    private com.raven.button.PanelBorder panelBorder2;
    private javax.swing.JTable tbDotGiamGia;
    private com.toedter.calendar.JDateChooser txtBatDau;
    private com.raven.button.TextField txtGiaTriGiam;
    private javax.swing.JLabel txtId;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    private javax.swing.JLabel txtMaGiamGia;
    private com.raven.button.TextField txtMax;
    private com.raven.button.TextField txtMin;
    private com.raven.button.TextField txtTenDotGiam;
    private com.raven.button.TextField txtTim;
    // End of variables declaration//GEN-END:variables
}
