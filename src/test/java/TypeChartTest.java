import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TypeChartTest {
    @Test
    void thereAreEighteenTypes() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(18, typeChart.getTypes().size());
    }

    @Test
    void fireDoesDoubleDamageToGrass() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(2.0, typeChart.getDamageMultiplier("Fire","Grass"));
    }

    @Test
    void ghostdoesNoDamageToNormal() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.0, typeChart.getDamageMultiplier("Ghost","Normal"));
    }

    @Test
    void steeldoesHalfDamageToFire() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.5, typeChart.getDamageMultiplier("Steel","Fire"));
    }

    @Test
    void waterdoesneutralDamageToBug() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(1, typeChart.getDamageMultiplier("Water","Bug"));
    }

    @Test
    void unknownDefendingTypeThrows() throws Exception {
    TypeChart typeChart = new TypeChart();
    assertThrows(IllegalArgumentException.class,
            () -> typeChart.getDamageMultiplier("Fire", "Fariy"));
}

 @Test
    void unknownAttackingTypeThrows() throws Exception {
    TypeChart typeChart = new TypeChart();
    assertThrows(IllegalArgumentException.class,
            () -> typeChart.getDamageMultiplier("Fireball", "Fariy"));
}

}