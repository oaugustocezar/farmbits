package com.example.farmbits.respository;

import com.example.farmbits.model.Provider;
import com.example.farmbits.repository.ProviderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@DataJpaTest
public class ProviderRepositoryTest {
 ProviderRepository providerRepository = new ProviderRepository() {
     @Override
     public <S extends Provider> S save(S s) {
         return null;
     }

     @Override
     public <S extends Provider> Iterable<S> saveAll(Iterable<S> iterable) {
         return null;
     }

     @Override
     public Optional<Provider> findById(Long aLong) {
         return Optional.empty();
     }

     @Override
     public boolean existsById(Long aLong) {
         return false;
     }

     @Override
     public Iterable<Provider> findAll() {
         return null;
     }

     @Override
     public Iterable<Provider> findAllById(Iterable<Long> iterable) {
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
     public void delete(Provider provider) {

     }

     @Override
     public void deleteAllById(Iterable<? extends Long> iterable) {

     }

     @Override
     public void deleteAll(Iterable<? extends Provider> iterable) {

     }

     @Override
     public void deleteAll() {

     }
 };
    @Test
    public void createShouldPersistData(){
        Provider provider = new Provider(1l,"providerTest","teste@teste");
        this.providerRepository.save(provider);
        assertThat(provider.getIdProvider()).isNotNull();
        assertThat(provider.getProviderName()).isEqualTo("providerTest");
        assertThat(provider.getEmail()).isEqualTo("teste@teste");
    }

    @Test public void deletShoudPersistData(){
        Provider provider = new Provider(1l,"providerTest","teste@teste");
        this.providerRepository.save(provider);
        this.providerRepository.delete(provider);
        assertThat(this.providerRepository.findById(provider.getIdProvider())).isEmpty();
    }

    @Test public void editShoulPersistData(){
        Provider provider = new Provider(1l,"providerTest","teste@teste");
        this.providerRepository.save(provider);
        provider.setProviderName("NewName");
        this.providerRepository.save(provider);
        assertThat(provider.getProviderName()).isEqualTo("NewName");

    }

}
