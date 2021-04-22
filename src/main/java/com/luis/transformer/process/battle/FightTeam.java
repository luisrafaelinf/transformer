package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import java.util.List;

public interface FightTeam {

    public CombatInfo fight(List<TransformerRequest> teamOne, List<TransformerRequest> teamTwo);
    
    public CombatInfo resumeOfFight();
    
}
