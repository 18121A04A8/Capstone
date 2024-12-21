package com.ecom.productservice.daos.fakeStore;

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
        product.setCategory(this.category);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        product.setId(this.id);

        return product;
    }
}
