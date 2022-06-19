package com.sid.gl.DTO.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sid.gl.entities.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("profil")
    private Profil profil;
}
