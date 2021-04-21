package com.luis.transformer.model.response;

import com.luis.transformer.model.entity.Transformer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransformerResponse {

    private Long id;
    private String team;
    private String name;
    private Integer mechanicalStrength;
    private Integer artificialIntelligence;
    private Integer mechanicalSpeed;
    private Integer endurance;
    private Integer rank;
    private Integer courage;
    private Integer firepower;
    private Integer mechanicalSkill;

    public static TransformerResponse fromTransformer(Transformer transformer) {
    
        TransformerResponse transformerResponse = new TransformerResponse();
        transformerResponse.setId(transformer.getId());
        transformerResponse.setTeam(transformer.getTeam());
        transformerResponse.setName(transformer.getName());
        transformerResponse.setMechanicalStrength(transformer.getStrength());
        transformerResponse.setArtificialIntelligence(transformer.getIntelligence());
        transformerResponse.setMechanicalSpeed(transformer.getSpeed());
        transformerResponse.setEndurance(transformer.getEndurance());
        transformerResponse.setRank(transformer.getRank());
        transformerResponse.setCourage(transformer.getCourage());
        transformerResponse.setFirepower(transformer.getFirepower());
        transformerResponse.setMechanicalSkill(transformer.getSkill());
        
        return transformerResponse;
        
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
}
