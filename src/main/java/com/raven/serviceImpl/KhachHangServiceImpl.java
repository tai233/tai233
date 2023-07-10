package com.raven.serviceImpl;

import com.raven.domainModel.KhachHang;
import com.raven.domainModel.LoaiKhachHang;
import com.raven.repository.KhachHangRepository;
import com.raven.service.KhachHangService;
import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll(); 
    }

    @Override
    public Boolean them(KhachHang khachHang) {
        return khachHangRepository.add(khachHang); 
    }

    @Override
    public Boolean sua(KhachHang khachHang) {
        return khachHangRepository.update(khachHang); 
    }

    @Override
    public Boolean delete(String Id) {
        return khachHangRepository.delete(Id);
    }

    @Override
    public KhachHang getOne(Integer Id) {
        return khachHangRepository.getOne(Id);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> tim(String TenKhachHang) {
        return khachHangRepository.tim(TenKhachHang); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> timTheoMa(String MaKhachHang) {
        return khachHangRepository.timTheoMa(MaKhachHang); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    

    @Override
    public List<LoaiKhachHang> getLoaiKhachHang() {
        return khachHangRepository.getLoaiKhachHang();
    }

   
}
