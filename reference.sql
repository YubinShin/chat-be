-- Create `chatroom` table
CREATE TABLE chatroom (
    chatroom_id INT NOT NULL AUTO_INCREMENT,
    chatroom_creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    chatroom_name VARCHAR(100) NOT NULL,
    chatroom_owner_user_id INT NOT NULL,
    PRIMARY KEY (chatroom_id)
) ENGINE=InnoDB;

-- Create `chatroom_member` table
CREATE TABLE chatroom_member (
    chatroom_member_user_join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    chatroom_member_chatroom_id INT NOT NULL,
    chatroom_member_user_id INT NOT NULL,
    PRIMARY KEY (chatroom_member_chatroom_id, chatroom_member_user_id)
) ENGINE=InnoDB;

-- Create `message` table
CREATE TABLE message (
    message_id INT NOT NULL AUTO_INCREMENT,
    message_content TEXT NOT NULL,
    message_timestamp DATETIME(6) NOT NULL,
    message_chatroom_id INT,
    message_reply_to_message_id INT,
    message_user_id INT,
    PRIMARY KEY (message_id)
) ENGINE=InnoDB;

-- Create `user` table
CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_created_at DATETIME(6) NOT NULL,
    user_email VARCHAR(255),
    user_oauth_provider VARCHAR(255),
    user_password VARCHAR(255) NOT NULL,
    user_profile_image VARCHAR(255),
    user_refresh_token VARCHAR(255),
    role ENUM('USER', 'ADMIN', 'MANAGER'),
    user_updated_at DATETIME(6) NOT NULL,
    user_username VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB;

-- Add foreign keys
ALTER TABLE chatroom
    ADD CONSTRAINT FK_chatroom_user FOREIGN KEY (chatroom_owner_user_id)
    REFERENCES user (user_id);

ALTER TABLE chatroom_member
    ADD CONSTRAINT FK_chatroom_member_chatroom FOREIGN KEY (chatroom_member_chatroom_id)
    REFERENCES chatroom (chatroom_id);

ALTER TABLE chatroom_member
    ADD CONSTRAINT FK_chatroom_member_user FOREIGN KEY (chatroom_member_user_id)
    REFERENCES user (user_id);

ALTER TABLE message
    ADD CONSTRAINT FK_message_chatroom FOREIGN KEY (message_chatroom_id)
    REFERENCES chatroom (chatroom_id);

ALTER TABLE message
    ADD CONSTRAINT FK_message_reply_message FOREIGN KEY (message_reply_to_message_id)
    REFERENCES message (message_id);

ALTER TABLE message
    ADD CONSTRAINT FK_message_user FOREIGN KEY (message_user_id)
    REFERENCES user (user_id);
