package com.wartinder.user.controller;

import com.wartinder.user.entity.User;
import com.wartinder.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        User newUser = User.builder()
                .name(user.getName())
                .mail(user.getMail())
                .phone(user.getPhone())
                .imgProfile(user.getImgProfile())
                .imgFrontpage(user.getImgFrontpage())
                .description(user.getDescription())
                .gender(user.getGender())
                .build();
        return ResponseEntity.ok(userService.saveUser(newUser));
    }
    @GetMapping("/userlist")
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userService.listUser());
    }
}
