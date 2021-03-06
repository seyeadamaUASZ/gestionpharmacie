package com.sid.gl.metier.client;

import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.client.ClientPostDTO;
import com.sid.gl.entities.Client;
import com.sid.gl.exceptions.ResourceNotFoundException;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.ClientRepository;
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
public class ClientImpl implements IClient{
    private ClientRepository repository;
    private ClientImplMapper doMapper;

    @Override
    public Client addClient(ClientPostDTO clientPostDTO) {
        return this.repository.save(doMapper.fromClientPostDto(clientPostDTO));
    }

    @Override
    public List<ClientGetDTO> listClient() {
        List<Client> listClients = this.repository.findAll();
        return listClients.stream()
                .map(client -> doMapper.fromClient(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientGetDTO getClient(Long id) {
        Optional<Client> client = this.repository.findById(id);
        if(client.isPresent()){
            Client cl = client.get();
            return doMapper.fromClient(cl);
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) throws ResourceNotFoundException {
        Optional<Client> client = this.repository.findById(id);
        if(client.isPresent()){
            this.repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Pas de client trouvé ");
        }

    }

    @Override
    public Integer countClients() {
        return this.repository.countClients();
    }

    @Override
    public void updateCLient(Long id,double montant) {
        Optional<Client> cl = this.repository.findById(id);
        if(cl.isPresent()){
            Client client  = cl.get();
            client.setId(id);
            client.setCredit(montant);
            this.repository.saveAndFlush(client);
        }
    }
}
