package com.example.Category_Product_Envanter.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Category_Product_Envanter.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
