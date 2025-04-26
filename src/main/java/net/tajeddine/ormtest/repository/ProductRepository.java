package net.tajeddine.ormtest.repository;

import net.tajeddine.ormtest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String kw);
    List<Product> findByNameContainsAndPriceGreaterThan(String mc, double price);
    @Query("SELECT p FROM Product p WHERE p.name LIKE :x AND p.price > :y")
    List<Product> search(@Param("x") String mc,@Param("y") double price);
}
