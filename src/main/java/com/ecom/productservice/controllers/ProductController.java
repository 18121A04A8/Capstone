package com.ecom.productservice.controllers;

import com.ecom.productservice.daos.product.*;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.createProduct(createProductRequestDto.toProduct());

        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public List<GetProductResponseDto> allProducts(){
        List<Product> productList= productService.getAllProducts();
        List<GetProductResponseDto> getProductResponseDtoList = new ArrayList<>();
        for (Product product : productList){
            getProductResponseDtoList.add(GetProductResponseDto.fromProduct(product));
        }
        return getProductResponseDtoList;
    }

    @GetMapping("/{id}")
    public GetProductResponseDto getProduct(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        return GetProductResponseDto.fromProduct(product);
    }

    @PatchMapping("/{id}")
    public UpdateProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequestDto updateProductRequestDto){
        Product product = productService.updateProduct(id, updateProductRequestDto.toProduct());
        return UpdateProductResponseDto.fromProduct(product);
    }





}
