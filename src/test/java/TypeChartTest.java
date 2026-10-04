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
        assertEquals(2.0, typeChart.getDamageMultiplierForSingleType("Fire","Grass"));
    }

    @Test
    void ghostdoesNoDamageToNormal() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.0, typeChart.getDamageMultiplierForSingleType("Ghost","Normal"));
    }

    @Test
    void steeldoesHalfDamageToFire() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.5, typeChart.getDamageMultiplierForSingleType("Steel","Fire"));
    }

    @Test
    void waterdoesNeutralDamageToBug() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(1.0, typeChart.getDamageMultiplierForSingleType("Water","Bug"));
    }

    @Test
    void unknownDefendingTypeThrows() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertThrows(IllegalArgumentException.class,
            () -> typeChart.getDamageMultiplierForSingleType("Fire", "Fariy"));
    }

    @Test
    void unknownAttackingTypeThrows() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertThrows(IllegalArgumentException.class,
            () -> typeChart.getDamageMultiplierForSingleType("Fireball", "Fariy"));
    }

    @Test
    void fireDoesFourTimesDamageToIceAndSteel() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(4.0, typeChart.getDamageMultiplierForDualType("Fire","Ice","Steel"));
    }

    @Test
    void fireDoesNeutralDamageToWaterAndGrass() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(1.0, typeChart.getDamageMultiplierForDualType("Fire","Water","Grass"));
    }

    @Test
    void bugDoesQuaterDamageToFireAndFlying() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.25, typeChart.getDamageMultiplierForDualType("Bug","Fire","Flying"));
    }

    @Test
    void groundDoesNoDamageToFlyingAndSteel() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertEquals(0.0, typeChart.getDamageMultiplierForDualType("Ground","Flying","Steel"));
    }

    @Test
    void sameTypeForDualType() throws Exception {
        TypeChart typeChart = new TypeChart();
        assertThrows(IllegalArgumentException.class,
            () -> typeChart.getDamageMultiplierForDualType("Fire", "Ground","Ground"));
    }

}