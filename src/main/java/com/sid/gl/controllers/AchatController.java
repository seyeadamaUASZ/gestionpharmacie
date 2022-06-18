package com.sid.gl.controllers;


import com.sid.gl.DTO.achat.AchatGetDTO;
import com.sid.gl.DTO.achat.AchatPostDTO;
import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.medicament.MedicamentGetDTO;
import com.sid.gl.entities.Achat;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.metier.achats.IAchat;
import com.sid.gl.metier.client.IClient;
import com.sid.gl.metier.medicament.IMedicament;
import com.sid.gl.tools.ServeurResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achat")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AchatController {

    private IAchat iAchat;

    private IMedicament iMedicament;

    private IClient iClient;

    private ClientImplMapper doMapper;

    @GetMapping
    public ServeurResponse listAchats(){
        ServeurResponse response = new ServeurResponse();
        List<AchatGetDTO> achatGetDTOS = iAchat.listAchats();
        if(!achatGetDTOS.isEmpty()){
            response.setStatut(true);
            response.setDescription("liste des achats");
            response.setData(achatGetDTOS);
        }else{
            response.setStatut(false);
            response.setDescription("liste vide");
            response.setData(null);
        }
        return response;
    }

    @PostMapping
    public ServeurResponse addAchat(@RequestBody AchatPostDTO achat){
        ServeurResponse response = new ServeurResponse();
        if(achat.getMedicament().getStock() < achat.getQuantite()){
            response.setStatut(false);
            response.setData(null);
            response.setDescription("La quantité demandée n'est pas disponible");
        }else{
            Achat achat1 = iAchat.addAchat(achat);
            if(achat1 !=null){
                //mis à jour du médicament
                MedicamentGetDTO medicament = iMedicament.getMedicament(achat.getMedicament().getId());
                int stockRestant = medicament.getStock() - achat.getQuantite();
                //mis à jour medicament
                iMedicament.updateMedicament(medicament.getId(),stockRestant);
                //condition sur la nulleté du client
                if(achat.getClient() != null){
                    ClientGetDTO clientGetDTO = iClient.getClient(achat.getClient().getId());
                    if(achat.getTypeAchat().equals("credit")){
                        double creditCLient = clientGetDTO.getCredit() + achat.getTotalPrice();
                        iClient.updateCLient(clientGetDTO.getId(),creditCLient);
                    }
                }
                //mis à jour client
                response.setStatut(true);
                response.setDescription("transaction ajoutée");
                response.setData(achat1);
            }else{
                response.setStatut(false);
                response.setDescription("transaction non ajoutée");
                response.setData(null);
            }
        }

        return response;
    }

    @GetMapping("/count")
    public ServeurResponse countAchat(){
        ServeurResponse response = new ServeurResponse();
        Integer counts = iAchat.countAchats();
        response.setData(counts);
        response.setDescription("nombre achats");
        return response;
    }
}
