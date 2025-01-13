package edu.vistula.mjask.springcrud.product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductUpdateRequest extends ProductRequest {
    private final Long id;

    @JsonCreator
    public ProductUpdateRequest(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        super(name);
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
