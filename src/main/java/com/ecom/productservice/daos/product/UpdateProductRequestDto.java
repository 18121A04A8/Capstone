package com.ecom.productservice.daos.product;

import com.ecom.productservice.models.Product;

public class UpdateProductRequestDto {
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setName(this.name);
        product.setCategory(this.category);
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