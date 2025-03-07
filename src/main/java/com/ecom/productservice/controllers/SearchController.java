package com.ecom.productservice.controllers;

import com.ecom.productservice.dtos.product.GetProductResponseDto;
import com.ecom.productservice.dtos.search.FilterDto;
import com.ecom.productservice.dtos.search.SearchResponseDto;
import com.ecom.productservice.dtos.search.SortingCriteria;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.SearchService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("")
    public SearchResponseDto search(@RequestParam("query") String query,
                       @RequestParam(value = "filters", required = false) String filtersJson,
                       @RequestParam(value = "sortBy", required = false)SortingCriteria sortingCriteria,
                       @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){

        List<FilterDto> filters = parseFilters(filtersJson);
        SearchResponseDto response = new SearchResponseDto();

        Page<Product> productsPage = searchService.search(query, filters, sortingCriteria, pageNumber, pageSize);

        List<GetProductResponseDto> getProductDtos = productsPage.getContent().stream()
                .map(GetProductResponseDto::fromProduct)
                .collect(Collectors.toList());

        Pageable pageable = PageRequest.of(productsPage.getNumber(), productsPage.getSize(), productsPage.getSort());
        Page<GetProductResponseDto> getProductDtoPage = new PageImpl<>(getProductDtos, pageable, productsPage.getTotalElements());

        response.setProductsPage(getProductDtoPage);

        return response;
    }

    private List<FilterDto> parseFilters(String filtersJson) {
        if (filtersJson == null || filtersJson.isEmpty()) {
            return new ArrayList<>();
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(filtersJson, new TypeReference<List<FilterDto>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Invalid filter format", e);
        }
    }

}
