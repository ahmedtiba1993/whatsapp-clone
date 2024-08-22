package com.tiba.whatsapp.mapper;

import com.tiba.whatsapp.dto.ChatResponse;
import com.tiba.whatsapp.model.Chat;
import org.springframework.stereotype.Service;

@Service
public class ChatMapper {

    public ChatResponse toResponse(Chat chat){
        return ChatResponse.builder()
                .id(chat.getId())
                .chatName(chat.getChatName())
                .build();
    }
}
