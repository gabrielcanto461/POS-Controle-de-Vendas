package br.com.posprodutos.usecases.client;

import br.com.posprodutos.dto.CustomerDTO;
import br.com.posprodutos.model.Customer;

public interface RegisterClientUseCases {
    CustomerDTO registerClient(Customer customer);
}
