package com.learning.springBootBasicProject.Controllers;

import com.learning.springBootBasicProject.Entity.UserEntity;
import com.learning.springBootBasicProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public void addNewUser(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }

    @PutMapping("/{name}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity, @PathVariable String name){

        UserEntity user = userService.findByName(name);
        if(user != null){
            user.setName(userEntity.getName());
            user.setPassword(userEntity.getPassword());
            userService.saveUser(user);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
