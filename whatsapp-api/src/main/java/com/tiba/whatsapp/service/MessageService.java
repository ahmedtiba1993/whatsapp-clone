package com.tiba.whatsapp.service;

import com.tiba.whatsapp.dto.MessageRequest;
import com.tiba.whatsapp.dto.MessageResponse;

import java.util.List;

public interface MessageService {

    Long sendMessage(MessageRequest messageRequest);

    List<MessageResponse> getMessagesByChatId(Long chatId);
}
