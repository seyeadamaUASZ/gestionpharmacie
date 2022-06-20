package com.sid.gl.metier.service_user;

import com.sid.gl.DTO.users.UserGetDTO;
import com.sid.gl.DTO.users.UserPostDTO;
import com.sid.gl.entities.User;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class IAccountServiceImpl implements IAccountService {
    private UserRepository repository;
    private ClientImplMapper doMapper;
    private BCryptPasswordEncoder encoder;

    @Override
    public UserGetDTO findUserByTelephone(String telephone) {
        return doMapper.fromUser(this.repository.findUserByTelephone(telephone));
    }

    @Override
    public User login(UserPostDTO userPostDTO) {
        User user = this.repository.findUserByTelephone(userPostDTO.getTelephone());
        if(user !=null){
            boolean verif = verification(userPostDTO.getPassword(), user.getPassword());
            if(verif){
                return user;
            }else{
                return null;
            }
        }
        return null;
    }


    @Override
    public boolean verification(String password, String passwordHash) {
        return encoder.matches(password, passwordHash);
    }

    @Override
    public User addUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return this.repository.findAll();
    }


}
