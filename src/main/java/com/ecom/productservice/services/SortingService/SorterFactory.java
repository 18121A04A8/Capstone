package com.ecom.productservice.services.SortingService;

import com.ecom.productservice.dtos.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorter(SortingCriteria sortingCriteria) {
        return switch (sortingCriteria){
            case RELEVANCE -> null;
            case PRICE_HIGH_TO_LOW -> new PriceHightToLowSorter();
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            default -> null;
        };
    }
}
