package com.ms.order_service.feign;

import com.ms.order_service.entity.dto.ProductDTO;
import com.ms.order_service.entity.dto.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("PRODUCT-SERVICE")
public interface ProductInterface {

    @PostMapping("product")
    public ResponseEntity<ResponseData> createProduct(@RequestBody ProductDTO product);

    @GetMapping("product/getAllProducts")
    public ResponseEntity<ResponseData> getAllProducts();

    @GetMapping("product/productById/{id}")
    public ResponseEntity<ResponseData> getProductById(@PathVariable Integer id);

    @DeleteMapping("product")
    public ResponseEntity<ResponseData> deleteById(@RequestParam Integer id);

}
