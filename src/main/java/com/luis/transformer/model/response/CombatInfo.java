package com.luis.transformer.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CombatInfo {

    private Integer battles;
    private String teamWinner;
    private String winners;
    private String teamLoser;
    private String losers;

    @Override
    public String toString() {
        return battles+" battles. \nWinning team ("+teamWinner+"): "+winners+" \n"
                +"Survicors from the losing team ("+teamLoser+"): "+losers;
    }
    
}
