package com.ecom.productservice.models;

import lombok.Getter;
import lombok.Setter;


public class BaseModel {
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
