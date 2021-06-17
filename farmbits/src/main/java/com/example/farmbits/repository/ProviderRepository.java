package com.example.farmbits.repository;

import com.example.farmbits.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends CrudRepository<Provider,Long> {
}
