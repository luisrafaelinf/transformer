package com.luis.transformer.process.separator;

import com.luis.transformer.constant.Team;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

public class TransformerSplitTeamTest {

    public TransformerSplitTeamTest() {
    }

    @Test
    public void testSplit() {

        List<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest();

        SplitTeam splitTeam = new TransformerSplitTeam();
        Map<String, List<TransformerRequest>> splitted = splitTeam.split(transformers);
        
        List<TransformerRequest> teamAutobots = splitted.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = splitted.get(Team.D.name());
        
        assertThat("The autobots team should have 4 players", teamAutobots.size(), is(4));
        assertThat("The decepticons team should have 4 players", teamDecepticons.size(), is(4));

    }

}
