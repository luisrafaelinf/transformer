package com.luis.transformer.fakedata;

import com.luis.transformer.model.entity.Transformer;
import java.util.Arrays;
import java.util.List;

public final class FakeTransformers {

    public static Transformer getSkyfire() {
        return new Transformer(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6);
    }
    
    public static Transformer getBluestreak() {
        return new Transformer(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4);
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

}
