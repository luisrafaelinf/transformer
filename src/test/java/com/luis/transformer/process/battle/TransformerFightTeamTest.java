package com.luis.transformer.process.battle;

import com.luis.transformer.constant.Team;
import com.luis.transformer.exception.TieTeamBattleException;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransformerFightTeamTest {

    @Autowired
    private FightTeam fightTeam;

    @Autowired
    private ShowTeam showTeam;
    

    public TransformerFightTeamTest() {
    }

    @Test
    @DisplayName("Test fight 4 battles with autobots winners")
    public void testFight4BattlesAutobotsWin() {
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest4BattlesWinAutobots()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));

        Map<String, List<TransformerRequest>> teams = showTeam.show(transformers);

        List<TransformerRequest> teamAutobots = teams.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = teams.get(Team.D.name());

        CombatInfo fightResume = fightTeam.fight(teamAutobots, teamDecepticons);

        assertThat("Number of battles should be 4", fightResume.getBattles(), is(4));
        assertThat("The team winner should be autobots", fightResume.getTeamWinner(), is("Autobots"));
        assertThat("The team loser should be decepticons", fightResume.getTeamLoser(), is("Decepticons"));
        assertThat("The team winner survicor should be Optimus Prime, Hound, Bluestreak", fightResume.getWinners(), is("Optimus Prime, Hound, Bluestreak"));

    }

    @Test
    @DisplayName("Test fight 4 battles with decepticons winners")
    public void testFight4BattlesDecepticonsWin() {
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest4BattlesWinDecepticons()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));

        Map<String, List<TransformerRequest>> teams = showTeam.show(transformers);

        List<TransformerRequest> teamAutobots = teams.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = teams.get(Team.D.name());

        CombatInfo fightResume = fightTeam.fight(teamAutobots, teamDecepticons);

        assertThat("Number of battles should be 4", fightResume.getBattles(), is(4));
        assertThat("The team winner should be autobots", fightResume.getTeamWinner(), is("Decepticons"));
        assertThat("The team loser should be decepticons", fightResume.getTeamLoser(), is("Autobots"));
        assertThat("The team winner survicor should be Soundwave, Thundercracker", fightResume.getWinners(), is("Soundwave, Thundercracker"));
        assertThat("The team loser survicor should be Optimus Prime", fightResume.getLosers(), is("Optimus Prime"));

    }

    @Test
    @DisplayName("Test fight 1 battle with decepticons winners")
    public void testFight1BattleDecepticonsWin() {
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest1BattlesWinDecepticons()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));

        Map<String, List<TransformerRequest>> teams = showTeam.show(transformers);

        List<TransformerRequest> teamAutobots = teams.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = teams.get(Team.D.name());

        CombatInfo fightResume = fightTeam.fight(teamAutobots, teamDecepticons);

        assertThat("Number of battles should be 1", fightResume.getBattles(), is(1));
        assertThat("The team winner should be autobots", fightResume.getTeamWinner(), is("Decepticons"));
        assertThat("The team loser should be decepticons", fightResume.getTeamLoser(), is("Autobots"));
        assertThat("The team winner survicor should be Soundwave", fightResume.getWinners(), is("Soundwave"));
        assertThat("The team loser survicor should be Hubcap", fightResume.getLosers(), is("Hubcap"));

    }

    @Test
    @DisplayName("Test fight tie battle no winners")
    public void testFightTieBattle() {
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequestTieBattle()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));

        Map<String, List<TransformerRequest>> teams = showTeam.show(transformers);

        List<TransformerRequest> teamAutobots = teams.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = teams.get(Team.D.name());

        assertThrows(TieTeamBattleException.class, () -> {
            fightTeam.fight(teamAutobots, teamDecepticons);
        }, "TieTeamBattleException should be throw");
        

    }

}
