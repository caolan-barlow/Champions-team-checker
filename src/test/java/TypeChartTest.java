import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TypeChartTest {
    @Test
    void thereAreEighteenTypes() throws Exception{
        TypeChart typeChart = new TypeChart();
        assertEquals(18, typeChart.getTypes().size());
    }
}