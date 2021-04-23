package com.luis.transformer.process.battle;

import com.luis.transformer.Application;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class TransformerShowTeamTest {

    @Autowired
    private ShowTeam showTeam;    
    
    public TransformerShowTeamTest() {
    }

    @Test
    @DisplayName("Split the players and create the teams")
    public void testShowTeams() {
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));
        
        Map<String, List<TransformerRequest>> teams = showTeam.show(transformers);
        
        assertThat("Both teams shoul be separated", teams.entrySet().size(), is(2));
    }

}
