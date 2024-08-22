package com.tiba.whatsapp.controller;

import com.tiba.whatsapp.dto.MessageRequest;
import com.tiba.whatsapp.service.MessageService;
import com.tiba.whatsapp.service.serviceImpl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Long> sendMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok().body(messageService.sendMessage(request));
    }
}
