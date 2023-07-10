
package com.raven.service;

import com.raven.domainModel.ChatLieu;
import java.util.List;


public interface ChatLieuService {
    
    List<ChatLieu> getAll();

    Boolean save(ChatLieu chatLieu);

    Boolean update(ChatLieu chatLieu);

    Boolean delete(Integer id);

    ChatLieu getOne(Integer id);
    
    ChatLieu getByMa(String ma);
    
}
