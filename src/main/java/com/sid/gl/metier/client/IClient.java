package com.sid.gl.metier.client;

import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.client.ClientPostDTO;
import com.sid.gl.entities.Client;
import com.sid.gl.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IClient {
    public Client addClient(ClientPostDTO clientPostDTO);
    public List<ClientGetDTO> listClient();
    public ClientGetDTO getClient(Long id);
    public void deleteClient(Long id) throws ResourceNotFoundException;
}
