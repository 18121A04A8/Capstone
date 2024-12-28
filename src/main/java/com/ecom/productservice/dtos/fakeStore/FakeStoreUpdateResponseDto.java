package com.ecom.productservice.dtos.fakeStore;

import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;


public class FakeStoreUpdateResponseDto {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private Long id;

    public Product toProduct(){
        Product product = new Product();
        product.setName(this.title);
        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        product.setId(this.id);

        return product;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
