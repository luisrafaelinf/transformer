package com.luis.transformer.fakedata;

import com.luis.transformer.model.entity.Transformer;
import com.luis.transformer.model.request.TransformerRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FakeTransformers {
    
    private FakeTransformers(){}

    public static Transformer getSkyfire() {
        return new Transformer(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6);
    }
    
    public static Transformer getBluestreak() {
        return new Transformer(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4);
    }
    
    public static TransformerRequest getSkyfireRequest() {
        return new TransformerRequest(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6);
    }
    
    public static TransformerRequest getBluestreakRequest() {
        return new TransformerRequest(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4);
    }
    
    public static TransformerRequest getOptimusPrimeRequest() {
        return new TransformerRequest(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7);
    }
    
    public static TransformerRequest getHoundRequest() {
        return new TransformerRequest(null, "A", "Hound", 7, 8, 5, 5, 6, 7, 5, 6);
    }
    
    public static TransformerRequest getPredakingRequest() {
        return new TransformerRequest(null, "A", "Predaking", 10, 8, 9, 9, 6, 7, 8, 10);
    }

    public static List<Transformer> getListTransformers() {

        return Arrays.asList(
                new Transformer(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7),
                new Transformer(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6),
                new Transformer(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4),
                new Transformer(null, "A", "Hound", 7, 8, 5, 5, 6, 7, 5, 6),
                new Transformer(null, "D", "Megatron", 7, 8, 6, 7, 8, 9, 9, 7),
                new Transformer(null, "D", "Soundwave", 6, 7, 5, 6, 4, 6, 5, 6),
                new Transformer(null, "D", "Starscream", 8, 5, 5, 4, 5, 5, 4, 5),
                new Transformer(null, "D", "Thundercracker", 5, 4, 6, 6, 4, 6, 7, 5)
        );
    }
    
    public static List<TransformerRequest> getListTransformersRequest() {

        return Arrays.asList(
                new TransformerRequest(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7),
                new TransformerRequest(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6),
                new TransformerRequest(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4),
                new TransformerRequest(null, "A", "Hound", 7, 8, 5, 5, 6, 7, 5, 6),
                new TransformerRequest(null, "D", "Megatron", 7, 8, 6, 7, 8, 9, 9, 7),
                new TransformerRequest(null, "D", "Soundwave", 6, 7, 5, 6, 4, 6, 5, 6),
                new TransformerRequest(null, "D", "Starscream", 8, 5, 5, 4, 5, 5, 4, 5),
                new TransformerRequest(null, "D", "Thundercracker", 5, 4, 6, 6, 4, 6, 7, 5)
        );
    }
    
    public static List<TransformerRequest> getListTransformersRequest4BattlesWinAutobots() {

        return Arrays.asList(
                new TransformerRequest(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7),
                new TransformerRequest(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6),
                new TransformerRequest(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4),
                new TransformerRequest(null, "A", "Hound", 7, 8, 5, 5, 6, 7, 5, 6),
                
                new TransformerRequest(null, "D", "Megatron", 7, 8, 6, 7, 8, 9, 9, 7),
                new TransformerRequest(null, "D", "Soundwave", 6, 7, 5, 6, 4, 6, 5, 6),
                new TransformerRequest(null, "D", "Starscream", 8, 5, 5, 4, 5, 5, 4, 5),
                new TransformerRequest(null, "D", "Thundercracker", 5, 4, 6, 6, 4, 6, 7, 5)
        );
    }
    
    public static List<TransformerRequest> getListTransformersRequest4BattlesWinDecepticons() {

        return Arrays.asList(
                new TransformerRequest(null, "D", "Megatron", 9, 10, 7, 8, 10, 7, 9, 7),
                new TransformerRequest(null, "D", "Soundwave", 7, 5, 7, 6, 10, 8, 7, 6),
                new TransformerRequest(null, "D", "Starscream", 6, 7, 3, 7, 5, 6, 6, 4),
                new TransformerRequest(null, "D", "Thundercracker", 7, 8, 5, 5, 6, 7, 5, 6),
                
                new TransformerRequest(null, "A", "Optimus Prime", 7, 8, 6, 7, 8, 9, 9, 7),
                new TransformerRequest(null, "A", "Skyfire", 6, 7, 5, 6, 4, 6, 5, 6),
                new TransformerRequest(null, "A", "Bluestreak", 8, 5, 5, 4, 5, 5, 4, 5),
                new TransformerRequest(null, "A", "Hound", 5, 4, 6, 6, 4, 6, 7, 5)
        );
    }
    
    public static List<TransformerRequest> getListTransformersRequest1BattlesWinDecepticons() {

        return Arrays.asList(
                new TransformerRequest(null, "D", "Soundwave", 8, 9, 2, 6, 7, 5, 6, 10),
                
                new TransformerRequest(null, "A", "Bluestreak", 6, 6, 7, 9, 5, 2, 9, 7),
                new TransformerRequest(null, "A", "Hubcap", 4,4,4,4,4,4,4,4)
        );
    }
    
    public static List<TransformerRequest> getListTransformersRequestTieBattle() {

        return Arrays.asList(
                new TransformerRequest(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7),
                new TransformerRequest(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6),
                new TransformerRequest(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4),
                new TransformerRequest(null, "A", "Hound", 4, 8, 5, 5, 6, 4, 5, 6),
                
                new TransformerRequest(null, "D", "Megatron", 7, 8, 6, 7, 8, 9, 9, 7),
                new TransformerRequest(null, "D", "Soundwave", 9, 7, 5, 6, 4, 9, 5, 6),
                new TransformerRequest(null, "D", "Starscream", 8, 5, 5, 4, 5, 5, 4, 5),
                new TransformerRequest(null, "D", "Thundercracker", 5, 4, 6, 6, 4, 6, 7, 5)
        );
    }

}
