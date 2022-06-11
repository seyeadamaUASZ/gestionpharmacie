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
    @JsonProperty("nomMedicament")
    private String nomMedicament;
    @JsonProperty("categorie")
    private Categorie categorie;
    @JsonProperty("urlImage")
    private String urlImage;
}
