  CREATE DATABASE DB_Sale_App
GO

USE DB_Sale_App
GO 

CREATE TABLE [NhanVien] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaNhanVien] nvarchar(255) UNIQUE,
  [HoTen] nvarchar(255),
  [Email] nvarchar(255),
  [SDT] nvarchar(255),
  [DiaChi] nvarchar(255),
  [NgaySinh] date,
  [GioiTinh] int,
  [MatKhau] nvarchar(255),
  [TrangThai]  int,
  [ChucVuId] int
)
GO

CREATE TABLE [ChucVu] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaChucVu] nvarchar(255) UNIQUE,
  [TenChucVu] nvarchar(255)
)
GO

CREATE TABLE [KhachHang] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaKhachHang] nvarchar(255) UNIQUE,
  [HoTen] nvarchar(255),
  [DiaChi] nvarchar(255),
  [SDT] nvarchar(255),
  [GioiTinh] int,
  [Email] nvarchar(255),
  [NgaySinh] date,
    [TrangThai]  int,
  [LoaiKhachHangId] int
)
GO

CREATE TABLE [LoaiKhachHang] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaLoaiKhachHang] nvarchar(255) UNIQUE,
  [TenLoaiKhachHang] nvarchar(255)
)
GO

CREATE TABLE [MauSac] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaMauSac] nvarchar(255) UNIQUE,
  [TenMauSac] nvarchar(255)
)
GO



CREATE TABLE [KichThuoc] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaKichThuoc] nvarchar(255) UNIQUE,
  [TenKichThuoc] nvarchar(255)
)
GO

CREATE TABLE [LoaiSanPham] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaLoaiSanPham] nvarchar(255) UNIQUE,
  [TenLoaiSanPham] nvarchar(255)
)
GO

CREATE TABLE [ChatLieu] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaChatLieu] nvarchar(255) UNIQUE,
  [TenChatLieu] nvarchar(255)
)
GO



CREATE TABLE [SanPham] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY,
  [MaSanPham] nvarchar(255) UNIQUE,
  [TenSanPham] nvarchar(255),
  [MoTa] nvarchar(255),
  [ThuongHieu] nvarchar(255),
  [XuatXu] nvarchar(255),
[TrangThai]  int,
)
GO



CREATE TABLE [SanPhamChiTiet] (
    [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaSanPhamChiTiet]  nvarchar(255),
  [MauSacID] int,
  [KichThuocID] int,
  [ChatLieuId] int,
  [LoaiSanPhamID] int,
  [SanPhamID] int,
  [NgayNhap] date,
  [Gia] int,
  [SoLuongTon] int,
)
GO

CREATE TABLE [DotGiamGia] (
  [Id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaGiamGia] nvarchar(255) UNIQUE,
  [TenDotGiamGia] nvarchar(255),
  [NgayBatDau] date,
  [NgayKetThuc] date,
  [giaTriNhoNhat] int,
  [giaTriLonNhat] int,
  [PhanTramGiamGia] int,
  [TrangThai] int,
)
GO

CREATE TABLE [PhieuGiaoHang] (
  [id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaPhieuGiaoHang] nvarchar(255) UNIQUE,
  [TenNguoiGiaoHang] nvarchar(255),
  [DiaChi] nvarchar(255),
  [GhiChu] nvarchar(255),
  [SoDienThoaiNguoiNhan] nvarchar(255),
  [NgayXuatHang] date,
  [NgayGiaoHang] date,
  [PhuongThucGiaoHang] nvarchar(255),
  [TrangThai] int,	
  [HoaDonId] int,
  [KhachHangId] int,
  [NhanVienId] int
)
GO

CREATE TABLE [HoaDon] (
  [id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaHoaDon] nvarchar(255) UNIQUE,
  [NgayTao] date,
  [TongTien] int,
  [TienKhuyenMai] int,
  [TienTraLai] int,
  [HinhThucThanhToan] nvarchar(255),
  [TrangThai] int,
  [KhachHangId] int,
  [NhanVienId] int,
  [DotGiamGiaID] int
)
GO

CREATE TABLE [HoaDonChiTiet] (
  [id] INT IDENTITY(1,1) PRIMARY KEY, 
  [MaHoaDonChiTiet] nvarchar(255) UNIQUE,
  [HoaDonID] int,
  [ChiTietSanPhamID] int,
  [SoLuong] int,
  [ThanhTien] int
)
GO


CREATE TABLE [GioHang] (
  [id] INT IDENTITY(1,1) PRIMARY KEY, 
  [ChiTietSanPhamID] int,
  [KhachHangId] int ,
  [NgayTao] date,
  [SoLuong] int,
)
GO

ALTER TABLE NhanVien
ADD FOREIGN KEY (ChucVuId) REFERENCES ChucVu(Id);

ALTER TABLE KhachHang
ADD FOREIGN KEY (LoaiKhachHangId) REFERENCES LoaiKhachHang(Id);


ALTER TABLE SanPhamChiTiet
ADD FOREIGN KEY (MauSacID) REFERENCES MauSac(Id);

ALTER TABLE SanPhamChiTiet
ADD FOREIGN KEY (KichThuocID) REFERENCES KichThuoc(Id);

ALTER TABLE SanPhamChiTiet
ADD FOREIGN KEY (ChatLieuId) REFERENCES ChatLieu(Id);





ALTER TABLE SanPhamChiTiet
ADD FOREIGN KEY (LoaiSanPhamID) REFERENCES LoaiSanPham(Id);

ALTER TABLE SanPhamChiTiet
ADD FOREIGN KEY (SanPhamID) REFERENCES SanPham(Id);

ALTER TABLE PhieuGiaoHang
ADD FOREIGN KEY (HoaDonId) REFERENCES HoaDon(Id);

ALTER TABLE PhieuGiaoHang
ADD FOREIGN KEY (KhachHangId) REFERENCES KhachHang(Id);

ALTER TABLE PhieuGiaoHang
ADD FOREIGN KEY (NhanVienId) REFERENCES NhanVien(Id);

ALTER TABLE HoaDon
ADD FOREIGN KEY (KhachHangId) REFERENCES KhachHang(Id);

ALTER TABLE HoaDon
ADD FOREIGN KEY (NhanVienId) REFERENCES NhanVien(Id);

ALTER TABLE HoaDon
ADD FOREIGN KEY (DotGiamGiaID) REFERENCES DotGiamGia(Id);

ALTER TABLE HoaDonChiTiet
ADD FOREIGN KEY (HoaDonID) REFERENCES HoaDon(Id);

ALTER TABLE HoaDonChiTiet
ADD FOREIGN KEY (ChiTietSanPhamID) REFERENCES SanPhamChiTiet(Id);

ALTER TABLE GioHang
ADD FOREIGN KEY (ChiTietSanPhamID) REFERENCES SanPhamChiTiet(Id);


ALTER TABLE GioHang
ADD FOREIGN KEY (KhachHangId) REFERENCES KhachHang(Id);


INSERT INTO NhanVien (MaNhanVien, HoTen, Email, SDT, DiaChi, NgaySinh, GioiTinh, MatKhau, TrangThai, ChucVuId)
VALUES ('NV001', 'John Doe', 'johndoe@example.com', '123456789', '123 ABC Street', '1990-01-01', 1, '12345678', 0, 1);

INSERT INTO NhanVien (MaNhanVien, HoTen, Email, SDT, DiaChi, NgaySinh, GioiTinh, MatKhau, TrangThai, ChucVuId)
VALUES ('NV002', 'Jane Smith', 'janesmith@example.com', '987654321', '456 XYZ Street', '1992-05-10', 0, '12345678', 0, 2);
INSERT INTO NhanVien (MaNhanVien, HoTen, Email, SDT, DiaChi, NgaySinh, GioiTinh, MatKhau, TrangThai, ChucVuId)
VALUES ('NV003', 'Jane Smith1', 'janesmith@example.com', '123456789', '123 XYZ Street', '1994-04-12', 0, '12345678', 1, 2);





INSERT INTO KhachHang (MaKhachHang, HoTen, DiaChi, SDT, GioiTinh, Email, NgaySinh, TrangThai, LoaiKhachHangId)
VALUES ('KH001', 'John Smith', '456 XYZ Street', '987654321', 1, 'johnsmith@example.com', '1990-01-01', 0, 1);

INSERT INTO KhachHang (MaKhachHang, HoTen, DiaChi, SDT, GioiTinh, Email, NgaySinh, TrangThai, LoaiKhachHangId)
VALUES ('KH002', 'Jane Doe', '123 ABC Street', '123456789', 0, 'janedoe@example.com', '1992-05-10', 0, 2);


-- Insert data into SanPham table
INSERT INTO SanPham (MaSanPham, TenSanPham, MoTa, ThuongHieu, XuatXu, TrangThai)
VALUES ('SP001', 'Product A', 'This is product A', 'Brand A', 'Country A', 0);

INSERT INTO SanPham (MaSanPham, TenSanPham, MoTa, ThuongHieu, XuatXu, TrangThai)
VALUES ('SP002', 'Product B', 'This is product B', 'Brand B', 'Country B', 0);

-- Insert data into SanPhamChiTiet table
INSERT INTO SanPhamChiTiet (MaSanPhamChiTiet, MauSacID, KichThuocID, ChatLieuId, LoaiSanPhamID, SanPhamID, NgayNhap, Gia, SoLuongTon)
VALUES ('SPCT001', 1, 1, 1, 1, 1, '2023-06-09', 50000, 100);

INSERT INTO SanPhamChiTiet (MaSanPhamChiTiet, MauSacID, KichThuocID, ChatLieuId, LoaiSanPhamID, SanPhamID, NgayNhap, Gia, SoLuongTon)
VALUES ('SPCT002', 2, 2, 2, 2, 2, '2023-06-10', 75000, 200);

select * from KhachHang
INSERT INTO HoaDon (TienKhachTra

INSERT INTO ChucVu (MaChucVu, TenChucVu)
VALUES ('CV001', 'Manager');

INSERT INTO ChucVu (MaChucVu, TenChucVu)
VALUES ('CV002', 'Salesperson');


INSERT INTO LoaiKhachHang (MaLoaiKhachHang, TenLoaiKhachHang)
VALUES ('LKH001', 'Regular Customer');

INSERT INTO LoaiKhachHang (MaLoaiKhachHang, TenLoaiKhachHang)
VALUES ('LKH002', 'VIP Customer');


-- Insert data into KichThuoc table
INSERT INTO KichThuoc (MaKichThuoc, TenKichThuoc)
VALUES ('KT001', 'Small');

INSERT INTO KichThuoc (MaKichThuoc, TenKichThuoc)
VALUES ('KT002', 'Medium');

-- Insert data into MauSac table
INSERT INTO MauSac (MaMauSac, TenMauSac)
VALUES ('MS001', 'Red');

INSERT INTO MauSac (MaMauSac, TenMauSac)
VALUES ('MS002', 'Blue');

-- Insert data into ChatLieu table
INSERT INTO ChatLieu (MaChatLieu, TenChatLieu)
VALUES ('CL001', 'Cotton');

INSERT INTO ChatLieu (MaChatLieu, TenChatLieu)
VALUES ('CL002', 'Leather');

-- Insert data into LoaiSanPham table
INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham)
VALUES ('LSP001', 'Shoes');

INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham)
VALUES ('LSP002', 'Clothing');


	
select * from KhachHang
select * from SanPham
select * from SanPhamChiTiet


select * from ChucVu
select * from MauSac
select * from KichThuoc
select * from LoaiKhachHang
select * from LoaiSanPham
select * from ChatLieu

select * from NhanVien
select * from NhanVien where maNhanVien = 'NV001' and matKhau = '12345678'


select * from DotGiamGia


INSERT INTO DotGiamGia (MaGiamGia, TenDotGiamGia, NgayBatDau, NgayKetThuc, giaTriNhoNhat, giaTriLonNhat, PhanTramGiamGia, TrangThai)
VALUES ('DG001', 'Summer Sale', '2023-07-01', '2023-07-31', 100000, 500000, 20, 1);

INSERT INTO DotGiamGia (MaGiamGia, TenDotGiamGia, NgayBatDau, NgayKetThuc, giaTriNhoNhat, giaTriLonNhat, PhanTramGiamGia, TrangThai)
VALUES ('DG002', 'Winter Sale', '2023-12-01', '2023-12-31', 200000, 1000000, 30, 1);

INSERT INTO DotGiamGia (MaGiamGia, TenDotGiamGia, NgayBatDau, NgayKetThuc, giaTriNhoNhat, giaTriLonNhat, PhanTramGiamGia, TrangThai)
VALUES ('DG003', 'Black Friday', '2023-11-01', '2023-11-30', 500000, 2000000, 40, 1);