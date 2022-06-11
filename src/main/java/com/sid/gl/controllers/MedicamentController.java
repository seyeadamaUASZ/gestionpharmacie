package com.sid.gl.controllers;

import com.sid.gl.DTO.medicament.MedicamentGetDTO;
import com.sid.gl.DTO.medicament.MedicamentPostDTO;
import com.sid.gl.entities.Medicament;
import com.sid.gl.metier.medicament.IMedicament;
import com.sid.gl.tools.ServeurResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
    private IMedicament iMedicament;

    public MedicamentController(IMedicament iMedicament) {
        this.iMedicament = iMedicament;
    }

    @GetMapping
    public ServeurResponse listMedicament(){
        ServeurResponse serveurResponse = new ServeurResponse();
        List<MedicamentGetDTO> medicamentGetDTOS = iMedicament.listMedicaments();
        if(!medicamentGetDTOS.isEmpty()){
            serveurResponse.setData(null);
            serveurResponse.setDescription("liste vide");
            serveurResponse.setStatut(false);
        }else{
            serveurResponse.setData(medicamentGetDTOS);
            serveurResponse.setDescription("liste des médicaments");
            serveurResponse.setStatut(true);
        }
        return serveurResponse;
    }

    @PostMapping
    public ServeurResponse addMedicament(@RequestBody MedicamentPostDTO medicamentPostDTO){
        ServeurResponse serveurResponse = new ServeurResponse();
        Medicament medicament=iMedicament.addMedicament(medicamentPostDTO);
        if(!medicament.equals("")){
            serveurResponse.setStatut(true);
            serveurResponse.setData(medicament);
            serveurResponse.setDescription("médicament ajouté avec succés");
        }else{
            serveurResponse.setStatut(false);
            serveurResponse.setData(null);
            serveurResponse.setDescription("Erreur sur l'ajout ");
        }
        return serveurResponse;

    }
    @GetMapping("/{id}")
    public ServeurResponse checkMedicament(@PathVariable("id") Long id){
        ServeurResponse serveurResponse = new ServeurResponse();
        MedicamentGetDTO medicament = iMedicament.getMedicament(id);
        if(!medicament.equals("")){
            serveurResponse.setStatut(true);
            serveurResponse.setData(medicament);
            serveurResponse.setDescription("médicament recupéré");
        }else{
            serveurResponse.setStatut(false);
            serveurResponse.setData(null);
            serveurResponse.setDescription("medicament non récupéré ");
        }
        return serveurResponse;
    }


}
