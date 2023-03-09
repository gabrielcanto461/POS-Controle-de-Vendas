package br.com.posprodutos.dto;

import br.com.posprodutos.model.Customer;
import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;

    private String nome;

    private String bairro;

    private Double saldoDevedor;

    private String ultimaCompra;

    public CustomerDTO(Customer customer) {
        id = customer.getCustomerId();
        nome = customer.getName();
        bairro = customer.getAddress().getDistrict();
        saldoDevedor = customer.getAccount().getDebt();
        ultimaCompra = customer.getAccount().getLatestPurchaseDetailsAsString();
    }
}
