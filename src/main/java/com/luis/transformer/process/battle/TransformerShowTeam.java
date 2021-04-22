package com.luis.transformer.process.battle;

import com.luis.transformer.model.request.TransformerRequest;
import com.luis.transformer.process.converter.sort.SortedPlayer;
import com.luis.transformer.process.separator.SplitTeam;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class TransformerShowTeam implements ShowTeam {

    private final SortedPlayer sortedPlayer;
    private final SplitTeam splitTeam;

    public TransformerShowTeam(SortedPlayer sortedPlayer, SplitTeam splitTeam) {
        this.sortedPlayer = sortedPlayer;
        this.splitTeam = splitTeam;
    }

    @Override
    public Map<String, List<TransformerRequest>> show(HashSet<TransformerRequest> players) {

        List<TransformerRequest> sortedPlayers = sortedPlayer.sort(players);

        Map<String, List<TransformerRequest>> teams = splitTeam.split(sortedPlayers);

        showConsole(teams);

        return teams;

    }

    /**
     * this method show the order of team and score
     * @param teams 
     */
    private void showConsole(Map<String, List<TransformerRequest>> teams) {
        
        System.out.print("\t");
        System.out.print("Name ");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("Rank");
        System.out.print("\t");
        System.out.print("Courage");
        System.out.print("\t");
        System.out.print("Strength");
        System.out.print("\t");
        System.out.print("Skill");
        System.out.print("\t");
        System.out.print("Overall \n");

        for (Map.Entry<String, List<TransformerRequest>> entry : teams.entrySet()) {
            System.out.println(entry.getKey());

            for (TransformerRequest player : entry.getValue()) {

                System.out.print("\t");
                System.out.printf("\033[32m%-15s\033[0m", player.getName());
                System.out.print("\t");
                System.out.print(player.getRank());
                System.out.print("\t");
                System.out.print(player.getCourage());
                System.out.print("\t");
                System.out.print(player.getMechanicalStrength());
                System.out.print("\t");
                System.out.print("\t");
                System.out.print(player.getMechanicalSkill());
                System.out.print("\t");
                System.out.print((player.getMechanicalStrength()
                        + player.getArtificialIntelligence()
                        + player.getMechanicalSpeed()
                        + player.getEndurance()
                        + player.getFirepower()));
                System.out.print("\n");

            }

        }
    }

}
