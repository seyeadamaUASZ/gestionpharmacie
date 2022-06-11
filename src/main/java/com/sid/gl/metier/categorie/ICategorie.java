package com.sid.gl.metier.categorie;

import com.sid.gl.DTO.categorie.CategorieGetDTO;
import com.sid.gl.DTO.categorie.CategoriePostDTO;
import com.sid.gl.entities.Categorie;
import com.sid.gl.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICategorie {
    public Categorie addCategorie(CategoriePostDTO categoriePostDTO);
    public List<CategorieGetDTO> listCategories();
    public CategorieGetDTO getCategorie(Long id);
    public void deleteCategorie(Long id) throws ResourceNotFoundException;
}
