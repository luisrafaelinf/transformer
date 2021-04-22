package com.luis.transformer.process.battle;

import com.luis.transformer.constant.PointLost;
import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class DefaultOponentRule implements OponentRule {

    @Override
    public TransformerRequest pointCourage(TransformerRequest oponentOne, TransformerRequest oponentTwo) {
        return calculatePointWinner(oponentOne, oponentTwo, PointLost.COURAGE);
    }

    @Override
    public TransformerRequest pointStrength(TransformerRequest oponentOne, TransformerRequest oponentTwo) {
        return calculatePointWinner(oponentOne, oponentTwo, PointLost.STRENGTH);
    }

    @Override
    public TransformerRequest pointSkill(TransformerRequest oponentOne, TransformerRequest oponentTwo) {
        return calculatePointWinner(oponentOne, oponentTwo, PointLost.SKILL);
    }

    
    private TransformerRequest calculatePointWinner(TransformerRequest oponentOne, TransformerRequest oponentTwo, Integer point) {

        if (oponentOne.getCourage() - oponentTwo.getCourage() >= point) {
            return oponentOne;
        }

        if (oponentTwo.getCourage() - oponentOne.getCourage() >= point) {
            return oponentTwo;
        }

        return new TransformerRequest();

    }

}
