package com.ecom.productservice.dtos.search;

import com.ecom.productservice.dtos.product.GetProductResponseDto;
import com.ecom.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class SearchResponseDto {
    private Page<GetProductResponseDto> productsPage;
}
