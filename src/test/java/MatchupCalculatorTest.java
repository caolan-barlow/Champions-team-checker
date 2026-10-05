import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MatchupCalculatorTest {

    @Test
    void toxapexTakesDoubleFromGround() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        assertEquals(2.0, calculator.getDamageTaken("Toxapex", "Ground"));
    }

    @Test
    void toxapexTakesNormalFromGrass() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        assertEquals(1.0, calculator.getDamageTaken("Toxapex", "Grass"));
    }

    @Test
    void charmanderTakesDoubleFromWater() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        assertEquals(2.0, calculator.getDamageTaken("Charmander", "Water"));
    }

    @Test
    void heatranTakesQuadrupleFromGround() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        assertEquals(4.0, calculator.getDamageTaken("Heatran", "Ground"));
    }

    @Test
    void unknownPokemonThrows() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calculator.getDamageTaken("Banana", "Fire"));
    }

    @Test
    void toxapexHasAnEntryForEveryType() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        Map<String, Double> damageTaken = calculator.getDamageTakenFromAllTypes("Toxapex");
        assertEquals(18, damageTaken.size());
    }

    @Test
    void toxapexProfileHasTheRightMultipliers() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        Map<String, Double> damageTaken = calculator.getDamageTakenFromAllTypes("Toxapex");
        assertEquals(2.0, damageTaken.get("Ground"));
        assertEquals(2.0, damageTaken.get("Electric"));
        assertEquals(2.0, damageTaken.get("Psychic"));
        assertEquals(0.5, damageTaken.get("Fire"));
        assertEquals(1.0, damageTaken.get("Normal"));
    }

    @Test
    void oneOfThreeAreWeakToGround() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        List<String> team = List.of("Toxapex", "Heatran", "Charizard");
        assertEquals(1, calculator.getWeakCount(team, "Ground"));
    }   

    @Test
    void twoOfThreeAreWeakToWater() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        List<String> team = List.of("Toxapex", "Heatran", "Charizard");
        assertEquals(2, calculator.getWeakCount(team, "Water"));
    }

    @Test
    void nobodyIsWeakToNormal() throws Exception {
        MatchupCalculator calculator = new MatchupCalculator();
        List<String> team = List.of("Toxapex", "Heatran", "Charizard");
        assertEquals(0, calculator.getWeakCount(team, "Normal"));
    }
}