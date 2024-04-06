package com.example.productservice.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Category")
public class Category extends BaseModal {
    private String title;

    public Category() {
    }
}
