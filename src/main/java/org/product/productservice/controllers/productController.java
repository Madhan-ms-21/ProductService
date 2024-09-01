package org.product.productservice.controllers;


import org.product.productservice.dtos.createProductDto;
import org.product.productservice.models.product;
import org.product.productservice.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class productController {

    @Autowired
    public productService productservice;

    @PostMapping("/create")
    public product createProduct(@RequestBody createProductDto productDto){
//        return new product();
        return productservice.createProduct(productDto);
    }

    @GetMapping("/")
    public List<product> getAllProducts(){
        return productservice.getAllProduct();
    }

    @GetMapping("/{productId}")
    public product getProduct(@PathVariable UUID productId){
        return productservice.getProduct(productId);
    }

    @PutMapping("{productId}")
    public product updateProduct(@PathVariable UUID productId, @RequestBody product product){

        return productservice.updateProduct(product);
    }

}
