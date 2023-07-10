
package com.raven.domainModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LoaiKhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoaiKhachHang {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaLoaiKhachHang", unique = true)
    private String maLoaiKhachHang;

    @Column(name = "TenLoaiKhachHang")
    private String tenLoaiKhachHang;
    
}
