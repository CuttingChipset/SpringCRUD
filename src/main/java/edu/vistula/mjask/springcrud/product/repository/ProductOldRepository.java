package edu.vistula.mjask.springcrud.product.repository;

import edu.vistula.mjask.springcrud.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Deprecated
public class ProductOldRepository {
    protected final Map<Long, Product> map = new HashMap<>();
    protected long counter = 1;

    public Product save(Product product) {
        setId(product);
        return product;
    }

    private Product setId(Product product) {
        if (product.getId() != null) {
            map.put(product.getId(), product);
        } else {
            product.setId(counter);
            map.put(counter, product);
            counter++;
        }
        return product;
    }

    public Optional<Product> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    public void deleteById(Long id) {
        map.remove(id);
    }
}
