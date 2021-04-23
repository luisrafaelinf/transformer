package com.luis.transformer.model.response;

import com.google.common.base.Objects;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.entity.Transformer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

public class TransformerResponseTest {

    public TransformerResponseTest() {
    }

    @Test
    public void testFromTransformer() {
        
        Transformer skyfire = FakeTransformers.getSkyfire();
        skyfire.setId(1l);
        
        TransformerResponse response = TransformerResponse.fromTransformer(skyfire);
        
        assertThat("the ID shoul be equals", Objects.equal(response.getId(), skyfire.getId()), is(true));
        assertThat("the team should be equals", Objects.equal(response.getTeam(), skyfire.getTeam()), is(true));
        assertThat("the name should be equals", Objects.equal(response.getName(), skyfire.getName()), is(true));
        assertThat("the strength should be equals", Objects.equal(response.getMechanicalStrength(), skyfire.getStrength()), is(true));
        assertThat("the intelligence should be equals", Objects.equal(response.getArtificialIntelligence(), skyfire.getIntelligence()), is(true));
        assertThat("the speed should be equals", Objects.equal(response.getMechanicalSpeed(), skyfire.getSpeed()), is(true));
        assertThat("the endurance should be equals", Objects.equal(response.getEndurance(), skyfire.getEndurance()), is(true));
        assertThat("the rank should be equals", Objects.equal(response.getRank(), skyfire.getRank()), is(true));
        assertThat("the courage should be equals", Objects.equal(response.getCourage(), skyfire.getCourage()), is(true));
        assertThat("the firepower should be equals", Objects.equal(response.getFirepower(), skyfire.getFirepower()), is(true));
        assertThat("the skill should be equals", Objects.equal(response.getMechanicalSkill(), skyfire.getSkill()), is(true));
        
    }

}
