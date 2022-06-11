package com.sid.gl.mappers;

import com.sid.gl.DTO.achat.AchatGetDTO;
import com.sid.gl.DTO.categorie.CategorieGetDTO;
import com.sid.gl.DTO.categorie.CategoriePostDTO;
import com.sid.gl.DTO.client.ClientGetDTO;
import com.sid.gl.DTO.client.ClientPostDTO;
import com.sid.gl.DTO.medicament.MedicamentGetDTO;
import com.sid.gl.DTO.medicament.MedicamentPostDTO;
import com.sid.gl.entities.Achat;
import com.sid.gl.entities.Categorie;
import com.sid.gl.entities.Client;
import com.sid.gl.entities.Medicament;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientImplMapper {

    public ClientGetDTO fromClient(Client client){
        ClientGetDTO clientGetDTO = new ClientGetDTO();
        BeanUtils.copyProperties(client,clientGetDTO);
        return clientGetDTO;
    }

    /*public ClientGetDTO opTionalfromClient(Optional<Client> client){
        ClientGetDTO clientGetDTO = new ClientGetDTO();
        BeanUtils.copyProperties(client,clientGetDTO);
        return clientGetDTO;
    }*/

    public Client fromClientPostDto(ClientPostDTO clientPostDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientPostDTO,client);
        return client;
    }

    public AchatGetDTO fromAchat(Achat achat){
        AchatGetDTO achatGetDTO = new AchatGetDTO();
        BeanUtils.copyProperties(achat,achatGetDTO);
        return achatGetDTO;
    }

   /* public Achat fromAchatPostDto(AchatPostDTO achatPostDTO){
        Achat achat = new Achat();
        BeanUtils.copyProperties(achatPostDTO,achat);
        return achat;
    }*/

   public Categorie fromCategoriePostDTo(CategoriePostDTO categoriePostDTO){
       Categorie categorie = new Categorie();
       BeanUtils.copyProperties(categoriePostDTO,categorie);
       return categorie;
   }

   public CategorieGetDTO fromCategorie(Categorie categorie){
       CategorieGetDTO  categorieGetDTO = new CategorieGetDTO();
       BeanUtils.copyProperties(categorie,categorieGetDTO);
       return categorieGetDTO;
   }



   /*public Optional<CategorieGetDTO>  oPtioncategorieToCategorieGetDTO(Optional<Categorie> categorie){
       Optional<CategorieGetDTO> categorieGetDTO= Optional.of(new CategorieGetDTO());
       BeanUtils.copyProperties(categorie,categorieGetDTO);
       System.out.println(categorie);
       return categorieGetDTO;
   }*/

   public Medicament fromMedicamentPostDTO(MedicamentPostDTO medicamentPostDTO){
       Medicament medicament = new Medicament();
       BeanUtils.copyProperties(medicamentPostDTO,medicament);
       return medicament;
   }

   public MedicamentGetDTO fromMedicament(Medicament medicament){
       MedicamentGetDTO medicamentGetDTO = new MedicamentGetDTO();
       BeanUtils.copyProperties(medicament,medicamentGetDTO);
       return medicamentGetDTO;
   }

    /*public MedicamentGetDTO optionalfromMedicament(Optional<Medicament> medicament){
        MedicamentGetDTO medicamentGetDTO = new MedicamentGetDTO();
        BeanUtils.copyProperties(medicament,medicamentGetDTO);
        return medicamentGetDTO;
    }*/
}
