package com.raven.serviceImplement;

import com.raven.domainModel.MauSac;
import com.raven.repository.MauSacRepository;
import com.raven.service.MauSacService;
import java.util.List;

public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public Boolean save(MauSac mauSac) {return mauSacRepository.addNew(mauSac);
    }

    @Override
    public Boolean update(MauSac mauSac) {return mauSacRepository.upDate(mauSac);
    }

    @Override
    public Boolean delete(Integer id) {return mauSacRepository.delete(id);
    }

    @Override
    public MauSac getOne(Integer id) {
        return null;
    }

    @Override
    public MauSac getByMa(String ma) {
        return null;
    }

 
}
