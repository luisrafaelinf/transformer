package com.luis.transformer.process.battle;

import com.luis.transformer.fakedata.FakeDataOverall;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.Objects;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultGeneralBattleRuleTest {

    public DefaultGeneralBattleRuleTest() {
    }

    @Test
    @DisplayName("Calculing overall rating")
    public void testPointOverallRatingHighOpponentOne() {
        TransformerRequest transformerHigh = FakeDataOverall.getTransformerHigh();
        TransformerRequest transformerLow = FakeDataOverall.getTransformerLow();

        GeneralBattleRule rule = new DefaultGeneralBattleRule();
        TransformerRequest pointOverallRating = rule.pointOverallRating(transformerHigh, transformerLow);
        
        assertThat("", Objects.equals(transformerHigh.getName(), pointOverallRating.getName()), is(true));

    }
    
    @Test
    @DisplayName("Calculing overall rating")
    public void testPointOverallRatingHighOpponentTwo() {
        TransformerRequest transformerHigh = FakeDataOverall.getTransformerHigh();
        TransformerRequest transformerLow = FakeDataOverall.getTransformerLow();

        GeneralBattleRule rule = new DefaultGeneralBattleRule();
        TransformerRequest pointOverallRating = rule.pointOverallRating(transformerLow, transformerHigh);
        
        assertThat("", Objects.equals(transformerHigh.getName(), pointOverallRating.getName()), is(true));

    }

    @Test
    @DisplayName("Calculing overall ratingf equals")
    public void testPointOverallRatingEquals() {
        TransformerRequest transformerHigh = FakeDataOverall.getTransformerHigh();

        GeneralBattleRule rule = new DefaultGeneralBattleRule();
        TransformerRequest pointOverallRating = rule.pointOverallRating(transformerHigh, transformerHigh);
        
        assertThat("", Objects.isNull(pointOverallRating.getName()), is(true));

    }

}
