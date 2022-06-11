package com.sid.gl.controllers;

import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.client.ClientPostDTO;
import com.sid.gl.entities.Client;
import com.sid.gl.exceptions.ResourceNotFoundException;
import com.sid.gl.metier.client.IClient;
import com.sid.gl.tools.ServeurResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private IClient iClient;

    public ClientController(IClient iClient) {
        this.iClient = iClient;
    }

    @GetMapping
    public ServeurResponse listClient(){
        ServeurResponse serveurResponse = new ServeurResponse();
        List<ClientGetDTO> clientGetDTOS = iClient.listClient();
        if(!clientGetDTOS.isEmpty()){
            serveurResponse.setDescription("liste des clients");
            serveurResponse.setStatut(true);
            serveurResponse.setData(clientGetDTOS);
        }else{
            serveurResponse.setDescription("liste vide");
            serveurResponse.setStatut(false);
            serveurResponse.setData(null);
        }
        return serveurResponse;
    }

    @PostMapping
    public ServeurResponse addClient(@RequestBody ClientPostDTO clientPostDTO){
        ServeurResponse serveurResponse = new ServeurResponse();
        Client client = iClient.addClient(clientPostDTO);
        if(!client.equals("")){
            serveurResponse.setDescription("client ajouté");
            serveurResponse.setStatut(true);
            serveurResponse.setData(client);
        }else{
            serveurResponse.setDescription("client non ajouté");
            serveurResponse.setStatut(false);
            serveurResponse.setData(null);
        }
        return serveurResponse;
    }


    @GetMapping("/{id}")
    public ServeurResponse getClient(@PathVariable("id") Long id){
        ServeurResponse serveurResponse = new ServeurResponse();
        ClientGetDTO clientGetDTO = iClient.getClient(id);
        if(!clientGetDTO.equals("")){
            serveurResponse.setDescription("client retrouvé");
            serveurResponse.setStatut(true);
            serveurResponse.setData(clientGetDTO);
        }else{
            serveurResponse.setDescription("client non trouvé");
            serveurResponse.setStatut(false);
            serveurResponse.setData(null);
        }
        return serveurResponse;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id")Long id) throws ResourceNotFoundException {
        iClient.deleteClient(id);
    }


}
