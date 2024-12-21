package com.ecom.productservice.services;

import com.ecom.productservice.daos.product.UpdateProductRequestDto;
import com.ecom.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDbImpl implements ProductService{


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }
    @Override
    public Product updateProduct(Long id, Product product) {return null;}
}
