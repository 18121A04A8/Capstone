package com.ecom.productservice.services;

import com.ecom.productservice.dtos.search.FilterDto;
import com.ecom.productservice.dtos.search.SortingCriteria;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.repositories.ProductRespository;
import com.ecom.productservice.services.FilteringService.Filter;
import com.ecom.productservice.services.FilteringService.FilterFactory;
import com.ecom.productservice.services.SortingService.SorterFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRespository productRespository;
    public SearchService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    public Page<Product> search(String query,
                                        List<FilterDto> filters,
                                        SortingCriteria sortingCriteria,
                                        int pageNumber,
                                        int pageSize) {

        List<Product> products = productRespository.findByNameContaining(query);
        for(FilterDto filterDto : filters) {
            products = FilterFactory.getFilterFromKey(filterDto.getKey()).apply(products, filterDto.getValues());
        }

        if( sortingCriteria != null) {
            products = SorterFactory.getSorter(sortingCriteria).sort(products);
        }
        int start = Math.max(0, pageNumber * pageSize);
        int end = Math.min(start + pageSize, products.size());

        List<Product> productsOnPage = products.subList(start, end);
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return new PageImpl<>(productsOnPage, pageable, products.size());
    }
}
