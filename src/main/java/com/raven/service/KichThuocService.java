
package com.raven.service;

import com.raven.domainModel.KichThuoc;
import java.util.List;


public interface KichThuocService {
     List<KichThuoc> getAll();

    Boolean save(KichThuoc kichThuoc);

    Boolean update(KichThuoc kichThuoc);

    Boolean delete(Integer id);

    KichThuoc getOne(Integer id);
    
    KichThuoc getByMa(String ma);
}
