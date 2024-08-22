package com.tiba.whatsapp.mapper;

import com.tiba.whatsapp.dto.UserResponse;
import com.tiba.whatsapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUserName())
                .build();
    }
}
