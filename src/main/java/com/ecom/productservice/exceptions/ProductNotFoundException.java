package com.ecom.productservice.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product Not Found with ID: " + id);
    }
}
