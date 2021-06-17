package com.example.farmbits.repository;

import com.example.farmbits.model.Category;
import com.example.farmbits.model.Product;
import com.example.farmbits.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product>findProductsByDiscountGreaterThanEqual(Double discount);
    List<Product>findProductsByCategory_Id(Long id);
    List<Product>findProductsByProviders_IdProvider(Long id);

}
