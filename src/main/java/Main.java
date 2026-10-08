import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        TeamMember toxapex = new TeamMember("Toxapex", "Black Sludge", "Regenerator", "Bold",
        List.of("Scald", "Recover", "Haze", "Toxic"), 32, 0, 32, 0, 2, 0);

        TeamMember heatran = new TeamMember("Heatran", "Leftovers", "Flash Fire", "Modest",
        List.of("Magma Storm", "Earth Power", "Flash Cannon", "Protect"), 32, 0, 0, 32, 2, 0);

        TeamMember charizard = new TeamMember("Charizard", "Charizardite Y", "Blaze", "Timid",
        List.of("Heat Wave", "Air Slash", "Solar Beam", "Protect"), 2, 0, 0, 32, 0, 32);

        TeamMember garchomp = new TeamMember("Garchomp", "Life Orb", "Rough Skin", "Jolly",
        List.of("Earthquake", "Dragon Claw", "Rock Slide", "Protect"), 2, 32, 0, 0, 0, 32);

        TeamMember sylveon = new TeamMember("Sylveon", "Sitrus Berry", "Pixilate", "Modest",
        List.of("Hyper Voice", "Moonblast", "Helping Hand", "Protect"), 32, 0, 0, 32, 2, 0);

        TeamMember tyranitar = new TeamMember("Tyranitar", "Chople Berry", "Sand Stream", "Adamant",
        List.of("Rock Slide", "Crunch", "Low Kick", "Protect"), 32, 32, 0, 0, 2, 0);

        Team team = new Team(List.of(toxapex, heatran, charizard, garchomp, sylveon, tyranitar));



        // MatchupCalculator calculator = new MatchupCalculator();
        // TypeChart typeChart = new TypeChart();

        // List<String> team = List.of("Toxapex", "Heatran", "Charizard", "Garchomp", "Sylveon", "Tyranitar");

        // for (TypeEntry entry : typeChart.getTypes()) {

        //     int quadWeakCount = calculator.getQuadWeakCount(team, entry.name());

        //     int weakCount = calculator.getWeakCount(team, entry.name());

        //     int resistCount = calculator.getResistCount(team, entry.name());

        //     int quadResistCount = calculator.getQuadResistCount(team, entry.name());

        //     int immuneCount = calculator.getImmuneCount(team, entry.name());


        //     System.out.println(entry.name() + ": " + quadWeakCount + " quad weak, " + weakCount + " weak, " + resistCount + " resist, " + quadResistCount + " quad resist, " + immuneCount + " immune, ");
        // }
    }
}