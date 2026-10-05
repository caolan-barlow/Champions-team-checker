import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        MatchupCalculator calculator = new MatchupCalculator();
        TypeChart typeChart = new TypeChart();

        List<String> team = List.of("Toxapex", "Heatran", "Charizard", "Garchomp", "Sylveon", "Tyranitar");

        for (TypeEntry entry : typeChart.getTypes()) {
            int weakCount = calculator.getWeakCount(team, entry.name());
            System.out.println(entry.name() + ": " + weakCount + " weak");
        }
    }
}