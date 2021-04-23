package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;

public interface OpponentRule {

    public TransformerRequest pointCourage(TransformerRequest opponentOne, TransformerRequest opponentTwo);

    public TransformerRequest pointStrength(TransformerRequest opponentOne, TransformerRequest opponentTwo);

    public TransformerRequest pointSkill(TransformerRequest opponentOne, TransformerRequest opponentTwo);

}
