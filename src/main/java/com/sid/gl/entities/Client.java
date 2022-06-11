package com.sid.gl.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom_client")
    private String nom;
    @Column(name="prenom_client")
    private String prenom;
    @Column(name="telephone_client")
    private String telephone;
    @Column(name="adresse_client")
    private String adresse;
    @Column(name="credit_client")
    private double credit;
}
