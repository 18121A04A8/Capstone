package com.ecom.productservice.dtos.product;

import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;


public class UpdateProductRequestDto {
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setName(this.name);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);

        return product;
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

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
