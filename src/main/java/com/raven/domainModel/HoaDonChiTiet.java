package com.raven.domainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaHoaDonChiTiet", unique = true)
    private String maHoaDonChiTiet;

    @ManyToOne
    @JoinColumn(name = "HoaDonID")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ChiTietSanPhamID")
    private SanPhamChiTiet chiTietSanPham;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "ThanhTien")
    private int thanhTien;

}
