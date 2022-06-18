package com.sid.gl.DTO.achat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.gl.entities.Client;
import com.sid.gl.entities.Medicament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchatPostDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("medicament")
    private Medicament medicament;
    @JsonProperty("quantite")
    private int quantite;
    @JsonProperty("totalPrice")
    private double totalPrice;
    @JsonProperty("typeAchat")
    private String typeAchat;

}
