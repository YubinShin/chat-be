-- 사용자 테이블 생성
CREATE TABLE User (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    Password VARCHAR(100) NOT NULL,
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    RefreshToken TEXT,
    ProfileImage TEXT,
    OAuthProvider VARCHAR(50)
);

-- 채팅방 테이블 생성
CREATE TABLE ChatRoom (
    ChatRoomID INT AUTO_INCREMENT PRIMARY KEY,
    ChatRoomName VARCHAR(100) NOT NULL,
    CreationDate DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 메시지 테이블 생성
CREATE TABLE Message (
    MessageID INT AUTO_INCREMENT PRIMARY KEY,
    ChatRoomID INT,
    UserID INT,
    MessageContent TEXT NOT NULL,
    Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    ReplyToMessageID INT DEFAULT NULL,
    FOREIGN KEY (ChatRoomID) REFERENCES ChatRoom(ChatRoomID),
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (ReplyToMessageID) REFERENCES Message(MessageID)
);

-- 채팅방 멤버 테이블 생성
CREATE TABLE ChatRoomMember (
    ChatRoomID INT,
    UserID INT,
    JoinDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ChatRoomID, UserID),
    FOREIGN KEY (ChatRoomID) REFERENCES ChatRoom(ChatRoomID),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);