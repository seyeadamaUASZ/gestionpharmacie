package com.sid.gl.metier.medicament;

import com.sid.gl.DTO.medicament.MedicamentGetDTO;
import com.sid.gl.DTO.medicament.MedicamentPostDTO;
import com.sid.gl.entities.Medicament;
import com.sid.gl.exceptions.ResourceNotFoundException;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.MedicamentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class MedicamentImpl implements IMedicament{
    private MedicamentRepository repository;
    private ClientImplMapper doMapper;

    @Override
    public Medicament addMedicament(MedicamentPostDTO medicament) {
        return this.repository.save(doMapper.fromMedicamentPostDTO(medicament));
    }

    @Override
    public List<MedicamentGetDTO> listMedicaments() {
        List<Medicament> medicaments = this.repository.findAll();
        return medicaments.stream()
                .map(medicament -> doMapper.fromMedicament(medicament))
                .collect(Collectors.toList());
    }

    @Override
    public MedicamentGetDTO getMedicament(Long id) {
        Optional<Medicament> medicament = this.repository.findById(id);
        if(medicament.isPresent()){
            Medicament med = medicament.get();
            return doMapper.fromMedicament(med);
        }
        return null;
    }

    @Override
    public void deleteMedicament(Long id) throws ResourceNotFoundException {
        Optional<Medicament> medicament = this.repository.findById(id);
        if(medicament.isPresent()){
            this.repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Identifiant medicament non existant !");
        }
    }
}
