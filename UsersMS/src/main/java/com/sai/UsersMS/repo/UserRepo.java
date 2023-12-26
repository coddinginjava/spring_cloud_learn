package com.sai.UsersMS.repo;


import com.sai.UsersMS.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<UserEntity,Long> {

}
