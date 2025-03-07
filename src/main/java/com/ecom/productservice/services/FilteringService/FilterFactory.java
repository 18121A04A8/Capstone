package com.ecom.productservice.services.FilteringService;

public class FilterFactory {

    public static Filter getFilterFromKey(String key){
        return switch (key){
            case "ram" -> new RAMFilter();
            case "Brand" -> new BrandFilter();
            case null, default -> null;
        };
    }
}
