package com.DermApp.Backend.diagnostic.domain.persistence;

import com.DermApp.Backend.diagnostic.domain.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findChatById(Long chatId);
}
