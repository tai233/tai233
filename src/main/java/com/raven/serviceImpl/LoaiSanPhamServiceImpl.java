package com.raven.serviceImplement;

import com.raven.domainModel.LoaiKhachHang;
import com.raven.domainModel.LoaiSanPham;
import com.raven.repository.LoaiSanPhamRepository;
import com.raven.service.LoaiKhachHangService;
import com.raven.service.LoaiSanPhamService;
import java.util.List;

public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

    private LoaiSanPhamRepository loaiSanPhamRepository = new LoaiSanPhamRepository();

    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSanPhamRepository.getAll();
    }

    @Override
    public Boolean save(LoaiSanPham loaiSanPham) {
        return loaiSanPhamRepository.addNew(loaiSanPham);
    }

    @Override
    public Boolean update(LoaiSanPham loaiSanPham) {
        return loaiSanPhamRepository.upDate(loaiSanPham);
    }

    @Override
    public Boolean delete(Integer id) {
        return loaiSanPhamRepository.delete(id);
    }

    @Override
    public LoaiSanPham getOne(Integer id) {
        return null;
    }

    @Override
    public LoaiSanPham getByMa(String ma) {
        return null;
    }

}
