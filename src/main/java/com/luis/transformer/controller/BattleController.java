package com.luis.transformer.controller;

import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import com.luis.transformer.process.Battlefield;
import java.util.HashSet;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(
        path = "transformers/v1/battle",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class BattleController {
    
    private final Battlefield battlefield;

    public BattleController(Battlefield battlefield) {
        this.battlefield = battlefield;
    }
            
    @GetMapping
    public ResponseEntity<String> fight(@RequestBody @Valid HashSet<TransformerRequest> players) {
    
        CombatInfo body = battlefield.goToBattleField(players);
        
        return ResponseEntity.ok().body(body.toString());
    }

}
