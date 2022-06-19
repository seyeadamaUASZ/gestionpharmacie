package com.sid.gl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    @Column(unique = true)
    private String telephone;
    private String password;
    @ManyToOne
    @JoinColumn(name="profil_id")
    private Profil profil;
}
