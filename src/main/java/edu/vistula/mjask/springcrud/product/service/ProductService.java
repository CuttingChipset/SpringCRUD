package edu.vistula.mjask.springcrud.product.service;

import edu.vistula.mjask.springcrud.product.api.request.ProductRequest;
import edu.vistula.mjask.springcrud.product.api.request.ProductUpdateRequest;
import edu.vistula.mjask.springcrud.product.api.response.ProductResponse;
import edu.vistula.mjask.springcrud.product.domain.Product;
import edu.vistula.mjask.springcrud.product.repository.ProductRepository;
import edu.vistula.mjask.springcrud.product.support.ProductExceptionSupplier;
import edu.vistula.mjask.springcrud.product.support.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public ProductResponse update(Long id, ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, productUpdateRequest));
        return productMapper.toProductResponse(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
