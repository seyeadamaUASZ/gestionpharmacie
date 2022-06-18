package com.sid.gl.repositories;

import com.sid.gl.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {

    @Query("select count(m) from Medicament m")
    public Integer countMedicamentsById();
}
