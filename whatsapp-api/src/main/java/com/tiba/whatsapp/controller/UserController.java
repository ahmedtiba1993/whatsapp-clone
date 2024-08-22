package com.tiba.whatsapp.controller;

import com.tiba.whatsapp.dto.UserRequest;
import com.tiba.whatsapp.dto.UserResponse;
import com.tiba.whatsapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> login(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.login(userRequest));
    }
}
