package com.yubin.chat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResources {

    @Autowired
    private UserDaoService service;

    @GetMapping(path="/users")
    public List<ApplicationUser> retrieveAllUser() {
        return service.findAllUser();
    }

    @GetMapping(path="/users?username={username}")
    public ApplicationUser retrieveUser(@RequestParam String username) {
        return service.findByUsername(username);
    }

    @PostMapping(path="/users/register")
    public String registerUser(@RequestBody UserDto userDto) {
        service.createUser(userDto);
        return "redirect:/successPage";
    }

    @PatchMapping(path="/users/{username}")
    public String editUser(@PathVariable String username) {
        return "edited success";
    }

    @DeleteMapping(path="/users/{username}")
    public String deleteUser(@PathVariable String username) {
        return "deleted success";
    }
}
