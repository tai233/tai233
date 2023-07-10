package com.raven.serviceImpl;

import com.raven.domainModel.HoaDonChiTiet;
import com.raven.service.HoaDonChiTietService;
import com.raven.repository.HoaDonChiTietRepository;
import java.util.List;

public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.getAll();

    }

    @Override
    public Boolean save(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.save(hdct);
    }

    @Override
    public Boolean update(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.update(hdct);
    }

    @Override
    public Boolean delete(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.delete(hdct);
    }

    @Override
    public HoaDonChiTiet getOne(Integer id) {
        return hoaDonChiTietRepository.getOne(id);
    }

    public static void main(String[] args) {
        new HoaDonChiTietServiceImpl().getAll().toArray();
    }

    @Override
    public HoaDonChiTiet getHdctByIdCtsp(Integer idctsp) {
        return hoaDonChiTietRepository.getHdctByIdCtsp(idctsp);
    }

    @Override
    public HoaDonChiTiet getHdctByIdCtspAndIdHd(Integer idCtsp, Integer idHd) {
        return hoaDonChiTietRepository.getHdctByIdCtspAndIdHd(idCtsp, idHd);
    }

    @Override
    public List<HoaDonChiTiet> getHDCTByIdHD(Integer id) {
        return hoaDonChiTietRepository.getHdctByIdHd(id);
    }

}
