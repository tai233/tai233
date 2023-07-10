
package com.raven.service;

import com.raven.domainModel.HoaDon;
import java.util.List;


public interface HoaDonService {
    
     List<HoaDon> getAll();

    HoaDon getOne(int id);
    
    List<HoaDon> getHdWhere(int tt, int id);

    HoaDon getOneByMaHD(String maHoaDon);

    List<HoaDon> getHoaDonByIdNV(int idnv);

    Boolean save(HoaDon hd);

    Boolean update(HoaDon hd);

    Boolean delete(HoaDon hd);
    
}
