package com.sid.gl.controllers;


import com.sid.gl.DTO.users.UserPostDTO;
import com.sid.gl.entities.User;
import com.sid.gl.metier.service_user.IAccountService;
import com.sid.gl.tools.ServeurResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityRestController {
    private IAccountService iAccountService;
    private BCryptPasswordEncoder encoder;

    @PostMapping("user/login")
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

    @PostMapping("user/addUser")
    public ServeurResponse addUser(@RequestBody UserPostDTO userPostDTO){
        ServeurResponse response = new ServeurResponse();
        User user = iAccountService.addUser(userPostDTO);
        if(user!=null){
          response.setStatut(true);
          response.setDescription("Utilisateur créé");
          response.setData(user);
        }else{
            response.setStatut(false);
            response.setDescription("Utilisateur non créé");
            response.setData(null);
        }
        return response;
    }



}
