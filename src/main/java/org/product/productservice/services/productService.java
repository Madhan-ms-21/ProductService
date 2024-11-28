package org.product.productservice.services;



import org.product.productservice.dtos.createProductDto;
import org.product.productservice.models.product;
import org.product.productservice.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public product createProduct(createProductDto createProductDto){

        product product = new product();
        product.setName(createProductDto.getName());
        product.setDescription(createProductDto.getDescription());
        product.setPrice(createProductDto.getPrice());
        product.setCategory(createProductDto.getCategory());
        return productRepository.save(product);
    }
    public product getProduct(UUID id){
        return productRepository.findById(id);
    }
    public List<product> getAllProduct(){
//        Pageable pageable = PageRequest.of()
        return productRepository.findAll();
    }
    public product updateProduct(product product){
        return productRepository.save(product);
    }
}
