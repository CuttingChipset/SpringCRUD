package edu.vistula.mjask.springcrud.product.api;

import edu.vistula.mjask.springcrud.product.api.request.ProductRequest;
import edu.vistula.mjask.springcrud.product.api.request.ProductUpdateRequest;
import edu.vistula.mjask.springcrud.product.api.response.ProductResponse;
import edu.vistula.mjask.springcrud.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "create", headers="Accept=*/*", produces = "application/json")
    @Operation(summary = "Create a product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody final ProductRequest productRequest) {
        ProductResponse response = productService.addProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "update/{id}", headers="Accept=*/*", produces = "application/json")
    @Operation(summary = "Update a product")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody final ProductUpdateRequest productRequest) {
        ProductResponse response = productService.update(id, productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/{id}", headers="Accept=*/*", produces = "application/json")
    @Operation(summary = "Find a product")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        ProductResponse response = productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "list", headers="Accept=*/*", produces = "application/json")
    @Operation(summary = "List all products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> responses = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @DeleteMapping(path = "delete/{id}", headers="Accept=*/*", produces = "application/json")
    @Operation(summary = "Delete a product")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
