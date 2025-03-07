package com.ecom.productservice.services.FilteringService;

import com.ecom.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;


public class RAMFilter implements Filter{

    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        List<Product> filteredProducts = new ArrayList<>();

        for(Product product : products) {
            if(product.getDescription().contains("")){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
