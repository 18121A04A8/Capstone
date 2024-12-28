package com.ecom.productservice.services;

import com.ecom.productservice.exceptions.ProductNotFoundException;
import com.ecom.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProduct(Long id) throws ProductNotFoundException;

    public Product updateProduct(Long id, Product product);
}
