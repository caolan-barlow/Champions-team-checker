import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        MatchupCalculator calculator = new MatchupCalculator();
        TypeChart typeChart = new TypeChart();

        List<String> team = List.of("Toxapex", "Heatran", "Charizard", "Garchomp", "Sylveon", "Tyranitar");

        for (TypeEntry entry : typeChart.getTypes()) {

            int quadWeakCount = calculator.getQuadWeakCount(team, entry.name());

            int weakCount = calculator.getWeakCount(team, entry.name());

            int resistCount = calculator.getResistCount(team, entry.name());

            int quadResistCount = calculator.getQuadResistCount(team, entry.name());

            int immuneCount = calculator.getImmuneCount(team, entry.name());


            System.out.println(entry.name() + ": " + quadWeakCount + " quad weak, " + weakCount + " weak, " + resistCount + " resist, " + quadResistCount + " quad resist, " + immuneCount + " immune, ");
        }
    }
}