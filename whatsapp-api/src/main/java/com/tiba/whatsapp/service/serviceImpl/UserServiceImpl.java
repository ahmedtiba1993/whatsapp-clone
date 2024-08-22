package com.tiba.whatsapp.service.serviceImpl;

import com.tiba.whatsapp.dto.UserRequest;
import com.tiba.whatsapp.dto.UserResponse;
import com.tiba.whatsapp.mapper.UserMapper;
import com.tiba.whatsapp.model.User;
import com.tiba.whatsapp.repository.UserRepository;
import com.tiba.whatsapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse login(UserRequest userRequest) {

        Optional<User> existingUser = userRepository.findByUserName(userRequest.userName());

        if(existingUser.isPresent()) {

            UserResponse userResponse = new UserResponse();
            userResponse.setId(existingUser.get().getId());
            userResponse.setFirstName(existingUser.get().getFirstName());
            userResponse.setLastName(existingUser.get().getLastName());
            userResponse.setUsername(existingUser.get().getUserName());
            return userResponse;

        }else{

            User userSaved = userRepository.save(User.builder().userName(userRequest.userName()).build());
            return userMapper.toUserResponse(userSaved);

        }
    }
}
