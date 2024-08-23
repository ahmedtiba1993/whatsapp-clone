package com.tiba.whatsapp.mapper;

import com.tiba.whatsapp.dto.MessageResponse;
import com.tiba.whatsapp.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {

    public MessageResponse toResponse(Message message) {
        return MessageResponse.builder()
                .id(message.getId())
                .content(message.getContent())
                .timestamp(message.getTimestamp())
                .build();
    }
}
