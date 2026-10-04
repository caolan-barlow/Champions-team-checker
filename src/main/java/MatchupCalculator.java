import java.io.IOException;
import java.util.List;

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

}