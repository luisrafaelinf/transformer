package com.luis.transformer.component;

import com.luis.transformer.model.entity.Transformer;
import com.luis.transformer.service.TransformerService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TransformerService transformerService;
    
    @Override
    public void run(String... args) throws Exception {
        
        transformerService.saveAllTransformers( Arrays.asList(
                        new Transformer(null, "A", "Optimus Prime", 9, 10, 7, 8, 10, 7, 9, 7),
                        new Transformer(null, "A", "Skyfire", 7, 5, 7, 6, 10, 8, 7, 6),
                        new Transformer(null, "A", "Bluestreak", 6, 7, 3, 7, 5, 6, 6, 4),
                        new Transformer(null, "A", "Hound", 7, 8, 5, 5, 6, 7, 5, 6),
                        
                        new Transformer(null, "D", "Megatron", 7, 8, 6, 7, 8, 9, 9, 7),
                        new Transformer(null, "D", "Soundwave", 6, 7, 5, 6, 4, 6, 5, 6),
                        new Transformer(null, "D", "Starscream", 8, 5, 5, 4, 5, 5, 4, 5),
                        new Transformer(null, "D", "Thundercracker", 5, 4, 6, 6, 4, 6, 7, 5)                
                ));
        
    }

}
