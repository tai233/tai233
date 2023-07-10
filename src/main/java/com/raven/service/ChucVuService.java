
package com.raven.service;

import com.raven.domainModel.ChucVu;
import java.util.List;

public interface ChucVuService {
     List<ChucVu> getAll();

    Boolean save(ChucVu chucVu);

    Boolean update(ChucVu chucVu);

    Boolean delete(Integer id);

    ChucVu getOne(Integer id);
    
    ChucVu getByMa(String ma);
}
