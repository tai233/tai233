package com.raven.service;

import com.raven.domainModel.KhachHang;
import com.raven.domainModel.LoaiKhachHang;
import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();
    
    
      List<LoaiKhachHang> getLoaiKhachHang();

    Boolean them(KhachHang khachHang);

    Boolean sua(KhachHang khachHang);

    Boolean delete(String Id);

    KhachHang getOne(Integer Id);

    public List<KhachHang> tim(String TenKhachKhang);

    public List<KhachHang> timTheoMa(String MaKhachHang);

}
