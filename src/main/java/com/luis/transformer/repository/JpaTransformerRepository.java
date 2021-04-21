package com.luis.transformer.repository;

import com.luis.transformer.model.entity.Transformer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTransformerRepository extends JpaRepository<Transformer, Long>, TransformerRepository {

    @Override
    public Optional<Transformer> findByName(String name);
    
}
