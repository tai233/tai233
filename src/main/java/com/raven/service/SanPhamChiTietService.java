package com.raven.service;

import com.raven.domainModel.ChatLieu;
import com.raven.domainModel.KichThuoc;
import com.raven.domainModel.LoaiSanPham;
import com.raven.domainModel.MauSac;
import com.raven.domainModel.SanPham;
import com.raven.domainModel.SanPhamChiTiet;
import java.util.List;

/**
 *
 * @author haiz2
 */
public interface SanPhamChiTietService {

    public List<SanPhamChiTiet> getAll();

    List<SanPham> getSP();

    List<MauSac> getMauSac();

    List<ChatLieu> getChatLieu();

    List<KichThuoc> getKichThuoc();

    List<LoaiSanPham> getLoaiSanPham();

    SanPhamChiTiet getOneByMaCtsp(String ma);

    Boolean create(SanPhamChiTiet chiTietSP);
    
    public Boolean update(SanPhamChiTiet chiTietSp);


    public SanPhamChiTiet getOne(int id);

    Boolean delete(Integer id);

}
