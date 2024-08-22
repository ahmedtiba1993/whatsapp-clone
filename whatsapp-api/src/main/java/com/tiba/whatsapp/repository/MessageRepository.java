package com.tiba.whatsapp.repository;

import com.tiba.whatsapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
