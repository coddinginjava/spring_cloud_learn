package com.sai.UsersMS.controller;

import com.sai.dto.CreateUserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String getStatus(){
        return "working!!!" + " in the port number  -> " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@RequestBody  CreateUserRequestModel userDetails){
        return "Create user  method is called" + userDetails;
    }
}
