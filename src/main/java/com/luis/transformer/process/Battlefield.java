package com.luis.transformer.process;

import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import java.util.HashSet;

public interface Battlefield {
    
    public CombatInfo goToBattleField(HashSet<TransformerRequest> players);

}
