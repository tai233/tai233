package com.raven.service;

import com.raven.domainModel.SanPham;
import java.util.List;

/**
 *
 * @author haiz2
 */
public interface SanPhamService {

    List<SanPham> getAll();

    Boolean save(SanPham sanPham);

    Boolean update(SanPham sanPham);

    Boolean delete(Integer id);

    SanPham getOne(Integer id);

    SanPham getByMa(String ma);

    List<SanPham> findByName(String ten);

    List<SanPham> findByXuatXu(String xuatXu);
}
