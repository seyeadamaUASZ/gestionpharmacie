package com.sid.gl.DTO.categorie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieGetDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("urlCategorie")
    private String urlCategorie;
}
