import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        MatchupCalculator calculator = new MatchupCalculator();
        Map<String, Double> damageTaken = calculator.getDamageTakenFromAllTypes("Toxapex");

        for (Map.Entry<String, Double> pair : damageTaken.entrySet()) {
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }

    }
}