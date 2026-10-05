import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchupCalculator {

    private final Pokedex pokedex;
    private final TypeChart typeChart;


     public MatchupCalculator() throws IOException {
        this.pokedex = new Pokedex();
        this.typeChart = new TypeChart();
     }


    public double getDamageTaken(String pokemonName, String attackingType) {

        List<String> pokemonTypes = pokedex.getPokemonTypes(pokemonName);

        if (pokemonTypes.size() == 1) {
            return typeChart.getDamageMultiplierForSingleType(attackingType, pokemonTypes.get(0));
        }

    return typeChart.getDamageMultiplierForDualType(attackingType, pokemonTypes.get(0), pokemonTypes.get(1));
    }

    public Map<String, Double> getDamageTakenFromAllTypes(String pokemonName) {

        Map<String, Double> damageTaken = new LinkedHashMap<>();

        for (TypeEntry entry : typeChart.getTypes()) {
        double multiplier = getDamageTaken(pokemonName, entry.name());
        damageTaken.put(entry.name(), multiplier);
        }

        return damageTaken;

    }

    private int countWithMultiplier(List<String> team, String attackingType, double multiplier) {

        int count = 0;

        for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == multiplier) {
                count++;
                }
            }

        return count;
    }

    public int getWeakCount(List<String> team, String attackingType) {

        return countWithMultiplier(team, attackingType, 2.0);
    }

    public int getImmuneCount(List<String> team, String attackingType) {

        return countWithMultiplier(team, attackingType, 0.0);
    }

    public int getQuadWeakCount(List<String> team, String attackingType) {

        return countWithMultiplier(team, attackingType, 4.0);
    }

    public int getQuadResistCount(List<String> team, String attackingType) {

        return countWithMultiplier(team, attackingType, 0.25);
    }

    public int getResistCount(List<String> team, String attackingType) {

        return countWithMultiplier(team, attackingType, 0.5);
    }


}