package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;

public interface GeneralBattleRule {

    public TransformerRequest pointOverallRating(TransformerRequest opponentOne, TransformerRequest opponentTwo);
    
}
