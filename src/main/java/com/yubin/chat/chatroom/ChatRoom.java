package com.yubin.chat.chatroom;

import com.yubin.chat.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ChatRoom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomID;

    @Column(nullable = false, length = 100)
    private String chatRoomName;

    @Column(nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "userId")
    private User createdBy;

    public ChatRoom(String chatRoomName, User createdBy) {
        this.chatRoomName = chatRoomName;
        this.createdBy = createdBy;
    }
}
