package com.luis.transformer.service;

import com.luis.transformer.model.entity.Transformer;
import java.util.List;

public interface TransformerService {

    public Long totalTransformers();

    public List<Transformer> saveAllTransformers(List<Transformer> transformers);

    public Transformer saveTransformer(Transformer transformer);

    public Transformer getTransformerById(Long id);

    public List<Transformer> findAllTransformers();
    
    public void deleteAllTransformers();
    
    public void deleteTransformer(Long id);
    
    public Transformer getByName(String name);
    
    public Transformer updateTransformer(Transformer transformer);

}
