package com.tiba.whatsapp.service.serviceImpl;

import com.tiba.whatsapp.dto.MessageRequest;
import com.tiba.whatsapp.dto.MessageResponse;
import com.tiba.whatsapp.mapper.MessageMapper;
import com.tiba.whatsapp.model.Chat;
import com.tiba.whatsapp.model.Message;
import com.tiba.whatsapp.model.User;
import com.tiba.whatsapp.repository.ChatRepository;
import com.tiba.whatsapp.repository.MessageRepository;
import com.tiba.whatsapp.service.ChatService;
import com.tiba.whatsapp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final ChatRepository chatRepository;
    private final MessageMapper messageMapper;

    @Override
    public Long sendMessage(MessageRequest messageRequest) {
        Chat chat = chatService.findByUser(messageRequest.sender(), messageRequest.receiver());
        if(chat == null) {
            chat = chatRepository.save(
                    Chat.builder()
                    .user1(User.builder().id(messageRequest.sender()).build())
                    .user2(User.builder().id(messageRequest.receiver()).build())
                    .build()
            );
        }

        Message message = Message.builder()
                .chat(chat)
                .sender(User.builder().id(messageRequest.sender()).build())
                .content(messageRequest.message())
                .build();

        return messageRepository.save(message).getId();
    }

    @Override
    public List<MessageResponse> getMessagesByChatId(Long chatId) {
        List<Message> messageList = messageRepository.findAllByChat_Id(chatId);
        List<MessageResponse> messageResponseList = messageList.stream().map(messageMapper::toResponse).toList();
        return messageResponseList;
    }
}
