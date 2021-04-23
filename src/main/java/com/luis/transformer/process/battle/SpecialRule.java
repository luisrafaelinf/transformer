package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;

public interface SpecialRule {

    public Boolean supremeOpponents(TransformerRequest opponentOne, TransformerRequest opponentTwo);
    
    public TransformerRequest validateName(TransformerRequest opponentOne, TransformerRequest opponentTwo);
    
}
