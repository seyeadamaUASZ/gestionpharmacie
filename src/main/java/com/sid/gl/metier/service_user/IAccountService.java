package com.sid.gl.metier.service_user;

import com.sid.gl.DTO.users.UserGetDTO;
import com.sid.gl.DTO.users.UserPostDTO;
import com.sid.gl.entities.User;

public interface IAccountService {
    UserGetDTO findUserByTelephone(String telephone);
    User login(UserPostDTO userPostDTO);
    User addUser(UserPostDTO userPostDTO);
    boolean verification(String password, String passwordHash);
}
