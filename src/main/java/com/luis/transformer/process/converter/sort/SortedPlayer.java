package com.luis.transformer.process.converter.sort;

import java.util.HashSet;
import java.util.List;

public interface SortedPlayer<T> {

    public List<T> sort(HashSet<T> players);
    
}
