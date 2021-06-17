package com.example.farmbits.controller;

import com.example.farmbits.model.Category;
import com.example.farmbits.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    ResponseEntity insertCategory (@RequestBody Category category) throws Exception{
        try{
            categoryRepository.save(category);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    ResponseEntity <Object> find(){
        try{
            Iterable<Category> categories =  categoryRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
    @PutMapping
    ResponseEntity<Object> updateCategory(@RequestParam Long id, @RequestBody Category category){
        try{
            Optional<Category> categories = categoryRepository.findById(id);
            categories.get().setName(category.getName());
            categoryRepository.save(categories.get());
            return ResponseEntity.status(HttpStatus.OK).body("Atualizado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
