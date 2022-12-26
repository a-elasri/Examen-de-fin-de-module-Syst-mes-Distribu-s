package com.example.inventoryservice.inventoryQuery.service;

import com.example.commonapi.events.CategorieCreatedEvent;
import com.example.commonapi.events.CategorieUpdatedEvent;
import com.example.commonapi.events.ProductCreatedEvent;
import com.example.commonapi.events.ProductUpdatedEvent;
import com.example.inventoryservice.inventoryQuery.entities.Categorie;
import com.example.inventoryservice.inventoryQuery.entities.Product;
import com.example.inventoryservice.inventoryQuery.repositories.CategoryRepository;
import com.example.inventoryservice.inventoryQuery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceHandler {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @EventHandler
    public void on(CategorieCreatedEvent event) {
        log.info("*********************************");
        log.info("CategorieCreatedEvent received");
        Categorie categorie = new Categorie() ;
        categorie.setId(event.getId());
        categorie.setDescription(event.getDescription());
        categorie.setNom(event.getNom());
        categoryRepository.save(categorie) ;
    }

    @EventHandler
    public void on(CategorieUpdatedEvent event) {
        log.info("*********************************");
        log.info("CategorieUpdatedEvent received");
        Categorie categorie= categoryRepository.findById(event.getId()).get();
        categorie.setDescription(event.getDescription());
        categorie.setNom(event.getNom());
        categoryRepository.save(categorie) ;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        log.info("*********************************");
        log.info("ProductCreatedEvent received");
        Product product = new Product() ;
        product.setId(event.getId());
        product.setNom(event.getNom());
        product.setPrix(event.getPrix());
        product.setQte(event.getQte());
        product.setEtat(event.getEtat());

       Categorie categorie = categoryRepository.findById(event.getCategorie()).get();
        if (categorie != null) {
            product.setCategorie(categorie);
        }
        productRepository.save(product) ;
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) {
        log.info("*********************************");
        log.info("ProductUpdateddEvent received");
        Product product = productRepository.findById(event.getId()).get();
        product.setNom(event.getNom());
        product.setPrix(event.getPrix());
        product.setQte(event.getQte());
        product.setEtat(event.getEtat());

        Categorie categorie = categoryRepository.findById(event.getCategorie()).get();

        product.setCategorie(categorie);

        productRepository.save(product) ;
    }

}
