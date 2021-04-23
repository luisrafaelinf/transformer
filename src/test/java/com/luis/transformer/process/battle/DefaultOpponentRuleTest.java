package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import java.util.Objects;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultOpponentRuleTest {

    public DefaultOpponentRuleTest() {
    }

    @Test
    @DisplayName("Opponent with high courage")
    public void testPointCourageOpponent() {
        
        TransformerRequest highCourage = new TransformerRequest(null, "A", "high", 0, 0, 0, 0, 0, 9, 0, 0);
        TransformerRequest lowCourage = new TransformerRequest(null, "A", "low", 0, 0, 0, 0, 0, 5, 0, 0);
        TransformerRequest sameCourage = new TransformerRequest(null, "A", "same", 0, 0, 0, 0, 0, 5, 0, 0);
        
        OpponentRule rule = new DefaultOpponentRule();
        TransformerRequest pointCourageOne = rule.pointCourage(highCourage, lowCourage);
        TransformerRequest pointCourageTwo = rule.pointCourage(lowCourage, highCourage);
        TransformerRequest pointCourageNone = rule.pointCourage(lowCourage, sameCourage);
        
        assertThat("the opponent one should have the higher corauge", Objects.equals(highCourage.getName(), pointCourageOne.getName()), is(true));
        assertThat("the opponent two should have the higher corauge", Objects.equals(highCourage.getName(), pointCourageTwo.getName()), is(true));
        assertThat("the opponents no win by corauge", Objects.isNull(pointCourageNone.getName()), is(true));
        
    }

    @Test
    @DisplayName("Opponent with high strength")
    public void testPointStrength() {
        
        TransformerRequest highStrength = new TransformerRequest(null, "A", "high", 9, 0, 0, 0, 0, 0, 0, 0);
        TransformerRequest lowStrength = new TransformerRequest(null, "A", "low", 5, 0, 0, 0, 0, 0, 0, 0);
        TransformerRequest sameStrength = new TransformerRequest(null, "A", "same", 5, 0, 0, 0, 0, 0, 0, 0);
        
        OpponentRule rule = new DefaultOpponentRule();
        TransformerRequest pointStrengthOne = rule.pointStrength(highStrength, lowStrength);
        TransformerRequest pointStrengthTwo = rule.pointStrength(lowStrength, highStrength);
        TransformerRequest pointStrengthNone = rule.pointStrength(lowStrength, sameStrength);
                
        assertThat("the opponent one should have the higher strenght", Objects.equals(highStrength.getName(), pointStrengthOne.getName()), is(true));
        assertThat("the opponent two should have the higher strenght", Objects.equals(highStrength.getName(), pointStrengthTwo.getName()), is(true));
        assertThat("the opponents no win by strength", Objects.isNull(pointStrengthNone.getName()), is(true));
    }

    @Test
    @DisplayName("Opponent with high skill")
    public void testPointSkill() {
        
        TransformerRequest highSkill = new TransformerRequest(null, "A", "high", 0,0, 0, 0, 0, 0, 0, 9);
        TransformerRequest lowSkill = new TransformerRequest(null, "A", "low", 0,0, 0, 0, 0, 0, 0, 5);
        TransformerRequest sameSkill = new TransformerRequest(null, "A", "same", 0,0, 0, 0, 0, 0, 0, 5);
        
        OpponentRule rule = new DefaultOpponentRule();
        TransformerRequest pointSkillOne = rule.pointSkill(highSkill, lowSkill);
        TransformerRequest pointSkillTwo = rule.pointSkill(lowSkill, highSkill);
        TransformerRequest pointSkillNone = rule.pointSkill(lowSkill, sameSkill);
        
        assertThat("the opponent one should have the higher skill", Objects.equals(highSkill.getName(), pointSkillOne.getName()), is(true));
        assertThat("the opponent two should have the higher skill", Objects.equals(highSkill.getName(), pointSkillTwo.getName()), is(true));
        assertThat("the opponents no win by skill", Objects.isNull(pointSkillNone.getName()), is(true));
    }

}
