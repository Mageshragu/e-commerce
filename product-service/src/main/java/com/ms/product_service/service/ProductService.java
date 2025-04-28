package com.ms.product_service.service;

import com.ms.product_service.Entity.Product;
import com.ms.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getProductById(Integer id) {
        Product productDB = productRepository.findById(id).orElseThrow( () -> new RuntimeException("Product not found "+id));
        return productDB;
    }

    public boolean deleteById(Integer id) {
        productRepository.findById(id).ifPresentOrElse(
                product -> productRepository.deleteById(id),
                () -> { throw new RuntimeException("Product not found "+id);}
        );
        return true;
    }
}
