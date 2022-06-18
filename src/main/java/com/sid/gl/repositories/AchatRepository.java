package com.sid.gl.repositories;

import com.sid.gl.entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AchatRepository extends JpaRepository<Achat,Long> {

    @Query("select count(a) from Achat a")
    public Integer countAchats();
}
