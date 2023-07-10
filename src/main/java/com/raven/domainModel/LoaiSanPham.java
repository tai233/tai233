package com.raven.domainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LoaiSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoaiSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaLoaiSanPham", unique = true)
    private String maLoaiSanPham;

    @Column(name = "TenLoaiSanPham")
    private String tenLoaiSanPham;
}
