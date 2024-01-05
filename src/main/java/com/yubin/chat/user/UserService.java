package com.yubin.chat.user;

public interface UserService {

    ApplicationUser createUser(UserDto userdto);

    ApplicationUser findByUsername(String username);

}
