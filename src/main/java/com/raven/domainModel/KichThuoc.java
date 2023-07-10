package com.raven.domainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "KichThuoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KichThuoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaKichThuoc", unique = true)
    private String maKichThuoc;

    @Column(name = "TenKichThuoc")
    private String tenKichThuoc;
}
