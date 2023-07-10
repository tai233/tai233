package com.raven.service;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.PhieuGiaoHang;
import java.util.List;

/**
 *
 * @author haiz2
 */
public interface PhieuGiaoHangService {

      List<PhieuGiaoHang> getAll();
    List<PhieuGiaoHang> getAllChuaGiao();

    List<PhieuGiaoHang> getAllDaLay();

    List<PhieuGiaoHang> getAllDangGiao();

    List<PhieuGiaoHang> getAllDaGiaoHang();

    Boolean save(PhieuGiaoHang phieuGiaoHang);

    Boolean updateDaLay(Integer id);

    Boolean updateDangGiao(Integer id);

    Boolean updateDaGiao(Integer id);

    List<HoaDon> getAllHoaDon();

    List<HoaDon> getHoaDon();

}
