package com.luis.transformer.process.battle;

import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.Objects;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultSpecialRuleTest {

    public DefaultSpecialRuleTest() {
    }

    @Test
    @DisplayName("validating name of supreme transformers optimus prime")
    public void testValidateNameOptimusPrime() {
        
        final String prime = "Optimus Prime";
        
        TransformerRequest optimusPrime = FakeTransformers.getOptimusPrimeRequest();
        
        SpecialRule specialRule = new DefaultSpecialRule();
        TransformerRequest validateName = specialRule.validateName(optimusPrime, FakeTransformers.getHoundRequest());
        
        assertThat(String.format("The name should be %s", prime), Objects.equals(validateName.getName(), prime), is(true));
    }

    @Test
    @DisplayName("validating name of supreme transformers predaking")
    public void testValidateNamePredaking() {
        
        final String predaking = "Predaking";
        
        TransformerRequest predakingRequest = FakeTransformers.getPredakingRequest();
        
        
        SpecialRule specialRule = new DefaultSpecialRule();
        TransformerRequest validateName = specialRule.validateName(predakingRequest, FakeTransformers.getHoundRequest());
        
        assertThat(String.format("The name should be %s", predaking), Objects.equals(validateName.getName(), predaking), is(true));
    }

}
