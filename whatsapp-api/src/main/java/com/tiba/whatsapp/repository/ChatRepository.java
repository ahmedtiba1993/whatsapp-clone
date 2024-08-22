package com.tiba.whatsapp.repository;

import com.tiba.whatsapp.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
