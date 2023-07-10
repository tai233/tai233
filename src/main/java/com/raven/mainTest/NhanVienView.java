package com.raven.mainTest;

import com.raven.domainModel.*;

import com.raven.service.*;
import com.raven.serviceImpl.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienView extends javax.swing.JFrame {

    private DefaultComboBoxModel dcbm;

    private DefaultTableModel dtm;

    private NhanVienService taiKhoanService = new NhanVienServiceImpl();

    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private StringBuilder sb;

    public NhanVienView() {
        initComponents();
        rdoDangLam.setEnabled(false);
        rdoNghiLam.setEnabled(false);
        loadCbb(chucVuService.getAll());
        loadTableDangLam(taiKhoanService.getAllDangLam());
        loadTableNghiLam(taiKhoanService.getAllNghiLam());
    }

    private void loadCbb(List<ChucVu> listChucVu) {
        dcbm = (DefaultComboBoxModel) cbxVaiTro.getModel();
        for (ChucVu chucVuResponse : listChucVu) {
            dcbm.addElement(chucVuResponse.getTenChucVu());
        }

    }

    private void loadTableDangLam(List<NhanVien> listTaiKhoan) {
        dtm = (DefaultTableModel) table_NhanVienDangLam.getModel();
        dtm.setRowCount(0);
        for (NhanVien nhanVien : listTaiKhoan) {
            dtm.addRow(new Object[]{
                nhanVien.getId(), nhanVien.getMaNhanVien(), nhanVien.getHoTen(),
                nhanVien.getEmail(), nhanVien.getSdt(), nhanVien.getDiaChi(), nhanVien.getNgaySinh(),
                nhanVien.getGioiTinh() == 1 ? "Nam" : "Nu",
                nhanVien.getMatKhau(), nhanVien.hthiTrangThai(), nhanVien.getChucVu().getTenChucVu()
            });
        }
    }

    private void loadTableNghiLam(List<NhanVien> listTaiKhoan) {
        dtm = (DefaultTableModel) table_NhanVienNghiLam.getModel();
        dtm.setRowCount(0);
        for (NhanVien nhanVien : listTaiKhoan) {
            dtm.addRow(new Object[]{
                nhanVien.getId(), nhanVien.getMaNhanVien(), nhanVien.getHoTen(),
                nhanVien.getEmail(), nhanVien.getSdt(), nhanVien.getDiaChi(), nhanVien.getNgaySinh(),
                nhanVien.getGioiTinh() == 1 ? "Nam" : "Nu",
                nhanVien.getMatKhau(), nhanVien.hthiTrangThai(), nhanVien.getChucVu().getTenChucVu()
            });
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
        if (txtNgaySinh.getText().isEmpty()) {
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

        if (txtMatKhau.getText().isEmpty()) {
            sb.append("MatKhau không được để trống\n");
        }

        return sb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.raven.button.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new com.raven.button.TextField();
        jLabel9 = new javax.swing.JLabel();
        txtTen = new com.raven.button.TextField();
        jLabel11 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtMatKhau = new com.raven.button.TextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rdoDangLam = new javax.swing.JRadioButton();
        rdoNghiLam = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new com.raven.button.TextField();
        txtDiaChi = new com.raven.button.TextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSdt = new com.raven.button.TextField();
        btnXoa = new com.raven.button.Button();
        button7 = new com.raven.button.Button();
        btnSua = new com.raven.button.Button();
        btnThem = new com.raven.button.Button();
        cbxVaiTro = new com.raven.button.Combobox();
        txtID = new javax.swing.JLabel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_NhanVienDangLam = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_NhanVienNghiLam = new javax.swing.JTable();
        btnClose = new com.raven.button.Button();
        txtMa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhân Viên");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Mã NV");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Họ Tên");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setText("Email");

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel12.setText("Mật Khẩu");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setText("ID");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setText("Trạng Thái");

        buttonGroup2.add(rdoDangLam);
        rdoDangLam.setText("Đang Làm Việc");

        buttonGroup2.add(rdoNghiLam);
        rdoNghiLam.setText("Nghỉ Làm");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setText("Vai Trò");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Ngày Sinh");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Địa Chỉ ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("SDT");

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        button7.setText("ClearForm");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtID.setText("....................");

        materialTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                materialTabbed1StateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table_NhanVienDangLam.setModel(new javax.swing.table.DefaultTableModel(
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
        table_NhanVienDangLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_NhanVienDangLamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_NhanVienDangLam);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Đang Làm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        table_NhanVienNghiLam.setModel(new javax.swing.table.DefaultTableModel(
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
        table_NhanVienNghiLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_NhanVienNghiLamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_NhanVienNghiLam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Nghỉ Làm", jPanel2);

        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtMa.setText("....................");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14))
                                .addGap(92, 92, 92)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(94, 94, 94)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoNam)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(146, 146, 146)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGap(180, 180, 180)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(121, 121, 121)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(rdoDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(rdoNghiLam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(110, 110, 110)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel13))))
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtID))
                        .addGap(27, 27, 27)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMa))
                        .addGap(35, 35, 35)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(rdoDangLam)
                        .addComponent(rdoNghiLam)))
                .addGap(33, 33, 33)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn tài khoản để xóa");
        } else if (taiKhoanService.delete(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTableDangLam(taiKhoanService.getAllDangLam());
            loadTableNghiLam(taiKhoanService.getAllNghiLam());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_button7ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        Integer id = Integer.parseInt(txtID.getText());
        if (id == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhan vien để xóa");
            return;
        }

        NhanVien taiKhoan = new NhanVien();
        taiKhoan.setId(Integer.parseInt(txtID.getText()));
        taiKhoan.setMaNhanVien(txtMa.getText());
        taiKhoan.setHoTen(txtTen.getText());
        taiKhoan.setEmail(txtEmail.getText());

        String formatString = "yyyy-MM-dd";
        String ngaySinh = txtNgaySinh.getText();
        DateFormat dateFormat = new SimpleDateFormat(formatString);
        Date date;
        try {
            date = dateFormat.parse(ngaySinh);
            taiKhoan.setNgaySinh(date);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        taiKhoan.setSdt(txtSdt.getText());
        taiKhoan.setDiaChi(txtDiaChi.getText());
        taiKhoan.setMatKhau(txtMatKhau.getText());

        Integer gioiTinh = 0;
        if (rdoNam.isSelected()) {
            gioiTinh = 1;
        } else {
            gioiTinh = 0;

        }
        taiKhoan.setGioiTinh(gioiTinh);

        taiKhoan.setTrangThai(1);
        int tenChucVu = cbxVaiTro.getSelectedIndex();
        ChucVu chucVu = taiKhoanService.getChucVu().get(tenChucVu);
        System.out.println("Chuc Vu" + chucVu);
        taiKhoan.setChucVu(chucVu);

        if (taiKhoanService.add(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Update thành công");
            loadTableDangLam(taiKhoanService.getAllDangLam());
            loadTableNghiLam(taiKhoanService.getAllNghiLam());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Update thất bại");

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        if (validator().length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }

        NhanVien taiKhoan = new NhanVien();
        taiKhoan.setMaNhanVien(genMa());
        taiKhoan.setHoTen(txtTen.getText());
        taiKhoan.setEmail(txtEmail.getText());

        String formatString = "yyyy-MM-dd";
        String ngaySinh = txtNgaySinh.getText();
        DateFormat dateFormat = new SimpleDateFormat(formatString);
        Date date;
        try {
            date = dateFormat.parse(ngaySinh);
            taiKhoan.setNgaySinh(date);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        taiKhoan.setSdt(txtSdt.getText());
        taiKhoan.setDiaChi(txtDiaChi.getText());
        taiKhoan.setMatKhau(txtMatKhau.getText());

        Integer gioiTinh = 0;
        if (rdoNam.isSelected()) {
            gioiTinh = 1;
        } else {
            gioiTinh = 1;

        }
        taiKhoan.setGioiTinh(gioiTinh);

        taiKhoan.setTrangThai(1);
        int tenChucVu = cbxVaiTro.getSelectedIndex();
        ChucVu chucVu = taiKhoanService.getChucVu().get(tenChucVu);
        System.out.println("Chuc Vu" + chucVu);
        taiKhoan.setChucVu(chucVu);

        if (taiKhoanService.add(taiKhoan)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableDangLam(taiKhoanService.getAllDangLam());
            loadTableNghiLam(taiKhoanService.getAllNghiLam());
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
        return "NV" + randomNumber;

    }


    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void materialTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_materialTabbed1StateChanged
        // TODO add your handling code here:
        loadTableDangLam(taiKhoanService.getAllDangLam());
        loadTableNghiLam(taiKhoanService.getAllNghiLam());
    }//GEN-LAST:event_materialTabbed1StateChanged

    private void table_NhanVienNghiLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_NhanVienNghiLamMouseClicked
        // TODO add your handling code here:
        int row = table_NhanVienNghiLam.getSelectedRow();
        txtID.setText(table_NhanVienNghiLam.getValueAt(row, 0).toString());
        txtMa.setText(table_NhanVienNghiLam.getValueAt(row, 1).toString());
        txtTen.setText(table_NhanVienNghiLam.getValueAt(row, 2).toString());
        txtEmail.setText(table_NhanVienNghiLam.getValueAt(row, 3).toString());
        txtSdt.setText(table_NhanVienNghiLam.getValueAt(row, 4).toString());
        txtDiaChi.setText(table_NhanVienNghiLam.getValueAt(row, 5).toString());
        txtNgaySinh.setText(table_NhanVienNghiLam.getValueAt(row, 6).toString());
        if (table_NhanVienNghiLam.getValueAt(row, 7).toString().equals("Nam")) {
            rdoNam.setSelected(true);
            rdoNu.setSelected(false);
        } else {
            rdoNu.setSelected(true);
            rdoNam.setSelected(false);
        }

        txtMatKhau.setText(table_NhanVienNghiLam.getValueAt(row, 8).toString());
        if (table_NhanVienNghiLam.getValueAt(row, 9).toString().equals("Đang Làm Việc")) {
            rdoDangLam.setSelected(true);
            rdoNghiLam.setSelected(false);
        } else {
            rdoNghiLam.setSelected(true);
            rdoDangLam.setSelected(false);
        }
        cbxVaiTro.getModel().setSelectedItem(table_NhanVienNghiLam.getValueAt(row, 10));
    }//GEN-LAST:event_table_NhanVienNghiLamMouseClicked

    private void table_NhanVienDangLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_NhanVienDangLamMouseClicked
        // TODO add your handling code here:
        int row = table_NhanVienDangLam.getSelectedRow();
        txtID.setText(table_NhanVienDangLam.getValueAt(row, 0).toString());
        txtMa.setText(table_NhanVienDangLam.getValueAt(row, 1).toString());
        txtTen.setText(table_NhanVienDangLam.getValueAt(row, 2).toString());
        txtEmail.setText(table_NhanVienDangLam.getValueAt(row, 3).toString());
        txtSdt.setText(table_NhanVienDangLam.getValueAt(row, 4).toString());
        txtDiaChi.setText(table_NhanVienDangLam.getValueAt(row, 5).toString());
        txtNgaySinh.setText(table_NhanVienDangLam.getValueAt(row, 6).toString());
        if (table_NhanVienDangLam.getValueAt(row, 7).toString().equals("Nam")) {
            rdoNam.setSelected(true);
            rdoNu.setSelected(false);
        } else {
            rdoNu.setSelected(true);
            rdoNam.setSelected(false);
        }

        txtMatKhau.setText(table_NhanVienDangLam.getValueAt(row, 8).toString());
        if (table_NhanVienDangLam.getValueAt(row, 9).toString().equals("Đang Làm Việc")) {
            rdoDangLam.setSelected(true);
            rdoNghiLam.setSelected(false);
        } else {
            rdoNghiLam.setSelected(true);
            rdoDangLam.setSelected(false);
        }
        cbxVaiTro.getModel().setSelectedItem(table_NhanVienDangLam.getValueAt(row, 10));
    }//GEN-LAST:event_table_NhanVienDangLamMouseClicked

    private void clearForm() {
        txtMa.setText("");
        txtID.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtTen.setText("");
        txtMatKhau.setText("");
        txtNgaySinh.setText("");
        txtSdt.setText("");
        rdoDangLam.setSelected(true);
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
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.button.Button btnClose;
    private com.raven.button.Button btnSua;
    private com.raven.button.Button btnThem;
    private com.raven.button.Button btnXoa;
    private com.raven.button.Button button7;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.raven.button.Combobox cbxVaiTro;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private tabbed.MaterialTabbed materialTabbed1;
    private com.raven.button.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rdoDangLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghiLam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable table_NhanVienDangLam;
    private javax.swing.JTable table_NhanVienNghiLam;
    private com.raven.button.TextField txtDiaChi;
    private com.raven.button.TextField txtEmail;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtMa;
    private com.raven.button.TextField txtMatKhau;
    private com.raven.button.TextField txtNgaySinh;
    private com.raven.button.TextField txtSdt;
    private com.raven.button.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
