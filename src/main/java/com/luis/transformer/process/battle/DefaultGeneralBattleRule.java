package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultGeneralBattleRule implements GeneralBattleRule {

    @Override
    public TransformerRequest pointOverallRating(TransformerRequest oponentOne, TransformerRequest oponentTwo) {

        Integer overallPlayerOne = calculateOverall(oponentOne);
        Integer overallPlayerTwo = calculateOverall(oponentTwo);

        if (overallPlayerOne > overallPlayerTwo) {
            return oponentOne;
        } else if (overallPlayerOne < overallPlayerTwo) {
            return oponentTwo;
        }
        
        return new TransformerRequest();

    }

    private Integer calculateOverall(TransformerRequest player) {

        return player.getMechanicalStrength()
                + player.getArtificialIntelligence()
                + player.getMechanicalSpeed()
                + player.getEndurance()
                + player.getFirepower();
    }

}
