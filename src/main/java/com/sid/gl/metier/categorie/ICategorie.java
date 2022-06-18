package com.sid.gl.metier.categorie;

import com.sid.gl.DTO.categorie.CategorieGetDTO;
import com.sid.gl.DTO.categorie.CategoriePostDTO;
import com.sid.gl.entities.Categorie;
import com.sid.gl.exceptions.ResourceNotFoundException;

import java.util.List;


public interface ICategorie {
     Categorie addCategorie(CategoriePostDTO categoriePostDTO);
     List<CategorieGetDTO> listCategories();
     CategorieGetDTO getCategorie(Long id);
     void deleteCategorie(Long id) throws ResourceNotFoundException;


}
