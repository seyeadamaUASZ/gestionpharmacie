package com.sid.gl.metier.achats;

import com.sid.gl.DTO.achat.AchatGetDTO;
import com.sid.gl.DTO.achat.AchatPostDTO;
import com.sid.gl.entities.Achat;

import java.util.List;

public interface IAchat {
    Achat addAchat(AchatPostDTO achatPostDTO);
    List<AchatGetDTO> listAchats();
    Integer countAchats();
}
