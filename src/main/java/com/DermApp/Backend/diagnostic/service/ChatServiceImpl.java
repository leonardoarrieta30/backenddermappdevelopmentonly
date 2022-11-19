package com.DermApp.Backend.diagnostic.service;

import com.DermApp.Backend.diagnostic.domain.model.entity.Chat;
import com.DermApp.Backend.diagnostic.domain.persistence.ChatRepository;
import com.DermApp.Backend.diagnostic.domain.service.ChatService;
import com.DermApp.Backend.shared.exception.ResourceNotFoundException;
import com.DermApp.Backend.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ChatServiceImpl implements ChatService {

    private static final String ENTITY = "Chat";
    private final ChatRepository chatRepository;
    private final Validator validator;

    public ChatServiceImpl(ChatRepository chatRepository, Validator validator) {
        this.chatRepository = chatRepository;
        this.validator = validator;
    }


    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }

//    @Override
//    public Page<Chat> getAll(Pageable pageable) {
//        return chatRepository.findAll(pageable);
//    }

    @Override
    public Chat getById(Long chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,chatId));
    }

    @Override
    public Chat create(Chat chat) {
        Set<ConstraintViolation<Chat>> violations = validator.validate(chat);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return chatRepository.save(chat);
    }

}
