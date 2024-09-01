package org.product.productservice.repositories;

import org.product.productservice.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface productRepository extends JpaRepository<product, Long> {

    product findByName(String name);
    List<product> findByCategory(String category);


   product findById(UUID id);
}
