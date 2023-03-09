package br.com.posprodutos.usecases.product;

import br.com.posprodutos.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FindProductsUseCases {

    List<Product> findAll();
}
