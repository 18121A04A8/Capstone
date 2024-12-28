package com.ecom.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@MappedSuperclass

public class BaseModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_on;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_on;

    @PrePersist
    public void onCreate(){
        created_on = new Date();
        updated_on = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        updated_on = new Date();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }
}
