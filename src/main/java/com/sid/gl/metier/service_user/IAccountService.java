package com.sid.gl.metier.service_user;

import com.sid.gl.DTO.users.UserGetDTO;
import com.sid.gl.DTO.users.UserPostDTO;
import com.sid.gl.entities.User;

import java.util.List;

public interface IAccountService {
    UserGetDTO findUserByTelephone(String telephone);
    User login(UserPostDTO userPostDTO);
    boolean verification(String password, String passwordHash);
    User addUser(User  user);
    List<User> listUsers();
}
