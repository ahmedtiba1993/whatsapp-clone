package com.tiba.whatsapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Chat {

    @Id
    @GeneratedValue
    private Long id;
    private String chatName;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User user2;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Message> messages;

}
