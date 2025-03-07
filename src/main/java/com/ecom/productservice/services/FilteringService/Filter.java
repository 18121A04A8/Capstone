package com.ecom.productservice.services.FilteringService;

import com.ecom.productservice.models.Product;

import java.util.List;

public interface Filter {

    List<Product> apply(List<Product> products,
                        List<String> allowedValues);
}
