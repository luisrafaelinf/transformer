package com.luis.transformer.repository;

import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.entity.Transformer;
import java.util.Optional;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JpaTransformerRepositoryTest {
    
    @Autowired
    private TransformerRepository repository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    public JpaTransformerRepositoryTest() {
        
    }
    
    @BeforeEach
    public void setUp() {
        entityManager.persistAndFlush(FakeTransformers.getSkyfire());
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    @DisplayName("Finding by name")
    public void testFindByName() {
    
        final String nameExpected = "Skyfire";
        Optional<Transformer> transformes = repository.findByName(nameExpected);
        
        MatcherAssert.assertThat(
                String.format("Transformer with name %s should not be empty", nameExpected), 
                transformes.isPresent(), 
                Matchers.is(true)
        );
        
    }
    
    
}
