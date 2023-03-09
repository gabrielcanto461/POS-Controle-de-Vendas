package br.com.posprodutos.controllers;

import br.com.posprodutos.model.Product;
import br.com.posprodutos.usecases.product.FindProductsUseCases;
import br.com.posprodutos.usecases.product.SaveProductsUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProductController {

    private final FindProductsUseCases findProductsUseCases;
    private final SaveProductsUseCases saveProductsUseCases;

    @Autowired
    public ProductController(FindProductsUseCases findProductsUseCases, SaveProductsUseCases saveProductsUseCases) {
        this.findProductsUseCases = findProductsUseCases;
        this.saveProductsUseCases = saveProductsUseCases;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){

        return ResponseEntity.ok(findProductsUseCases.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@Validated @RequestBody Product product){
        var productSaved = saveProductsUseCases.saveProduct(product);

        if (productSaved==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.created(null).body(productSaved);
    }





}
