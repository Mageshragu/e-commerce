package com.ms.product_service.controller;

import com.ms.product_service.Entity.Product;
import com.ms.product_service.Entity.dto.ResponseData;
import com.ms.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData> createProduct(@RequestBody Product product
//                                                      @RequestPart(required = false)MultipartFile productImage
    )
    {
        try{
            Product productResponse = productService.createProduct(product);
            return new ResponseEntity<>(new ResponseData(productResponse,null),null, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<ResponseData> getAllProducts()
    {
        try{
            List<Product> productResponse = productService.getAllProducts();
            return new ResponseEntity<>(new ResponseData(productResponse,null),null, HttpStatus.OK);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<ResponseData> getProductById(@PathVariable Integer id)
    {
        try{
            Product productResponse = productService.getProductById(id);
            return new ResponseEntity<>(new ResponseData(productResponse,null),null, HttpStatus.OK);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<ResponseData> deleteById(@RequestParam Integer id)
    {
        try{
            boolean productResponse = productService.deleteById(id);
            return new ResponseEntity<>(new ResponseData(productResponse,null),null, HttpStatus.OK);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
