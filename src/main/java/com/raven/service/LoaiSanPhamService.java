package com.raven.service;

import com.raven.domainModel.LoaiSanPham;
import java.util.List;

public interface LoaiSanPhamService {

    List<LoaiSanPham> getAll();

    Boolean save(LoaiSanPham loaiSanPham);

    Boolean update(LoaiSanPham loaiSanPham);

    Boolean delete(Integer id);

    LoaiSanPham getOne(Integer id);

    LoaiSanPham getByMa(String ma);
}
