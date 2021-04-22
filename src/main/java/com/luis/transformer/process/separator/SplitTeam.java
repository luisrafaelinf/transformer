package com.luis.transformer.process.separator;

import com.luis.transformer.model.request.TransformerRequest;
import java.util.List;
import java.util.Map;

public interface SplitTeam {

    public Map<String, List<TransformerRequest>> split(List<TransformerRequest> players);
    
}
