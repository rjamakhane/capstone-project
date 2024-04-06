package com.example.productservice.modals;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModal {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
