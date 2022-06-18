package com.sid.gl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Achat  extends Operation{
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name="medicament_id")
    private Medicament medicament;
    @Column(name="qt_achat")
    private int quantite;
     @Column(name="prix_total")
     private double totalPrice;
     private String typeAchat ="vente";




}
