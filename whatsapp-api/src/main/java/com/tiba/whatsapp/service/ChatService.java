package com.tiba.whatsapp.service;

import com.tiba.whatsapp.dto.ChatResponse;
import com.tiba.whatsapp.model.Chat;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatService {

    List<ChatResponse> findAllByUserId(Long userId);

    Chat findByUser(Long user1Id, Long user2Id);

}
