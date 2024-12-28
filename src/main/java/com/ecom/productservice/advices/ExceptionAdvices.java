package com.ecom.productservice.advices;

import com.ecom.productservice.dtos.ErrorResponseDto;
import com.ecom.productservice.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseDto handleProductNotFoundException(ProductNotFoundException e) {
        ErrorResponseDto error = new ErrorResponseDto();
        error.setMessage(e.getMessage());
        error.setStatus("Error");
        return error;

    }
}
