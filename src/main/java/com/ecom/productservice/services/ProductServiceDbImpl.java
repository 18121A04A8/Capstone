package com.ecom.productservice.services;

import com.ecom.productservice.exceptions.ProductNotFoundException;
import com.ecom.productservice.models.Category;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.repositories.CategoryRepository;
import com.ecom.productservice.repositories.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDbImpl implements ProductService{

    private ProductRespository productRespository;
    private CategoryRepository categoryRepository;
    public ProductServiceDbImpl(ProductRespository productRespository, CategoryRepository categoryRepository) {
        this.productRespository = productRespository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * This method creates the product.
     * @param product
     * @return Product
     */
    @Override
    public Product createProduct(Product product) {

        String categoryName = product.getCategory().getName();
        Optional<Category> optionalCategory = categoryRepository.findByname(categoryName);
        if(optionalCategory.isEmpty()){
            Category category = categoryRepository.save(product.getCategory());
        }else{
            Category category = optionalCategory.get();
            product.setCategory(category);
        }

        productRespository.save(product);

        return product;

    }

    /**
     * This method returns the all products
     * @return List
     */
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRespository.findAll();
        return products;
    }

    /**
     *  This method returns the Product based on id
     * @param id
     * @return Product
     * @throws ProductNotFoundException
     */
    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRespository.findById(id);
        if(!optionalProduct.isPresent()){
            throw new ProductNotFoundException(id);
        }
        return optionalProduct.get();

    }

    /**
     *  This updates the product
     * @param id
     * @param newProduct
     * @return Product
     */
    @Override
    public Product updateProduct(Long id, Product newProduct) {
        Optional<Product> oldProductOptional = productRespository.findById(id);
        if(!oldProductOptional.isPresent()){
            throw new ProductNotFoundException(id);
        }
        if (newProduct.getCategory().getName() != null) {
            Optional<Category> categoryOptional = categoryRepository.findByname(newProduct.getCategory().getName());
            if(!categoryOptional.isPresent()){
                categoryRepository.save(newProduct.getCategory());
            }else{
                newProduct.setCategory(categoryOptional.get());
            }
        }
        Product oldProduct = oldProductOptional.get();
        updateProductDetails(oldProduct, newProduct);
        productRespository.save(newProduct);
        return newProduct;
    }

    /**
     * This method will compare oldProduct with new newProduct and updated the newProduct
     * @param oldProduct
     * @param newProduct
     */
    private void updateProductDetails(Product oldProduct, Product newProduct) {
        newProduct.setId(oldProduct.getId());
        newProduct.setCreated_on(oldProduct.getCreated_on());
        if(newProduct.getName() == null ){
            newProduct.setName(oldProduct.getName());
        }
        if(newProduct.getDescription() == null ){
            newProduct.setDescription(oldProduct.getDescription());
        }
        if(newProduct.getPrice() == 0.0){
            newProduct.setPrice(oldProduct.getPrice());
        }
        if(newProduct.getCategory().getName() == null){
            newProduct.setCategory(oldProduct.getCategory());
        }
        if(newProduct.getImageUrl() == null){
            newProduct.setImageUrl(oldProduct.getImageUrl());
        }
    }


}
