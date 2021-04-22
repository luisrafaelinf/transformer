package com.luis.transformer.process.converter.sort;

import com.luis.transformer.model.request.PlayerRank;
import java.util.HashSet;
import java.util.List;

public interface SortedPlayer<T extends PlayerRank> {

    public List<T> sort(HashSet<T> players);
    
}
