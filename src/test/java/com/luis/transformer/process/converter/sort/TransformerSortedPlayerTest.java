package com.luis.transformer.process.converter.sort;

import com.google.common.base.Objects;
import com.luis.transformer.fakedata.FakeTransformers;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.HashSet;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

public class TransformerSortedPlayerTest {

    public TransformerSortedPlayerTest() {
    }

    @Test
    public void testSort() {
        
        
        HashSet<TransformerRequest> transformers = FakeTransformers.getListTransformersRequest()
                .stream()
                .collect(Collectors.toCollection(HashSet::new ));
        
        SortedPlayer<TransformerRequest> sortedPlayer = new TransformerSortedPlayer();
        
        //ordered by rank
        String expected = "Skyfire,Optimus Prime,Megatron,Hound,Bluestreak,Starscream,Soundwave,Thundercracker";
        String sorted = sortedPlayer.sort(transformers)
                .stream()
                .map(t -> t.getName())
                .collect(Collectors.joining(","));
        
        assertThat("The lists sorted shoul be equals", Objects.equal(sorted, expected), is(true));
        
    }

}
