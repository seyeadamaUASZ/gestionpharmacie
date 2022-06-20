package com.sid.gl.metier.profil;

import com.sid.gl.DTO.profil.ProfilDTO;
import com.sid.gl.entities.Profil;

import java.util.List;

public interface IProfil {
    Profil addProfil(ProfilDTO profilDTO);
    List<ProfilDTO> listProfils();
}
