package com.sid.gl.metier.profil;

import com.sid.gl.DTO.profil.ProfilDTO;
import com.sid.gl.entities.Profil;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.ProfilRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProfilImpl implements IProfil{
    private ProfilRepository repository;
    private ClientImplMapper doMapper;

    @Override
    public Profil addProfil(ProfilDTO profilDTO) {
        return this.repository.save(doMapper.fromProfilDTO(profilDTO));
    }

    @Override
    public List<ProfilDTO> listProfils() {
        List<Profil> profils = this.repository.findAll();
        return profils.stream()
                .map(profil -> doMapper.fromProfil(profil))
                .collect(Collectors.toList());
    }
}
