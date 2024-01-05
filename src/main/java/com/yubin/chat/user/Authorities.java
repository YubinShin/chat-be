package com.yubin.chat.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {

    @Id
    @Column(name = "authorities_username")
    private String username;

    @Column(name = "authorities_authority")
    private String authority;

    // 여기서 User 클래스는 'user' 테이블에 매핑된 JPA 엔티티를 가정합니다.
    // 외래키 제약조건을 정의합니다.
    @ManyToOne
    @JoinColumn(name = "authorities_username", referencedColumnName = "user_username", foreignKey = @ForeignKey(name = "fk_authorities_users"), insertable = false, updatable = false)
    private ApplicationUser applicationUser;
}
