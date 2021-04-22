package com.luis.transformer.process.battle;

import com.luis.transformer.constant.SupremePlayer;
import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultSpecialRule implements SpecialRule {

    @Override
    public Boolean supremeOponents(TransformerRequest oponentOne, TransformerRequest oponentTwo) {
        return isSupremePlayer(oponentOne) && isSupremePlayer(oponentTwo);
    }

    @Override
    public TransformerRequest validateName(TransformerRequest oponentOne, TransformerRequest oponentTwo) {
        
        if (isSupremePlayer(oponentOne)) {
            return oponentOne;
        }
        
        if (isSupremePlayer(oponentTwo)) {
            return oponentOne;
        }
        
        return new TransformerRequest();
        
    }
    
    private Boolean isSupremePlayer(TransformerRequest player) {
        
        return player.getName().equals(SupremePlayer.OPTIMUS) || player.getName().equals(SupremePlayer.PREDAKING);
    
    }

}
