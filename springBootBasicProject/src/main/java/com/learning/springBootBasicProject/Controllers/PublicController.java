package com.learning.springBootBasicProject.Controllers;

import com.learning.springBootBasicProject.Entity.UserEntity;
import com.learning.springBootBasicProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;


    @GetMapping("/health-Check")
    public String healthCheck(){
        return  "OK";
    }

    @PostMapping("/addNewUser")
    public void addNewUser(@RequestBody UserEntity userEntity){
        userService.saveNewUser(userEntity);
    }
}
