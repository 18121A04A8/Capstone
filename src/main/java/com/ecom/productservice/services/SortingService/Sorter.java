package com.ecom.productservice.services.SortingService;

import com.ecom.productservice.models.Product;

import java.util.List;

public interface Sorter {
    public List<Product> sort(List<Product> products);
}

