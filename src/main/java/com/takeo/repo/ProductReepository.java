package com.takeo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.model.Product;

@Repository
public interface ProductReepository extends JpaRepository<Product, Integer> {

}
