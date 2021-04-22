package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;

public interface OponentRule {

    public TransformerRequest pointCourage(TransformerRequest oponentOne, TransformerRequest oponentTwo);

    public TransformerRequest pointStrength(TransformerRequest oponentOne, TransformerRequest oponentTwo);

    public TransformerRequest pointSkill(TransformerRequest oponentOne, TransformerRequest oponentTwo);

}
