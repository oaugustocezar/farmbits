package com.example.farmbits.controller;

import com.example.farmbits.model.Category;
import com.example.farmbits.model.Provider;
import com.example.farmbits.repository.CategoryRepository;
import com.example.farmbits.repository.ProviderRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/providers")
public class ProviderController {
@Autowired
ProviderRepository providerRepository;

    @PostMapping(headers = {"Accept=application/json"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody Provider provider) throws Exception, URISyntaxException{
      try{
          providerRepository.save(provider);
          return ResponseEntity.status(HttpStatus.OK).body("Inserido com sucesso");
      }catch (Exception e){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
      }
    }
    @GetMapping
    public ResponseEntity <List<Provider>> findAll(){
        try{
            List<Provider> providers = (List<Provider>) providerRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(providers);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }


    }
    @PutMapping
    ResponseEntity<Object> updateProvider(@RequestParam Long id, @RequestBody Provider provider){
        try{
            Optional<Provider> provider1 = providerRepository.findById(id);
            provider1.get().setProviderName(provider.getProviderName());
            provider1.get().setEmail(provider.getEmail());
            providerRepository.save(provider1.get());
            return ResponseEntity.status(HttpStatus.OK).body("Atualizado");

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping
    ResponseEntity<Object> deleteProvider(@RequestParam Long id) throws Exception{
        try{
            Optional<Provider> providers = this.providerRepository.findById(id);
            this.providerRepository.delete(providers.get());
            return ResponseEntity.status(HttpStatus.OK).body("Deletado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }








}
