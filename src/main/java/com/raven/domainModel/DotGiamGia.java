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
@Table(name = "DotGiamGia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DotGiamGia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaGiamGia", unique = true)
    private String maGiamGia;

    @Column(name = "TenDotGiamGia")
    private String tenDotGiamGia;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "giaTriNhoNhat")
    private int giaTriNhoNhat;

    @Column(name = "giaTriLonNhat")
    private int giaTriLonNhat;

    @Column(name = "PhanTramGiamGia")
    private int phanTramGiamGia;

    @Column(name = "TrangThai")
    private int trangThai;

    public String htTrangThai() {
        if (this.trangThai == 1) {
            return "Đang diễn ra";
        } else if (this.trangThai == 2) {
            return "Sắp diễn ra";
        }
        return "Kết thúc";
    }

}
