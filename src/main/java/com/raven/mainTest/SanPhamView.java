package com.raven.mainTest;

import com.raven.domainModel.*;
import com.raven.repository.SanPhamChiTietRepository;

import com.raven.service.*;
import com.raven.serviceImpl.SanPhamChiTietServiceImpl;
import com.raven.serviceImpl.SanPhamServiceImpl;
import com.raven.serviceImplement.*;
import com.raven.view.ChatLieuView;
import com.raven.view.KichThuocView;
import com.raven.view.LoaiSanPhamView;
import com.raven.view.MauSacView;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haiz2
 */
public class SanPhamView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultComboBoxModel defaultComboBoxModel1;
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietServiceImpl();

    private SanPhamChiTietRepository sanPhamChiTietRepository = new SanPhamChiTietRepository();

    private KichThuocService kichThuocService = new KichThuocServiceImpl();
    private MauSacService mauSacService = new MauSacServiceImpl();
    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();
    private LoaiSanPhamService loaiSpService = new LoaiSanPhamServiceImpl();

    public SanPhamView() {
        initComponents();
        rdo_DangKinhDoanh.setEnabled(false);
        rdo_NgungKinhDoanh.setEnabled(false);
        loadTableSanPham(sanPhamService.getAll());
        loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
        loadMauSac(mauSacService.getAll());
        loadKichThuoc(kichThuocService.getAll());
        loadChatLieu(chatLieuService.getAll());
        loadLoaiSanPham(loaiSpService.getAll());
        loadCBBSanPham(sanPhamService.getAll());

    }

    private void loadMauSac(List<MauSac> listMauSac) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_MauSac.getModel();
        defaultComboBoxModel1 = (DefaultComboBoxModel) cbx_MauSac1.getModel();
        for (MauSac mauSacResponse : listMauSac) {
            defaultComboBoxModel.addElement(mauSacResponse.getTenMauSac());
            defaultComboBoxModel1.addElement(mauSacResponse.getTenMauSac());
        }
    }

    private void loadKichThuoc(List<KichThuoc> listKichThuoc) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_KichThuoc.getModel();
        defaultComboBoxModel1 = (DefaultComboBoxModel) cbx_KichThuoc1.getModel();
        for (KichThuoc kichThuocResponse : listKichThuoc) {
            defaultComboBoxModel.addElement(kichThuocResponse.getTenKichThuoc());
            defaultComboBoxModel1.addElement(kichThuocResponse.getTenKichThuoc());
        }
    }

    private void loadChatLieu(List<ChatLieu> listChatLieu) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_ChatLieu.getModel();
        defaultComboBoxModel1 = (DefaultComboBoxModel) cbx_ChatLieu1.getModel();
        for (ChatLieu chatLieuResponse : listChatLieu) {
            defaultComboBoxModel.addElement(chatLieuResponse.getTenChatLieu());
            defaultComboBoxModel1.addElement(chatLieuResponse.getTenChatLieu());
        }
    }

    private void loadLoaiSanPham(List<LoaiSanPham> listLoaiSanPham) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_LoaiSP.getModel();
        defaultComboBoxModel1 = (DefaultComboBoxModel) cbx_LoaiSP1.getModel();
        for (LoaiSanPham loaiSanPhamResponse : listLoaiSanPham) {
            defaultComboBoxModel.addElement(loaiSanPhamResponse.getTenLoaiSanPham());
            defaultComboBoxModel1.addElement(loaiSanPhamResponse.getTenLoaiSanPham());
        }
    }

    private void loadCBBSanPham(List<SanPham> listSanPham) {
        defaultComboBoxModel = (DefaultComboBoxModel) cbx_TenSP.getModel();
        for (SanPham sanPhamResponse : sanPhamService.getAll()) {
            defaultComboBoxModel.addElement(sanPhamResponse.getTenSanPham());
        }
    }

    private void loadTableSanPhamChiTiet(List<SanPhamChiTiet> listSPChiTiet) {
        defaultTableModel = (DefaultTableModel) table_SanPhamChiTiet.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamChiTiet sanPhamChiTietResponse : listSPChiTiet) {
            defaultTableModel.addRow(new Object[]{
                sanPhamChiTietResponse.getId(),
                sanPhamChiTietResponse.getMaSanPhamChiTiet(),
                sanPhamChiTietResponse.getSanPham().getTenSanPham(),
                sanPhamChiTietResponse.getGia(),
                sanPhamChiTietResponse.getMauSac().getTenMauSac(),
                sanPhamChiTietResponse.getKichThuoc().getTenKichThuoc(), sanPhamChiTietResponse.getChatLieu().getTenChatLieu(),
                sanPhamChiTietResponse.getLoaiSanPham().getTenLoaiSanPham(),
                sanPhamChiTietResponse.getSoLuongTon(),
                sanPhamChiTietResponse.getSoLuongTon() > 0 ? "Còn Hàng" : "Hết Hàng",
                sanPhamChiTietResponse.getNgayNhap()
            });
        }
    }

    public void loadTableSanPham(List<SanPham> sanPhamResponses) {
        defaultTableModel = (DefaultTableModel) table_SanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPham sanPhamResponse : sanPhamResponses) {
            defaultTableModel.addRow(new Object[]{
                sanPhamResponse.getId(), sanPhamResponse.getMaSanPham(),
                sanPhamResponse.getTenSanPham(), sanPhamResponse.getMoTa(), sanPhamResponse.getThuongHieu(),
                sanPhamResponse.getXuatXu(), sanPhamResponse.getTrangThai() == 1 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.raven.button.PanelBorder();
        materialTabbed1 = new tabbed.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Sua = new com.raven.button.Button();
        jLabel4 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Ten = new com.raven.button.TextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ThuongHieu = new com.raven.button.TextField();
        btn_Them = new com.raven.button.Button();
        btn_Xoa = new com.raven.button.Button();
        btn_Clear = new com.raven.button.Button();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_MoTa = new com.raven.button.TextField();
        cbx_XuatXu = new com.raven.button.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        rdo_DangKinhDoanh = new javax.swing.JRadioButton();
        rdo_NgungKinhDoanh = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new com.raven.button.TextField();
        txt_Ma = new javax.swing.JLabel();
        cbx_XuatXu1 = new com.raven.button.Combobox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_SoLuong = new com.raven.button.TextField();
        txt_Gia = new com.raven.button.TextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_ThemSPCT = new com.raven.button.Button();
        btn_SuaSPCT = new com.raven.button.Button();
        btn_XoaSPCT = new com.raven.button.Button();
        btn_Clear1 = new com.raven.button.Button();
        button6 = new com.raven.button.Button();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_SanPhamChiTiet = new javax.swing.JTable();
        cbx_TenSP = new com.raven.button.Combobox();
        cbx_KichThuoc = new com.raven.button.Combobox();
        cbx_ChatLieu = new com.raven.button.Combobox();
        cbx_MauSac = new com.raven.button.Combobox();
        cbx_LoaiSP = new com.raven.button.Combobox();
        jLabel21 = new javax.swing.JLabel();
        txt_ID1 = new javax.swing.JLabel();
        txt_MaSPCT = new javax.swing.JLabel();
        cbx_KichThuoc1 = new com.raven.button.Combobox();
        cbx_ChatLieu1 = new com.raven.button.Combobox();
        cbx_MauSac1 = new com.raven.button.Combobox();
        cbx_LoaiSP1 = new com.raven.button.Combobox();
        btn_Clear2 = new com.raven.button.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_ChatLieu = new com.raven.button.Button();
        btn_KichThuoc = new com.raven.button.Button();
        btn_LoaiSanPham = new com.raven.button.Button();
        btn_MauSac = new com.raven.button.Button();
        btnClose1 = new com.raven.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialTabbed1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Tìm Kiếm Sản Phẩm");

        btn_Sua.setBackground(new java.awt.Color(0, 102, 255));
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        txt_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ID.setText("................");

        jLabel6.setText("Xuất Xứ");

        jLabel7.setText("Tên SP");

        jLabel8.setText("Thuơng Hiệu");

        btn_Them.setBackground(new java.awt.Color(0, 102, 255));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 0, 51));
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Clear.setBackground(new java.awt.Color(255, 0, 51));
        btn_Clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_Clear.setText("Clear");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã SP");

        jLabel10.setText("Mô Tả");

        jLabel11.setText("Trạng Thái");

        cbx_XuatXu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Croatia", "Canada", "Sweden", "United Kingdom", "Wales" }));

        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma SP", "Ten SP", "Mô Tả", "Thương Hiệu", "Xuất Xứ", "Trang Thái"
            }
        ));
        table_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_SanPham);

        buttonGroup1.add(rdo_DangKinhDoanh);
        rdo_DangKinhDoanh.setText("Đang kinh doanh");

        buttonGroup1.add(rdo_NgungKinhDoanh);
        rdo_NgungKinhDoanh.setText("Ngừng kinh doanh");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Thông Tin Sản Phẩm");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        txt_Ma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Ma.setText("................");

        cbx_XuatXu1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Croatia", "Canada", "Sweden", "United Kingdom", "Wales" }));
        cbx_XuatXu1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_XuatXu1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(182, 182, 182)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_MoTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbx_XuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdo_DangKinhDoanh)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdo_NgungKinhDoanh))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_XuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(77, 77, 77)
                                                .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(203, 203, 203))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ID)
                    .addComponent(jLabel6)
                    .addComponent(cbx_XuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txt_MoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ma))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rdo_DangKinhDoanh)
                    .addComponent(rdo_NgungKinhDoanh))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_XuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        materialTabbed1.addTab("Sản Phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Thông Tin Chi Tiết Sản Phẩm");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setText("Tên SP");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("Mã SPCT");

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setText("Giá");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setText("Số Lượng");

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel17.setText("Kích Thước");

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setText("Chất Liệu");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setText("Màu Sắc");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setText("Loại Sản Phẩm");

        btn_ThemSPCT.setBackground(new java.awt.Color(0, 102, 255));
        btn_ThemSPCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemSPCT.setText("Thêm");
        btn_ThemSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSPCTActionPerformed(evt);
            }
        });

        btn_SuaSPCT.setBackground(new java.awt.Color(0, 102, 255));
        btn_SuaSPCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_SuaSPCT.setText("Sửa");
        btn_SuaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSPCTActionPerformed(evt);
            }
        });

        btn_XoaSPCT.setBackground(new java.awt.Color(255, 0, 51));
        btn_XoaSPCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaSPCT.setText("Xóa");
        btn_XoaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaSPCTActionPerformed(evt);
            }
        });

        btn_Clear1.setBackground(new java.awt.Color(255, 0, 51));
        btn_Clear1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Clear1.setText("Clear");
        btn_Clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Clear1ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(0, 102, 255));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("Tìm Kiếm");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setText("Tìm Kiếm Sản Phẩm");

        table_SanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma SPCT", "Ten SP", "Gia", "Màu Sắc", "Kích Thước", "Chất Liệu", "Loại Sản Phẩm", "Số Lượng Tồn", "Trạng Thái", "NgayNhap"
            }
        ));
        table_SanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_SanPhamChiTiet);

        jLabel21.setText("ID");

        txt_ID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ID1.setText("................");

        txt_MaSPCT.setText(".................");

        btn_Clear2.setBackground(new java.awt.Color(255, 0, 51));
        btn_Clear2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Clear2.setText("Load");
        btn_Clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Clear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(64, 64, 64)
                                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(64, 64, 64))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(80, 80, 80)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_MaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel17)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel18)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel20)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbx_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbx_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(txt_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btn_ThemSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(btn_SuaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(btn_XoaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(btn_Clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_Clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbx_KichThuoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cbx_ChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbx_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbx_LoaiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_TenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel17)
                        .addComponent(cbx_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txt_ID1)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(cbx_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_MaSPCT))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cbx_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbx_LoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_SuaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThemSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_KichThuoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_ChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_LoaiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        materialTabbed1.addTab("Sản Phẩm Chi Tiết", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Thuộc Tính Sản Phẩm");

        btn_ChatLieu.setText("Chất Liệu");
        btn_ChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChatLieuActionPerformed(evt);
            }
        });

        btn_KichThuoc.setText("Kích Thước");
        btn_KichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KichThuocActionPerformed(evt);
            }
        });

        btn_LoaiSanPham.setText("Loại Sản Phẩm");
        btn_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoaiSanPhamActionPerformed(evt);
            }
        });

        btn_MauSac.setText("Màu Sắc");
        btn_MauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(642, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(465, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Thuộc Tính Sản Phẩm", jPanel3);

        btnClose1.setText("X");
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamMouseClicked
        // TODO add your handling code here:
        int row = table_SanPham.getSelectedRow();
        txt_ID.setText(table_SanPham.getValueAt(row, 0).toString());
        txt_Ma.setText(table_SanPham.getValueAt(row, 1).toString());
        txt_Ten.setText(table_SanPham.getValueAt(row, 2).toString());
        txt_ThuongHieu.setText(table_SanPham.getValueAt(row, 4).toString());
        cbx_XuatXu.getModel().setSelectedItem(table_SanPham.getValueAt(row, 5));
        txt_MoTa.setText(table_SanPham.getValueAt(row, 3).toString());
        if (table_SanPham.getValueAt(row, 6).equals("Đang kinh doanh")) {
            rdo_DangKinhDoanh.setSelected(true);
            rdo_NgungKinhDoanh.setSelected(false);
        } else {
            rdo_DangKinhDoanh.setSelected(false);
            rdo_NgungKinhDoanh.setSelected(true);
        }
    }//GEN-LAST:event_table_SanPhamMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();
        sanPham.setMaSanPham(genMa());
        sanPham.setTenSanPham(txt_Ten.getText());
        sanPham.setMoTa(txt_MoTa.getText());
        sanPham.setThuongHieu(txt_ThuongHieu.getText());
        sanPham.setXuatXu(cbx_XuatXu.getSelectedItem().toString());

       
        sanPham.setTrangThai(1);

        if (sanPhamService.save(sanPham)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableSanPham(sanPhamService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }

    }//GEN-LAST:event_btn_ThemActionPerformed

    private String genMa() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "SP" + randomNumber;

    }

    private String genMaCT() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "SPCT" + randomNumber;

    }


    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:

        Integer id = Integer.parseInt(txt_ID.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn san pham để xóa");
            return;
        }

        SanPham sanPham = new SanPham();
        sanPham.setId(Integer.parseInt(txt_ID.getText()));
        sanPham.setMaSanPham(txt_Ma.getText());
        sanPham.setTenSanPham(txt_Ten.getText());
        sanPham.setMoTa(txt_MoTa.getText());
        sanPham.setThuongHieu(txt_ThuongHieu.getText());
        sanPham.setXuatXu(cbx_XuatXu.getSelectedItem().toString());

        int trangThai = 0;
        if (rdo_DangKinhDoanh.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        sanPham.setTrangThai(trangThai);

        if (sanPhamService.save(sanPham)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadTableSanPham(sanPhamService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }

    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txt_ID.getText());

        if (sanPhamService.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTableSanPham(sanPhamService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_ChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChatLieuActionPerformed
        // TODO add your handlinuView g code here:

        ChatLieuView chatLieuView = new ChatLieuView();
        chatLieuView.setVisible(true);

    }//GEN-LAST:event_btn_ChatLieuActionPerformed

    private void btn_KichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KichThuocActionPerformed
        // TODO add your handling code here:
        KichThuocView chatLieuView = new KichThuocView();
        chatLieuView.setVisible(true);
    }//GEN-LAST:event_btn_KichThuocActionPerformed

    private void btn_MauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MauSacActionPerformed
        // TODO add your handling code here:
        MauSacView chatLieuView = new MauSacView();
        chatLieuView.setVisible(true);
    }//GEN-LAST:event_btn_MauSacActionPerformed

    private void btn_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoaiSanPhamActionPerformed
        // TODO add your handling code here:
        LoaiSanPhamView chatLieuView = new LoaiSanPhamView();
        chatLieuView.setVisible(true);
    }//GEN-LAST:event_btn_LoaiSanPhamActionPerformed

    private void btn_ThemSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSPCTActionPerformed
        // TODO add your handling code here:
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        int tenSP = cbx_TenSP.getSelectedIndex();
        SanPham sanPham = sanPhamChiTietService.getSP().get(tenSP);
        sanPhamChiTiet.setSanPham(sanPham);

        int mauSacIndex = cbx_MauSac.getSelectedIndex();
        MauSac mauSac = sanPhamChiTietService.getMauSac().get(mauSacIndex);
        sanPhamChiTiet.setMauSac(mauSac);

        int chatLieuIndex = cbx_ChatLieu.getSelectedIndex();
        ChatLieu chatLieu = sanPhamChiTietService.getChatLieu().get(chatLieuIndex);
        sanPhamChiTiet.setChatLieu(chatLieu);

        int kichThuocIndex = cbx_KichThuoc.getSelectedIndex();
        KichThuoc kichThuoc = sanPhamChiTietService.getKichThuoc().get(kichThuocIndex);
        sanPhamChiTiet.setKichThuoc(kichThuoc);

        int loaiSPIndex = cbx_LoaiSP.getSelectedIndex();
        LoaiSanPham loaiSanPham = sanPhamChiTietService.getLoaiSanPham().get(loaiSPIndex);
        sanPhamChiTiet.setLoaiSanPham(loaiSanPham);

        sanPhamChiTiet.setMaSanPhamChiTiet(genMaCT());
        sanPhamChiTiet.setNgayNhap(new Date());

        sanPhamChiTiet.setNgayNhap(new Date());
        sanPhamChiTiet.setSoLuongTon(Integer.parseInt(txt_SoLuong.getText()));
        sanPhamChiTiet.setGia(Integer.parseInt(txt_Gia.getText()));

        if (sanPhamChiTietService.create(sanPhamChiTiet)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
            clearFormSPCT();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_ThemSPCTActionPerformed

    private void btn_SuaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSPCTActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txt_ID1.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn đợt giảm giá để xóa");
            return;
        }

        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setId(Integer.parseInt(txt_ID1.getText()));
        int tenSP = cbx_TenSP.getSelectedIndex();
        SanPham sanPham = sanPhamChiTietService.getSP().get(tenSP);
        sanPhamChiTiet.setSanPham(sanPham);

        int mauSacIndex = cbx_MauSac.getSelectedIndex();
        MauSac mauSac = sanPhamChiTietService.getMauSac().get(mauSacIndex);
        sanPhamChiTiet.setMauSac(mauSac);

        int chatLieuIndex = cbx_ChatLieu.getSelectedIndex();
        ChatLieu chatLieu = sanPhamChiTietService.getChatLieu().get(chatLieuIndex);
        sanPhamChiTiet.setChatLieu(chatLieu);

        int kichThuocIndex = cbx_KichThuoc.getSelectedIndex();
        KichThuoc kichThuoc = sanPhamChiTietService.getKichThuoc().get(kichThuocIndex);
        sanPhamChiTiet.setKichThuoc(kichThuoc);

        int loaiSPIndex = cbx_LoaiSP.getSelectedIndex();
        LoaiSanPham loaiSanPham = sanPhamChiTietService.getLoaiSanPham().get(loaiSPIndex);
        sanPhamChiTiet.setLoaiSanPham(loaiSanPham);

        sanPhamChiTiet.setMaSanPhamChiTiet(txt_MaSPCT.getText());
        sanPhamChiTiet.setNgayNhap(new Date());

        sanPhamChiTiet.setNgayNhap(new Date());
        sanPhamChiTiet.setSoLuongTon(Integer.parseInt(txt_SoLuong.getText()));
        sanPhamChiTiet.setGia(Integer.parseInt(txt_Gia.getText()));

        if (sanPhamChiTietService.create(sanPhamChiTiet)) {
            JOptionPane.showMessageDialog(this, "Cập Nhật thành công");
            loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
            clearFormSPCT();
        } else {
            JOptionPane.showMessageDialog(this, "Cập Nhật thất bại");
        }
    }//GEN-LAST:event_btn_SuaSPCTActionPerformed


    private void btn_XoaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaSPCTActionPerformed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txt_ID1.getText());

        if (sanPhamChiTietService.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
            clearFormSPCT();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_XoaSPCTActionPerformed

    private void btn_Clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Clear1ActionPerformed
        // TODO add your handling code here:
        clearFormSPCT();
    }//GEN-LAST:event_btn_Clear1ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        String mauSac = cbx_MauSac1.getSelectedItem().toString();
        String chatLieu = cbx_ChatLieu1.getSelectedItem().toString();
        String kichThuoc = cbx_KichThuoc1.getSelectedItem().toString();
        String loaiSanPham = cbx_LoaiSP1.getSelectedItem().toString();
        loadTableSanPhamChiTiet(sanPhamChiTietRepository.filterProducts(mauSac, chatLieu, kichThuoc, loaiSanPham));
        System.out.println("aaasajdh" + sanPhamChiTietRepository.filterProducts(mauSac, chatLieu, kichThuoc, loaiSanPham));

    }//GEN-LAST:event_button6ActionPerformed

    private void table_SanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamChiTietMouseClicked
        // TODO add your handling code here:
        int row = table_SanPhamChiTiet.getSelectedRow();
        txt_ID1.setText(table_SanPhamChiTiet.getValueAt(row, 0).toString());
        txt_MaSPCT.setText(table_SanPhamChiTiet.getValueAt(row, 1).toString());
        cbx_TenSP.getModel().setSelectedItem(table_SanPhamChiTiet.getValueAt(row, 2));
        txt_Gia.setText(table_SanPhamChiTiet.getValueAt(row, 3).toString());
        cbx_MauSac.getModel().setSelectedItem(table_SanPhamChiTiet.getValueAt(row, 4));
        cbx_KichThuoc.getModel().setSelectedItem(table_SanPhamChiTiet.getValueAt(row, 5));
        cbx_ChatLieu.getModel().setSelectedItem(table_SanPhamChiTiet.getValueAt(row, 6));
        cbx_LoaiSP.getModel().setSelectedItem(table_SanPhamChiTiet.getValueAt(row, 7));
        txt_SoLuong.setText(table_SanPhamChiTiet.getValueAt(row, 8).toString());
    }//GEN-LAST:event_table_SanPhamChiTietMouseClicked

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btnClose1ActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        String searchValues = txtSearch.getText();
        loadTableSanPham(sanPhamService.findByName(searchValues));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void cbx_XuatXu1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_XuatXu1ItemStateChanged
        // TODO add your handling code here:
        String xuatXu = cbx_XuatXu1.getSelectedItem().toString();
        loadTableSanPham(sanPhamService.findByXuatXu(xuatXu));
    }//GEN-LAST:event_cbx_XuatXu1ItemStateChanged

    private void materialTabbed1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialTabbed1MouseClicked
        // TODO add your handling code here:
        System.out.println("11111");
//          loadTableSanPham(sanPhamService.getAll());
//        loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
//        loadMauSac(mauSacService.getAll());
//        loadKichThuoc(kichThuocService.getAll());
//        loadChatLieu(chatLieuService.getAll());
//        loadLoaiSanPham(loaiSpService.getAll());
//        loadCBBSanPham(sanPhamService.getAll());
    }//GEN-LAST:event_materialTabbed1MouseClicked

    private void btn_Clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Clear2ActionPerformed
        // TODO add your handling code here:
          loadTableSanPham(sanPhamService.getAll());
        loadTableSanPhamChiTiet(sanPhamChiTietService.getAll());
    }//GEN-LAST:event_btn_Clear2ActionPerformed

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private void clearFormSPCT() {
        txt_MaSPCT.setText("");
        cbx_TenSP.setSelectedIndex(0);
        txt_Gia.setText("");
        txt_SoLuong.setText("");
        cbx_ChatLieu.setSelectedIndex(0);
        cbx_KichThuoc.setSelectedIndex(0);
        cbx_MauSac.setSelectedIndex(0);
        cbx_LoaiSP.setSelectedIndex(0);
    }

    private void clearForm() {
        txt_Ma.setText("");
        txt_Ten.setText("");
        txt_MoTa.setText("");
        txt_ID.setText("");
        cbx_XuatXu.setSelectedIndex(1);
        rdo_DangKinhDoanh.setSelected(true);
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
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose1;
    private com.raven.button.Button btn_ChatLieu;
    private com.raven.button.Button btn_Clear;
    private com.raven.button.Button btn_Clear1;
    private com.raven.button.Button btn_Clear2;
    private com.raven.button.Button btn_KichThuoc;
    private com.raven.button.Button btn_LoaiSanPham;
    private com.raven.button.Button btn_MauSac;
    private com.raven.button.Button btn_Sua;
    private com.raven.button.Button btn_SuaSPCT;
    private com.raven.button.Button btn_Them;
    private com.raven.button.Button btn_ThemSPCT;
    private com.raven.button.Button btn_Xoa;
    private com.raven.button.Button btn_XoaSPCT;
    private com.raven.button.Button button6;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.button.Combobox cbx_ChatLieu;
    private com.raven.button.Combobox cbx_ChatLieu1;
    private com.raven.button.Combobox cbx_KichThuoc;
    private com.raven.button.Combobox cbx_KichThuoc1;
    private com.raven.button.Combobox cbx_LoaiSP;
    private com.raven.button.Combobox cbx_LoaiSP1;
    private com.raven.button.Combobox cbx_MauSac;
    private com.raven.button.Combobox cbx_MauSac1;
    private com.raven.button.Combobox cbx_TenSP;
    private com.raven.button.Combobox cbx_XuatXu;
    private com.raven.button.Combobox cbx_XuatXu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private tabbed.MaterialTabbed materialTabbed1;
    private com.raven.button.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rdo_DangKinhDoanh;
    private javax.swing.JRadioButton rdo_NgungKinhDoanh;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JTable table_SanPhamChiTiet;
    private com.raven.button.TextField txtSearch;
    private com.raven.button.TextField txt_Gia;
    private javax.swing.JLabel txt_ID;
    private javax.swing.JLabel txt_ID1;
    private javax.swing.JLabel txt_Ma;
    private javax.swing.JLabel txt_MaSPCT;
    private com.raven.button.TextField txt_MoTa;
    private com.raven.button.TextField txt_SoLuong;
    private com.raven.button.TextField txt_Ten;
    private com.raven.button.TextField txt_ThuongHieu;
    // End of variables declaration//GEN-END:variables
}
