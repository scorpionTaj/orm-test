package net.tajeddine.ormtest.repository;

import net.tajeddine.ormtest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String kw);
}
