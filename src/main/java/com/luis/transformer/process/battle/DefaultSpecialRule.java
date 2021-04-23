package com.luis.transformer.process.battle;

import com.luis.transformer.constant.SupremePlayer;
import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultSpecialRule implements SpecialRule {

    @Override
    public Boolean supremeOpponents(TransformerRequest opponentOne, TransformerRequest opponentTwo) {
        return isSupremePlayer(opponentOne) && isSupremePlayer(opponentTwo);
    }

    @Override
    public TransformerRequest validateName(TransformerRequest opponentOne, TransformerRequest opponentTwo) {
        
        if (isSupremePlayer(opponentOne)) {
            return opponentOne;
        }
        
        if (isSupremePlayer(opponentTwo)) {
            return opponentOne;
        }
        
        return new TransformerRequest();
        
    }
    
    private Boolean isSupremePlayer(TransformerRequest player) {
        
        return player.getName().equals(SupremePlayer.OPTIMUS) || player.getName().equals(SupremePlayer.PREDAKING);
    
    }

}
