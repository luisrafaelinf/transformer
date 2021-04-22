package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;

public interface SpecialRule {

    public Boolean supremeOponents(TransformerRequest oponentOne, TransformerRequest oponentTwo);
    
    public TransformerRequest validateName(TransformerRequest oponentOne, TransformerRequest oponentTwo);
    
}
