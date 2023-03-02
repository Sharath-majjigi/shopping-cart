package com.programming.techie.discoveryserver.productservice.repository;

import com.programming.techie.discoveryserver.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
