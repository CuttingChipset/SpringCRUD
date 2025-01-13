package edu.vistula.mjask.springcrud.product.support;

import edu.vistula.mjask.springcrud.product.api.request.ProductRequest;
import edu.vistula.mjask.springcrud.product.api.request.ProductUpdateRequest;
import edu.vistula.mjask.springcrud.product.api.response.ProductResponse;
import edu.vistula.mjask.springcrud.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return new Product(request.getName());
    }

    public Product toProduct(Product product, ProductUpdateRequest request) {
        product.setName(request.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
