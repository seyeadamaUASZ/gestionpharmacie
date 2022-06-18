package com.sid.gl.metier.achats;

import com.sid.gl.DTO.achat.AchatGetDTO;
import com.sid.gl.DTO.achat.AchatPostDTO;
import com.sid.gl.entities.Achat;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.AchatRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class AchatImpl implements IAchat{
    private AchatRepository achatRepository;
    private ClientImplMapper doMapper;

    @Override
    public Achat addAchat(AchatPostDTO achatPostDTO) {
        return this.achatRepository.save(doMapper.fromAchatPostDto(achatPostDTO));
    }

    @Override
    public List<AchatGetDTO> listAchats() {
        List<Achat> achats = this.achatRepository.findAll();
        return achats.stream()
                .map(achat -> doMapper.fromAchat(achat))
                .collect(Collectors.toList());
    }

    @Override
    public Integer countAchats() {
        return this.achatRepository.countAchats();
    }


}
