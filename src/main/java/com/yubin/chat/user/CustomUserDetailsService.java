package com.yubin.chat.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        ApplicationUser applicationUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 회원이 존재하지 않습니다."));

        return User.builder()
                .username(applicationUser.getUsername())
                .password(applicationUser.getPassword())
                .roles("USER")
                .build();
                //.disabled(!applicationUser.isVerified())
                //.accountExpired(applicationUser.isAccountCredentialIsExpired())
                //.accountLocked(applicationUser.isLocked())
        // ;
    }

}
