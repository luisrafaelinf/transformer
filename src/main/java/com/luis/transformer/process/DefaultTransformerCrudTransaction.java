package com.luis.transformer.process;

import com.luis.transformer.model.entity.Transformer;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.TransformerResponse;
import com.luis.transformer.service.TransformerService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class DefaultTransformerCrudTransaction implements TransformerCrudTransaction {

    private final TransformerService transformerService;

    public DefaultTransformerCrudTransaction(TransformerService transformerService) {
        this.transformerService = transformerService;
    }
    
    @Override
    public List<TransformerResponse> findAllTransformer() {
     
        List<Transformer> transformers = transformerService.findAllTransformers();
        
        return transformers.stream()
                .map(TransformerResponse::fromTransformer)
                .collect(Collectors.toList());
    }

    @Override
    public TransformerResponse createNewTransformer(TransformerRequest transformerRequest) {
        
        Transformer transformer = transformerFromRequest(transformerRequest);
        
        Transformer newTransformer = transformerService.saveTransformer(transformer);
        
        return TransformerResponse.fromTransformer(newTransformer);
    }

    @Override
    public TransformerResponse findTransformerById(@NotNull Long id) {
        Transformer transformer = transformerService.getTransformerById(id);
        
        return TransformerResponse.fromTransformer(transformer);
        
    }

    @Override
    public TransformerResponse updateTransformer(TransformerRequest transformerRequest, @NotNull Long id) {
        Transformer transformer = transformerFromRequest(transformerRequest);
        transformer.setId(id);
        
        Transformer transformerUpdated = transformerService.updateTransformer(transformer);
        
        return TransformerResponse.fromTransformer(transformerUpdated);
        
    }
    
    @Override
    public void deleteTransformer(Long id) {
        transformerService.deleteTransformer(id);
    }
    
    private Transformer transformerFromRequest(TransformerRequest transformerRequest) {
        
        Transformer transformer = new Transformer();
        transformer.setTeam(transformerRequest.getTeam());
        transformer.setName(transformerRequest.getName());
        transformer.setStrength(transformerRequest.getMechanicalStrength());
        transformer.setIntelligence(transformerRequest.getArtificialIntelligence());
        transformer.setSpeed(transformerRequest.getMechanicalSpeed());
        transformer.setEndurance(transformerRequest.getEndurance());
        transformer.setRank(transformerRequest.getRank());
        transformer.setCourage(transformerRequest.getCourage());
        transformer.setFirepower(transformerRequest.getFirepower());
        transformer.setSkill(transformerRequest.getMechanicalSkill());
        
        return transformer;
    
    }


}
