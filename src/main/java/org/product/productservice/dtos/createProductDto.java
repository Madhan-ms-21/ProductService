package org.product.productservice.dtos;

import lombok.Data;

@Data
public class createProductDto {

    private String name;
    private String description;
    private Double price;
    private String category;

}


