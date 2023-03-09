package br.com.posprodutos.usecases.product;

import br.com.posprodutos.model.Product;
import br.com.posprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductsUseCasesImpl implements FindProductsUseCases {

    private final ProductRepository productRepository;

    @Autowired
    public FindProductsUseCasesImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
}
