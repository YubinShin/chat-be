package com.yubin.chat.chatroom;

import com.yubin.chat.chatroommember.ChatRoomMember;
import com.yubin.chat.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "chatroom_owner_user_id", nullable = false)
    private User chatroomOwner; // 변경된 부분

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatRoomMember> chatRoomMembers = new ArrayList<>();
}
