package com.example.Category_Product_Envanter.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Category_Product_Envanter.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
