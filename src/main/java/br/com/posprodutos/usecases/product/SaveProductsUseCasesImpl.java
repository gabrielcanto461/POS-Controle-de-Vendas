package br.com.posprodutos.usecases.product;

import br.com.posprodutos.model.Product;
import br.com.posprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveProductsUseCasesImpl implements SaveProductsUseCases{

    private final ProductRepository productRepository;

    @Autowired
    public SaveProductsUseCasesImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        }catch (Exception e){
            return null;
        }

    }
}
