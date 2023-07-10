package com.raven.service;

import com.raven.domainModel.ChucVu;
import java.util.List;
import com.raven.domainModel.NhanVien;

public interface NhanVienService {


    List<NhanVien> getAllDangLam();

    List<NhanVien> getAllNghiLam();
    
    List<ChucVu> getChucVu();

    Boolean add(NhanVien taiKhoan);

    Boolean update(NhanVien taiKhoan);

    Boolean delete(Integer id);


    NhanVien getByMaAndMatKhau(String ma, String pass);

    NhanVien getByMa(String email);

}
