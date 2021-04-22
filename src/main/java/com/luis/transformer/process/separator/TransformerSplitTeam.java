package com.luis.transformer.process.separator;

import com.luis.transformer.model.request.TransformerRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TransformerSplitTeam implements SplitTeam {

    @Override
    public Map<String, List<TransformerRequest>> split(List<TransformerRequest> players) {
        
        return players
                .stream()
                .collect(Collectors.groupingBy(
                        TransformerRequest::getTeam, 
                        LinkedHashMap::new, 
               Collectors.toList()
                ));

    }

}
