package com.yubin.chat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ApplicationUser createUser(UserDto userdto) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(userdto.getUsername());
        applicationUser.setPassword(userdto.getPassword());
        applicationUser.setEmail(userdto.getEmail());
        applicationUser.setProfileImage(userdto.getProfileImage());

        return userRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 회원이 존재하지 않습니다."));
    }
}
