package com.sid.gl.controllers;

import com.sid.gl.DTO.profil.ProfilDTO;
import com.sid.gl.entities.Profil;
import com.sid.gl.metier.profil.IProfil;
import com.sid.gl.tools.ServeurResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profil")
@Slf4j
@CrossOrigin(origins="*")
@AllArgsConstructor
public class ProfilController {
    private IProfil iProfil;

    @PostMapping
    public ServeurResponse addProfil(@RequestBody ProfilDTO profilDTO){
        ServeurResponse response = new ServeurResponse();
        Profil profil = iProfil.addProfil(profilDTO);
        if(profil!=null){
            response.setData(profil);
            response.setStatut(true);
            response.setDescription("Le profil est ajouté");
        }else{
            response.setData(null);
            response.setStatut(false);
            response.setDescription("Le profil n'est pas ajouté");
        }
        return response;
    }


    @GetMapping
    public ServeurResponse listProfil(){
        ServeurResponse response = new ServeurResponse();
        List<ProfilDTO> profilDTOS = iProfil.listProfils();
        if(!profilDTOS.isEmpty()){
            response.setData(profilDTOS);
            response.setStatut(true);
            response.setDescription("liste des profils");
        }else{
            response.setData(null);
            response.setStatut(false);
            response.setDescription("liste vide");
        }
        return response;
    }
}
