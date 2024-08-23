package com.tiba.whatsapp.repository;

import com.tiba.whatsapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByChat_Id(Long chatId);
}
