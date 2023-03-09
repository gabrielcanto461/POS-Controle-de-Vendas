package br.com.posprodutos.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;

    private Double debt;

    @OneToMany
    private List<Purchase> listOfPurchases;

    public String getLatestPurchaseDetailsAsString(){
        var size = listOfPurchases.size();
        var purchaseDetails = "";
        if(listOfPurchases.isEmpty())
            return "Não há compras recentes";

        var productsList = listOfPurchases.get(size-1).getProducts();

        purchaseDetails = productsList.stream()
                .map(Product::toString )
                .collect(Collectors.joining(", "));

        return purchaseDetails;

    }


}
