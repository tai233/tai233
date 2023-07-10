package com.raven.serviceImpl;

import com.raven.domainModel.ChucVu;
import com.raven.repository.ChucVuRepository;
import com.raven.service.ChucVuService;
import java.util.List;

public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public Boolean save(ChucVu chucVu) { 
        return chucVuRepository.addNew(chucVu);
    }

    @Override
    public Boolean update(ChucVu chucVu) { 
        return chucVuRepository.upDate(chucVu);
    }

    @Override
    public Boolean delete(Integer id) { 
        return chucVuRepository.delete(id);
    }

    @Override
    public ChucVu getOne(Integer id) {
        return null;
    }

    @Override
    public ChucVu getByMa(String ma) {
        return null;
    }

}
