package com.example.commonapi.commands;

import com.example.commonapi.enums.ProductEtat;
import lombok.Getter;

public class UpdateProductCommand extends  BaseCommand<String>{

   @Getter private String nom ;
   @Getter private double prix ;
   @Getter private  int qte  ;
   @Getter private ProductEtat etat ;
    @Getter private String categorie ;

    public UpdateProductCommand(String id, String nom, double prix, int qteStock, ProductEtat etat,String categorie) {
        super(id);
        this.nom = nom;
        this.prix = prix;
        this.qte = qteStock;
        this.etat = etat;
        this.categorie =categorie ;
    }
}
