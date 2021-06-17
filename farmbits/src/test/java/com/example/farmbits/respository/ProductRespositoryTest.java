package com.example.farmbits.respository;

import com.example.farmbits.model.Category;
import com.example.farmbits.model.Product;
import com.example.farmbits.model.Provider;
import com.example.farmbits.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRespositoryTest {
  ProductRepository productRepository = new ProductRepository() {
    @Override
    public List<Product> findProductsByDiscountGreaterThanEqual(Double discount) {
      return null;
    }

    @Override
    public List<Product> findProductsByCategory_Id(Long id) {
      return null;
    }

    @Override
    public List<Product> findProductsByProviders_IdProvider(Long id) {
      return null;
    }


    @Override
    public <S extends Product> S save(S s) {
      return null;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
      return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
      return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
      return false;
    }

    @Override
    public Iterable<Product> findAll() {
      return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> iterable) {
      return null;
    }

    @Override
    public long count() {
      return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }
  };

  @Test
  public void createShouldPersistData(){

    Category category = new Category(1l,"categoryteste");
    Provider provider = new Provider(1l,"providerTest","teste@teste");
    List<Provider> providerList = new ArrayList<Provider>();
    providerList.add(provider);
    Product product = new Product(1l,"teste","descrição",30.5,10.0,category,providerList);

    this.productRepository.save(product);
    assertThat(product.getIdProduct()).isNotNull();
    assertThat(product.getProductName()).isEqualTo("teste");
    assertThat(product.getDescription()).isEqualTo("descrição");
    assertThat(product.getCategory().getName()).isEqualTo("categoryteste");
    assertThat(product.getCategory().getId()).isNotNull();
    assertThat(product.getProviders().get(0).getIdProvider()).isNotNull();
    assertThat(product.getProviders().get(0).getProviderName()).isEqualTo("providerTest");
    assertThat(product.getProviders().get(0).getEmail()).isEqualTo("teste@teste");  }

  @Test
  public void deletShoulPersistData(){
    Category category = new Category(1l,"categoryteste");
    Provider provider = new Provider(1l,"providerTest","teste@teste");
    List<Provider> providerList = new ArrayList<Provider>();
    providerList.add(provider);
    Product product = new Product(1l,"teste","descrição",30.5,10.0,category,providerList);

    this.productRepository.save(product);
    this.productRepository.delete(product);
    assertThat(this.productRepository.findById(product.getIdProduct())).isEmpty();
  }

 /* @Test
  public void findShouldByGreater(){
    Category category = new Category(1l,"categoryteste");
    Provider provider = new Provider(1l,"providerTest","teste@teste");
    List<Provider> providerList = new ArrayList<Provider>();
    providerList.add(provider);
    Product product = new Product(1l,"teste","descrição",30.5,35.0,category,providerList);
    this.productRepository.save(product);
    List <Product> products = productRepository.findProductsByDiscountGreaterThanEqual(30.0);
    System.out.println(products.get(0).toString());
  }*/
}


