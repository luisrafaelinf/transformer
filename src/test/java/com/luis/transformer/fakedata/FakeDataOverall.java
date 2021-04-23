package com.luis.transformer.fakedata;

import com.luis.transformer.model.request.TransformerRequest;

public final class FakeDataOverall {
    
    public static TransformerRequest getTransformerHigh() {
        return new TransformerRequest(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6);
    }
    
    public static TransformerRequest getTransformerLow() {
        return new TransformerRequest(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4);
    }

}
