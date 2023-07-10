
package com.raven.service;

import com.raven.domainModel.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author haiz2
 */
public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();

    
//    get hoa don chi tiet boi ctsp and idhd
    HoaDonChiTiet getHdctByIdCtspAndIdHd(Integer idCtsp, Integer idHd);

    Boolean save(HoaDonChiTiet hdct);

    Boolean update(HoaDonChiTiet hdct);

    Boolean delete(HoaDonChiTiet hdct);

    HoaDonChiTiet getOne(Integer id);

    
//    get list hoa don chi tiet boi hoa don (list hoa don chi tiet )
    List<HoaDonChiTiet> getHDCTByIdHD(Integer id);

    
//    getq  hoa don chi tiet boi 1 sp
    HoaDonChiTiet getHdctByIdCtsp(Integer idCTSP);

    
}
