package com.tiba.whatsapp.controller;

import com.tiba.whatsapp.dto.MessageRequest;
import com.tiba.whatsapp.dto.MessageResponse;
import com.tiba.whatsapp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Long> sendMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok().body(messageService.sendMessage(request));
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getMessagesByChatId(@RequestParam Long chatId) {
        return ResponseEntity.ok(messageService.getMessagesByChatId(chatId));
    }
}
