package com.raven.serviceImpl;

import com.raven.domainModel.ChucVu;
import com.raven.domainModel.NhanVien;
import com.raven.repository.NhanVienRepository;
import com.raven.service.NhanVienService;
import java.util.List;

public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAllDangLam() {
        return nhanVienRepository.getAllDangLam();
    }

    @Override
    public List<NhanVien> getAllNghiLam() {
        return nhanVienRepository.getAllNghiLam();
    }

    @Override
    public Boolean add(NhanVien taiKhoan) {
        return nhanVienRepository.add(taiKhoan);
    }

    @Override
    public Boolean update(NhanVien taiKhoan) {
        return nhanVienRepository.add(taiKhoan);
    }

    @Override
    public Boolean delete(Integer id) {
        return nhanVienRepository.delete(id);
    }

    @Override
    public NhanVien getByMaAndMatKhau(String ma, String pass) {
        return null;
    }

    @Override
    public NhanVien getByMa(String email) {
        return null;
    }

    @Override
    public List<ChucVu> getChucVu() {
        return nhanVienRepository.getChucVu();
    }

}
