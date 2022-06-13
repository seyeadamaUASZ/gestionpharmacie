package com.sid.gl.metier.medicament;

import com.sid.gl.DTO.medicament.MedicamentGetDTO;
import com.sid.gl.DTO.medicament.MedicamentPostDTO;
import com.sid.gl.entities.Medicament;
import com.sid.gl.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IMedicament {
    public Medicament addMedicament(MedicamentPostDTO medicament);
    public List<MedicamentGetDTO> listMedicaments();
    public MedicamentGetDTO getMedicament(Long id);

    public void deleteMedicament(Long id) throws ResourceNotFoundException;

}
