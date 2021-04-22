package com.luis.transformer.process;

import com.luis.transformer.constant.Team;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import com.luis.transformer.process.battle.ShowTeam;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.luis.transformer.process.battle.FightTeam;

@Service
public class CybertronBattlefield implements Battlefield {
    
    private final ShowTeam showTeam;
    private final FightTeam fightTeam;

    public CybertronBattlefield(ShowTeam showTeam, FightTeam fightTeam) {
        this.showTeam = showTeam;
        this.fightTeam = fightTeam;
    }

    @Override
    public CombatInfo goToBattleField(HashSet<TransformerRequest> players) {

        Map<String, List<TransformerRequest>> teams = showTeam.show(players);
        
        List<TransformerRequest> teamAutobots = teams.get(Team.A.name());
        List<TransformerRequest> teamDecepticons = teams.get(Team.D.name());
        
        CombatInfo fightResume = fightTeam.fight(teamAutobots, teamDecepticons);
        
        return fightResume;
        
    }

}
