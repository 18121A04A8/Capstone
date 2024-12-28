package com.ecom.productservice.dtos.product;

import com.ecom.productservice.models.Product;


public class CreateProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private String imageUrl;

    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        createProductResponseDto.setName(product.getName());
        createProductResponseDto.setCategoryName(product.getCategory().getName());
        createProductResponseDto.setDescription(product.getDescription());
        createProductResponseDto.setPrice(product.getPrice());
        createProductResponseDto.setId(product.getId());
        createProductResponseDto.setImageUrl(product.getImageUrl());

        return createProductResponseDto;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
