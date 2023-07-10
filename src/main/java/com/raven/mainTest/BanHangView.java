package com.raven.mainTest;

import com.raven.domainModel.DotGiamGia;
import com.raven.domainModel.HoaDon;
import com.raven.domainModel.HoaDonChiTiet;
import com.raven.domainModel.KhachHang;
import com.raven.domainModel.SanPhamChiTiet;
import com.raven.repository.DotGiamGiaRepository;
import com.raven.repository.PhieuGiaoHangRepository;
import com.raven.repository.SanPhamChiTietRepository;

import com.raven.service.BanHangService;
import com.raven.service.DotGiamGiaService;
import com.raven.service.HoaDonChiTietService;
import com.raven.service.HoaDonService;
import com.raven.service.KhachHangService;
import com.raven.service.SanPhamChiTietService;
import com.raven.serviceImpl.BanHangServiceImpl;
import com.raven.serviceImpl.DotGiamGiaServiceImpl;
import com.raven.serviceImpl.HoaDonChiTietServiceImpl;
import com.raven.serviceImpl.HoaDonServiceImpl;
import com.raven.serviceImpl.KhachHangServiceImpl;
import com.raven.serviceImpl.SanPhamChiTietServiceImpl;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BanHangView extends javax.swing.JFrame {
    
    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultTableModel dtmHoaDon;
    
    private DefaultTableModel defaultTableModel;
    
    private SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietServiceImpl();
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    
    private BanHangService banHangService = new BanHangServiceImpl();
    
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    
    private DefaultComboBoxModel dcbm;
    private SanPhamChiTietRepository sanPhamChiTietRepository = new SanPhamChiTietRepository();
    private DotGiamGiaService dotGiamGiaService = new DotGiamGiaServiceImpl();
    
    private PhieuGiaoHangRepository phieuGiaoHangRepository = new PhieuGiaoHangRepository();
    private DotGiamGiaRepository dotGiamGiaRepository = new DotGiamGiaRepository();
    
    public BanHangView() {
        
        initComponents();
        
        loadTable(sanPhamChiTietService.getAll());
        loadTableHD(hoaDonService.getAll());
        loadDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());
        
    }
    
    private void loadDotGiamGia(List<DotGiamGia> listDotGiamGia) {
        dcbm = (DefaultComboBoxModel) cbx_DotGiamGia.getModel();
        for (DotGiamGia dotGiamGia : listDotGiamGia) {
            if (dotGiamGia.getTrangThai() == 1) {
                dcbm.addElement(dotGiamGia.getTenDotGiamGia());
            }
        }
        
    }
    
    private void loadTableHD(List<HoaDon> listHDChiTiet) {
        defaultTableModel = (DefaultTableModel) table_HoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : listHDChiTiet) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getId(),
                hoaDon.getMaHoaDon(),
                hoaDon.getNgayTao(),
                //                hoaDon.getNhanVien().getMaNhanVien(),
                //                hoaDon.getKhachHang().getMaKhachHang(),
                hoaDon.hthiTrangThai(),});
        }
    }
    
    private void loadTable(List<SanPhamChiTiet> listSPChiTiet) {
        defaultTableModel = (DefaultTableModel) table_SanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPhamChiTiet sanPhamChiTietResponse : listSPChiTiet) {
            defaultTableModel.addRow(new Object[]{
                sanPhamChiTietResponse.getMaSanPhamChiTiet(),
                sanPhamChiTietResponse.getSanPham().getTenSanPham(),
                sanPhamChiTietResponse.getGia(),
                sanPhamChiTietResponse.getMauSac().getTenMauSac(),
                sanPhamChiTietResponse.getKichThuoc().getTenKichThuoc(),
                sanPhamChiTietResponse.getChatLieu().getTenChatLieu(),
                sanPhamChiTietResponse.getLoaiSanPham().getTenLoaiSanPham(),
                sanPhamChiTietResponse.getSoLuongTon(),
                sanPhamChiTietResponse.getSoLuongTon() > 0 ? "Con Hang" : "Het Hang"
            });
        }
    }
    
    private void LoadTableHoaDonChiTiet(ArrayList<HoaDonChiTiet> listHD) {
        System.out.println("listHD" + listHD.toString());
        defaultTableModel = (DefaultTableModel) table_GioHang.getModel();
        
        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "MÃ HD", "MA SPCT", "TÊN SẢN PHẨM",
            "MÀU SẮC", "KÍCH THƯỚC", "SỐ LƯỢNG", "GIÁ", "TONG TIEN"});
        
        defaultTableModel.setRowCount(0);
        for (HoaDonChiTiet hoaDon : listHD) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getId(),
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_HoaDon = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_GioHang = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        button7 = new com.raven.button.Button();
        txtSearch = new com.raven.button.TextField();
        button12 = new com.raven.button.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        btn_TaoHoaDon = new com.raven.button.Button();
        txtMaHD = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        textField1 = new com.raven.button.TextField();
        txtTienKhachDua = new com.raven.button.TextField();
        button8 = new com.raven.button.Button();
        button9 = new com.raven.button.Button();
        jSeparator2 = new javax.swing.JSeparator();
        panelBorder2 = new com.raven.button.PanelBorder();
        txtID = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JLabel();
        txt_TenKH = new javax.swing.JLabel();
        lblCapBac = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_ChonKH = new com.raven.button.Button();
        jLabel30 = new javax.swing.JLabel();
        cbx_DotGiamGia = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtPhamTram = new javax.swing.JLabel();
        btnClose = new com.raven.button.Button();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        table_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma HD", "Ngay Tao", "Trang Thai"
            }
        ));
        table_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_HoaDon);

        table_GioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma SP", "Ngay Tao", "Don Gia", "So Luong"
            }
        ));
        jScrollPane5.setViewportView(table_GioHang);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setText("Danh Sách Sản Phẩm");

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setText("Hóa Đơn");

        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma SP", "Ten SP", "Don Gia", "Mau Sac", "Kich Thuoc", "Chat Lieu", "Loai SP", "So Luong Ton", "Trang Thai"
            }
        ));
        table_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_SanPham);

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setText("Giỏ Hàng");

        button7.setText("Tìm Kiếm");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button12.setText("Xóa Sản Phẩm");
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã Hóa Đơn");

        btn_TaoHoaDon.setText("Tạo Hóa Đơn");
        btn_TaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoHoaDonActionPerformed(evt);
            }
        });

        txtMaHD.setText("........");

        jLabel7.setText("Tiền Thừa");

        jLabel8.setText("Tổng Tiền");

        jLabel9.setText("Tiền Khách Đưa");

        jLabel10.setText("Ten DGG");

        jLabel11.setText("Thanh Toán");

        jLabel12.setText("Ghi Chú");

        jLabel13.setText("Hình Thức Thanh Toán");

        lblThanhTien.setText("........");

        txtThanhTien.setText("........");

        txtTienThua.setText("........");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt ", "Chuyển Khoản" }));

        textField1.setText("textField1");

        txtTienKhachDua.setText("......");
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        button8.setText("Thanh Toán");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setText("Hủy Hóa Đơn");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        txt_MaKH.setText("........");

        txt_TenKH.setText("........");

        lblCapBac.setText("........");

        jLabel4.setText("Loai Khach Hang");

        jLabel2.setText("Tên Khách Hàng");

        jLabel1.setText("Mã Khách Hàng");

        jLabel3.setText("ID");

        btn_ChonKH.setText("Chọn");
        btn_ChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btn_ChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCapBac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(96, 96, 96)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_MaKH))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_TenKH))
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCapBac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel30.setText("Đơn Hàng");

        cbx_DotGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_DotGiamGiaItemStateChanged(evt);
            }
        });
        cbx_DotGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_DotGiamGiaMouseClicked(evt);
            }
        });
        cbx_DotGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_DotGiamGiaActionPerformed(evt);
            }
        });

        jLabel14.setText("Phan Tram");

        txtPhamTram.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_TaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(52, 52, 52)
                                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtPhamTram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbx_DotGiamGia, 0, 122, Short.MAX_VALUE)))))
                                    .addComponent(jLabel30)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 30, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel30))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel19)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btn_TaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtMaHD))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblThanhTien))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbx_DotGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtPhamTram))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(101, Short.MAX_VALUE))))
        );

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Bán Hàng");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoHoaDonActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        System.out.println("id" + id);
        ChonKhachHang chonKhachHang = new ChonKhachHang();
        if (id == "") {
            JOptionPane.showMessageDialog(this, "Vui long chon khach hang!");
            return;
        }
        System.out.println("1111");
        createHoaDon();
    }//GEN-LAST:event_btn_TaoHoaDonActionPerformed
    
    private int getThanhTien() {
        int tien = 0;
        for (int i = 0; i < table_GioHang.getRowCount(); i++) {
            tien += Integer.parseInt(table_GioHang.getValueAt(i, 8).toString());
        }
        return tien;
    }

    private void table_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HoaDonMouseClicked
//        // TODO add your handling code here:

        int row = table_HoaDon.getSelectedRow();
        Integer id = Integer.parseInt(table_HoaDon.getValueAt(row, 0).toString());
        
          String maHoaDon = table_HoaDon.getValueAt(row, 1).toString();
        LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(id));
        
        KhachHang khachHang = phieuGiaoHangRepository.getKhachHangByHoaDon(maHoaDon);
        System.out.println("KhachHang" + khachHang) ;
        txtID.setText(Integer.toString(khachHang.getId()));
        txt_MaKH.setText(khachHang.getMaKhachHang());
        
        txt_TenKH.setText(khachHang.getHoTen());
        lblCapBac.setText(khachHang.getLoaiKhachHang().getTenLoaiKhachHang());
        
        txtMaHD.setText(table_HoaDon.getValueAt(row, 1).toString());
        lblThanhTien.setText(getThanhTien() + " đ");
        txtThanhTien.setText(getThanhTien() + " đ");
    }//GEN-LAST:event_table_HoaDonMouseClicked

    private void table_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamMouseClicked
        // TODO add your handling code here:
        String maCtsp = table_SanPham.getValueAt(table_SanPham.getSelectedRow(), 0).toString();
        txtSearch.setText(maCtsp);
        
        themVaoGioHangQR(maCtsp);
        lblThanhTien.setText(getThanhTien() + " đ");
        txtThanhTien.setText(getThanhTien() + " đ");
    }//GEN-LAST:event_table_SanPhamMouseClicked

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        // TODO add your handling code here:
        try {
            int xacNhan = JOptionPane.showConfirmDialog(this, "Xóa giỏ hàng?");
            if (xacNhan == JOptionPane.YES_OPTION) {
                for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietService.getHDCTByIdHD(getIdHd())) {
                    hoaDonChiTietService.delete(hoaDonChiTiet);
                }
                LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
            }
        } catch (Exception e) {
        }
        lblThanhTien.setText(getThanhTien() + " đ");
        txtThanhTien.setText(getThanhTien() + " đ");
    }//GEN-LAST:event_button12ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:

        if (txtMaHD.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được chọn!");
            return;
        }
        if (table_GioHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có gì trong giỏ hàng!");
            return;
        }
        thanhToan();
        clearForm();
        ChonKhachHang.setKhachHang(khachHangService.getOne(1));
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_button9ActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        
        txtTienThua.setText((Integer.parseInt(txtTienKhachDua.getText()) - Integer.parseInt(txtThanhTien.getText())) + "");

    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btn_ChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonKHActionPerformed
        // TODO add your handling code here:
        KhachHangTable khachHangTable = new KhachHangTable();
        khachHangTable.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_ChonKHActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        String searchValue = txtSearch.getText();
        loadTable(sanPhamChiTietRepository.findByName(searchValue));
    }//GEN-LAST:event_button7ActionPerformed

    private void cbx_DotGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_DotGiamGiaMouseClicked
        // TODO add your handling code here:
        String tenDotGiamGia = cbx_DotGiamGia.getSelectedItem().toString();
        
        DotGiamGia dotGiamGia = dotGiamGiaRepository.findByName(tenDotGiamGia);
        
//        if (getThanhTien() < dotGiamGia.getGiaTriNhoNhat() || getThanhTien() > dotGiamGia.getGiaTriLonNhat()) {
//            JOptionPane.showMessageDialog(this, "Ban ko du dieu kien app ma");
//            return;
//        } else {
            int total = getThanhTien() - (getThanhTien() * dotGiamGia.getPhanTramGiamGia()) / 100;
            System.out.println("getThanhTien" + getThanhTien());
            System.out.println(total);
            
            txtThanhTien.setText(Integer.toString(total));
//        }
        

    }//GEN-LAST:event_cbx_DotGiamGiaMouseClicked

    private void cbx_DotGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_DotGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_DotGiamGiaActionPerformed

    private void cbx_DotGiamGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_DotGiamGiaItemStateChanged
        // TODO add your handling code here:
        String ten = cbx_DotGiamGia.getSelectedItem().toString();
        DotGiamGia dotGiamGia = dotGiamGiaRepository.findByName(ten);
        txtPhamTram.setText(dotGiamGia.getPhanTramGiamGia() + "%");
    }//GEN-LAST:event_cbx_DotGiamGiaItemStateChanged
    
    private void thanhToan() {
        HoaDon hd = hoaDonService.getOneByMaHD(txtMaHD.getText());
        hd.setNgayTao(new Date());
        hd.setHinhThucThanhToan(cboHinhThucThanhToan.getSelectedItem().toString());
        hd.setTongTien(Integer.parseInt(txtThanhTien.getText()));
        hd.setTienKhachTra(Integer.parseInt(txtTienKhachDua.getText()));
        hd.setTienTraLai(Integer.parseInt(txtTienThua.getText()));
        DotGiamGia dotGiamGia = dotGiamGiaRepository.findByName(cbx_DotGiamGia.getSelectedItem().toString());
        hd.setDotGiamGia(dotGiamGia);
        int id = Integer.parseInt(txtID.getText());
        for (KhachHang khachHang : khachHangService.getAll()) {
            if (khachHang.getId() == id) {
                System.out.println("khhh" + khachHang);
                hd.setKhachHang(khachHang);
            }
        }
        hd.setTrangThai(2);
        if (hoaDonService.update(hd)) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            clearTable(table_GioHang);
            loadTableHD(hoaDonService.getAll());
        }
    }
    
    private void clearForm() {
        txtID.setText("");
        txtMaHD.setText("");
        txt_TenKH.setText("");
        txt_MaKH.setText("");
        txtThanhTien.setText("");
        txtTienKhachDua.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        lblCapBac.setText("");
        lblThanhTien.setText("");
        
    }
    
    private static void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    
    private void themVaoGioHangQR(String maCtsp) {
        System.out.println("maCtsp" + maCtsp);
        
        System.out.println(" hoaDonChiTietService.getHDCTByIdHD(getIdHd())" + hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
        boolean check = true;
        for (HoaDonChiTiet hdct : hoaDonChiTietService.getHDCTByIdHD(getIdHd())) {
            if (hdct.getChiTietSanPham().getMaSanPhamChiTiet().equals(maCtsp)) {
                check = false;
            }
        }
        if (check) {
            
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            SanPhamChiTiet ctsp = sanPhamChiTietService.getOneByMaCtsp(maCtsp);
            System.out.println("CTSP" + maCtsp);
            hdct.setMaHoaDonChiTiet(genMaHDCT().substring(0, 7));
            hdct.setChiTietSanPham(ctsp);
            HoaDon hoaDon = hoaDonService.getOne(getIdHd());
            System.out.println("hoaDOn" + hoaDon);
            hdct.setHoaDon(hoaDon);
            
            int sl = inputSoLuong();
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
                return;
            }
            hdct.setSoLuong(sl);
            hoaDonChiTietService.save(hdct);
            LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
        } else {
            SanPhamChiTiet ctsp = sanPhamChiTietService.getOneByMaCtsp(maCtsp);
            HoaDonChiTiet hdct = hoaDonChiTietService.getHdctByIdCtspAndIdHd(ctsp.getId(), getIdHd());
            int soL = inputSoLuong();
            if (soL < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
                return;
            }
            if (soL == 0) {
                hdct.setSoLuong(soL);
                hoaDonChiTietService.delete(hdct);
                LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
            } else {
                hdct.setSoLuong(hdct.getSoLuong() + soL);
                hoaDonChiTietService.update(hdct);
                LoadTableHoaDonChiTiet((ArrayList<HoaDonChiTiet>) hoaDonChiTietService.getHDCTByIdHD(getIdHd()));
                ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soL);
                sanPhamChiTietService.update(ctsp);
                loadTable(sanPhamChiTietService.getAll());
                
            }
            
        }
        
    }
    
    private int inputSoLuong() {
        try {
            int sl = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng"));
            return sl;
        } catch (Exception e) {
            
            return -1;
        }
        
    }
    
    private int getIdHd() {
        String maHD = txtMaHD.getText();
        int idHd = hoaDonService.getOneByMaHD(maHD).getId();
        return idHd;
    }
    
    public void createHoaDon() {
        System.out.println("user" + UserLogin.getNhanVien());
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(genMa().substring(0, 9));
        hd.setNgayTao(new Date());
        hd.setTongTien(0);
        hd.setTienKhachTra(0);
        hd.setTienTraLai(0);
        hd.setHinhThucThanhToan("Tiền Mặt");
        hd.setTrangThai(1);
        
        hd.setNhanVien(UserLogin.getNhanVien());
        System.out.println("3333333");
//        KhachHang khachHang = khachHangService.getOne(Integer.parseInt(txtID.getText()));

        int id = Integer.parseInt(txtID.getText());
        for (KhachHang khachHang : khachHangService.getAll()) {
            if (khachHang.getId() == id) {
                System.out.println("khhh" + khachHang);
                hd.setKhachHang(khachHang);
            }
        }
        
        hd.setDotGiamGia(null);
        if (hoaDonService.save(hd)) {
            loadTableHD(hoaDonService.getAll());
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại!");
        }
        
    }
    
    private String genMa() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "HD" + randomNumber;
        
    }
    
    private String genMaHDCT() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "HDCT" + randomNumber;
        
    }
    
    private String getMaHd() {
        int row = table_HoaDon.getSelectedRow();
        String maHD = table_HoaDon.getValueAt(row, 0).toString();
        return maHD;
    }
    
    public void setTextFieldValues(String id, String ma, String name, String loaiKh) {
        System.out.println("ma1111" + ma + name);
        txtID.setText(id);
        txt_MaKH.setText(ma);
        txt_TenKH.setText(name);
        lblCapBac.setText(loaiKh);
        
    }

//    public void setTextFieldValues1(String ten, String phanTram) {
//        
//        System.out.println("Ten" + ten + phanTram);
//        txt_TenDGG.setText(ten);
//        txt_PhanTram.setText(phanTram + "%");
//        
//        int phanTram1 = Integer.parseInt(phanTram);
//        int total = (getThanhTien() *phanTram1 ) /100;
//        txtThanhTien.setText(Integer.toString(total));
//
//    }
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
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private com.raven.button.Button btn_ChonKH;
    private com.raven.button.Button btn_TaoHoaDon;
    private com.raven.button.Button button12;
    private com.raven.button.Button button7;
    private com.raven.button.Button button8;
    private com.raven.button.Button button9;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbx_DotGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCapBac;
    private javax.swing.JLabel lblThanhTien;
    private com.raven.button.PanelBorder panelBorder1;
    private com.raven.button.PanelBorder panelBorder2;
    private javax.swing.JTable table_GioHang;
    private javax.swing.JTable table_HoaDon;
    private javax.swing.JTable table_SanPham;
    private com.raven.button.TextField textField1;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtMaHD;
    private javax.swing.JLabel txtPhamTram;
    private com.raven.button.TextField txtSearch;
    private javax.swing.JLabel txtThanhTien;
    private com.raven.button.TextField txtTienKhachDua;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txt_MaKH;
    private javax.swing.JLabel txt_TenKH;
    // End of variables declaration//GEN-END:variables
}
