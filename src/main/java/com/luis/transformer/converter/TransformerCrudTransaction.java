package com.luis.transformer.converter;

import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.TransformerResponse;
import java.util.List;

public interface TransformerCrudTransaction {

    public List<TransformerResponse> findAllTransformer();

    public TransformerResponse createNewTransformer(TransformerRequest transformerRequest);
    
    public TransformerResponse findTransformerById(Long id);
    
    public TransformerResponse updateTransformer(TransformerRequest transformerRequest, Long id);
    
    public void deleteTransformer(Long id);

}
