package com.raven.serviceImpl;

import com.raven.domainModel.SanPham;
import com.raven.repository.SanPhamRepository;

import com.raven.service.SanPhamService;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public Boolean save(SanPham sanPham) {
        return sanPhamRepository.addNew(sanPham);
    }

    @Override
    public Boolean update(SanPham sanPham) {
        return sanPhamRepository.upDate(sanPham);
    }

    @Override
    public Boolean delete(Integer id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public SanPham getOne(Integer id) {
        return null;
    }

    @Override
    public SanPham getByMa(String ma) {
        return null;
    }

    @Override
    public List<SanPham> findByName(String ten) {
        return sanPhamRepository.findByName(ten);
    }

    @Override
    public List<SanPham> findByXuatXu(String xuatXu) {
           return sanPhamRepository.findByXuatXu(xuatXu);
    }

}
