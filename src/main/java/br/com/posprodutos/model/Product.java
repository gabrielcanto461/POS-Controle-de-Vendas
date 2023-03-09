package br.com.posprodutos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;

    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductUnity productUnity;

    @Override
    public String toString() {
        return name;
    }
}
