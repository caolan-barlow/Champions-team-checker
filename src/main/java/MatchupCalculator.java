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

    public int getWeakCount(List<String> team, String attackingType) {

        int count = 0;

            for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == 2.0) {
                count++;
                }
            }   

        return count;
    }

    public int getImmuneCount(List<String> team, String attackingType) {

        int count = 0;

            for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == 0.0) {
                count++;
                }
            }   

        return count;
    }

    public int getQuadWeakCount(List<String> team, String attackingType) {

        int count = 0;

            for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == 4.0) {
                count++;
                }
            }   

        return count;   
    }

    public int getQuadResistedCount(List<String> team, String attackingType) {

        int count = 0;

            for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == 0.25) {
                count++;
                }
            }   

        return count;   
    }

    public int getResistedCount(List<String> team, String attackingType) {

        int count = 0;

            for (String pokemonName : team) {
                if (getDamageTaken(pokemonName, attackingType) == 0.5) {
                count++;
                }
            }   

        return count;   
    }



}