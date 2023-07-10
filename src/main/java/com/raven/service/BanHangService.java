/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.HoaDonChiTiet;
import com.raven.domainModel.KhachHang;
import com.raven.domainModel.NhanVien;
import com.raven.domainModel.SanPham;
import com.raven.domainModel.SanPhamChiTiet;
import java.util.List;

/**
 *
 * @author haiz2
 */
public interface BanHangService {
    

    List<SanPhamChiTiet> getSanPham(String tenSP);

    List<HoaDonChiTiet> getHoaDonChiTietByHoaDon(String ma);

    List<HoaDon> getHoaDonByMa(String Ma);

    Boolean createHDCT(HoaDonChiTiet hoaDonChiTiet);

    Boolean createHD(HoaDon hoaDon);

    Boolean updateChiTietSP(SanPhamChiTiet chiTietSP);

    Boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet);


    List<HoaDon> getAllHoaDon();

    List<SanPham> getAllSanPham();

    List<HoaDonChiTiet> getAllHDCT();

    List<NhanVien> getAllTaiKhoans();

    HoaDon getByMaHD(String maHD);

    Boolean updateSLSP(SanPhamChiTiet chiTietSP, String id);

    Boolean huyDon(HoaDon hoaDon, String idHD);

    Boolean updateKhach(HoaDon hoaDon, String id);

    Boolean tangSL(HoaDonChiTiet hoaDonChiTiet, String idHDCT);

    Boolean giamSL(HoaDonChiTiet hoaDonChiTiet, String idHDCT);

    Boolean updateGiamSL(SanPhamChiTiet chiTietSP, String id);

    Boolean updateTangSL(SanPhamChiTiet chiTietSP, String id);

    Boolean thanhToan(HoaDon hoaDon, String id);

    Boolean xoaHDCT(String idHDCT);

    KhachHang getByMaKH(String maKhachHang);

    List<HoaDon> getHoaDonDaThanhToan(String maNV);

    List<HoaDon> getHoaDonDaHuy(String maNV);
    
}
