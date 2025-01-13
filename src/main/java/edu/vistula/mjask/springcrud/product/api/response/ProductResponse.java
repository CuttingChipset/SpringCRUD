package edu.vistula.mjask.springcrud.product.api.response;

public class ProductResponse {

    private Long id;

    private String name;

    public ProductResponse(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
}
