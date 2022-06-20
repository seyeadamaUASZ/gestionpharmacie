package com.sid.gl.DTO.profil;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameProfil")
    private String nameProfil;
}
