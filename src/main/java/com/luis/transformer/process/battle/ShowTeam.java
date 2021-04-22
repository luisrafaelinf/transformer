package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface ShowTeam {

    public Map<String, List<TransformerRequest>> show(HashSet<TransformerRequest> players);
    
}
