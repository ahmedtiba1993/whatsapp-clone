package com.tiba.whatsapp.repository;

import com.tiba.whatsapp.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query("select c from Chat c where c.user1.id = :id or c.user2.id = :id")
    List<Chat> findByUserId(Long id);

    @Query("SELECT c FROM Chat c WHERE (c.user1.id IN (:user1Id, :user2Id) AND c.user2.id IN (:user1Id, :user2Id))")
    Chat findByUser(Long user1Id, Long user2Id);
}
