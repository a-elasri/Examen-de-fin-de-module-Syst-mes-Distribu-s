package com.example.inventoryservice.inventoryQuery.entities;

import com.example.commonapi.enums.ProductEtat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private String id ;
    private String nom ;
    private double prix ;
    private  int qte  ;
    private ProductEtat etat ;


    @ManyToOne
    private Categorie categorie;

}
