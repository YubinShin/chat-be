package com.yubin.chat.chatroommember;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomMemberId implements Serializable {

    private int chatRoomId;
    private int userId;

    // 생성자, getter, setter 등

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatRoomMemberId that = (ChatRoomMemberId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(chatRoomId, that.chatRoomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatRoomId);
    }
}
