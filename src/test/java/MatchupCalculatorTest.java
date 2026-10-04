import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}