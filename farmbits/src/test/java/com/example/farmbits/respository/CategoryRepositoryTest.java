package com.example.farmbits.respository;

import com.example.farmbits.model.Category;
import com.example.farmbits.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {
    private CategoryRepository categoryRepository = new CategoryRepository() {
        @Override
        public <S extends Category> S save(S s) {
            return null;
        }

        @Override
        public <S extends Category> Iterable<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<Category> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public Iterable<Category> findAll() {
            return null;
        }

        @Override
        public Iterable<Category> findAllById(Iterable<Long> iterable) {
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
        public void delete(Category category) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> iterable) {

        }

        @Override
        public void deleteAll(Iterable<? extends Category> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    };
    @Test
    public void createShouldPersistData(){
        Category category = new Category(1l,"categoryteste");
        this.categoryRepository.save(category);
        assertThat(category.getId()).isNotNull();
        assertThat(category.getName()).isEqualTo("categoryteste");
    }

    @Test
    public void deleteShouldPersistData(){
        Category category = new Category(1l,"categoryteste");
        this.categoryRepository.save(category);
        this.categoryRepository.delete(category);
        assertThat(this.categoryRepository.findById(category.getId())).isEmpty();

    }

    @Test
    public void editShouldPersistData(){
        Category category = new Category(1l,"categoryteste");
        this.categoryRepository.save(category);
        category.setName("teste2");
        this.categoryRepository.save(category);
        assertThat(category.getName()).isEqualTo("teste2");

    }
}
