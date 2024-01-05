package com.yubin.chat.message;

import com.yubin.chat.user.ApplicationUser;
import com.yubin.chat.chatroom.ChatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @ManyToOne
    @JoinColumn(name = "message_chatroom_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "message_user_id")
    private ApplicationUser user;

    @Column(name = "message_content", nullable = false, columnDefinition = "TEXT")
    private String messageContent;

    @Column(name = "message_timestamp", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "message_reply_to_message_id")
    private Message replyToMessage;

}
