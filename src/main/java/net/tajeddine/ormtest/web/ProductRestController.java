package net.tajeddine.ormtest.web;

import net.tajeddine.ormtest.entities.Product;
import net.tajeddine.ormtest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }
}
