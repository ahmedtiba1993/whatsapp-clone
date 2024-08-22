package com.tiba.whatsapp.service.serviceImpl;

import com.tiba.whatsapp.dto.ChatResponse;
import com.tiba.whatsapp.mapper.ChatMapper;
import com.tiba.whatsapp.model.Chat;
import com.tiba.whatsapp.repository.ChatRepository;
import com.tiba.whatsapp.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> findAllByUserId(Long userId) {
        List<Chat> chatList = chatRepository.findByUserId(userId);
        List<ChatResponse> chatResponseList = chatList.stream().map(chatMapper::toResponse).toList();
        return chatResponseList;
    }

    @Override
    public Chat findByUser(Long user1Id, Long user2Id) {
        return chatRepository.findByUser(user1Id, user2Id);
    }
}
