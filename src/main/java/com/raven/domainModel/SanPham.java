package com.raven.domainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaSanPham", unique = true)
    private String maSanPham;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @Column(name = "MoTa")
    private String moTa;


    @Column(name = "ThuongHieu")
    private String thuongHieu;

    @Column(name = "XuatXu")
    private String xuatXu;

    @Column(name = "TrangThai")
    private int trangThai;

}
