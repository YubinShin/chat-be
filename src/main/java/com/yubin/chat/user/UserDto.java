package com.yubin.chat.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty()
    private String username;

    @NotEmpty()
    private String email;

    @NotEmpty()
    private String password;

    @NotEmpty()
    private String confirmPassword;

    @NotEmpty()
    private String profileImage;
}
