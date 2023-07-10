package com.raven.mainTest;

import com.raven.domainModel.*;
import com.raven.service.*;
import com.raven.serviceImpl.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class KhachHangView extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private LoaiKhachHangService loaiKhachHangService = new LoaiKhachHangServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private StringBuilder sb;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public KhachHangView() {
        initComponents();
        rdoConHD.setEnabled(false);
        rdoNgungHD.setEnabled(false);
        loadCbo(loaiKhachHangService.getAll());
        LoadTable((ArrayList<KhachHang>) khachHangService.getAll());
        LoadTableHoaDon((ArrayList<HoaDon>) hoaDonService.getAll());
    }

    private String doiNgay(Date d) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        String ngaySinh = format.format(d);
        return ngaySinh;
    }

    private void loadCbo(List<LoaiKhachHang> all) {
        DefaultComboBoxModel defaultComboBoxModel;
        defaultComboBoxModel = (DefaultComboBoxModel) cbxLoaiKH.getModel();
        defaultComboBoxModel.removeAllElements();
        for (LoaiKhachHang loaiKhachHang : loaiKhachHangService.getAll()) {
            defaultComboBoxModel.addElement(loaiKhachHang.getTenLoaiKhachHang());
        }
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

    private void LoadTableHoaDon(ArrayList<HoaDon> listHD) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel = (DefaultTableModel) table_LichSu.getModel();
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

    private boolean isValidPhoneNumber(String phone) {
        // Phone number pattern: 10 digits, optionally starting with a "+" sign
        String phonePattern = "^\\+?\\d{10}$";
        return Pattern.matches(phonePattern, phone);
    }

    private boolean isValidEmail(String email) {
        // Email pattern using a simple regex
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailPattern, email);
    }

    private StringBuilder validator() {
        sb = new StringBuilder();
        if (txtTen.getText().isEmpty()) {
            sb.append("Ten không được để trống\n");
        }

        if (txtSdt.getText().isEmpty()) {
            sb.append("SDT không được để trống\n");
        } else {
            String sdt = txtSdt.getText();
            if (!isValidPhoneNumber(sdt)) {
                sb.append("SDT không dung dinh dang\n");
            }

        }
        if (!txtNgaySinh.getJCalendar().isEnabled()) {
            sb.append("Phải chọn ngày sinh \n");
        }

        if (txtEmail.getText().isEmpty()) {
            sb.append("Email không được để trống\n");

        } else {
            String email = txtEmail.getText();
            if (!isValidEmail(email)) {
                sb.append("Email không dung dinh dang\n");
            }

        }

        if (txtDiaChi.getText().isEmpty()) {
            sb.append("DiaChi không được để trống\n");
        }

        return sb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.raven.button.PanelBorder();
        txtDiaChi = new com.raven.button.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdoConHD = new javax.swing.JRadioButton();
        rdoNgungHD = new javax.swing.JRadioButton();
        btnThem = new com.raven.button.Button();
        btnSua = new com.raven.button.Button();
        btnClear = new com.raven.button.Button();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        txtTen = new com.raven.button.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new com.raven.button.TextField();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new com.raven.button.TextField();
        jLabel9 = new javax.swing.JLabel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_KhachHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_LichSu = new javax.swing.JTable();
        cbxLoaiKH = new com.raven.button.Combobox();
        btnXoa = new com.raven.button.Button();
        jLabel13 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JLabel();
        btnClose = new com.raven.button.Button();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new com.raven.button.TextField();
        btn_Search = new com.raven.button.Button();
        txt_Ma = new javax.swing.JLabel();
        btnClear1 = new com.raven.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setText("Trạng Thái");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách Hàng");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setText("Loại Khách Hàng");

        buttonGroup2.add(rdoConHD);
        rdoConHD.setText("Còn Hoạt Động");

        buttonGroup2.add(rdoNgungHD);
        rdoNgungHD.setText("Ngừng Hoạt Động");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setText("Làm Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setText("Ngày Sinh");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("ID");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Họ Tên");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("SDT");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Địa Chỉ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        table_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_KhachHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Danh Sách", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        table_LichSu.setModel(new javax.swing.table.DefaultTableModel(
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
        table_LichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_LichSuMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_LichSu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Lịch Sử Giao Dịch", jPanel2);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setText("Mã KH");

        txt_ID.setText("............................");

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setText("Tìm Kiếm");

        btn_Search.setText("Tìm Kiếm");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        txt_Ma.setText("............................");

        btnClear1.setText("Load");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(384, 384, 384)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(32, 32, 32)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoConHD)
                                .addGap(28, 28, 28)
                                .addComponent(rdoNgungHD))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(34, 34, 34)
                                .addComponent(cbxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(22, 22, 22)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel6))
                                    .addGap(42, 42, 42)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(rdoNam)
                                            .addGap(49, 49, 49)
                                            .addComponent(rdoNu)))))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(40, 40, 40)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ID))
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdoConHD)
                            .addComponent(rdoNgungHD))
                        .addGap(14, 14, 14)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_Ma))
                        .addGap(10, 10, 10)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(14, 14, 14)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
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
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        int index = table_KhachHang.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }

        KhachHang taiKhoan = new KhachHang();
        taiKhoan.setId(Integer.parseInt(txt_ID.getText()));
        taiKhoan.setMaKhachHang(txt_Ma.getText());
        taiKhoan.setHoTen(txtTen.getText());
        taiKhoan.setEmail(txtEmail.getText());

        taiKhoan.setNgaySinh(txtNgaySinh.getDate());

        taiKhoan.setSdt(txtSdt.getText());
        taiKhoan.setDiaChi(txtDiaChi.getText());

        Integer gioiTinh = 0;
        if (rdoNam.isSelected()) {
            gioiTinh = 1;
        } else {
            gioiTinh = 0;

        }
        taiKhoan.setGioiTinh(gioiTinh);

        taiKhoan.setTrangThai(1);
        int tenChucVu = cbxLoaiKH.getSelectedIndex();
        LoaiKhachHang loaiKhachHang = khachHangService.getLoaiKhachHang().get(tenChucVu);
        taiKhoan.setLoaiKhachHang(loaiKhachHang);

        if (khachHangService.sua(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Update thành công");
            LoadTable((ArrayList<KhachHang>) khachHangService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Update thất bại");

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void table_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KhachHangMouseClicked
        // TODO add your handling code here:
        int row = table_KhachHang.getSelectedRow();
        txt_ID.setText(table_KhachHang.getValueAt(row, 0).toString());
        txt_Ma.setText(table_KhachHang.getValueAt(row, 1).toString());
        txtTen.setText(table_KhachHang.getValueAt(row, 2).toString());
        txtDiaChi.setText(table_KhachHang.getValueAt(row, 3).toString());
        txtSdt.setText(table_KhachHang.getValueAt(row, 4).toString());
        if (table_KhachHang.getValueAt(row, 5).toString().equals("Nam")) {
            rdoNam.setSelected(true);
            rdoNu.setSelected(false);
        } else {
            rdoNu.setSelected(true);
            rdoNam.setSelected(false);
        }
        txtEmail.setText(table_KhachHang.getValueAt(row, 6).toString());

//        txtNgaySinh.setDateFormatString(table_KhachHang.getValueAt(row, 7).toString());
        try {
            Date ngayS = new SimpleDateFormat("dd-MM-yyyy").parse(table_KhachHang.getValueAt(row, 7).toString());
            txtNgaySinh.setDate(ngayS);
        } catch (Exception e) {
        }

        if (table_KhachHang.getValueAt(row, 8).toString().equals("Còn hoạt động")) {
            rdoConHD.setSelected(true);
            rdoNgungHD.setSelected(false);
        } else {
            rdoConHD.setSelected(false);
            rdoNgungHD.setSelected(true);
        }
        cbxLoaiKH.getModel().setSelectedItem(table_KhachHang.getValueAt(row, 9));
    }//GEN-LAST:event_table_KhachHangMouseClicked

    private void table_LichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_LichSuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_LichSuMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String id = txt_ID.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn tài khoản để xóa");
        } else if (khachHangService.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            LoadTable((ArrayList<KhachHang>) khachHangService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        if (validator().length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }

        KhachHang taiKhoan = new KhachHang();
        taiKhoan.setMaKhachHang(genMa());
        taiKhoan.setHoTen(txtTen.getText());
        taiKhoan.setEmail(txtEmail.getText());

        taiKhoan.setNgaySinh(txtNgaySinh.getDate());

        taiKhoan.setSdt(txtSdt.getText());
        taiKhoan.setDiaChi(txtDiaChi.getText());

        Integer gioiTinh = 0;
        if (rdoNam.isSelected()) {
            gioiTinh = 1;
        } else {
            gioiTinh = 1;

        }
        taiKhoan.setGioiTinh(gioiTinh);

        taiKhoan.setTrangThai(1);
        int tenChucVu = cbxLoaiKH.getSelectedIndex();
        LoaiKhachHang loaiKhachHang = khachHangService.getLoaiKhachHang().get(tenChucVu);
        taiKhoan.setLoaiKhachHang(loaiKhachHang);

        if (khachHangService.them(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            LoadTable((ArrayList<KhachHang>) khachHangService.getAll());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private String genMa() {
        Random random = new Random();
        int max = 100000000;
        int min = 1;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return "KH" + randomNumber;

    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        String searchValues = txtSearch.getText();
          LoadTable((ArrayList<KhachHang>) khachHangService.tim(searchValues));
        
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
          LoadTable((ArrayList<KhachHang>) khachHangService.getAll());
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void clearForm() {
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtTen.setText("");
        txt_ID.setText("");
        txt_Ma.setText("");
        txtSdt.setText("");
        txtNgaySinh.setCalendar(null);
        rdoNam.setSelected(true);
        rdoConHD.setSelected(true);
        cbxLoaiKH.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClear;
    private com.raven.button.Button btnClear1;
    private com.raven.button.Button btnClose;
    private com.raven.button.Button btnSua;
    private com.raven.button.Button btnThem;
    private com.raven.button.Button btnXoa;
    private com.raven.button.Button btn_Search;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.raven.button.Combobox cbxLoaiKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private tabbed.MaterialTabbed materialTabbed1;
    private com.raven.button.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rdoConHD;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNgungHD;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable table_KhachHang;
    private javax.swing.JTable table_LichSu;
    private com.raven.button.TextField txtDiaChi;
    private com.raven.button.TextField txtEmail;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private com.raven.button.TextField txtSdt;
    private com.raven.button.TextField txtSearch;
    private com.raven.button.TextField txtTen;
    private javax.swing.JLabel txt_ID;
    private javax.swing.JLabel txt_Ma;
    // End of variables declaration//GEN-END:variables
}
