package com.raven.serviceImplement;

import com.raven.domainModel.ChatLieu;
import com.raven.repository.ChatLieuRepository;
import com.raven.service.ChatLieuService;
import java.util.ArrayList;
import java.util.List;

public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.getAll();
    }

    @Override
    public Boolean save(ChatLieu chatLieu) {
         return chatLieuRepository.addNew(chatLieu);
    }

    @Override
    public Boolean update(ChatLieu chatLieu) { return chatLieuRepository.upDate(chatLieu);
    }

    @Override
    public Boolean delete(Integer id) {return chatLieuRepository.delete(id);
    }

    @Override
    public ChatLieu getOne(Integer id) {
        return null;
    }

    @Override
    public ChatLieu getByMa(String ma) {
        return null;
    }


}
