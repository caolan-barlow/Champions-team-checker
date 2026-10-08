import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Pokedex {
    private final List<PokedexEntry> pokemon;

    public Pokedex() throws IOException {
        InputStream stream = getClass().getResourceAsStream("/pokedex/pokedex.json");
        this.pokemon = new ObjectMapper().readValue(stream, new TypeReference<List<PokedexEntry>>() {});
    }

    public List<PokedexEntry> getPokemonList() {
        return pokemon;
    }

    public int getPokemonStat(String pokemonName, String stat) {

        for(PokedexEntry entry : pokemon) {
            if(entry.pokemonName().equals(pokemonName)) {
                return switch (stat){
                    case "HP" -> entry.hp();
                    case "Atk" -> entry.atk();
                    case "Def" -> entry.def();
                    case "Sp.Atk" -> entry.spAtk();
                    case "Sp.Def" -> entry.spDef();
                    case "Speed" -> entry.speed();

                    default -> throw new IllegalArgumentException("Unknown stat: " + stat);

                };
            }
        }

        throw new IllegalArgumentException("Unable to find the pokemon with the name: " + pokemonName );

    }

    public List<String> getPokemonTypes(String pokemonName){

        for(PokedexEntry entry : pokemon) {
            if(entry.pokemonName().equals(pokemonName)) {
                return entry.types();
            }
        }

       throw new IllegalArgumentException("Unable to find the pokemon with the name: " + pokemonName );

    }

    public int getPokemonHPStat(String pokemonName) {

        return getPokemonStat(pokemonName, "HP");

    }

    public int getPokemonAttackStat(String pokemonName) {

        return getPokemonStat(pokemonName, "Atk");

    }

    public int getPokemonDefenceStat(String pokemonName) {

        return getPokemonStat(pokemonName, "Def");

    }

    public int getPokemonSpecialAttackStat(String pokemonName) {

        return getPokemonStat(pokemonName, "Sp.Atk");

    }

    public int getPokemonSpecialDefenceStat(String pokemonName) {

        return getPokemonStat(pokemonName, "Sp.Def");

    }

    public int getPokemonSpeedStat(String pokemonName) {

        return getPokemonStat(pokemonName, "Speed");

    }

}
