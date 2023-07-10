package com.raven.serviceImpl;

import com.raven.domainModel.HoaDon;
import com.raven.repository.HoaDonRepository;
import com.raven.service.HoaDonService;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonReposity = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hoaDonReposity.getAll();

    }

    @Override
    public HoaDon getOne(int id) {
        return hoaDonReposity.getOne(id);
    }

    @Override
    public Boolean save(HoaDon hd) {
        return hoaDonReposity.save(hd);
    }

    @Override
    public Boolean update(HoaDon hd) {
        return hoaDonReposity.update(hd);
    }

    @Override
    public Boolean delete(HoaDon hd) {
        return hoaDonReposity.delete(hd);
    }

    @Override
    public List<HoaDon> getHoaDonByIdNV(int idnv) {
        return hoaDonReposity.getHoaDonByIdNV(idnv);
    }

    @Override
    public HoaDon getOneByMaHD(String maHoaDon) {
        return hoaDonReposity.getOneByMaHD(maHoaDon);
    }

    @Override
    public List<HoaDon> getHdWhere(int tt, int id) {
        return hoaDonReposity.getHdWhere(tt, id);
    }

}
