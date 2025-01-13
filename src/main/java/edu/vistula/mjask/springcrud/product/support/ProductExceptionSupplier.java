package edu.vistula.mjask.springcrud.product.support;

import edu.vistula.mjask.springcrud.product.support.exception.ProductNotFoundException;

import java.util.function.Supplier;

public class ProductExceptionSupplier {

    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
