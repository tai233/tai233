
package com.raven.domainModel;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PhieuGiaoHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PhieuGiaoHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaPhieuGiaoHang", unique = true)
    private String maPhieuGiaoHang;

    @Column(name = "TenNguoiGiaoHang")
    private String tenNguoiGiaoHang;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "SoDienThoaiNguoiNhan")
    private String soDienThoaiNguoiNhan;

    @Column(name = "NgayXuatHang")
    private Date ngayXuatHang;

    @Column(name = "NgayGiaoHang")
    private Date ngayGiaoHang;

    @Column(name = "PhuongThucGiaoHang")
    private String phuongThucGiaoHang;

 
    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "HoaDonId")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "KhachHangId")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "NhanVienId")
    private NhanVien nhanVien;
    
    
    public String htTrangThai() {
        if (this.trangThai == 0) {
            return "Chưa Lấy Hàng";
        } else if (this.trangThai == 1) {
            return "Đã Lấy Hàng";
        }else if (this.trangThai == 2) {
            return "Đang Giao Hàng";
        }
        else if (this.trangThai == 3) {
            return "Đã Giao Hàng";
        }
        return "Giao Hàng Thành Công";
    } 
    
}
