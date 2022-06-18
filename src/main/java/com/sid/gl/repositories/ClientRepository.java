package com.sid.gl.repositories;

import com.sid.gl.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("select count(c) from Client c")
    public Integer countClients();
}
