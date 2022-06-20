package com.sid.gl.controllers;


import com.sid.gl.DTO.users.UserGetDTO;
import com.sid.gl.DTO.users.UserPostDTO;
import com.sid.gl.entities.User;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.metier.service_user.IAccountService;
import com.sid.gl.repositories.UserRepository;
import com.sid.gl.tools.ServeurResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/auth")
public class SecurityRestController {
    private IAccountService iAccountService;
    private BCryptPasswordEncoder encoder;
    private ClientImplMapper doMapper;
    private UserRepository repo;

    @PostMapping("/login")
    public ServeurResponse login(@RequestBody UserPostDTO userbody){
        ServeurResponse response = new ServeurResponse();
        User user = iAccountService.login(userbody);
        if(user!=null){
            response.setStatut(true);
            response.setDescription("Authentification réussie");
            response.setData(user);
        }else{
            response.setStatut(false);
            response.setDescription("Authentification non réussie");
            response.setData(null);
        }
        return response;
    }

    @PostMapping("/addUser")
    public ServeurResponse addUser(@RequestBody UserPostDTO userPostDTO){
        ServeurResponse response = new ServeurResponse();
        User user = doMapper.fromUserPostDTO(userPostDTO);
        String codeencode = encoder.encode(user.getPassword());
        user.setPassword(codeencode);
        User user1=this.iAccountService.addUser(user);
        if(user1 !=null){
            response.setStatut(true);
            response.setDescription("utilisateur créé");
            response.setData(user1);
        }else{
            response.setStatut(false);
            response.setDescription("utilisateur non créé");
            response.setData(null);
        }
        return response;

    }


    @GetMapping("/users")
    public ServeurResponse listUsers(){
        ServeurResponse response = new ServeurResponse();
        List<User> users = iAccountService.listUsers();
        List<UserGetDTO> userGetDTOS = users.stream()
                .map(user -> doMapper.fromUser(user))
                .collect(Collectors.toList());
        if(userGetDTOS.isEmpty()){
            response.setData(null);
            response.setDescription("liste vide");
            response.setStatut(false);
        }else{
            response.setData(userGetDTOS);
            response.setDescription("liste des utilisateurs");
            response.setStatut(true);
        }
        return response;
    }



}
