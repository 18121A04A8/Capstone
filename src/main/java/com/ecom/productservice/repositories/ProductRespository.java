package com.ecom.productservice.repositories;

import com.ecom.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {

   List<Product> findByNameContaining(String title);

}
