
package com.raven.service;

import com.raven.domainModel.MauSac;
import java.util.List;


public interface MauSacService {
     List<MauSac> getAll();

    Boolean save(MauSac mauSac);

    Boolean update(MauSac mauSac);

    Boolean delete(Integer id);

    MauSac getOne(Integer id);
    
    MauSac getByMa(String ma);
}
