package com.raven.serviceImpl;

import com.raven.domainModel.LoaiKhachHang;
import com.raven.repository.LoaiKhachHangRepository;
import com.raven.service.LoaiKhachHangService;
import java.util.List;

public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {

    private LoaiKhachHangRepository loaiKhachHangRepository = new LoaiKhachHangRepository();

    @Override
    public List<LoaiKhachHang> getAll() {
        return loaiKhachHangRepository.getAll();
    }

    @Override
    public Boolean save(LoaiKhachHang loaiKhachHang) {
        return loaiKhachHangRepository.addNew(loaiKhachHang);
    }

    @Override
    public Boolean update(LoaiKhachHang loaiKhachHang) {
        return loaiKhachHangRepository.upDate(loaiKhachHang);
    }

    @Override
    public Boolean delete(Integer id) {
        return loaiKhachHangRepository.delete(id);
    }

    @Override
    public LoaiKhachHang getOne(Integer id) {
        return null;
    }

    @Override
    public LoaiKhachHang getByMa(String ma) {
        return null;
    }

  
}
