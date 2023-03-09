package br.com.posprodutos.repository;

import br.com.posprodutos.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
