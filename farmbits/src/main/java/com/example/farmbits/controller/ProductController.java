package com.example.farmbits.controller;

import com.example.farmbits.model.Product;
import com.example.farmbits.model.Provider;
import com.example.farmbits.repository.ProductRepository;
import com.example.farmbits.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProviderRepository providerRepository;

    @PostMapping
    ResponseEntity<Object> create(@RequestBody Product product)throws Exception{
            productRepository.save(product);
            return ResponseEntity.status(200).body("OK");
    }
    @GetMapping(path = "/discount")
    ResponseEntity<List<Product>> findDiscount(){
        List <Product> products = productRepository.findProductsByDiscountGreaterThanEqual(30.0);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path ="/provider")
    ResponseEntity <Object> findProductsByProvider(@RequestParam Long id) {
        Optional<Provider> products = providerRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PutMapping
    ResponseEntity<Object> updateCategory (@RequestParam Long id, @RequestBody Product category) {
        Optional<Product> product = productRepository.findById(id);
        product.get().setCategory(category.getCategory());
        productRepository.save(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
    @DeleteMapping
    ResponseEntity<Object>deleteProduct(@RequestParam Long id){
        try{
            Optional<Product> products = productRepository.findById(id);
            productRepository.delete(products.get());
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}
