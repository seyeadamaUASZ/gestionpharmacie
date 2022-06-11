package com.sid.gl.DTO.medicament;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.gl.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentPostDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("codeMedicament")
    private String codeMedicament;
    @JsonProperty("prixu")
    private double prixu;
    @JsonProperty("stock")
    private int stock;
    @JsonProperty("categorie")
    private Categorie categorie;
    @JsonProperty("url_image")
    private String urlImage;
}
