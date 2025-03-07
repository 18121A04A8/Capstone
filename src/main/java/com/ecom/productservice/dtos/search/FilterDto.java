package com.ecom.productservice.dtos.search;

import com.ecom.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FilterDto {
    private String key;
    private List<String> values;
}
