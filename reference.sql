-- 사용자 테이블 생성
CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_username VARCHAR(50) NOT NULL,
    user_email VARCHAR(100),
    user_password VARCHAR(100) NOT NULL,
    user_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    user_refresh_token TEXT,
    user_profile_image TEXT,
    user_oauth_provider VARCHAR(50),
    role VARCHAR(50) NOT NULL
);

-- 채팅방 테이블 생성
CREATE TABLE chatroom (
    chatroom_id INT AUTO_INCREMENT PRIMARY KEY,
    chatroom_name VARCHAR(100) NOT NULL,
    chatroom_creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    chatroom_created_by_user_id INT,
    FOREIGN KEY (chatroom_created_by_user_id) REFERENCES user(user_id)
);

-- 메시지 테이블 생성
CREATE TABLE message (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    message_chatroom_id INT,
    message_user_id INT,
    message_content TEXT NOT NULL,
    message_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    message_reply_to_message_id INT DEFAULT NULL,
    FOREIGN KEY (message_chatroom_id) REFERENCES chatroom(chatroom_id),
    FOREIGN KEY (message_user_id) REFERENCES user(user_id),
    FOREIGN KEY (message_reply_to_message_id) REFERENCES message(message_id)
);

-- 채팅방 멤버 테이블 생성
CREATE TABLE chatroom_member (
    chatroom_member_chatroom_id INT,
    chatroom_member_user_id INT,
    chatroom_member_user_join_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (chatroom_member_chatroom_id, chatroom_member_user_id),
    FOREIGN KEY (chatroom_member_chatroom_id) REFERENCES chatroom(chatroom_id),
    FOREIGN KEY (chatroom_member_user_id) REFERENCES user(user_id)
);