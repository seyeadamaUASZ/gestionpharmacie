package com.sid.gl.metier.categorie;

import com.sid.gl.DTO.categorie.CategorieGetDTO;
import com.sid.gl.DTO.categorie.CategoriePostDTO;
import com.sid.gl.entities.Categorie;
import com.sid.gl.exceptions.ResourceNotFoundException;
import com.sid.gl.mappers.ClientImplMapper;
import com.sid.gl.repositories.CategorieRepository;
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
public class ICategorieImpl implements ICategorie {
    private CategorieRepository repository;
    private ClientImplMapper doMapper;

    @Override
    public Categorie addCategorie(CategoriePostDTO categoriePostDTO) {
        return this.repository.save(doMapper.fromCategoriePostDTo(categoriePostDTO));
    }

    @Override
    public List<CategorieGetDTO> listCategories() {
        List<Categorie> categories = this.repository.findAll();

        return categories.stream()
                .map(categorie -> doMapper.fromCategorie(categorie))
                .collect(Collectors.toList());
    }

    @Override
    public CategorieGetDTO getCategorie(Long id) {
        Optional<Categorie> categorie = this.repository.findById(id);
        if(categorie.isPresent()){
            Categorie cat = categorie.get();
            return doMapper.fromCategorie(cat);
        }
        return null;
    }


    @Override
    public void deleteCategorie(Long id) throws ResourceNotFoundException {
     Optional<Categorie> categorieOptional = this.repository.findById(id);
     if(categorieOptional.isPresent()){
         this.repository.deleteById(id);
     }else{
         throw new ResourceNotFoundException("cette categorie n'existe pas !!");
     }
    }
}
