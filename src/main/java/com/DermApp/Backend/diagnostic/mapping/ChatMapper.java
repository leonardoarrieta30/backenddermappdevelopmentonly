package com.DermApp.Backend.diagnostic.mapping;

import com.DermApp.Backend.diagnostic.domain.model.entity.Chat;
import com.DermApp.Backend.diagnostic.resource.ChatResource;
import com.DermApp.Backend.diagnostic.resource.CreateChatResource;
import com.DermApp.Backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ChatMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ChatResource toResource(Chat model){
        return mapper.map(model, ChatResource.class);
    }

    public Chat toModel(CreateChatResource resource){
        return mapper.map(resource, Chat.class);
    }
}
