package com.tiba.whatsapp.service;

import com.tiba.whatsapp.dto.UserRequest;
import com.tiba.whatsapp.dto.UserResponse;

public interface UserService {

    UserResponse login(UserRequest userRequest);

}
