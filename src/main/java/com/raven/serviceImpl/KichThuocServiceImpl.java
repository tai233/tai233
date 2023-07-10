package com.raven.serviceImplement;

import com.raven.domainModel.KichThuoc;
import com.raven.repository.KichThuocRepository;
import com.raven.service.KichThuocService;
import java.util.List;

public class KichThuocServiceImpl implements KichThuocService {

    private KichThuocRepository kichThuocRepository = new KichThuocRepository();

    @Override
    public List<KichThuoc> getAll() {
        return kichThuocRepository.getAll();
    }

    @Override
    public Boolean save(KichThuoc kichThuoc) {
        return kichThuocRepository.addNew(kichThuoc);
    }

    @Override
    public Boolean update(KichThuoc kichThuoc) {
        return kichThuocRepository.upDate(kichThuoc);
    }

    @Override
    public Boolean delete(Integer id) {
        return kichThuocRepository.delete(id);
    }

    @Override
    public KichThuoc getOne(Integer id) {
        return null;
    }

    @Override
    public KichThuoc getByMa(String ma) {
        return null;
    }

}
