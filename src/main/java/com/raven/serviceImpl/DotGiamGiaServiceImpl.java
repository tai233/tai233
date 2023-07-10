package com.raven.serviceImpl;

import com.raven.domainModel.DotGiamGia;
import com.raven.repository.DotGiamGiaRepository;
import com.raven.service.DotGiamGiaService;
import java.util.List;

/**
 *
 * @author user
 */
public class DotGiamGiaServiceImpl implements DotGiamGiaService{
    DotGiamGiaRepository dotGiamGiaRepository = new DotGiamGiaRepository();
    
    @Override
    public List<DotGiamGia> getAll() {
        return dotGiamGiaRepository.getAll();
    }

    @Override
    public boolean add(DotGiamGia dotGiamGia) {
        return dotGiamGiaRepository.add(dotGiamGia);
    }

    @Override
    public boolean update(DotGiamGia dotGiamGia) {
        dotGiamGiaRepository.update(dotGiamGia); 
        return true;    
    }

    @Override
    public boolean delete(Integer id) {
        return dotGiamGiaRepository.delete(id);
    }

    @Override
    public List<DotGiamGia> timTen(String ten) {
        return dotGiamGiaRepository.timTen(ten);
    }

    @Override
    public List<DotGiamGia> timMa(String ma) {
        return dotGiamGiaRepository.timMa(ma);
    }

    @Override
    public List<DotGiamGia> timGiam(int ptGiam) {
        return dotGiamGiaRepository.timGiam(ptGiam);
    }
    
}
