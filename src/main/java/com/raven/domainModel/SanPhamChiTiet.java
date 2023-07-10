package com.raven.domainModel;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SanPhamChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaSanPhamChiTiet")
    private String maSanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name = "MauSacID")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "KichThuocID")
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "ChatLieuId")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "LoaiSanPhamID")
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "SanPhamID")
    private SanPham sanPham;

    @Column(name = "NgayNhap")
    private Date ngayNhap;

    @Column(name = "Gia")
    private int gia;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

}
