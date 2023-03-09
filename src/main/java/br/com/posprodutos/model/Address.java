package br.com.posprodutos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private String city;
    private String district;
    private String street;
    private String number;
    private String complement;
}
