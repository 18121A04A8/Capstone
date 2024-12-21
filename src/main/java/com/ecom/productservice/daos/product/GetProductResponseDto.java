package com.ecom.productservice.daos.product;

import com.ecom.productservice.models.Product;

public class GetProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

    public static GetProductResponseDto fromProduct(Product product){
        GetProductResponseDto getAllProductsResponseDto = new GetProductResponseDto();
        getAllProductsResponseDto.setId(product.getId());
        getAllProductsResponseDto.setName(product.getName());
        getAllProductsResponseDto.setDescription(product.getDescription());
        getAllProductsResponseDto.setPrice(product.getPrice());
        getAllProductsResponseDto.setCategory(product.getCategory());
        getAllProductsResponseDto.setImageUrl(product.getImageUrl());
        return getAllProductsResponseDto;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
