package com.example.commonapi.dtos;

import com.example.commonapi.enums.ProductEtat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDTO {
    private String nom ;
    private double prix ;
    private  int qte  ;
    private ProductEtat etat ;
    private String categorie ;

}
