package com.sid.gl.DTO.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPostDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("adresse")
    private String adresse;
    @JsonProperty("credit")
    private double credit;
}
