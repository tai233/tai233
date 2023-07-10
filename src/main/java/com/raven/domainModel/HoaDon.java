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
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaHoaDon", unique = true)
    private String maHoaDon;

    @Column(name = "TongTien")
    private int tongTien;

    @Column(name = "TienKhachTra")
    private int tienKhachTra;

    @Column(name = "TienTraLai")
    private int tienTraLai;

    @Column(name = "HinhThucThanhToan")
    private String hinhThucThanhToan;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "KhachHangId")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "NhanVienId")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "DotGiamGiaID")
    private DotGiamGia dotGiamGia;

    public String hthiTrangThai() {

        if (this.trangThai == 0) {

            return "Đã Hủy";
        } else if (this.trangThai == 1) {
            return "Chưa Thanh Toán";
        }
        return "Đã Thanh Toán";

    }

}
