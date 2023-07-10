package com.raven.serviceImpl;

import com.raven.domainModel.ChatLieu;
import com.raven.domainModel.KichThuoc;
import com.raven.domainModel.LoaiSanPham;
import com.raven.domainModel.MauSac;
import com.raven.domainModel.SanPham;
import com.raven.domainModel.SanPhamChiTiet;
import com.raven.repository.SanPhamChiTietRepository;
import com.raven.service.SanPhamChiTietService;
import java.util.List;

/**
 *
 * @author haiz2
 */
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    private SanPhamChiTietRepository sanPhamChiTietRepository = new SanPhamChiTietRepository();

    @Override
    public List<SanPhamChiTiet> getAll() {
        return sanPhamChiTietRepository.getAll();
    }

    @Override
    public List<SanPham> getSP() {
          return sanPhamChiTietRepository.getSanPham();
    }

    @Override
    public List<MauSac> getMauSac() {
          return sanPhamChiTietRepository.getMauSac();
    }

    @Override
    public List<ChatLieu> getChatLieu() {
          return sanPhamChiTietRepository.getChatLieu();
    }

    @Override
    public List<KichThuoc> getKichThuoc() {
          return sanPhamChiTietRepository.getKichThuoc();
    }

    @Override
    public List<LoaiSanPham> getLoaiSanPham() {
          return sanPhamChiTietRepository.getLoaiSanPham();
    }

    @Override
    public Boolean create(SanPhamChiTiet chiTietSP) {  
        return sanPhamChiTietRepository.add(chiTietSP);
    }

    @Override
    public Boolean delete(Integer id) {
        return sanPhamChiTietRepository.delete(id);
    }

    @Override
    public SanPhamChiTiet getOneByMaCtsp(String ma) {
         return sanPhamChiTietRepository.getOneByMaCtsp(ma);
    }

    @Override
    public Boolean update(SanPhamChiTiet chiTietSp) {  
        return sanPhamChiTietRepository.add(chiTietSp);
    }


    @Override
    public SanPhamChiTiet getOne(int id) {
        return null;
    }

   

}
