package com.sid.gl.controllers;

import com.sid.gl.DTO.categorie.CategorieGetDTO;
import com.sid.gl.DTO.categorie.CategoriePostDTO;
import com.sid.gl.entities.Categorie;
import com.sid.gl.exceptions.ResourceNotFoundException;
import com.sid.gl.metier.categorie.ICategorie;
import com.sid.gl.tools.ServeurResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "*")
public class CategorieController {
    private ICategorie iCategorie;

    public CategorieController(ICategorie iCategorie) {
        this.iCategorie = iCategorie;
    }

    @GetMapping
    public ServeurResponse listCategories(){
        ServeurResponse response = new ServeurResponse();
        List<CategorieGetDTO> categoriesGetDTOS = iCategorie.listCategories();
        if(!categoriesGetDTOS.isEmpty()){
            response.setStatut(true);
            response.setDescription("liste des catégories");
            response.setData(categoriesGetDTOS);
        }else{
            response.setStatut(false);
            response.setDescription("liste vide");
            response.setData(null);
        }
        return response;
    }


    @PostMapping
    public ServeurResponse addCategorie(@RequestBody CategoriePostDTO categoriePostDTO){
        ServeurResponse response = new ServeurResponse();
        Categorie categorie = iCategorie.addCategorie(categoriePostDTO);
        if(categorie!=null){
            response.setStatut(true);
            response.setDescription("categorie ajoutée ");
            response.setData(categorie);
        }else{
            response.setStatut(false);
            response.setDescription("catégorie non ajoutée ");
            response.setData(null);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ServeurResponse getCategorie(@PathVariable("id")Long id){
        ServeurResponse response = new ServeurResponse();
       CategorieGetDTO categorie = iCategorie.getCategorie(id);
        if(categorie!=null){
            response.setStatut(true);
            response.setDescription("categorie trouvée ");
            response.setData(categorie);
        }else{
            response.setStatut(false);
            response.setDescription("catégorie non trouvée ");
            response.setData(null);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable("id") Long id) throws ResourceNotFoundException {
        iCategorie.deleteCategorie(id);
    }



}
