package com.luis.transformer.repository;

import com.luis.transformer.model.entity.Transformer;
import java.util.Optional;

public interface TransformerRepository {

    Optional<Transformer> findByName(String name);
    
}
