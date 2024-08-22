package com.tiba.whatsapp.service;

import com.tiba.whatsapp.dto.MessageRequest;

public interface MessageService {

    Long sendMessage(MessageRequest messageRequest);
}
