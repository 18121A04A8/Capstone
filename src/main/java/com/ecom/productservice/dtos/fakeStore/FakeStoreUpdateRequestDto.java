package com.ecom.productservice.dtos.fakeStore;

import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;


public class FakeStoreUpdateRequestDto {
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public static FakeStoreUpdateRequestDto fromProduct(Product product) {
        FakeStoreUpdateRequestDto fakeStoreUpdateRequestDto = new FakeStoreUpdateRequestDto();
        fakeStoreUpdateRequestDto.title = product.getName();
        fakeStoreUpdateRequestDto.description = product.getDescription();
        fakeStoreUpdateRequestDto.category = product.getCategory().getName();
        fakeStoreUpdateRequestDto.price = product.getPrice();
        fakeStoreUpdateRequestDto.image = product.getImageUrl();

        return fakeStoreUpdateRequestDto;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
