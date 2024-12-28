package com.ecom.productservice.repositories;

import com.ecom.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {

}
