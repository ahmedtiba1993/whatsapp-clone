package com.tiba.whatsapp.dto;

public record MessageRequest(
        String message,
        Long sender,
        Long receiver
) {
}
