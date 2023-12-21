package com.yubin.chat.chatroom;

import com.yubin.chat.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatroom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id
    @Column(name = "chatroom_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatroomId;

    @Column(name = "chatroom_name", nullable = false, length = 100)
    private String chatroomName;

    @Column(name = "chatroom_creation_date", nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime chatroomCreationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_created_by_user_id")
    private User createdBy;
}
