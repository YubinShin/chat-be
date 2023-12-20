package com.yubin.chat.message;

import com.yubin.chat.user.User;
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
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column(nullable = false)
    private Integer chatRoomId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String messageContent;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column
    private Integer replyToMessageId;

    // 연관 관계 매핑 (옵션)
//    @ManyToOne
//    @JoinColumn(name = "chatRoomId", insertable = false, updatable = false)
//    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "replyToMessageId", insertable = false, updatable = false)
    private Message replyToMessage;

}