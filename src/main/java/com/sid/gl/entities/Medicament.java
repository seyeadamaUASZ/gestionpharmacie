package com.sid.gl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="code_medicament")
    private String codeMedicament;
    @Column(name="prix_medicament")
    private double prixu;
    @Column(name="stock_medicament")
    private int stock;
    @ManyToOne
    @JoinColumn(name="id_categorie")
    private Categorie categorie;
    @Column(name="url_image")
    private String urlImage;
}
