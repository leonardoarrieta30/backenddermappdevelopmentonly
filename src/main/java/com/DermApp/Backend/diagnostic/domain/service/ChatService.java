package com.DermApp.Backend.diagnostic.domain.service;

import com.DermApp.Backend.diagnostic.domain.model.entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatService {
    List<Chat> getAll();
//    Page<Chat> getAll(Pageable pageable);
    Chat getById(Long chatId);
    Chat create(Chat chat);
//    Chat update(Long chatId, Chat request);
    //ResponseEntity<?> delete(Long chatId);

}
