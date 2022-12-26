package com.example.inventoryservice.inventoryQuery.repositories;


import com.example.inventoryservice.inventoryQuery.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie,String> {
}
