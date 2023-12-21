package com.yubin.chat.chatroommember;

import com.yubin.chat.chatroom.ChatRoom;
import com.yubin.chat.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatroom_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomMember {

    @EmbeddedId
    private ChatRoomMemberId id;

    @MapsId("chatRoomId")
    @ManyToOne
    @JoinColumn(name = "chatroom_member_chatroom_id")
    private ChatRoom chatRoom;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "chatroom_member_user_id")
    private User user;

    @Column(name = "chatroom_member_user_join_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime joinDate;

}
