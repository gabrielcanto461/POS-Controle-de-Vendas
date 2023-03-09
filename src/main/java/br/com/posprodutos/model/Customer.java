package br.com.posprodutos.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "account_number")
    private Account account;

}
