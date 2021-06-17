package com.example.farmbits.repository;

import com.example.farmbits.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository <Category,Long> {
}
