package com.sid.gl.metier.client;

import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.client.ClientPostDTO;
import com.sid.gl.entities.Client;
import com.sid.gl.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IClient {
    Client addClient(ClientPostDTO clientPostDTO);
    List<ClientGetDTO> listClient();
    ClientGetDTO getClient(Long id);
    void deleteClient(Long id) throws ResourceNotFoundException;

    public Integer countClients();

    void updateCLient(Long id,double montant);
}
