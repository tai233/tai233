
package com.raven.service;

import com.raven.domainModel.LoaiKhachHang;
import java.util.List;


public interface LoaiKhachHangService {
    List<LoaiKhachHang> getAll();

    Boolean save(LoaiKhachHang loaiKhachHang);

    Boolean update(LoaiKhachHang loaiKhachHang);

    Boolean delete(Integer id);

    LoaiKhachHang getOne(Integer id);
    
    LoaiKhachHang getByMa(String ma);
}
