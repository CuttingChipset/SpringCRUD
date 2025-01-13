package edu.vistula.mjask.springcrud.product.repository;

import edu.vistula.mjask.springcrud.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
