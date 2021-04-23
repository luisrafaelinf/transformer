package com.luis.transformer.process.battle;

import com.luis.transformer.constant.PointLost;
import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultOpponentRule implements OpponentRule {

    @Override
    public TransformerRequest pointCourage(TransformerRequest opponentOne, TransformerRequest opponentTwo) {
        if (opponentOne.getCourage() - opponentTwo.getCourage() >= PointLost.COURAGE) {
            return opponentOne;
        }

        if (opponentTwo.getCourage() - opponentOne.getCourage() >= PointLost.COURAGE) {
            return opponentTwo;
        }

        return new TransformerRequest();
    }

    @Override
    public TransformerRequest pointStrength(TransformerRequest opponentOne, TransformerRequest opponentTwo) {
        if (opponentOne.getMechanicalStrength()- opponentTwo.getMechanicalStrength()>= PointLost.STRENGTH) {
            return opponentOne;
        }

        if (opponentTwo.getMechanicalStrength()- opponentOne.getMechanicalStrength()>= PointLost.STRENGTH) {
            return opponentTwo;
        }

        return new TransformerRequest();
    }

    @Override
    public TransformerRequest pointSkill(TransformerRequest opponentOne, TransformerRequest opponentTwo) {
        if (opponentOne.getMechanicalSkill()- opponentTwo.getMechanicalSkill() >= PointLost.SKILL) {
            return opponentOne;
        }

        if (opponentTwo.getMechanicalSkill()- opponentOne.getMechanicalSkill() >= PointLost.SKILL) {
            return opponentTwo;
        }

        return new TransformerRequest();
    }

    


}
