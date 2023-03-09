package br.com.posprodutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;

    @OneToMany
    private List<Product> products;

    private Double totalValue;

    @Temporal(TemporalType.DATE)
    private Date date = Date.from(Instant.now());
}
