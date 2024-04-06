package com.example.productservice.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Product")
public class Product extends BaseModal {
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    private String image;

    @ManyToOne
    private Rating rating;

    public Product() {
    }
}
