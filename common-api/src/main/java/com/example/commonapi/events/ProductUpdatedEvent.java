package com.example.commonapi.events;

import lombok.Getter;
import com.example.commonapi.enums.ProductEtat;

public class ProductUpdatedEvent extends BaseEvent<String>{

    @Getter
    private String nom ;
    @Getter private double prix ;
    @Getter private  int qte  ;
    @Getter private ProductEtat etat ;
    @Getter private String categorie ;
    public ProductUpdatedEvent(String id, String nom, double prix, int qte, ProductEtat etat) {
        super(id);
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
        this.etat = etat;
    }
}

