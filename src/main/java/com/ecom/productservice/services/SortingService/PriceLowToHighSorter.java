package com.ecom.productservice.services.SortingService;

import com.ecom.productservice.models.Product;

import java.util.Comparator;
import java.util.List;

public class PriceLowToHighSorter implements Sorter {
    @Override
    public List<Product> sort(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        return products;
    }
}
