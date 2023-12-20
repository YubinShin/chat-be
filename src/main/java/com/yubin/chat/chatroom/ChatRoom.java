package com.yubin.chat.chatroom;

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

    @Column
    private int createdByUserID;

    public ChatRoom(String chatRoomName, int createdByUserID) {
        this.chatRoomName = chatRoomName;
        this.createdByUserID = createdByUserID;
    }
}
