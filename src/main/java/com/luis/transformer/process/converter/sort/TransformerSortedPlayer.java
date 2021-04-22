package com.luis.transformer.process.converter.sort;

import com.luis.transformer.model.request.TransformerRequest;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TransformerSortedPlayer implements SortedPlayer<TransformerRequest> {

    @Override
    public List<TransformerRequest> sort(HashSet<TransformerRequest> players) {

        return players.stream()
                .sorted((c1, c2) -> c2.getRank().compareTo(c1.getRank()))
                .collect(Collectors.toList());
    }

}
