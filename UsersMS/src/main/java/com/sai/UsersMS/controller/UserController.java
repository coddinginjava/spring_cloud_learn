package com.sai.UsersMS.controller;

import com.sai.UsersMS.service.UsersService;
import com.sai.dto.CreateUserRequestModel;
import com.sai.dto.UserDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final Environment env;
    private final UsersService usersService;
    private ModelMapper modelMapper;

    @GetMapping("/status/check")
    public String getStatus(){
        return "working!!!" + " in the port number  -> " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid  @RequestBody CreateUserRequestModel userDetails){

        try{
            UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
            UserDTO user = usersService.createUser(userDTO);
            return  new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
