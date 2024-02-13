package com.sparta.newsfeed.entity;

import com.sparta.newsfeed.dto.request.UserInfoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mbti;

    public User(String username, String password, String email, String mbti) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mbti = mbti;
    }

    public void userInfoUpdate(UserInfoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
        this.mbti = requestDto.getMbti();
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
