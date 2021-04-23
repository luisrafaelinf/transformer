package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultGeneralBattleRule implements GeneralBattleRule {

    @Override
    public TransformerRequest pointOverallRating(TransformerRequest opponentOne, TransformerRequest opponentTwo) {

        Integer overallPlayerOne = opponentOne.overallRating();
        Integer overallPlayerTwo = opponentTwo.overallRating();

        if (overallPlayerOne > overallPlayerTwo) {
            return opponentOne;
        } else if (overallPlayerOne < overallPlayerTwo) {
            return opponentTwo;
        }
        
        return new TransformerRequest();

    }


}
