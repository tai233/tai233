package com.raven.serviceImpl;

import com.raven.domainModel.HoaDon;
import com.raven.domainModel.PhieuGiaoHang;
import com.raven.repository.PhieuGiaoHangRepository;
import com.raven.service.PhieuGiaoHangService;
import java.util.List;

public class PhieuGiaoHangServiceImpl implements PhieuGiaoHangService {

    private PhieuGiaoHangRepository phieuGiaoHangRepository = new PhieuGiaoHangRepository();

   

    @Override
    public List<PhieuGiaoHang> getAllChuaGiao() {
        return phieuGiaoHangRepository.getAllChuaGiao();
    }

    @Override
    public List<PhieuGiaoHang> getAllDaLay() {
        return phieuGiaoHangRepository.getAllDaLay();
    }

    @Override
    public List<PhieuGiaoHang> getAllDangGiao() {
        return phieuGiaoHangRepository.getAllDangGiao();
    }

    @Override
    public List<PhieuGiaoHang> getAllDaGiaoHang() {
        return phieuGiaoHangRepository.getAllDaGiao();
    }

    @Override
    public Boolean save(PhieuGiaoHang phieuGiaoHang) {
        return phieuGiaoHangRepository.addNew(phieuGiaoHang);
    }

    @Override
    public Boolean updateDaLay(Integer id) {
        return null;
    }

    @Override
    public Boolean updateDangGiao(Integer id) {
          return null;
    }

    @Override
    public Boolean updateDaGiao(Integer id) {
          return null;
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        return phieuGiaoHangRepository.getAllHoaDon();
    }

    @Override
    public List<HoaDon> getHoaDon() {
        return phieuGiaoHangRepository.getHoaDon();
    }

    @Override
    public List<PhieuGiaoHang> getAll() {
          return phieuGiaoHangRepository.getAll();
    }

}
