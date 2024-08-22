package com.tiba.whatsapp.mapper;

import com.tiba.whatsapp.dto.ChatResponse;
import com.tiba.whatsapp.dto.UserResponse;
import com.tiba.whatsapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {

    public UserResponse toUserResponse(User user, List<ChatResponse> chatResponses) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUserName())
                .chatResponses(chatResponses)
                .build();
    }
}
