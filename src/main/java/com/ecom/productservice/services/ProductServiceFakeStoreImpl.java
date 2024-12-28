package com.ecom.productservice.services;

import com.ecom.productservice.dtos.fakeStore.FakeStoreCreateProductRequestDto;
import com.ecom.productservice.dtos.fakeStore.FakeStoreResponseDto;
import com.ecom.productservice.dtos.fakeStore.FakeStoreUpdateResponseDto;
import com.ecom.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class ProductServiceFakeStoreImpl implements  ProductService{
    private RestTemplate restTemplate ;
    public ProductServiceFakeStoreImpl (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreResponseDto fakeStoreCreateProductResponseDto = restTemplate.postForObject("https://fakestoreapi.com/products", FakeStoreCreateProductRequestDto.fromProduct(product), FakeStoreResponseDto.class);
        return fakeStoreCreateProductResponseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDto[] fakeStoreResponseDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreResponseDto fakeStoreResponseDto : fakeStoreResponseDtos) {
            products.add(fakeStoreResponseDto.toProduct());
        }
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        FakeStoreResponseDto fakeStoreResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreResponseDto.class);
        return fakeStoreResponseDto.toProduct();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
        //FakeStoreUpdateResponseDto fakeStoreUpdateResponseDto = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, FakeStoreUpdateRequestDto.fromProduct(product), FakeStoreUpdateResponseDto.class);
        //FakeStoreUpdateResponseDto fakeStoreUpdateResponseDto = new FakeStoreUpdateResponseDto();
       // return fakeStoreUpdateResponseDto.toProduct();
    }
}
