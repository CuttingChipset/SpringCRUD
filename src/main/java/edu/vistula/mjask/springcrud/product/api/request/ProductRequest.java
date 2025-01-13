package edu.vistula.mjask.springcrud.product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ProductRequest {

    private String name;

    @JsonCreator
    public ProductRequest(final String name) {
        this.name = name;
    }

    public String getName() {
            return this.name;
        }

}
