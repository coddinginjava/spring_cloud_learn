package com.sai.UsersMS.service;

import com.sai.UsersMS.entity.UserEntity;
import com.sai.UsersMS.repo.UserRepo;
import com.sai.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UsersService{

    private ModelMapper modelMapper;

    private UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());

        System.out.println("modelMapper.getConfiguration().getMatchingStrategy()   ===> " +modelMapper.getConfiguration().getMatchingStrategy());

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        String encode = bCryptPasswordEncoder.encode(userDTO.getPassword());

        System.out.println("encode = " + encode);

        userEntity.setEncryptedPassword(encode);


        userRepo.save(userEntity);


        System.out.println("userEntity = " + userEntity);

        return userDTO;
    }
}
