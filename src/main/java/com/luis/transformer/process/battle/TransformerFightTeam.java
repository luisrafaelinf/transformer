package com.luis.transformer.process.battle;

import com.luis.transformer.constant.Team;
import com.luis.transformer.exception.BattlefieldDestroyedException;
import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.model.response.CombatInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.websocket.OnOpen;
import org.springframework.stereotype.Component;

@Component
public class TransformerFightTeam implements FightTeam {

    private List<TransformerRequest> winnerAutobots;
    private List<TransformerRequest> winnerDecepticons;
    
    private List<TransformerRequest> teamAutobots;
    private List<TransformerRequest> teamDecepticons;    

    private final SpecialRule specialRule;
    private final OponentRule oponentRule;
    private final GeneralBattleRule battleRule;

    private Integer totalOfBattles = 0;

    public TransformerFightTeam(SpecialRule specialRule, OponentRule oponentRule, GeneralBattleRule battleRule) {
        this.specialRule = specialRule;
        this.oponentRule = oponentRule;
        this.battleRule = battleRule;
    }

    @Override
    public CombatInfo fight(List<TransformerRequest> teamAutobots, List<TransformerRequest> teamDecepticons) {

        this.winnerAutobots = new ArrayList<>();
        this.winnerDecepticons = new ArrayList<>();
        this.teamAutobots = teamAutobots;
        this.teamDecepticons = teamDecepticons;
        
        final Integer min = Math.min(teamAutobots.size(), teamDecepticons.size());
        totalOfBattles = 0;

        while (totalOfBattles < min) {

            TransformerRequest oponentOne = teamAutobots.get(totalOfBattles);
            TransformerRequest oponentTwo = teamDecepticons.get(totalOfBattles);
            
            if (specialRule.supremeOponents(oponentOne, oponentTwo)) {
                winnerAutobots.clear();
                winnerDecepticons.clear();
                throw new BattlefieldDestroyedException("Cybertron has been destroyed. Without survivors.");
            }

            TransformerRequest supremePlayer = specialRule.validateName(oponentOne, oponentTwo);
            if (Objects.nonNull(supremePlayer.getName())) {
                addWinner(supremePlayer);
                continue;
            }

            TransformerRequest pointCourage = oponentRule.pointCourage(oponentOne, oponentTwo);
            TransformerRequest pointStrength = oponentRule.pointStrength(oponentOne, oponentTwo);

            if ((Objects.nonNull(pointCourage.getName()) && Objects.nonNull(pointStrength.getName()))) {

                if (Objects.equals(pointCourage.getName(), pointStrength.getName())) {
                    addWinner(pointCourage);
                    continue;
                }

            }

            TransformerRequest pointSkill = oponentRule.pointSkill(oponentOne, oponentTwo);

            if (Objects.nonNull(pointSkill.getName())) {
                addWinner(pointSkill);
                continue;
            }

            TransformerRequest pointOverallRating = battleRule.pointOverallRating(oponentOne, oponentTwo);

            if (Objects.nonNull(pointOverallRating.getName())) {
                addWinner(pointOverallRating);
                continue;
            } else {
                totalOfBattles++;
            }

        }

        return resumeOfFight();

    }

    @Override
    public CombatInfo resumeOfFight() {

        CombatInfo info = new CombatInfo();
        info.setBattles(totalOfBattles);

        String namesAutobots = getNames(winnerAutobots);
        String namesDecepticons = getNames(winnerDecepticons);

        if (winnerAutobots.size() > winnerDecepticons.size()) {

            info.setTeamWinner(Team.A.getDescription());
            info.setWinners(namesAutobots);
            info.setTeamLoser(Team.D.getDescription());
            
            if (totalOfBattles <= teamDecepticons.size()) {
                List<TransformerRequest> skipped = new ArrayList<>(teamDecepticons.subList(totalOfBattles, teamDecepticons.size()));
                skipped.addAll(winnerDecepticons);
                info.setLosers(getNames(skipped));
                
            }
            
        } else {
            
            info.setTeamWinner(Team.D.getDescription());
            info.setWinners(namesDecepticons);
            info.setTeamLoser(Team.A.getDescription());
            
            if (totalOfBattles <= teamAutobots.size()) {
                List<TransformerRequest> skipped = new ArrayList<>(teamAutobots.subList(totalOfBattles, teamAutobots.size()));
                skipped.addAll(winnerAutobots);
                info.setLosers(getNames(skipped));
                
            }
            
        }

        return info;
    }

    private String getNames(List<TransformerRequest> players) {

        return players.stream()
                .map(a -> a.getName())
                .collect(Collectors.joining(", "));
    }

    private void addWinner(TransformerRequest player) {

        if (player.getTeam().equals(Team.A.name())) {
            winnerAutobots.add(player);
        } else {
            winnerDecepticons.add(player);
        }

        totalOfBattles++;

    }

}
