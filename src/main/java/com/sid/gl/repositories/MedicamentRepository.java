package com.sid.gl.repositories;

import com.sid.gl.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
}
